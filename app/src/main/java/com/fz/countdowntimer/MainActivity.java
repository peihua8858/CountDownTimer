package com.fz.countdowntimer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fz.DemoActivity;

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
        countdownView.start(50000000L);
        countdownView1 = findViewById(R.id.cv_countdown_timer1);
        countdownView1.start(50000000L);
        countdownView2 = findViewById(R.id.cv_countdown_timer2);
        countdownView2.start(500000000L);
        countdownView3 = findViewById(R.id.cv_countdown_timer3);
        countdownView3.start(500000000L);
        countdownView4 = findViewById(R.id.cv_countdown_timer4);
        countdownView4.start(500000000L);
    }

    public void onClick(View view) {
        startActivity(new Intent(this, DemoActivity.class));
    }
}
