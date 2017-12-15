package com.example.administrator.textdemo.udp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.textdemo.R;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class UdpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udp);

        address();

    }

    public void address() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
                    System.out.println(Arrays.toString(allByName));
                    InetAddress byName = InetAddress.getByName("UMMMZHE4GX4KT68");
                    Log.e("=====", "获取到的那个IP地址是：" + byName.getHostAddress());
                    InetAddress allByName2 = InetAddress.getByName("10.7.156.60");
                    System.out.println(allByName2.getHostName());
                    InetAddress localHost = InetAddress.getLocalHost();
                    Log.e("=====", "IP：" + localHost.getHostAddress());
                    Log.e("=====", "主机：" + localHost.getHostName());
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
