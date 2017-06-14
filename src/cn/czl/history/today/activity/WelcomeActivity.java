package cn.czl.history.today.activity;

import java.util.Random;  

import cn.czl.history.today.R;

 

 

import android.app.Activity;  
import android.content.Intent;  
import android.os.Bundle;  
import android.os.Handler;  
import android.os.Message;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.view.animation.Animation;  
import android.view.animation.AnimationUtils;  
import android.widget.ImageView;  
import android.widget.LinearLayout;  
  
public class WelcomeActivity extends Activity {  
    private ImageView welcomeImage;  
    private Thread t1, t2;  
    private Handler handler;  
    private int rand = new Random().nextInt(4);;  
    private Animation animation;  
    private int pageNumber = 1;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_welcome);  
        welcomeImage = (ImageView) findViewById(R.id.welcome_iv);  
        animation = AnimationUtils.loadAnimation(this, R.anim.scal_anim);  
        LinearLayout layout = (LinearLayout) findViewById(R.id.welcome_layout);  
        layout.setOnClickListener(new OnClickListener() {  
  
            @Override  
            public void onClick(View v) {  
                if (pageNumber == 2) {  
                    t1.interrupt();  
                    t2.interrupt();  
                    turnPage();// 跳转界面  
                }  
            }  
        });  
        handler = new Handler() {  
            @Override  
            public void handleMessage(Message msg) {  
                super.handleMessage(msg);  
                if (msg.what == 0) {  
                    switch (rand) {  
                    case 0:  
                        // 设置动画背景  
                        startAnimation(R.drawable.back3);  
                        break;  
                    case 1:  
                        startAnimation(R.drawable.back3);  
                        break;  
                    case 2:  
                        startAnimation(R.drawable.back3);  
                        break;  
                    case 3:  
                        startAnimation(R.drawable.back3);  
                        break;  
                    default:  
                        break;  
                    }  
                }  
            }  
        };  
        t1 = new Thread(new Runnable() {  
  
            @Override  
            public void run() {  
                try {  
                    Thread.sleep(300);  
                    handler.sendEmptyMessage(0);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        });  
        t1.start();  
        t2 = new Thread(new Runnable() {  
  
            @Override  
            public void run() {  
                try {  
                    Thread.sleep(8000);  
                    turnPage();// 跳转界面  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        });  
    }  
  
    /** 
     * 跳转到主界面 
     */  
    private void turnPage() {  
        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);  
        WelcomeActivity.this.startActivity(intent);  
        WelcomeActivity.this.finish();  
    }  
  
    /** 
     * 设置动画背景 
     *  
     * @param imageSource 
     */  
    private void startAnimation(int imageSource) {  
        welcomeImage.setBackgroundDrawable(getResources().getDrawable(  
                imageSource));  
        welcomeImage.setAnimation(animation);  
        welcomeImage.startAnimation(animation);  
        t2.start();  
        pageNumber = 2;  
    }  
}  
