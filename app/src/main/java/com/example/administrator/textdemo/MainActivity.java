package com.example.administrator.textdemo;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.administrator.textdemo.ui.AidlActivity;
import com.example.administrator.textdemo.ui.ZheXianActivity;
import com.example.administrator.textdemo.ui.dhActivity;
import com.example.administrator.textdemo.ui.ConActivity;
import com.example.administrator.textdemo.ui.MessengerActivity;
import com.example.administrator.textdemo.ui.JXActivity;
import com.example.administrator.textdemo.ui.MyViewActivity;
import com.example.administrator.textdemo.ui.UdpActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

    public void jx(View view){
        startActivity(new Intent(this,JXActivity.class));
    }
    public void dh(View view){
        startActivity(new Intent(this,dhActivity.class));
    }
    public void aidl(View view){
        startActivity(new Intent(this,AidlActivity.class));
    }
    public void local_service(View view){startActivity(new Intent(this,ConActivity.class));}
    public void myview(View view){
        startActivity(new Intent(this,MyViewActivity.class));
    }
    public void messnge_service(View view){startActivity(new Intent(this,MessengerActivity.class));}
    public void udp(View view){startActivity(new Intent(this,UdpActivity.class));}
    public void zx(View view){startActivity(new Intent(this,ZheXianActivity.class));}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
