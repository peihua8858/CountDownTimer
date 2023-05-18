package com.fz.countdowntimer.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fz.countdowntimer.CountdownView;
import com.fz.countdowntimer.DynamicConfig;
import com.fz.countdowntimer.OnCountdownListener;

public class MainActivity extends AppCompatActivity {
    CountdownView countdownView;
    CountdownView countdownView1;
    CountdownView countdownView2;
    CountdownView countdownView3;
    CountdownView countdownView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countdownView = findViewById(R.id.cv_countdown_timer);
        countdownView.setOnCountdownListener(new OnCountdownListener() {
            @Override
            public void onFinish(CountdownView cv) {
                Log.d("MainActivity", "countdownView>>>倒计时结束了。。。。。。");
            }
        });
        countdownView1 = findViewById(R.id.cv_countdown_timer1);
        countdownView1.setOnCountdownListener(new OnCountdownListener() {
            @Override
            public void onFinish(CountdownView cv) {
                Log.d("MainActivity", "countdownView1>>>倒计时结束了。。。。。。");
            }
        });
        countdownView1.start(0L);
        countdownView2 = findViewById(R.id.cv_countdown_timer2);
        countdownView2.start(500000000L);
        countdownView3 = findViewById(R.id.cv_countdown_timer3);
        countdownView3.start(500000000L);
        countdownView4 = findViewById(R.id.cv_countdown_timer4);
        DynamicConfig.Builder builder = new DynamicConfig.Builder();
        builder.setTimeFontType(R.font.proximanova_semibold);
        builder.setRemainTime(500000000L);
        countdownView4.startDynamic(builder.build());


//        countdownView.startDynamic(builder.build());
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_demo:
                startActivity(new Intent(this, DemoActivity.class));
                break;
            case R.id.btn_demo2:
                startActivity(new Intent(this, DemoActivity2.class));
                break;
            default:
                break;
        }
    }
}
