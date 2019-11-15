package com.fz.countdowntimer.demo;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.fz.countdowntimer.CountdownView;
import com.fz.countdowntimer.DynamicConfig;

public class DemoActivity extends AppCompatActivity {
    CountdownView countdownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        countdownView = findViewById(R.id.cv_countdown_timer);
        countdownView.startDynamic(DynamicConfig.createBuilder()
                .setRemainTime(50000000L)
                .setTimeTextSize(36F)
                .setShowHour(true)
                .setTimeTextColor(Color.BLUE)
                .setSuffixTextColor(Color.WHITE)
                .setSuffixTextSize(36)
                .build());
    }
}
