package com.example.administrator.textdemo.json_xml;

import android.content.res.XmlResourceParser;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.textdemo.R;
import com.example.administrator.textdemo.entity.StudentEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JXActivity extends AppCompatActivity {
    public static final String jsonData = "{\n" +
            "    \"tools\": [\n" +
            "    { \"name\":\"css format\" , \"site\":\"http://www.atool.org/csscompression.php\" },\n" +
            "    { \"name\":\"json format\" , \"site\":\"http://www.atool.org/jsonformat.php\" },\n" +
            "    { \"name\":\"hash MD5\" , \"site\":\"http://www.atool.org/hash.php\" }\n" +
            "    ]\n" +
            "    }";
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jx);
        tv = (TextView) findViewById(R.id.tv);
        startThread();
    }
    private List<StudentEntity> xmlJX() throws XmlPullParserException, IOException {
        StudentEntity entity = null;
        List<StudentEntity> list = null;
        XmlResourceParser parser = getResources().getXml(R.xml.student);
        int type = parser.getEventType();
        while (type != XmlPullParser.END_DOCUMENT) {
            switch (type) {
                case XmlResourceParser.START_DOCUMENT:
                    list = new ArrayList<>();
                    break;
                case XmlPullParser.START_TAG:
                    if (parser.getName().equals("student")) {
                        entity = new StudentEntity();
                        entity.setNum(parser.getAttributeValue(0));
                    }
                    if (parser.getName().equals("age")) {
                        entity.setAge(Integer.parseInt(parser.nextText()));
                    } else if (parser.getName().equals("sex")) {
                        entity.setSex(parser.nextText());
                    } else if (parser.getName().equals("idCard")) {
                        entity.setIdCard(Long.parseLong(parser.nextText()));
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if (parser.getName().equals("student")) {
                        list.add(entity);
                        entity = null;
                    }
                    break;
            }
            type = parser.next();
        }
        parser.close();
        return list;
    }

    private void jsonJX() throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray tools = jsonObject.getJSONArray("tools");
        for (int i = 0; i < tools.length(); i++) {
            JSONObject object = tools.getJSONObject(i);
            Log.i("====json", object.getString("name") + "," + object.getString("site"));
            tv.append(object.getString("name") + "," + object.getString("site")+"\n");
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TAG_1:
                    List<StudentEntity> list = (List<StudentEntity>) msg.obj;
                    for (StudentEntity entity : list) {
                        Log.i("====StudentEntity------", entity.toString());
                        tv.append(entity.toString()+"\n");
                    }
                    break;
            }
        }
    };

    private static final int TAG_1 = 0x01;

    private void startThread() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            jsonJX();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            List<StudentEntity> entities = xmlJX();
                            Message message = handler.obtainMessage();
                            message.what = TAG_1;
                            message.obj = entities;
                            handler.sendMessage(message);
                        } catch (XmlPullParserException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }
}
