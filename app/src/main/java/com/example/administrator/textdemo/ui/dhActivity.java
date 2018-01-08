package com.example.administrator.textdemo.ui;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.administrator.textdemo.R;

public class dhActivity extends AppCompatActivity {
    private AnimationDrawable drawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dh);
        ImageView imageView= (ImageView) findViewById(R.id.img);
        //将帧动画，设置给 ImageView

        //      imageView.setImageResource(R.drawable.frame_drawable);
        drawable = (AnimationDrawable)
                imageView.getDrawable();

    }
    // 实现一个透明度的动画
    public void alpha(View view) {
        //现在，想将动画，给View执行。

        // Drawable drawable = getDrawable(R.mipmap.ic_launcher);

        //通过一个工具类，加载一个动画。
        Animation animation = AnimationUtils.
                loadAnimation(this, R.anim.alpha);

        //开启一个动画
        view.startAnimation(animation);

    }

    //旋转
    public void rotate(View view) {

        Animation animation = AnimationUtils.
                loadAnimation(this, R.anim.rotate);

        view.startAnimation(animation);
    }


    public void  start(View view){
        drawable.start();
    }



    //缩放：  ALT+ENTER  快速修复
    public void scale(View view) {
        //提取一个 局部变量 ALT+CONTROL + V
        //提取一个 成员变量 ALT+CONTROL + F
        Animation animation = AnimationUtils.
                loadAnimation(this, R.anim.scale);

        view.startAnimation(animation);
    }

    //平移
    public void translate(final View view) {
        Animation animation = AnimationUtils.
                loadAnimation(this, R.anim.translate);

        view.startAnimation(animation);


        //设置动画的监听。
        animation.setAnimationListener(
                new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        //当动画开始的时候，回调
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //当动画结束的时候，回调
                        //当动画结束的时候，设置视图消失
                        view.setVisibility(View.GONE);

                        //设置不可用，为了避免Android的一个bug。
                        view.setEnabled(false);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        //当动画重复的时候，回调
                    }
                });


    }

    //舞娘
    public void dancer(View view) {

        //1 . 加载动画
        Animation animation = AnimationUtils.
                loadAnimation(this, R.anim.dancer);

        //2 . 运行动画
        view.startAnimation(animation);

        //3 . 如果需要，可以设置监听
        animation.setAnimationListener(
                new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                }
        );
    }
}
