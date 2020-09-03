package com.fz.countdowntimer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;

/**
 * 倒计时组件属性辅助类
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2019/5/8 19:59
 */
class AttributeHelper {
    /**
     * 默认时间后缀
     */
    static final String DEFAULT_SUFFIX = ":";
    /**
     * 时间值，天、时、分、秒、毫秒
     */
    int mDay, mHour, mMinute, mSecond, mMillisecond;
    /**
     * 控制时间显示和隐藏
     * {@link #isShowDay} 是否显示天
     * {@link #isShowHour} 是否显示小时
     * {@link #isShowMinute} 是否显示分钟
     * {@link #isShowSecond} 是否显示秒
     * {@link #isShowMillisecond} 是否显示毫秒
     */
    boolean isShowDay, isShowHour, isShowMinute, isShowSecond, isShowMillisecond;

    /**
     * 当前上下文
     */
    Context mContext;
    /**
     * 时间格式化字符，只适用于{@link String#format(String, Object...)}方式
     *
     * @see {@link String#format(String, Object...)}
     */
    String mDayFormat, mHourFormat, mMinuteFormat, mSecondFormat, mMillisecondFormat;
    /**
     * 时间后缀符，默认是为“:”
     * {@link #mSuffix} 全局后缀符
     * {@link #mSuffixDay} 天数后缀符
     * {@link #mSuffixHour} 小时数后缀符
     * {@link #mSuffixMinute} 分钟数后缀符
     * {@link #mSuffixSecond} 秒数后缀符
     * {@link #mSuffixMillisecond} 毫秒数后缀符
     */
    String mSuffix, mSuffixDay, mSuffixHour, mSuffixMinute, mSuffixSecond, mSuffixMillisecond;
    /**
     * 用于判定是否含有后缀符号
     * {@link #hasSetSuffixDay} 是否有天数后缀符
     * {@link #hasSetSuffixHour} 是否有小时数后缀符
     * {@link #hasSetSuffixMinute} 是否有分钟数后缀符
     * {@link #hasSetSuffixSecond} 是否有秒数后缀符
     * {@link #hasSetSuffixMillisecond} 是否有毫秒数后缀符
     */
    boolean hasSetSuffixDay, hasSetSuffixHour, hasSetSuffixMinute, hasSetSuffixSecond, hasSetSuffixMillisecond;
    /**
     * 是否字体颜色
     */
    @ColorInt
    int mTimeTextColor;
    /**
     * 时间字体大小，单位px
     */
    float mTimeTextSize;
    /**
     * 后缀符号字体颜色
     */
    @ColorInt
    int mSuffixTextColor;
    /**
     * 后缀符号字体大小
     */
    float mSuffixTextSize;
    /**
     * 时间文本样式
     * {@link #mTimeTextAppearance} 全局时间文本样式
     * {@link #mDayTextAppearance} 天数文本样式
     * {@link #mHourTextAppearance} 小时文本样式
     * {@link #mMinuteTextAppearance} 分钟文本样式
     * {@link #mSecondTextAppearance} 秒数文本样式
     * {@link #mMillisecondTextAppearance} 毫秒数文本样式
     */
    int mTimeTextAppearance, mDayTextAppearance, mHourTextAppearance,
            mMinuteTextAppearance, mSecondTextAppearance, mMillisecondTextAppearance;
    /**
     * 后缀符文本样式
     * {@link #mSuffixTextAppearance} 全局时间后缀符号文本样式
     * {@link #mSuffixDayTextAppearance} 天数后缀符号文本样式
     * {@link #mSuffixHourTextAppearance} 小时后缀符号文本样式
     * {@link #mSuffixMinuteTextAppearance} 分钟后缀符号文本样式
     * {@link #mSuffixSecondTextAppearance} 秒数后缀符号文本样式
     * {@link #mSuffixMillisecondTextAppearance} 毫秒数后缀符号文本样式
     */
    int mSuffixTextAppearance, mSuffixDayTextAppearance, mSuffixHourTextAppearance,
            mSuffixMinuteTextAppearance, mSuffixSecondTextAppearance, mSuffixMillisecondTextAppearance;
    /**
     * 时间背景资源id
     * {@link #mTimeBackgroundRes} 全局时间背景
     * {@link #mDayBackgroundRes} 天数背景
     * {@link #mHourBackgroundRes} 小时背景
     * {@link #mMinuteBackgroundRes} 分钟背景
     * {@link #mSecondBackgroundRes} 秒数背景
     * {@link #mMillisecondBackgroundRes} 毫秒数背景
     */
    @DrawableRes
    int mTimeBackgroundRes, mDayBackgroundRes, mHourBackgroundRes, mMinuteBackgroundRes,
            mSecondBackgroundRes, mMillisecondBackgroundRes;
    /**
     * 时间后缀符背景资源id
     * {@link #mSuffixBackgroundRes} 全局时间后缀符背景
     * {@link #mSuffixDayBackgroundRes} 天数后缀符背景
     * {@link #mSuffixHourBackgroundRes} 小时后缀符背景
     * {@link #mSuffixMinuteBackgroundRes} 分钟后缀符背景
     * {@link #mSuffixSecondBackgroundRes} 秒数后缀符背景
     * {@link #mSuffixMillisecondBackgroundRes} 毫秒数后缀符背景
     */
    @DrawableRes
    int mSuffixBackgroundRes, mSuffixDayBackgroundRes, mSuffixHourBackgroundRes,
            mSuffixMinuteBackgroundRes, mSuffixSecondBackgroundRes, mSuffixMillisecondBackgroundRes;
    /**
     * 是否将(天转换成小时数、小时数转成分钟数、分钟数转成秒数)显示，true是将天转换成小时数显示
     * {@link #isConvertDaysToHours} 当{@link #isShowDay}为false时，是否天转换成小时数
     * {@link #isConvertHoursToMinutes} 当{@link #isShowHour}为false时，是否小时数转成分钟数
     * {@link #isConvertMinutesToSeconds} 当{@link #isShowMinute}为false时，是否分钟数转成秒数
     */
    boolean isConvertDaysToHours, isConvertHoursToMinutes, isConvertMinutesToSeconds;
    /**
     * 小时数最大显示数限制，如：当该值为99时，则小时数显示最大为99
     * {@link #mLimitHourDigits} 当{@link #isConvertDaysToHours}为true时，显示最大小时数
     * {@link #mLimitMinuteDigits} 当{@link #isConvertHoursToMinutes}为true时，显示最大分钟数
     * {@link #mLimitSecondDigits} 当{@link #isConvertMinutesToSeconds}为true时，显示最大秒数
     */
    int mLimitHourDigits, mLimitMinuteDigits, mLimitSecondDigits;
    /**
     * 毫秒数显示位数限制，取值范围是{1,2,3}，即表示要显示的位数，如该值为2，则值显示两位数
     */
    int mLimitMillisecondDigits;
    /**
     * 时间内边距
     */
    Rect mTimePaddingRect;
    /**
     * 时间后缀内边距
     */
    Rect mSuffixPaddingRect;

