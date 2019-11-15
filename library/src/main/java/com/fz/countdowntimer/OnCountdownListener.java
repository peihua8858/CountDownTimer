package com.fz.countdowntimer;

/**
 * 倒计时结束监听
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2019/5/8 09:41
 */
public interface OnCountdownListener {
    /**
     * 倒计时结束
     *
     * @param cv 倒计时控件
     * @author dingpeihua
     * @date 2019/5/8 09:42
     * @version 1.0
     */
    default void onFinish(CountdownView cv) {

    }

    /**
     * @param cv         倒计时控件
     * @param remainTime
     * @author dingpeihua
     * @date 2019/5/8 09:40
     * @version 1.0
     */
    default void onTick(CountdownView cv, long remainTime) {

    }

    /**
     * 倒计时停止
     *
     * @param cv                  倒计时控件
     * @param millisUntilFinished 剩余毫秒数
     * @author dingpeihua
     * @date 2019/5/8 09:45
     * @version 1.0
     */
    default void onStop(CountdownView cv, long millisUntilFinished) {

    }

    /**
     * 倒计时暂停
     *
     * @param cv                  倒计时控件
     * @param millisUntilFinished 剩余毫秒数
     * @author dingpeihua
     * @date 2019/5/8 09:45
     * @version 1.0
     */
    default void onPause(CountdownView cv, long millisUntilFinished) {

    }
}
