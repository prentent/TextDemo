package com.example.app_server;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.administrator.textdemo.IMyAidlInterface;
import com.example.administrator.textdemo.People;

import java.util.ArrayList;
import java.util.List;

public class MyService extends Service {

    private List<People> list=null;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("=======service","绑定成功了");
        list=new ArrayList<>();
        return iBinder;
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
        list=null;
    }

    private IBinder iBinder=new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.e("=======service","执行了");
        }

        @Override
        public List<People> addPeople(People peo) throws RemoteException {
            list.add(peo);
            return list;
        }
    };
}