    /**
     * 时间外边距
     */
    Rect mTimeMarginRect;
    /**
     * 时间后缀外边距
     */
    Rect mSuffixMarginRect;
    /**
     * 用于判定是否含有后缀符，局部使用
     */
    private boolean hasDaySuffix, hasHourSuffix, hasMinuteSuffix, hasSecondSuffix;
    /**
     * 天、时、分、秒是否保留两位数，即如果时间值小于10，是否在前面添加0，默认保留两位
     */
    boolean isDayTwoDigits, isHourTwoDigits, isMinuteTwoDigits, isSecondTwoDigits;
    long remainTime;
    /**
     * 时间背景颜色、圆角，边框颜色、圆角、边框
     * {@link #mTimeBgColor} 时间背景颜色
     * {@link #mTimeBgRadius} 时间背景圆角半径
     * {@link #mTimeBgBorderColor} 时间边框颜色
     * {@link #mTimeBgBorderSize} 时间边框宽度
     * {@link #mTimeBgBorderRadius} 时间边框圆角半径
     */
    int mTimeBgColor;
    int mTimeBgRadius;
    int mTimeBgBorderColor;
    int mTimeBgBorderSize;
    int mTimeBgBorderRadius;

    /**
     * 后缀背景颜色、圆角，边框颜色、圆角、边框
     * {@link #mSuffixBgColor} 后缀背景颜色
     * {@link #mSuffixBgRadius} 后缀背景圆角半径
     * {@link #mSuffixBgBorderColor} 后缀边框颜色
     * {@link #mSuffixBgBorderSize} 后缀边框宽度
     * {@link #mSuffixBgBorderRadius} 后缀边框圆角半径
     */
    int mSuffixBgColor;
    int mSuffixBgRadius;
    int mSuffixBgBorderColor;
    int mSuffixBgBorderSize;
    int mSuffixBgBorderRadius;
    /**
     * 时间背景大小
     */
    int mTimeBgSize;
    /**
     * 后缀背景大小
     */
    int mSuffixBgSize;
    float mDefaultTimeTextSize;
    float mDefaultSuffixTextSize;

