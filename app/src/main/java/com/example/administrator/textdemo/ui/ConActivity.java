package com.example.administrator.textdemo.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.textdemo.R;
import com.example.administrator.textdemo.service.LocalService;

/*
 服务之间通信
 */
public class ConActivity extends AppCompatActivity {

    private EditText edt;
    private ServiceConnection conn;
    private LocalService.LocalBinder binderLocal;
    private EditText edt_psd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con);
        initView();
        bindLocalService();
    }

    /**
     * 本地服务，假的登录操作
     */
    private void bindLocalService() {
        Intent intent=new Intent(this, LocalService.class);
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binderLocal = (LocalService.LocalBinder) service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                binderLocal=null;
            }
        };
        boolean Localservice = bindService(intent, conn, BIND_AUTO_CREATE);
        if (Localservice)
            Toast.makeText(ConActivity.this,"绑定本地服务成功了！！！",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(ConActivity.this,"绑定本地服务失败了！！！",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
        if (binderLocal!=null){
            binderLocal=null;
        }
    }

    private void initView() {
        edt = (EditText) findViewById(R.id.edt);
        edt_psd = (EditText) findViewById(R.id.edt_psd);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.login:
                if (binderLocal==null){
                    Toast.makeText(this,"绑定服务失败了！！！",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!TextUtils.isEmpty(edt.getText().toString())&&!TextUtils.isEmpty(edt_psd.getText().toString())){
                    if(binderLocal.login(edt.getText().toString().trim(),edt_psd.getText().toString().trim()))
                        Toast.makeText(this,"登录成功了！！！",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(this,"登录失败了！！！",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"输入不能为空！！！",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.in_1:
                outCard(0);
                break;
            case R.id.in_2:
                outCard(1);
                break;
            case R.id.in_3:
                outCard(2);
                break;
            case R.id.in_4:
                outCard(3);
                break;

            default:
                break;
        }
    }

    private void outCard(int i) {
        if (binderLocal==null){
            Toast.makeText(this,"绑定服务失败了！！！",Toast.LENGTH_SHORT).show();
        }else {
            Parcel writeParcel = Parcel.obtain();
            writeParcel.writeInt(i);
            Parcel readyParcel = Parcel.obtain();
            try {
                binderLocal.transact(100,writeParcel,readyParcel,0);
                Toast.makeText(this,readyParcel.readString(),Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
