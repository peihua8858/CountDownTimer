/*
 * Copyright (C) Globalegrow E-Commerce Co. , Ltd. 2007-2018.
 * All rights reserved.
 * This software is the confidential and proprietary information
 * of Globalegrow E-Commerce Co. , Ltd. ("Confidential Information").
 * You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement
 * you entered into with Globalegrow.
 */

package com.fz.countdowntimer;

import android.graphics.Rect;

/**
 * 动态参数配置
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2019/5/8 21:01
 */
public class DynamicConfig {
    Integer mDay;
    Integer mHour;
    Integer mMinute;
    Integer mSecond;
    Integer mMillisecond;
    Boolean isShowDay;
    Boolean isShowHour;
    Boolean isShowMinute;
    Boolean isShowSecond;
    Boolean isShowMillisecond;
    Boolean isConvertDaysToHours;
    Boolean isConvertHoursToMinutes;
    Integer mLimitMinuteDigits;
    Boolean isConvertMinutesToSeconds;
    Integer mLimitSecondDigits;
    Integer mLimitHourDigits;
    Integer mLimitMillisecondDigits;
    String mDayFormat;
    String mHourFormat;
    String mMinuteFormat;
    String mSecondFormat;
    String mMillisecondFormat;
    String mSuffix;
    String mSuffixDay;
    String mSuffixHour;
    String mSuffixMinute;
    String mSuffixSecond;
    String mSuffixMillisecond;
    Integer mTimeTextColor;
    Float mTimeTextSize;
    Integer mSuffixTextColor;
    Float mSuffixTextSize;
    Integer mTimeTextAppearance;
    Integer mDayTextAppearance;
    Integer mHourTextAppearance;
    Integer mMinuteTextAppearance;
    Integer mSecondTextAppearance;
    Integer mMillisecondTextAppearance;
    Integer mSuffixTextAppearance;
    Integer mSuffixDayTextAppearance;
    Integer mSuffixHourTextAppearance;
    Integer mSuffixMinuteTextAppearance;
    Integer mSuffixSecondTextAppearance;
    Integer mSuffixMillisecondTextAppearance;
    Integer mTimeBackgroundRes;
    Integer mDayBackgroundRes;
    Integer mHourBackgroundRes;
    Integer mMinuteBackgroundRes;
    Integer mSecondBackgroundRes;
    Integer mMillisecondBackgroundRes;
    Integer mSuffixBackgroundRes;
    Integer mSuffixDayBackgroundRes;
    Integer mSuffixHourBackgroundRes;
    Integer mSuffixMinuteBackgroundRes;
    Integer mSuffixSecondBackgroundRes;
    Integer mSuffixMillisecondBackgroundRes;
    Rect mTimePaddingRect;
    Rect mSuffixPaddingRect;
    Rect mTimeMarginRect;
    Rect mSuffixMarginRect;
    Boolean isDayTwoDigits;
    Boolean isHourTwoDigits;
    Boolean isMinuteTwoDigits;
    Boolean isSecondTwoDigits;
    Long remainTime;
    /**
     * 时间背景颜色、圆角，边框颜色、圆角、边框
     * {@link #mTimeBgColor} 时间背景颜色
     * {@link #mTimeBgRadius} 时间背景圆角半径
     * {@link #mTimeBgBorderColor} 时间边框颜色
     * {@link #mTimeBgBorderSize} 时间边框宽度
     * {@link #mTimeBgBorderRadius} 时间边框圆角半径
     */
    Integer mTimeBgColor;
    Integer mTimeBgRadius;
    Integer mTimeBgBorderColor;
    Integer mTimeBgBorderSize;
    Integer mTimeBgBorderRadius;

    /**
     * 后缀背景颜色、圆角，边框颜色、圆角、边框
     * {@link #mSuffixBgColor} 后缀背景颜色
     * {@link #mSuffixBgRadius} 后缀背景圆角半径
     * {@link #mSuffixBgBorderColor} 后缀边框颜色
     * {@link #mSuffixBgBorderSize} 后缀边框宽度
     * {@link #mSuffixBgBorderRadius} 后缀边框圆角半径
     */
    Integer mSuffixBgColor;
    Integer mSuffixBgRadius;
    Integer mSuffixBgBorderColor;
    Integer mSuffixBgBorderSize;
    Integer mSuffixBgBorderRadius;
    /**
     * 时间背景大小
     */
    Integer mTimeBgSize;
    /**
     * 后缀背景大小
     */
    Integer mSuffixBgSize;

