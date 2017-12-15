package com.example.administrator.textdemo.reciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/12/11.
 */

public class MyReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager cn= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ifo = cn.getActiveNetworkInfo();
        if (ifo==null){
            Toast.makeText(context,"无可用网路",Toast.LENGTH_SHORT).show();
        }else {
            if (ifo.isConnected()){
                if (ifo.getType()==ConnectivityManager.TYPE_MOBILE){
                    Toast.makeText(context,"当前使用移动数据网路。。",Toast.LENGTH_SHORT).show();
                }else if (ifo.getType()==ConnectivityManager.TYPE_WIFI){
                    Toast.makeText(context,"当前使用的是wifi网路",Toast.LENGTH_SHORT).show();
                }
            }
        }


    }
}
