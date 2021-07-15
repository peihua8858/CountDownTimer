package com.fz.countdowntimer.demo;

import android.os.SystemClock;
import android.util.Log;

import com.chad.library.adapter.base.entity.MultiItemEntity;


public class Demo2Bean implements MultiItemEntity {
    private long elapsedRealTime;
    private String title;
    private long countdownTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCountdownTime() {
        return countdownTime;
    }

    public void setCountdownTime(long countdownTime) {
        this.countdownTime = countdownTime;
    }

    public Demo2Bean(String title, long countdownTime) {
        this.title = title;
        this.countdownTime = countdownTime;
        elapsedRealTime = SystemClock.elapsedRealtime();
    }

    public long getCountDownEndTime() {
        return (elapsedRealTime + countdownTime * 1000) - SystemClock.elapsedRealtime();
    }

    public String getItemValue() {
        Log.d("Demo2Adapter", "Demo2Adapter>>>CountDownEndTime：" + getCountDownEndTime());
        if (getCountDownEndTime() <= 0) {
            return title + "_倒计时结束";
        }
        return title;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
