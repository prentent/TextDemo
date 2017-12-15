package com.example.administrator.textdemo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.textdemo.R;

/**
 * Created by Administrator on 2017/12/13.
 */

public class CCC extends RelativeLayout {

    private String taString;

    public CCC(Context context) {
        super(context);
    }
    @SuppressLint("Recycle")
    public CCC(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.ccc);
        taString = ta.getString(R.styleable.ccc_title);
        View init = init(context);
        this.addView(init);
    }

    private View init(Context context) {
        TextView textView=new TextView(context);
        textView.setText(taString);
        textView.setTextColor(Color.BLUE);
        return textView;
    }
}