    AttributeHelper(Context context, AttributeSet attrs) {
        mContext = context;
        mDefaultTimeTextSize = Utils.sp2px(mContext, 12);
        mDefaultSuffixTextSize = mDefaultTimeTextSize;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CountdownView);
        mTimeTextSize = ta.getDimension(R.styleable.CountdownView_timeTextSize, 0);
        mTimeTextColor = ta.getColor(R.styleable.CountdownView_timeTextColor, 0xFF000000);
        isShowDay = ta.getBoolean(R.styleable.CountdownView_isShowDay, false);
        isShowHour = ta.getBoolean(R.styleable.CountdownView_isShowHour, false);
        isShowMinute = ta.getBoolean(R.styleable.CountdownView_isShowMinute, true);
        isShowSecond = ta.getBoolean(R.styleable.CountdownView_isShowSecond, true);
        isShowMillisecond = ta.getBoolean(R.styleable.CountdownView_isShowMillisecond, false);
        isConvertDaysToHours = ta.getBoolean(R.styleable.CountdownView_isConvertDaysToHours, false);
        mLimitHourDigits = ta.getInt(R.styleable.CountdownView_limitHourDigits, -1);
        isConvertHoursToMinutes = ta.getBoolean(R.styleable.CountdownView_isConvertHoursToMinutes, false);
        mLimitMinuteDigits = ta.getInt(R.styleable.CountdownView_limitMinuteDigits, -1);
        isConvertMinutesToSeconds = ta.getBoolean(R.styleable.CountdownView_isConvertMinutesToSeconds, false);
        mLimitSecondDigits = ta.getInt(R.styleable.CountdownView_limitSecondDigits, -1);

        isDayTwoDigits = ta.getBoolean(R.styleable.CountdownView_isDayTwoDigits, true);
        isHourTwoDigits = ta.getBoolean(R.styleable.CountdownView_isHourTwoDigits, true);
        isMinuteTwoDigits = ta.getBoolean(R.styleable.CountdownView_isMinuteTwoDigits, true);
        isSecondTwoDigits = ta.getBoolean(R.styleable.CountdownView_isSecondTwoDigits, true);

        mLimitMillisecondDigits = ta.getInt(R.styleable.CountdownView_limitMillisecondDigits, 2);

        mSuffixTextSize = ta.getDimension(R.styleable.CountdownView_suffixTextSize, 0);
        mSuffixTextColor = ta.getColor(R.styleable.CountdownView_suffixTextColor, 0xFF000000);
        mDayFormat = ta.getString(R.styleable.CountdownView_dayFormat);
        mHourFormat = ta.getString(R.styleable.CountdownView_hourFormat);
        mMinuteFormat = ta.getString(R.styleable.CountdownView_minuteFormat);
        mSecondFormat = ta.getString(R.styleable.CountdownView_secondFormat);
        mMillisecondFormat = ta.getString(R.styleable.CountdownView_millisecondFormat);

        mSuffix = ta.getString(R.styleable.CountdownView_suffix);
        if (TextUtils.isEmpty(mSuffix)) {
            mSuffix = DEFAULT_SUFFIX;
        }
        hasDaySuffix = ta.hasValue(R.styleable.CountdownView_suffixDay);
        mSuffixDay = ta.getString(R.styleable.CountdownView_suffixDay);
        hasHourSuffix = ta.hasValue(R.styleable.CountdownView_suffixHour);
        mSuffixHour = ta.getString(R.styleable.CountdownView_suffixHour);
        hasMinuteSuffix = ta.hasValue(R.styleable.CountdownView_suffixMinute);
        mSuffixMinute = ta.getString(R.styleable.CountdownView_suffixMinute);
        hasSecondSuffix = ta.hasValue(R.styleable.CountdownView_suffixSecond);
        mSuffixSecond = ta.getString(R.styleable.CountdownView_suffixSecond);
        mSuffixMillisecond = ta.getString(R.styleable.CountdownView_suffixMillisecond);
        // time validate
//        if (!isShowDay && !isShowHour && !isShowMinute) {
//            isShowSecond = true;
//        }
//        if (!isShowSecond) {
//            isShowMillisecond = false;
//        }
        mTimeTextAppearance = ta.getResourceId(R.styleable.CountdownView_timeTextAppearance, android.R.attr.textAppearance);
        mDayTextAppearance = ta.getResourceId(R.styleable.CountdownView_dayTextAppearance, 0);
        mHourTextAppearance = ta.getResourceId(R.styleable.CountdownView_hourTextAppearance, 0);
        mMinuteTextAppearance = ta.getResourceId(R.styleable.CountdownView_minuteTextAppearance, 0);
        mSecondTextAppearance = ta.getResourceId(R.styleable.CountdownView_secondTextAppearance, 0);
        mMillisecondTextAppearance = ta.getResourceId(R.styleable.CountdownView_millisecondTextAppearance, 0);