    public static Builder createBuilder() {
        return new Builder();
    }

    private DynamicConfig(Builder builder) {
        mDay = builder.mDay;
        mHour = builder.mHour;
        mMinute = builder.mMinute;
        mSecond = builder.mSecond;
        mMillisecond = builder.mMillisecond;
        isShowDay = builder.isShowDay;
        isShowHour = builder.isShowHour;
        isShowMinute = builder.isShowMinute;
        isShowSecond = builder.isShowSecond;
        isShowMillisecond = builder.isShowMillisecond;
        isConvertDaysToHours = builder.isConvertDaysToHours;
        mDayFormat = builder.mDayFormat;
        mHourFormat = builder.mHourFormat;
        mMinuteFormat = builder.mMinuteFormat;
        mSecondFormat = builder.mSecondFormat;
        mMillisecondFormat = builder.mMillisecondFormat;
        mSuffix = builder.mSuffix;
        mSuffixDay = builder.mSuffixDay;
        mSuffixHour = builder.mSuffixHour;
        mSuffixMinute = builder.mSuffixMinute;
        mSuffixSecond = builder.mSuffixSecond;
        mSuffixMillisecond = builder.mSuffixMillisecond;
        mTimeTextColor = builder.mTimeTextColor;
        mTimeTextSize = builder.mTimeTextSize;
        mSuffixTextColor = builder.mSuffixTextColor;
        mSuffixTextSize = builder.mSuffixTextSize;
        mTimeTextAppearance = builder.mTimeTextAppearance;
        mDayTextAppearance = builder.mDayTextAppearance;
        mHourTextAppearance = builder.mHourTextAppearance;
        mMinuteTextAppearance = builder.mMinuteTextAppearance;
        mSecondTextAppearance = builder.mSecondTextAppearance;
        mMillisecondTextAppearance = builder.mMillisecondTextAppearance;
        mSuffixTextAppearance = builder.mSuffixTextAppearance;
        mSuffixDayTextAppearance = builder.mSuffixDayTextAppearance;
        mSuffixHourTextAppearance = builder.mSuffixHourTextAppearance;
        mSuffixMinuteTextAppearance = builder.mSuffixMinuteTextAppearance;
        mSuffixSecondTextAppearance = builder.mSuffixSecondTextAppearance;
        mSuffixMillisecondTextAppearance = builder.mSuffixMillisecondTextAppearance;
        mTimeBackgroundRes = builder.mTimeBackgroundRes;
        mDayBackgroundRes = builder.mDayBackgroundRes;
        mHourBackgroundRes = builder.mHourBackgroundRes;
        mMinuteBackgroundRes = builder.mMinuteBackgroundRes;
        mSecondBackgroundRes = builder.mSecondBackgroundRes;
        mMillisecondBackgroundRes = builder.mMillisecondBackgroundRes;
        mSuffixBackgroundRes = builder.mSuffixBackgroundRes;
        mSuffixDayBackgroundRes = builder.mSuffixDayBackgroundRes;
        mSuffixHourBackgroundRes = builder.mSuffixHourBackgroundRes;
        mSuffixMinuteBackgroundRes = builder.mSuffixMinuteBackgroundRes;
        mSuffixSecondBackgroundRes = builder.mSuffixSecondBackgroundRes;
        mSuffixMillisecondBackgroundRes = builder.mSuffixMillisecondBackgroundRes;
        mLimitHourDigits = builder.mLimitHourDigits;
        mLimitMillisecondDigits = builder.mLimitMillisecondDigits;
        mTimePaddingRect = builder.mTimePaddingRect;
        mSuffixPaddingRect = builder.mSuffixPaddingRect;
        mTimeMarginRect = builder.mTimeMarginRect;
        mSuffixMarginRect = builder.mSuffixMarginRect;
        isDayTwoDigits = builder.isDayTwoDigits;
        isHourTwoDigits = builder.isHourTwoDigits;
        isMinuteTwoDigits = builder.isMinuteTwoDigits;
        isSecondTwoDigits = builder.isSecondTwoDigits;
        remainTime = builder.remainTime;
        //时间背景及边框
        mTimeBgRadius = builder.timeBgRadius;
        mTimeBgColor = builder.timeBgColor;
        mTimeBgBorderSize = builder.timeBgBorderSize;
        mTimeBgBorderColor = builder.timeBgBorderColor;
        mTimeBgBorderRadius = builder.timeBgBorderRadius;

        //时间后缀背景及边框
        mSuffixBgColor = builder.suffixBgColor;
        mSuffixBgRadius = builder.suffixBgRadius;
        mSuffixBgBorderColor = builder.suffixBgBorderColor;
        mSuffixBgBorderSize = builder.suffixBgBorderSize;
        mSuffixBgBorderRadius = builder.suffixBgBorderRadius;

        isConvertHoursToMinutes = builder.isConvertHoursToMinutes;
        mLimitMinuteDigits = builder.limitMinuteDigits;
        isConvertMinutesToSeconds = builder.isConvertMinutesToSeconds;
        mLimitSecondDigits = builder.limitSecondDigits;
        mTimeBgSize = builder.timeBgSize;
        mSuffixBgSize = builder.suffixBgSize;
    }

