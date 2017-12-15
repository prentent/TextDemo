package com.example.administrator.textdemo.caream;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.textdemo.R;

import java.io.File;

public class CaremActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carem);
    }

    public void systemC(View view){
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = Environment.getExternalStorageDirectory();
        String s="HHH"+ System.currentTimeMillis()+".jpg";
        File d=new File(file,s);
        Uri uri = Uri.fromFile(d);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        startActivityForResult(intent,0);
    }
}
