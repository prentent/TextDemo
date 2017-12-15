package com.example.administrator.textdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/12/14.
 */

public class LocalService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new LocalBinder();
    }

    public class LocalBinder extends Binder {
        public boolean login(String name, String psd) {
            if (name.equals("123") && psd.equals("123"))
                return true;
            return false;
        }

        /**
         * 进程通信的原理
         * @param code  某一种标识。
         * @param data  数据。传递过来的数据
         * @param reply 回复过去的数据。
         * @param flags 某种标识
         * @return 一个boolean值。
         * @throws RemoteException
         */
        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            //获取传递过来的数据
            int code_ = data.readInt();
            String replyString = "";
            switch (code_) {
                case 0:
                    replyString = "压死";
                    break;
                case 1:
                    replyString = "不要";
                    break;
                case 2:
                    replyString = "过";
                    break;
                default:
                    replyString = "王炸";
                    break;
            }
            //返回的数据
            reply.writeString(replyString);

            return super.onTransact(code, data, reply, flags);
        }
    }
}