    public static final class Builder {
        private Integer mDay;
        private Integer mHour;
        private Integer mMinute;
        private Integer mSecond;
        private Integer mMillisecond;
        private Boolean isShowDay;
        private Boolean isShowHour;
        private Boolean isShowMinute;
        private Boolean isShowSecond;
        private Boolean isShowMillisecond;
        private Boolean isConvertDaysToHours;
        private String mDayFormat;
        private String mHourFormat;
        private String mMinuteFormat;
        private String mSecondFormat;
        private String mMillisecondFormat;
        private String mSuffix;
        private String mSuffixDay;
        private String mSuffixHour;
        private String mSuffixMinute;
        private String mSuffixSecond;
        private String mSuffixMillisecond;
        private Integer mTimeTextColor;
        private Float mTimeTextSize;
        private Integer mSuffixTextColor;
        private Float mSuffixTextSize;
        private Integer mTimeTextAppearance;
        private Integer mDayTextAppearance;
        private Integer mHourTextAppearance;
        private Integer mMinuteTextAppearance;
        private Integer mSecondTextAppearance;
        private Integer mMillisecondTextAppearance;
        private Integer mSuffixTextAppearance;
        private Integer mSuffixDayTextAppearance;
        private Integer mSuffixHourTextAppearance;
        private Integer mSuffixMinuteTextAppearance;
        private Integer mSuffixSecondTextAppearance;
        private Integer mSuffixMillisecondTextAppearance;
        private Integer mTimeBackgroundRes;
        private Integer mDayBackgroundRes;
        private Integer mHourBackgroundRes;
        private Integer mMinuteBackgroundRes;
        private Integer mSecondBackgroundRes;
        private Integer mMillisecondBackgroundRes;
        private Integer mSuffixBackgroundRes;
        private Integer mSuffixDayBackgroundRes;
        private Integer mSuffixHourBackgroundRes;
        private Integer mSuffixMinuteBackgroundRes;
        private Integer mSuffixSecondBackgroundRes;
        private Integer mSuffixMillisecondBackgroundRes;
        private Integer mLimitHourDigits;
        private Integer mLimitMillisecondDigits;
        private Rect mTimePaddingRect;
        private Rect mSuffixPaddingRect;
        private Rect mTimeMarginRect;
        private Rect mSuffixMarginRect;
        private Boolean isDayTwoDigits;
        private Boolean isHourTwoDigits;
        private Boolean isMinuteTwoDigits;
        private Boolean isSecondTwoDigits;
        private Long remainTime;
        private Integer timeBgColor;
        private Integer timeBgRadius;
        private Integer timeBgBorderColor;
        private Integer timeBgBorderSize;
        private Integer timeBgBorderRadius;

        private Integer suffixBgColor;
        private Integer suffixBgRadius;
        private Integer suffixBgBorderColor;
        private Integer suffixBgBorderSize;
        private Integer suffixBgBorderRadius;

        private Boolean isConvertHoursToMinutes;
        private Integer limitMinuteDigits;
        private Boolean isConvertMinutesToSeconds;
        private Integer limitSecondDigits;
        private Integer timeBgSize;
        private Integer suffixBgSize;

        public Builder() {
        }

        public Builder setDay(int val) {
            mDay = val;
            return this;
        }

        public Builder setHour(int val) {
            mHour = val;
            return this;
        }

        public Builder setMinute(int val) {
            mMinute = val;
            return this;
        }

        public Builder setSecond(int val) {
            mSecond = val;
            return this;
        }

        public Builder setMillisecond(int val) {
            mMillisecond = val;
            return this;
        }