        mSuffixTextAppearance = ta.getResourceId(R.styleable.CountdownView_suffixTextAppearance, android.R.attr.textAppearance);
        mSuffixDayTextAppearance = ta.getResourceId(R.styleable.CountdownView_suffixDayTextAppearance, 0);
        mSuffixHourTextAppearance = ta.getResourceId(R.styleable.CountdownView_suffixHourTextAppearance, 0);
        mSuffixMinuteTextAppearance = ta.getResourceId(R.styleable.CountdownView_suffixMinuteTextAppearance, 0);
        mSuffixSecondTextAppearance = ta.getResourceId(R.styleable.CountdownView_suffixSecondTextAppearance, 0);
        mSuffixMillisecondTextAppearance = ta.getResourceId(R.styleable.CountdownView_suffixMillisecondTextAppearance, 0);

        mTimeBackgroundRes = ta.getResourceId(R.styleable.CountdownView_timeBackground, 0);
        mDayBackgroundRes = ta.getResourceId(R.styleable.CountdownView_dayBackground, 0);
        mHourBackgroundRes = ta.getResourceId(R.styleable.CountdownView_hourBackground, 0);
        mMinuteBackgroundRes = ta.getResourceId(R.styleable.CountdownView_minuteBackground, 0);
        mSecondBackgroundRes = ta.getResourceId(R.styleable.CountdownView_secondBackground, 0);
        mMillisecondBackgroundRes = ta.getResourceId(R.styleable.CountdownView_millisecondBackground, 0);

        mSuffixBackgroundRes = ta.getResourceId(R.styleable.CountdownView_suffixBackground, 0);

        mSuffixDayBackgroundRes = ta.getResourceId(R.styleable.CountdownView_suffixDayBackground, 0);
        mSuffixHourBackgroundRes = ta.getResourceId(R.styleable.CountdownView_suffixHourBackground, 0);
        mSuffixMinuteBackgroundRes = ta.getResourceId(R.styleable.CountdownView_suffixMinuteBackground, 0);
        mSuffixSecondBackgroundRes = ta.getResourceId(R.styleable.CountdownView_suffixSecondBackground, 0);
        mSuffixMillisecondBackgroundRes = ta.getResourceId(R.styleable.CountdownView_suffixMillisecondBackground, 0);

        int mTimePadding = ta.getDimensionPixelSize(R.styleable.CountdownView_timePadding, 0);
        int timePaddingStart = ta.getDimensionPixelSize(R.styleable.CountdownView_timePaddingStart, 0);
        int timePaddingTop = ta.getDimensionPixelSize(R.styleable.CountdownView_timePaddingTop, 0);
        int timePaddingEnd = ta.getDimensionPixelSize(R.styleable.CountdownView_timePaddingEnd, 0);
        int timePaddingBottom = ta.getDimensionPixelSize(R.styleable.CountdownView_timePaddingBottom, 0);
        boolean hasCusPadding = timePaddingStart != 0 || timePaddingTop != 0 || timePaddingEnd != 0 || timePaddingBottom != 0;
        if (hasCusPadding) {
            mTimePaddingRect = new Rect(timePaddingStart, timePaddingTop, timePaddingEnd, timePaddingBottom);
        } else {
            mTimePaddingRect = new Rect(mTimePadding, mTimePadding, mTimePadding, mTimePadding);
        }

        int suffixPadding = ta.getDimensionPixelSize(R.styleable.CountdownView_suffixPadding, 0);
        int suffixPaddingStart = ta.getDimensionPixelSize(R.styleable.CountdownView_suffixPaddingStart, 0);
        int suffixPaddingTop = ta.getDimensionPixelSize(R.styleable.CountdownView_suffixPaddingTop, 0);
        int suffixPaddingEnd = ta.getDimensionPixelSize(R.styleable.CountdownView_suffixPaddingEnd, 0);
        int suffixPaddingBottom = ta.getDimensionPixelSize(R.styleable.CountdownView_suffixPaddingBottom, 0);
        boolean hasCusSuffixPadding = suffixPaddingStart != 0 || suffixPaddingTop != 0 || suffixPaddingEnd != 0 || suffixPaddingBottom != 0;
        if (hasCusSuffixPadding) {
            mSuffixPaddingRect = new Rect(suffixPaddingStart, suffixPaddingTop, suffixPaddingEnd, suffixPaddingBottom);
        } else {
            mSuffixPaddingRect = new Rect(suffixPadding, suffixPadding, suffixPadding, suffixPadding);
        }
//        int mTimeDayPadding = ta.getDimensionPixelSize(R.styleable.CountdownView_timeDayPadding, 0);
//        int mTimeHourPadding = ta.getDimensionPixelSize(R.styleable.CountdownView_timeHourPadding, 0);
//        int mTimeMinutePadding = ta.getDimensionPixelSize(R.styleable.CountdownView_timeMinutePadding, 0);
//        int mTimeSecondPadding = ta.getDimensionPixelSize(R.styleable.CountdownView_timeSecondPadding, 0);
//        int mTimeMillisecondPadding = ta.getDimensionPixelSize(R.styleable.CountdownView_timeMillisecondPadding, 0);

