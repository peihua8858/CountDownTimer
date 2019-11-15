package com.fz.countdowntimer;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/**
 * 使用android.os.CountDownTimer的源码
 * 1. 对回调onTick做了细小调整，已解决最后1秒不会倒计时到0，要等待2秒才回调onFinish
 * 2. 添加了一些自定义方法
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2019/5/8 09:42
 */
abstract class CountDownTimer implements Handler.Callback {
    private static final int MSG = 1;
    private long mMillisInFuture;
    private long mCountdownInterval;
    private long mStopTimeInFuture;
    private long mPauseTimeInFuture;
    private boolean isStop = false;
    private boolean isPause = false;
    private Handler mHandler;

    public CountDownTimer() {
    }

    public CountDownTimer(long millisInFuture) {
        this(millisInFuture, 1000);
    }

    /**
     * @param millisInFuture    总倒计时时间
     * @param countDownInterval 倒计时间隔时间
     */
    public CountDownTimer(long millisInFuture, long countDownInterval) {
        initTime(millisInFuture, countDownInterval);
    }

    void initTime(long millisInFuture) {
        initTime(millisInFuture, 1000);
    }

    void initTime(long millisInFuture, long countDownInterval) {
        // 解决秒数有时会一开始就减去了2秒问题（如10秒总数的，刚开始就8999，然后没有不会显示9秒，直接到8秒）
        if (countDownInterval > 1000) {
            millisInFuture += 15;
        }
        mMillisInFuture = millisInFuture;
        mCountdownInterval = countDownInterval;
        initHandler();
    }

    void initHandler() {
        if (mHandler == null) {
            mHandler = new Handler(this);
        }
    }

    public synchronized CountDownTimer start(long millisInFuture, long countDownInterval) {
        initTime(millisInFuture, countDownInterval);
        startTime(millisInFuture);
        return this;
    }

    public synchronized CountDownTimer start(long millisInFuture) {
        initTime(millisInFuture);
        startTime(millisInFuture);
        return this;
    }

    private void startTime(long millisInFuture) {
        isStop = false;
        isPause = false;
        if (millisInFuture <= 0) {
            onFinish();
            return;
        }
        mStopTimeInFuture = SystemClock.elapsedRealtime() + millisInFuture;
        mHandler.sendMessage(mHandler.obtainMessage(MSG));
    }

    /**
     * 开始倒计时
     */
    public synchronized final void start() {
        start(mMillisInFuture);
    }

    /**
     * 停止倒计时
     */
    public synchronized final void stop() {
        isStop = true;
        mHandler.removeMessages(MSG);
        onStop(remainingTime());
    }

    /**
     * 暂时倒计时
     * 调用{@link #restart()}方法重新开始
     */
    public synchronized final void pause() {
        if (isStop) {
            return;
        }
        isPause = true;
        mPauseTimeInFuture = remainingTime();
        mHandler.removeMessages(MSG);
        onPause(mPauseTimeInFuture);
    }

    /**
     * 重新开始
     */
    public synchronized final void restart() {
        if (isStop || !isPause) {
            return;
        }
        isPause = false;
        start(mPauseTimeInFuture);
    }

    /**
     * 倒计时间隔回调
     *
     * @param millisUntilFinished 剩余毫秒数
     */
    public abstract void onTick(long millisUntilFinished);

    /**
     * 倒计时结束回调
     */
    public abstract void onFinish();

    /**
     * 倒计时暂停
     */
    public abstract void onPause(long millisUntilFinished);

    /**
     * 倒计时停止
     *
     * @param millisUntilFinished
     */
    public abstract void onStop(long millisUntilFinished);

    /**
     * 剩余时间数，单位毫秒
     *
     * @return
     */
    public final long remainingTime() {
        return mStopTimeInFuture - SystemClock.elapsedRealtime();
    }

    @Override
    public final boolean handleMessage(Message msg) {
        synchronized (CountDownTimer.this) {
            if (isStop || isPause) {
                return true;
            }
            final long millisLeft = remainingTime();
            if (millisLeft <= 0) {
                onFinish();
            } else {
                long lastTickStart = SystemClock.elapsedRealtime();
                onTick(millisLeft);
                // take into account user's onTick taking time to execute
                long delay = lastTickStart + mCountdownInterval - SystemClock.elapsedRealtime();
                // special case: user's onTick took more than interval to
                // complete, skip to next interval
                while (delay < 0) {
                    delay += mCountdownInterval;
                }
                mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG), delay);
            }
            return true;
        }
    }
}
