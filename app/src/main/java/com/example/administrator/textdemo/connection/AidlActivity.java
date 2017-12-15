package com.example.administrator.textdemo.connection;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.administrator.textdemo.IMyAidlInterface;
import com.example.administrator.textdemo.People;
import com.example.administrator.textdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AidlActivity extends AppCompatActivity {
    private List<Map<String ,String> > list=new ArrayList<>();
    private ListView lv;
    private SimpleAdapter adapter;
    private IMyAidlInterface asInterface;
    private EditText edt_phone;
    private EditText edt_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        lv = (ListView) findViewById(R.id.lv);
        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_phone = (EditText) findViewById(R.id.edt_phone);
        bindAidlService();
        setAdapter();

    }

    private void setAdapter() {
        adapter = new SimpleAdapter(this, list, R.layout.item_aidl, new String[]{"name", "phone"}, new int[]{R.id.tv1, R.id.tv2});
        lv.setAdapter(adapter);
    }

    private void bindAidlService() {
        Intent intent=new Intent();
        intent.setAction("lh_service");
        intent.setPackage("com.example.app_server");
        boolean service = bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.e("====cleint", "绑定成功了");
                Toast.makeText(AidlActivity.this, "绑定成功了", Toast.LENGTH_SHORT).show();
                asInterface = IMyAidlInterface.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);

        if (service){
            Toast.makeText(AidlActivity.this, "成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(AidlActivity.this, "失败", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view){
        if (asInterface!=null){
            try {
                list.clear();
                List<People> peoples = asInterface.addPeople(new People(edt_name.getText().toString(), edt_phone.getText().toString()));
                for (People peo:peoples) {
                    Map<String ,String> map=new HashMap<>();
                    map.put("name",peo.getName());
                    map.put("phone",peo.getPhone());
                    list.add(map);
                }
                adapter.notifyDataSetChanged();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(AidlActivity.this, "未绑定服务！！！", Toast.LENGTH_SHORT).show();
        }
    }
}