        int timeMarginStart = ta.getDimensionPixelSize(R.styleable.CountdownView_timeMarginStart, 0);
        int timeMarginTop = ta.getDimensionPixelSize(R.styleable.CountdownView_timeMarginTop, 0);
        int timeMarginEnd = ta.getDimensionPixelSize(R.styleable.CountdownView_timeMarginEnd, 0);
        int timeMarginBottom = ta.getDimensionPixelSize(R.styleable.CountdownView_timeMarginBottom, 0);
        mTimeMarginRect = new Rect(timeMarginStart, timeMarginTop, timeMarginEnd, timeMarginBottom);

        int suffixMarginStart = ta.getDimensionPixelSize(R.styleable.CountdownView_suffixMarginStart, 0);
        int suffixMarginTop = ta.getDimensionPixelSize(R.styleable.CountdownView_suffixMarginTop, 0);
        int suffixMarginEnd = ta.getDimensionPixelSize(R.styleable.CountdownView_suffixMarginEnd, 0);
        int suffixMarginBottom = ta.getDimensionPixelSize(R.styleable.CountdownView_suffixMarginBottom, 0);
        mSuffixMarginRect = new Rect(suffixMarginStart, suffixMarginTop, suffixMarginEnd, suffixMarginBottom);

        //时间背景及边框
        mTimeBgRadius = ta.getDimensionPixelSize(R.styleable.CountdownView_timeBgRadius, 0);
        mTimeBgColor = ta.getColor(R.styleable.CountdownView_timeBgColor, 0);
        mTimeBgBorderSize = ta.getDimensionPixelSize(R.styleable.CountdownView_timeBgBorderSize, 0);
        mTimeBgBorderColor = ta.getColor(R.styleable.CountdownView_timeBgBorderColor, 0);
        mTimeBgBorderRadius = ta.getDimensionPixelSize(R.styleable.CountdownView_timeBgBorderRadius, 0);
        //时间背景大小
        mTimeBgSize = ta.getDimensionPixelSize(R.styleable.CountdownView_timeBgSize, 0);
        //后缀背景大小
        mSuffixBgSize = ta.getDimensionPixelSize(R.styleable.CountdownView_suffixBgSize, 0);
        //时间后缀背景及边框
        mSuffixBgColor = ta.getColor(R.styleable.CountdownView_suffixBgColor, 0);
        mSuffixBgRadius = ta.getDimensionPixelSize(R.styleable.CountdownView_suffixBgRadius, 0);
        mSuffixBgBorderColor = ta.getColor(R.styleable.CountdownView_suffixBgBorderColor, 0);
        mSuffixBgBorderSize = ta.getDimensionPixelSize(R.styleable.CountdownView_suffixBgBorderSize, 0);
        mSuffixBgBorderRadius = ta.getDimensionPixelSize(R.styleable.CountdownView_suffixBgBorderRadius, 0);


