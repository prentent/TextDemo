package com.example.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class MessengerService extends Service {
    public MessengerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("======","zhixing l");
        IBinder binder = messenger.getBinder();
        return binder;
    }

    private Messenger messenger=new Messenger(new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Message obtainTclient = Message.obtain(msg);
            switch (msg.what){
                case 0:
                    obtainTclient.arg2 = msg.arg1 + msg.arg2;
                    obtainTclient.what=1;
                    Log.e("======",msg.arg2 +"");
                    try {
                        msg.replyTo.send(obtainTclient);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    });
}
