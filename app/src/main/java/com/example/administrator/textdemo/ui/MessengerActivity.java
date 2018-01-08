package com.example.administrator.textdemo.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.textdemo.R;

/**
 * 使用Messenger进行进程间通信
 */
public class MessengerActivity extends AppCompatActivity {

    private EditText edt_1, edt_2;
    private ServiceConnection conn;
    private Messenger messengerServer;

    private Messenger messenger=new Messenger(new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    tv.setText(msg.arg2+"");
                    break;
            }
            super.handleMessage(msg);
        }
    });
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        edt_1 = (EditText) findViewById(R.id.edt_1);
        edt_2 = (EditText) findViewById(R.id.edt_2);
        tv = (TextView) findViewById(R.id.tv);

        bindMessengerServer();


    }

    private void bindMessengerServer() {
        Intent intent = new Intent();
        intent.setAction("com.example.messenger.MessengerService");
        intent.setPackage("com.example.messenger");
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                messengerServer = new Messenger(service);
                Toast.makeText(MessengerActivity.this,"绑定服务了",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                messengerServer = null;
            }
        };
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void onClick(View view) {
        String toString = edt_1.getText().toString();
        String toString1 = edt_2.getText().toString();
        if (!TextUtils.isEmpty(toString)&&!TextUtils.isEmpty(toString1)){
            Message obtain = Message.obtain(null, 0, Integer.parseInt(toString), Integer.parseInt(toString1));
            //把当前messenger传递过去，好返回数据
            obtain.replyTo=messenger;
            try {
                messengerServer.send(obtain);
                Toast.makeText(this,"发送了!!!",Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
                Toast.makeText(this,"异常!!!",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this,"输入不能为空!!!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
        if (messengerServer != null) {
            messengerServer = null;
        }
    }
}