        ta.recycle();
        initSuffixBase();
    }

    AttributeHelper() {
    }

    void configs(DynamicConfig dynamicConfig) {
        mDay = dynamicConfig.mDay == null ? mDay : dynamicConfig.mDay;
        mHour = dynamicConfig.mHour == null ? mHour : dynamicConfig.mHour;
        mMinute = dynamicConfig.mMinute == null ? mMinute : dynamicConfig.mMinute;
        mSecond = dynamicConfig.mSecond == null ? mSecond : dynamicConfig.mSecond;
        mMillisecond = dynamicConfig.mMillisecond == null ? mMillisecond : dynamicConfig.mMillisecond;
        isShowDay = dynamicConfig.isShowDay == null ? isShowDay : dynamicConfig.isShowDay;
        isShowHour = dynamicConfig.isShowHour == null ? isShowHour : dynamicConfig.isShowHour;
        isShowMinute = dynamicConfig.isShowMinute == null ? isShowMinute : dynamicConfig.isShowMinute;
        isShowSecond = dynamicConfig.isShowSecond == null ? isShowSecond : dynamicConfig.isShowSecond;
        isShowMillisecond = dynamicConfig.isShowMillisecond == null ? isShowMillisecond : dynamicConfig.isShowMillisecond;
        isConvertDaysToHours = dynamicConfig.isConvertDaysToHours == null ? isConvertDaysToHours : dynamicConfig.isConvertDaysToHours;
        mDayFormat = dynamicConfig.mDayFormat == null ? mDayFormat : dynamicConfig.mDayFormat;
        mHourFormat = dynamicConfig.mHourFormat == null ? mHourFormat : dynamicConfig.mHourFormat;
        mMinuteFormat = dynamicConfig.mMinuteFormat == null ? mMinuteFormat : dynamicConfig.mMinuteFormat;
        mSecondFormat = dynamicConfig.mSecondFormat == null ? mSecondFormat : dynamicConfig.mSecondFormat;
        mMillisecondFormat = dynamicConfig.mMillisecondFormat == null ? mMillisecondFormat : dynamicConfig.mMillisecondFormat;
        mSuffix = dynamicConfig.mSuffix == null ? mSuffix : dynamicConfig.mSuffix;
        mSuffixDay = dynamicConfig.mSuffixDay == null ? mSuffixDay : dynamicConfig.mSuffixDay;
        mSuffixHour = dynamicConfig.mSuffixHour == null ? mSuffixHour : dynamicConfig.mSuffixHour;
        mSuffixMinute = dynamicConfig.mSuffixMinute == null ? mSuffixMinute : dynamicConfig.mSuffixMinute;
        mSuffixSecond = dynamicConfig.mSuffixSecond == null ? mSuffixSecond : dynamicConfig.mSuffixSecond;
        mSuffixMillisecond = dynamicConfig.mSuffixMillisecond == null ? mSuffixMillisecond : dynamicConfig.mSuffixMillisecond;

        mTimeTextColor = dynamicConfig.mTimeTextColor == null ? mTimeTextColor : dynamicConfig.mTimeTextColor;
        mTimeTextSize = dynamicConfig.mTimeTextSize == null ? mTimeTextSize : dynamicConfig.mTimeTextSize;
        mSuffixTextColor = dynamicConfig.mSuffixTextColor == null ? mSuffixTextColor : dynamicConfig.mSuffixTextColor;
        mSuffixTextSize = dynamicConfig.mSuffixTextSize == null ? mSuffixTextSize : dynamicConfig.mSuffixTextSize;
        mTimeTextAppearance = dynamicConfig.mTimeTextAppearance == null ? mTimeTextAppearance : dynamicConfig.mTimeTextAppearance;
        mDayTextAppearance = dynamicConfig.mDayTextAppearance == null ? mDayTextAppearance : dynamicConfig.mDayTextAppearance;
        mHourTextAppearance = dynamicConfig.mHourTextAppearance == null ? mHourTextAppearance : dynamicConfig.mHourTextAppearance;
        mMinuteTextAppearance = dynamicConfig.mMinuteTextAppearance == null ? mMinuteTextAppearance : dynamicConfig.mMinuteTextAppearance;
        mSecondTextAppearance = dynamicConfig.mSecondTextAppearance == null ? mSecondTextAppearance : dynamicConfig.mSecondTextAppearance;
        mMillisecondTextAppearance = dynamicConfig.mMillisecondTextAppearance == null ? mMillisecondTextAppearance : dynamicConfig.mMillisecondTextAppearance;
        mSuffixTextAppearance = dynamicConfig.mSuffixTextAppearance == null ? mSuffixTextAppearance : dynamicConfig.mSuffixTextAppearance;
        mSuffixDayTextAppearance = dynamicConfig.mSuffixDayTextAppearance == null ? mSuffixDayTextAppearance : dynamicConfig.mSuffixDayTextAppearance;
        mSuffixHourTextAppearance = dynamicConfig.mSuffixHourTextAppearance == null ? mSuffixHourTextAppearance : dynamicConfig.mSuffixHourTextAppearance;
        mSuffixMinuteTextAppearance = dynamicConfig.mSuffixMinuteTextAppearance == null ? mSuffixMinuteTextAppearance : dynamicConfig.mSuffixMinuteTextAppearance;
        mSuffixSecondTextAppearance = dynamicConfig.mSuffixSecondTextAppearance == null ? mSuffixSecondTextAppearance : dynamicConfig.mSuffixSecondTextAppearance;
        mSuffixMillisecondTextAppearance = dynamicConfig.mSuffixMillisecondTextAppearance == null ? mSuffixMillisecondTextAppearance : dynamicConfig.mSuffixMillisecondTextAppearance;
        mTimeBackgroundRes = dynamicConfig.mTimeBackgroundRes == null ? mTimeBackgroundRes : dynamicConfig.mTimeBackgroundRes;
        mDayBackgroundRes = dynamicConfig.mDayBackgroundRes == null ? mDayBackgroundRes : dynamicConfig.mDayBackgroundRes;
        mHourBackgroundRes = dynamicConfig.mHourBackgroundRes == null ? mHourBackgroundRes : dynamicConfig.mHourBackgroundRes;
        mMinuteBackgroundRes = dynamicConfig.mMinuteBackgroundRes == null ? mMinuteBackgroundRes : dynamicConfig.mMinuteBackgroundRes;
        mSecondBackgroundRes = dynamicConfig.mSecondBackgroundRes == null ? mSecondBackgroundRes : dynamicConfig.mSecondBackgroundRes;
        mMillisecondBackgroundRes = dynamicConfig.mMillisecondBackgroundRes == null ? mMillisecondBackgroundRes : dynamicConfig.mMillisecondBackgroundRes;
        mSuffixBackgroundRes = dynamicConfig.mSuffixBackgroundRes == null ? mSuffixBackgroundRes : dynamicConfig.mSuffixBackgroundRes;
        mSuffixDayBackgroundRes = dynamicConfig.mSuffixDayBackgroundRes == null ? mSuffixDayBackgroundRes : dynamicConfig.mSuffixDayBackgroundRes;
        mSuffixHourBackgroundRes = dynamicConfig.mSuffixHourBackgroundRes == null ? mSuffixHourBackgroundRes : dynamicConfig.mSuffixHourBackgroundRes;
        mSuffixMinuteBackgroundRes = dynamicConfig.mSuffixMinuteBackgroundRes == null ? mSuffixMinuteBackgroundRes : dynamicConfig.mSuffixMinuteBackgroundRes;
        mSuffixSecondBackgroundRes = dynamicConfig.mSuffixSecondBackgroundRes == null ? mSuffixSecondBackgroundRes : dynamicConfig.mSuffixSecondBackgroundRes;
        mSuffixMillisecondBackgroundRes = dynamicConfig.mSuffixMillisecondBackgroundRes == null ? mSuffixMillisecondBackgroundRes : dynamicConfig.mSuffixMillisecondBackgroundRes;
        mLimitHourDigits = dynamicConfig.mLimitHourDigits == null ? mLimitHourDigits : dynamicConfig.mLimitHourDigits;
        mLimitMillisecondDigits = dynamicConfig.mLimitMillisecondDigits == null ? mLimitMillisecondDigits : dynamicConfig.mLimitMillisecondDigits;

        mTimePaddingRect = dynamicConfig.mTimePaddingRect == null ? mTimePaddingRect : dynamicConfig.mTimePaddingRect;
        mSuffixPaddingRect = dynamicConfig.mSuffixPaddingRect == null ? mSuffixPaddingRect : dynamicConfig.mSuffixPaddingRect;
        mTimeMarginRect = dynamicConfig.mTimeMarginRect == null ? mTimeMarginRect : dynamicConfig.mTimeMarginRect;
        mSuffixMarginRect = dynamicConfig.mSuffixMarginRect == null ? mSuffixMarginRect : dynamicConfig.mSuffixMarginRect;

        isDayTwoDigits = dynamicConfig.isDayTwoDigits == null ? isDayTwoDigits : dynamicConfig.isDayTwoDigits;
        isHourTwoDigits = dynamicConfig.isHourTwoDigits == null ? isHourTwoDigits : dynamicConfig.isHourTwoDigits;
        isMinuteTwoDigits = dynamicConfig.isMinuteTwoDigits == null ? isMinuteTwoDigits : dynamicConfig.isMinuteTwoDigits;
        isSecondTwoDigits = dynamicConfig.isSecondTwoDigits == null ? isSecondTwoDigits : dynamicConfig.isSecondTwoDigits;
        remainTime = dynamicConfig.remainTime == null ? remainTime : dynamicConfig.remainTime;

        //时间背景及边框
        mTimeBgRadius = dynamicConfig.mTimeBgRadius == null ? mTimeBgRadius : dynamicConfig.mTimeBgRadius;
        mTimeBgColor = dynamicConfig.mTimeBgColor == null ? mTimeBgColor : dynamicConfig.mTimeBgColor;
        mTimeBgBorderSize = dynamicConfig.mTimeBgBorderSize == null ? mTimeBgBorderSize : dynamicConfig.mTimeBgBorderSize;
        mTimeBgBorderColor = dynamicConfig.mTimeBgBorderColor == null ? mTimeBgBorderColor : dynamicConfig.mTimeBgBorderColor;
        mTimeBgBorderRadius = dynamicConfig.mTimeBgBorderRadius == null ? mTimeBgBorderRadius : dynamicConfig.mTimeBgBorderRadius;

        //时间后缀背景及边框
        mSuffixBgColor = dynamicConfig.mSuffixBgColor == null ? mSuffixBgColor : dynamicConfig.mSuffixBgColor;
        mSuffixBgRadius = dynamicConfig.mSuffixBgRadius == null ? mSuffixBgRadius : dynamicConfig.mSuffixBgRadius;
        mSuffixBgBorderColor = dynamicConfig.mSuffixBgBorderColor == null ? mSuffixBgBorderColor : dynamicConfig.mSuffixBgBorderColor;
        mSuffixBgBorderSize = dynamicConfig.mSuffixBgBorderSize == null ? mSuffixBgBorderSize : dynamicConfig.mSuffixBgBorderSize;
        mSuffixBgBorderRadius = dynamicConfig.mSuffixBgBorderRadius == null ? mSuffixBgBorderRadius : dynamicConfig.mSuffixBgBorderRadius;

        isConvertHoursToMinutes = dynamicConfig.isConvertHoursToMinutes == null ? isConvertHoursToMinutes : dynamicConfig.isConvertHoursToMinutes;
        mLimitMinuteDigits = dynamicConfig.mLimitMinuteDigits == null ? mLimitMinuteDigits : dynamicConfig.mLimitMinuteDigits;
        isConvertMinutesToSeconds = dynamicConfig.isConvertMinutesToSeconds == null ? isConvertMinutesToSeconds : dynamicConfig.isConvertMinutesToSeconds;
        mLimitSecondDigits = dynamicConfig.mLimitSecondDigits == null ? mLimitSecondDigits : dynamicConfig.mLimitSecondDigits;
        mTimeBgSize = dynamicConfig.mTimeBgSize == null ? mTimeBgSize : dynamicConfig.mTimeBgSize;
        mSuffixBgSize = dynamicConfig.mSuffixBgSize == null ? mSuffixBgSize : dynamicConfig.mSuffixBgSize;
        initSuffixBase();
    }

    private void initSuffixBase() {
        checkParams();
        hasSetSuffixDay = !TextUtils.isEmpty(mSuffixDay) || !hasDaySuffix && isShowDay;
        hasSetSuffixHour = !TextUtils.isEmpty(mSuffixHour) || !hasHourSuffix && isShowMinute && isShowHour;
        hasSetSuffixMinute = !TextUtils.isEmpty(mSuffixMinute) || !hasMinuteSuffix && isShowSecond && isShowMinute;
        hasSetSuffixSecond = !TextUtils.isEmpty(mSuffixSecond) || !hasSecondSuffix && isShowMillisecond && isShowSecond;
        hasSetSuffixMillisecond = !TextUtils.isEmpty(mSuffixMillisecond);
    }

    void checkParams() {
        isConvertDaysToHours = isConvertDaysToHours && isShowHour;
        isConvertHoursToMinutes = isConvertHoursToMinutes && isShowMinute;
        isConvertMinutesToSeconds = isConvertMinutesToSeconds && isShowSecond;
    }

    void setTimes(int day, int hour, int minute, int second, int millisecond) {
        mDay = day;
        mHour = hour;
        mMinute = minute;
        mSecond = second;
        mMillisecond = millisecond;
    }

    boolean refTimeShow(boolean isShowDay, boolean isShowHour, boolean isShowMinute,
                        boolean isShowSecond, boolean isShowMillisecond) {
        if (!isShowSecond) {
            isShowMillisecond = false;
        }
        boolean isModCountdownInterval = false;
        if (this.isShowDay != isShowDay) {
            this.isShowDay = isShowDay;
        }
        if (this.isShowHour != isShowHour) {
            this.isShowHour = isShowHour;
        }
        if (this.isShowMinute != isShowMinute) {
            this.isShowMinute = isShowMinute;
        }
        if (this.isShowSecond != isShowSecond) {
            this.isShowSecond = isShowSecond;
            isModCountdownInterval = true;
        }
        if (this.isShowMillisecond != isShowMillisecond) {
            this.isShowMillisecond = isShowMillisecond;
            isModCountdownInterval = true;
        }
        return isModCountdownInterval;
    }
}
