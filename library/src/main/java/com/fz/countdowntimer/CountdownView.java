package com.fz.countdowntimer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.core.widget.TextViewCompat;

/**
 * 倒计时组件
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2019/5/8 09:49
 */
public class CountdownView extends LinearLayout {
    /**
     * 一秒
     */
    public static final long ONE_SECOND = 1000L;
    /**
     * 一分钟
     */
    public static final long ONE_MINUTE = 60 * ONE_SECOND;
    /**
     * 一个小时
     */
    public static final long ONE_HOUR = 60 * ONE_MINUTE;
    /**
     * 一天
     */
    public static final long ONE_DAY = 24 * ONE_HOUR;
    private CountDownTimer mCountDownTimer;
    private OnCountdownListener mOnCountdownListener;
    AttributeHelper mHelper;
    private Context mContext;

    public CountdownView(Context context) {
        this(context, null);
    }

    public CountdownView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    DrawBgTextView mDayTextView;
    DrawBgTextView mHourTextView;
    DrawBgTextView mMinuteTextView;
    DrawBgTextView mSecondTextView;
    DrawBgTextView mMillisecondTextView;

    public CountdownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        setOrientation(HORIZONTAL);
        mHelper = new AttributeHelper(context, attrs);
        setGravity(Gravity.CENTER);
        init(context);
    }

    void init(Context context) {
        removeAllViews();
        mDayTextView = createTimeView(context, mHelper.isShowDay, mHelper.mDayBackgroundRes,
                mHelper.mDayTextAppearance, mHelper.mDayFormat, mHelper.isDayTwoDigits, -1);
        createSuffixView(context, mHelper.hasSetSuffixDay, mHelper.mSuffixDayBackgroundRes,
                mHelper.mSuffixDayTextAppearance, mHelper.mSuffixDay);

        mHourTextView = createTimeView(context, mHelper.isShowHour, mHelper.mHourBackgroundRes,
                mHelper.mHourTextAppearance, mHelper.mHourFormat, mHelper.isHourTwoDigits, mHelper.mLimitHourDigits);
        createSuffixView(context, mHelper.hasSetSuffixHour, mHelper.mSuffixHourBackgroundRes,
                mHelper.mSuffixHourTextAppearance, mHelper.mSuffixHour);

        mMinuteTextView = createTimeView(context, mHelper.isShowMinute, mHelper.mMinuteBackgroundRes,
                mHelper.mMinuteTextAppearance, mHelper.mMinuteFormat, mHelper.isMinuteTwoDigits, mHelper.mLimitMinuteDigits);
        createSuffixView(context, mHelper.hasSetSuffixMinute, mHelper.mSuffixMinuteBackgroundRes,
                mHelper.mSuffixMinuteTextAppearance, mHelper.mSuffixMinute);

        mSecondTextView = createTimeView(context, mHelper.isShowSecond, mHelper.mSecondBackgroundRes,
                mHelper.mSecondTextAppearance, mHelper.mSecondFormat, mHelper.isSecondTwoDigits, mHelper.mLimitSecondDigits);
        createSuffixView(context, mHelper.hasSetSuffixSecond, mHelper.mSuffixSecondBackgroundRes,
                mHelper.mSuffixSecondTextAppearance, mHelper.mSuffixSecond);

        mMillisecondTextView = createTimeView(context, mHelper.isShowMillisecond, mHelper.mMillisecondBackgroundRes,
                mHelper.mMillisecondTextAppearance, mHelper.mMillisecondFormat, false,
                mHelper.mLimitMillisecondDigits, true);
        createSuffixView(context, mHelper.hasSetSuffixMillisecond, mHelper.mSuffixMillisecondBackgroundRes,
                mHelper.mSuffixMillisecondTextAppearance, mHelper.mSuffixMillisecond);
    }

    private void createSuffixView(Context context, boolean hasSetSuffixDay, @DrawableRes int backgroundRes,
                                  int suffixTextAppearance, String suffix) {
        if (hasSetSuffixDay) {
            DrawBgTextView view = new DrawBgTextView(context);
            view.setGravity(Gravity.CENTER);
            Rect rectPadding = mHelper.mSuffixPaddingRect;
            view.setPaddingRelative(rectPadding.left, rectPadding.top, rectPadding.right, rectPadding.bottom);
            if (suffixTextAppearance != 0) {
                TextViewCompat.setTextAppearance(view, suffixTextAppearance);
            } else if (mHelper.mSuffixTextSize != 0 || mHelper.mSuffixTextColor != 0) {
                if (mHelper.mSuffixTextSize != 0) {
                    view.setTextSize(TypedValue.COMPLEX_UNIT_PX, mHelper.mSuffixTextSize);
                }
                if (mHelper.mSuffixTextColor != 0) {
                    view.setTextColor(mHelper.mSuffixTextColor);
                }
            } else {
                TextViewCompat.setTextAppearance(view, mHelper.mSuffixTextAppearance);
            }
            view.setText(TextUtils.isEmpty(suffix) ? ":" : suffix);
            if (backgroundRes != 0) {
                view.setBackgroundResource(backgroundRes);
            } else {
                if (mHelper.mSuffixBackgroundRes != 0) {
                    view.setBackgroundResource(mHelper.mSuffixBackgroundRes);
                } else {
                    int round = mHelper.mSuffixBgRadius;
                    if (round == 0) {
                        round = mHelper.mSuffixBgBorderRadius;
                    }
                    if (mHelper.mSuffixBgColor != 0) {
                        view.setRoundColor(mHelper.mSuffixBgColor, round);
                    }
                    if (mHelper.mSuffixBgBorderColor != 0) {
                        view.setStrokeWidth(mHelper.mSuffixBgBorderColor, round, mHelper.mSuffixBgBorderSize);
                    }
                }
            }
            Rect rectMargin = mHelper.mSuffixMarginRect;
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.leftMargin = rectMargin.left;
            params.topMargin = rectMargin.top;
            params.rightMargin = rectMargin.right;
            params.bottomMargin = rectMargin.bottom;
            if (mHelper.mSuffixBgSize > 0) {
                params.width = mHelper.mSuffixBgSize;
                params.height = mHelper.mSuffixBgSize;
                view.setWidth(mHelper.mSuffixBgSize);
                view.setHeight(mHelper.mSuffixBgSize);
            }
            addView(view, params);
        }
    }

    private DrawBgTextView createTimeView(Context context, boolean isShow, @DrawableRes int backgroundRes,
                                          int textAppearance, String format, boolean isLimitTwoDigits, int limitMaximum) {
        return createTimeView(context, isShow, backgroundRes, textAppearance, format, isLimitTwoDigits, limitMaximum, false);
    }

    private DrawBgTextView createTimeView(Context context, boolean isShow, @DrawableRes int backgroundRes,
                                          int textAppearance, String format, boolean isLimitTwoDigits, int limitMaximum, boolean isMillisecond) {
        if (isShow) {
            DrawBgTextView view = new DrawBgTextView(context);
            view.setGravity(Gravity.CENTER);
            Rect rectPadding = mHelper.mTimePaddingRect;
            view.setPaddingRelative(rectPadding.left, rectPadding.top, rectPadding.right, rectPadding.bottom);
            if (textAppearance != 0) {
                TextViewCompat.setTextAppearance(view, textAppearance);
            } else if (mHelper.mTimeTextSize != 0 || mHelper.mTimeTextColor != 0) {
                if (mHelper.mTimeTextSize != 0) {
                    view.setTextSize(TypedValue.COMPLEX_UNIT_PX, mHelper.mTimeTextSize);
                }
                if (mHelper.mTimeTextColor != 0) {
                    view.setTextColor(mHelper.mTimeTextColor);
                }
            } else {
                TextViewCompat.setTextAppearance(view, mHelper.mTimeTextAppearance);
            }
            Rect rectMargin = mHelper.mTimeMarginRect;
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.leftMargin = rectMargin.left;
            params.topMargin = rectMargin.top;
            params.rightMargin = rectMargin.right;
            params.bottomMargin = rectMargin.bottom;
            if (backgroundRes != 0) {
                view.setBackgroundResource(backgroundRes);
            } else {
                if (mHelper.mTimeBackgroundRes != 0) {
                    view.setBackgroundResource(mHelper.mTimeBackgroundRes);
                } else {
                    int round = mHelper.mTimeBgRadius;
                    if (round == 0) {
                        round = mHelper.mTimeBgBorderRadius;
                    }
                    if (mHelper.mTimeBgColor != 0) {
                        view.setRoundColor(mHelper.mTimeBgColor, round);
                    }
                    if (mHelper.mTimeBgBorderColor != 0) {
                        view.setStrokeWidth(mHelper.mTimeBgBorderColor, round, mHelper.mTimeBgBorderSize);
                    }
                }
            }
            view.setFormat(format);
            view.setLimitMaximum(limitMaximum);
            view.setLimitTwoDigits(isLimitTwoDigits);
            view.setMillisecond(isMillisecond);
            if (mHelper.mTimeBgSize > 0) {
                params.width = mHelper.mTimeBgSize;
                params.height = mHelper.mTimeBgSize;
                view.setWidth(mHelper.mTimeBgSize);
                view.setHeight(mHelper.mTimeBgSize);
            }
            addView(view, params);
            return view;
        }
        return null;
    }

    Rect checkRect(Rect rect, int size) {
        Rect outRect = new Rect(rect);
        outRect.offset(size, size);
        return outRect;
    }

    @Override
    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL) {
            return;
        }
        super.setOrientation(orientation);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        start(mHelper.remainTime);
    }

    /**
     * 开始倒计时
     *
     * @author dingpeihua
     * @date 2019/5/8 09:57
     * @version 1.0
     */
    public void start() {
        start(mHelper.remainTime);
    }


    /**
     * 开始倒计时
     *
     * @param millisecond 倒计时时间值，单位毫秒
     * @author dingpeihua
     * @date 2019/5/8 20:21
     * @version 1.0
     */
    public void start(long millisecond) {
        if (millisecond <= 0) {
            return;
        }
        if (null != mCountDownTimer) {
            mCountDownTimer.stop();
            mCountDownTimer = null;
        }
        long countDownInterval;
        if (mHelper.isShowMillisecond) {
            countDownInterval = 10;
            updateShow(millisecond);
        } else {
            countDownInterval = 1000;
        }
        mCountDownTimer = new CountDownTimer(millisecond, countDownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateShow(millisUntilFinished);
                if (null != mOnCountdownListener) {
                    mOnCountdownListener.onTick(CountdownView.this, millisUntilFinished);
                }
            }

            @Override
            public void onFinish() {
                // countdown end
                allShowZero();
                // callback
                if (null != mOnCountdownListener) {
                    mOnCountdownListener.onFinish(CountdownView.this);
                }
            }
        };
        mCountDownTimer.start();
    }

    /**
     * 停止倒计时
     *
     * @author dingpeihua
     * @date 2019/5/8 20:21
     * @version 1.0
     */
    public void stop() {
        if (null != mCountDownTimer) {
            mCountDownTimer.stop();
        }
    }

    /**
     * 暂停倒计时
     *
     * @author dingpeihua
     * @date 2019/5/8 20:21
     * @version 1.0
     */
    public void pause() {
        if (null != mCountDownTimer) {
            mCountDownTimer.pause();
        }
    }

    /**
     * 重新开始倒计时
     *
     * @author dingpeihua
     * @date 2019/5/8 20:21
     * @version 1.0
     */
    public void restart() {
        if (null != mCountDownTimer) {
            mCountDownTimer.restart();
        }
    }

    /**
     * 自定义时间显示
     *
     * @param isShowDay         isShowDay
     * @param isShowHour        isShowHour
     * @param isShowMinute      isShowMinute
     * @param isShowSecond      isShowSecond
     * @param isShowMillisecond isShowMillisecond
     * @author dingpeihua
     * @date 2019/5/8 20:20
     * @version 1.0
     */
    public void customTimeShow(boolean isShowDay, boolean isShowHour, boolean isShowMinute, boolean isShowSecond, boolean isShowMillisecond) {
        boolean isModCountdownInterval = mHelper.refTimeShow(isShowDay, isShowHour, isShowMinute, isShowSecond, isShowMillisecond);
        // judgement modify countdown interval
        if (isModCountdownInterval) {
            start(mHelper.remainTime);
        }
    }

    /**
     * 重置倒计时
     *
     * @author dingpeihua
     * @date 2019/5/8 20:22
     * @version 1.0
     */
    public void allShowZero() {
        updateShow(0);
    }

    /**
     * 设置倒计时监听器
     *
     * @param onCountdownEndListener 倒计时监听器
     * @author dingpeihua
     * @date 2019/5/8 20:23
     * @version 1.0
     */
    public void setOnCountdownListener(OnCountdownListener onCountdownEndListener) {
        mOnCountdownListener = onCountdownEndListener;
    }

    /**
     * 设置时间值，单位毫秒
     *
     * @param mRemainTime
     * @author dingpeihua
     * @date 2019/5/8 20:23
     * @version 1.0
     */
    public void setRemainTime(long mRemainTime) {
        reSetTime(mRemainTime);
    }

    /**
     * 获取倒计时时间值 单位毫秒
     *
     * @author dingpeihua
     * @date 2019/5/8 20:23
     * @version 1.0
     */
    public long getRemainTime() {
        return mHelper.remainTime;
    }

    /**
     * 更新时间显示
     *
     * @author dingpeihua
     * @date 2019/5/8 20:24
     * @version 1.0
     */
    public void updateShow(long ms) {
        reSetTime(ms);
    }

    /**
     * 计算时间并刷新视图
     *
     * @author dingpeihua
     * @date 2019/5/8 20:25
     * @version 1.0
     */
    private void reSetTime(long ms) {
        int day = 0;
        int hour;
        int minute;
        int second;
        boolean isConvertTime = mHelper.isConvertDaysToHours;
        if (isConvertTime) {
            hour = (int) (ms / ONE_HOUR);
        } else {
            day = (int) (ms / ONE_DAY);
            hour = (int) ((ms % ONE_DAY) / ONE_HOUR);
        }
        //如果需要将天转成时，则分不能转
        if (!isConvertTime && mHelper.isConvertHoursToMinutes) {
            isConvertTime = true;
            minute = (int) (ms / ONE_MINUTE);
        } else {
            minute = (int) ((ms % ONE_HOUR) / ONE_MINUTE);
        }
        //如果需要将天转成时或者时转成分，则秒不能转
        if (!isConvertTime && mHelper.isConvertMinutesToSeconds) {
            second = (int) (ms / ONE_SECOND);
        } else {
            second = (int) ((ms % ONE_MINUTE) / ONE_SECOND);
        }
        int millisecond = (int) (ms % ONE_SECOND);
        mHelper.remainTime = ms;
        mHelper.setTimes(day, hour, minute, second, millisecond);
        updateText(day, hour, minute, second, millisecond);
    }

    private void updateText(int day, int hour, int minute, int second, int millisecond) {
        if (mDayTextView != null) {
            mDayTextView.setValue(day);
        }
        if (mHourTextView != null) {
            mHourTextView.setValue(hour);
        }
        if (mMinuteTextView != null) {
            mMinuteTextView.setValue(minute);
        }
        if (mSecondTextView != null) {
            mSecondTextView.setValue(second);
        }
        if (mMillisecondTextView != null) {
            mMillisecondTextView.setValue(millisecond);
        }
    }

    /**
     * Dynamic show
     *
     * @param config DynamicConfig
     */
    public void startDynamic(DynamicConfig config) {
        if (this.mHelper == null) {
            this.mHelper = new AttributeHelper();
        }
        mHelper.configs(config);
        init(mContext);
        start(config.remainTime);
    }
}
