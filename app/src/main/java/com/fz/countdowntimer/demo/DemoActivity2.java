package com.fz.countdowntimer.demo;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fz.countdowntimer.CountdownView;
import com.fz.countdowntimer.DynamicConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DemoActivity2 extends AppCompatActivity {
    long[] times = new long[]{50, 20, 15, 60};
    CountdownView countdownView;
    Demo2Adapter demo2Adapter;
    RecyclerView recyclerView;
    int curPage = 1;
    int pageSize = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        recyclerView = findViewById(R.id.rv_countdown_views);
        demo2Adapter = new Demo2Adapter();
        demo2Adapter.setNewData(getData());
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(demo2Adapter);
        countdownView = findViewById(R.id.cv_countdown_timer);
        CountdownView cvCountdownTimer = findViewById(R.id.cv_countdown_timer1);
        cvCountdownTimer.start(500000);
        countdownView.startDynamic(DynamicConfig.createBuilder()
                .setRemainTime(50000000L)
                .setTimeTextSize(36F)
                .setShowHour(true)
                .setTimeTextColor(Color.BLUE)
                .setSuffixTextColor(Color.WHITE)
                .setSuffixTextSize(36)
                .build());
    }

    private List<Demo2Bean> getData() {
        List<Demo2Bean> datas = new ArrayList<>();
        for (int i = 0; i < pageSize; i++) {
            long time = times[i % 4];
            datas.add(new Demo2Bean("Item_" + i, time));
        }
        return datas;
    }
}