        public Builder setShowDay(boolean val) {
            isShowDay = val;
            return this;
        }

        public Builder setShowHour(boolean val) {
            isShowHour = val;
            return this;
        }

        public Builder setShowMinute(boolean val) {
            isShowMinute = val;
            return this;
        }

        public Builder setShowSecond(boolean val) {
            isShowSecond = val;
            return this;
        }

        public Builder setShowMillisecond(boolean val) {
            isShowMillisecond = val;
            return this;
        }

        public Builder setConvertDaysToHours(boolean val) {
            isConvertDaysToHours = val;
            return this;
        }

        public Builder setDayFormat(String val) {
            mDayFormat = val;
            return this;
        }

        public Builder setHourFormat(String val) {
            mHourFormat = val;
            return this;
        }

        public Builder setMinuteFormat(String val) {
            mMinuteFormat = val;
            return this;
        }

        public Builder setSecondFormat(String val) {
            mSecondFormat = val;
            return this;
        }

        public Builder setMillisecondFormat(String val) {
            mMillisecondFormat = val;
            return this;
        }

        public Builder setSuffix(String val) {
            mSuffix = val;
            return this;
        }

        public Builder setSuffixDay(String val) {
            mSuffixDay = val;
            return this;
        }

        public Builder setSuffixHour(String val) {
            mSuffixHour = val;
            return this;
        }

        public Builder setSuffixMinute(String val) {
            mSuffixMinute = val;
            return this;
        }

        public Builder setSuffixSecond(String val) {
            mSuffixSecond = val;
            return this;
        }

        public Builder setSuffixMillisecond(String val) {
            mSuffixMillisecond = val;
            return this;
        }

        public Builder setTimeTextColor(Integer val) {
            mTimeTextColor = val;
            return this;
        }

        public Builder setTimeTextSize(Float val) {
            mTimeTextSize = val;
            return this;
        }

        public Builder setSuffixTextColor(int val) {
            mSuffixTextColor = val;
            return this;
        }

        public Builder setSuffixTextSize(float val) {
            mSuffixTextSize = val;
            return this;
        }

        public Builder setTimeTextAppearance(int val) {
            mTimeTextAppearance = val;
            return this;
        }

        public Builder setDayTextAppearance(int val) {
            mDayTextAppearance = val;
            return this;
        }

        public Builder setHourTextAppearance(int val) {
            mHourTextAppearance = val;
            return this;
        }

        public Builder setMinuteTextAppearance(int val) {
            mMinuteTextAppearance = val;
            return this;
        }

        public Builder setSecondTextAppearance(int val) {
            mSecondTextAppearance = val;
            return this;
        }

        public Builder setMillisecondTextAppearance(int val) {
            mMillisecondTextAppearance = val;
            return this;
        }

        public Builder setSuffixTextAppearance(int val) {
            mSuffixTextAppearance = val;
            return this;
        }

        public Builder setSuffixDayTextAppearance(int val) {
            mSuffixDayTextAppearance = val;
            return this;
        }

        public Builder setSuffixHourTextAppearance(int val) {
            mSuffixHourTextAppearance = val;
            return this;
        }

        public Builder setSuffixMinuteTextAppearance(int val) {
            mSuffixMinuteTextAppearance = val;
            return this;
        }

        public Builder setSuffixSecondTextAppearance(int val) {
            mSuffixSecondTextAppearance = val;
            return this;
        }

        public Builder setSuffixMillisecondTextAppearance(int val) {
            mSuffixMillisecondTextAppearance = val;
            return this;
        }

        public Builder setTimeBackgroundRes(int val) {
            mTimeBackgroundRes = val;
            return this;
        }

        public Builder setDayBackgroundRes(int val) {
            mDayBackgroundRes = val;
            return this;
        }

        public Builder setHourBackgroundRes(int val) {
            mHourBackgroundRes = val;
            return this;
        }

        public Builder setSetMinuteBackgroundRes(int val) {
            mMinuteBackgroundRes = val;
            return this;
        }

        public Builder setSecondBackgroundRes(int val) {
            mSecondBackgroundRes = val;
            return this;
        }

        public Builder setMillisecondBackgroundRes(int val) {
            mMillisecondBackgroundRes = val;
            return this;
        }

        public Builder setSuffixBackgroundRes(int val) {
            mSuffixBackgroundRes = val;
            return this;
        }

        public Builder setSuffixDayBackgroundRes(int val) {
            mSuffixDayBackgroundRes = val;
            return this;
        }

        public Builder setSuffixHourBackgroundRes(int val) {
            mSuffixHourBackgroundRes = val;
            return this;
        }

        public Builder setSuffixMinuteBackgroundRes(int val) {
            mSuffixMinuteBackgroundRes = val;
            return this;
        }

        public Builder setSuffixSecondBackgroundRes(int val) {
            mSuffixSecondBackgroundRes = val;
            return this;
        }

        public Builder setSuffixMillisecondBackgroundRes(int val) {
            mSuffixMillisecondBackgroundRes = val;
            return this;
        }

        public Builder setLimitHourDigits(int val) {
            mLimitHourDigits = val;
            return this;
        }

        public Builder setLimitMillisecondDigits(int val) {
            mLimitMillisecondDigits = val;
            return this;
        }

        public Builder setTimePaddingRect(Rect val) {
            mTimePaddingRect = val;
            return this;
        }

        public Builder setSuffixPaddingRect(Rect val) {
            mSuffixPaddingRect = val;
            return this;
        }

        public Builder setTimeMarginRect(Rect val) {
            mTimeMarginRect = val;
            return this;
        }

        public Builder setSuffixMarginRect(Rect val) {
            mSuffixMarginRect = val;
            return this;
        }

        public Builder setDayTwoDigits(boolean val) {
            isDayTwoDigits = val;
            return this;
        }

        public Builder setHourTwoDigits(boolean val) {
            isHourTwoDigits = val;
            return this;
        }

        public Builder setMinuteTwoDigits(boolean val) {
            isMinuteTwoDigits = val;
            return this;
        }

        public Builder setSecondTwoDigits(boolean val) {
            isSecondTwoDigits = val;
            return this;
        }

        public Builder setRemainTime(long remainTime) {
            this.remainTime = remainTime;
            return this;
        }

        public Builder setTimeBgColor(int timeBgColor) {
            this.timeBgColor = timeBgColor;
            return this;
        }

        public Builder setTimeBgRadius(int timeBgRadius) {
            this.timeBgRadius = timeBgRadius;
            return this;
        }

        public Builder setTimeBgBorderColor(int timeBgBorderColor) {
            this.timeBgBorderColor = timeBgBorderColor;
            return this;
        }

        public Builder setTimeBgBorderSize(int timeBgBorderSize) {
            this.timeBgBorderSize = timeBgBorderSize;
            return this;
        }

        public Builder setTimeBgBorderRadius(int timeBgBorderRadius) {
            this.timeBgBorderRadius = timeBgBorderRadius;
            return this;
        }

        public Builder setSuffixBgColor(int suffixBgColor) {
            this.suffixBgColor = suffixBgColor;
            return this;
        }

        public Builder setSuffixBgRadius(int suffixBgRadius) {
            this.suffixBgRadius = suffixBgRadius;
            return this;
        }

        public Builder setSuffixBgBorderColor(int suffixBgBorderColor) {
            this.suffixBgBorderColor = suffixBgBorderColor;
            return this;
        }

        public Builder setSuffixBgBorderSize(int suffixBgBorderSize) {
            this.suffixBgBorderSize = suffixBgBorderSize;
            return this;
        }

        public Builder setSuffixBgBorderRadius(int suffixBgBorderRadius) {
            this.suffixBgBorderRadius = suffixBgBorderRadius;
            return this;
        }

        public Builder setConvertHoursToMinutes(boolean convertHoursToMinutes) {
            isConvertHoursToMinutes = convertHoursToMinutes;
            return this;
        }

        public Builder setLimitMinuteDigits(int limitMinuteDigits) {
            this.limitMinuteDigits = limitMinuteDigits;
            return this;
        }

        public Builder setConvertMinutesToSeconds(boolean convertMinutesToSeconds) {
            isConvertMinutesToSeconds = convertMinutesToSeconds;
            return this;
        }

        public Builder setLimitSecondDigits(int limitSecondDigits) {
            this.limitSecondDigits = limitSecondDigits;
            return this;
        }

        public Builder setTimeBgSize(int timeBgSize) {
            this.timeBgSize = timeBgSize;
            return this;
        }

        public Builder setSuffixBgSize(int suffixBgSize) {
            this.suffixBgSize = suffixBgSize;
            return this;
        }

        public DynamicConfig build() {
            return new DynamicConfig(this);
        }
    }
}
