# Android 倒计时组件，支持自定义样式

## 效果图
<img width="360" height="640" src="/images/16263343157578.png"/>

## 使用倒计时组件

通过XML将RatioImageView添加为布局文件，可以将其与任何其他视图一样使用

```css
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/rl_flash_sale"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="#ccF4394F"
    android:gravity="center"
    android:orientation="horizontal"
    android:padding="5dp"
    app:layout_constraintBottom_toBottomOf="@id/iv_image"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent">

    <com.fz.countdowntimer.CountdownView
        android:id="@+id/cv_countdown_timer"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentEnd="true"
        android:layout_centerVertical="true"
        android:layout_gravity="center"
        android:layout_marginStart="5dp"
        android:layoutDirection="ltr"
        app:isConvertDaysToHours="true"
        app:isShowDay="false"
        app:isShowHour="true"
        app:isShowMillisecond="false"
        app:isShowMinute="true"
        app:isShowSecond="true"
        app:limitHourDigits="99"
        app:suffixTextColor="@color/white"
        app:suffixTextSize="12sp"
        app:timeMarginEnd="3dp"
        app:timeMarginStart="3dp"
        app:timeTextColor="@color/white"
        app:timeTextSize="11sp" />
</RelativeLayout>
```

属性列表

```css
<declare-styleable name="CountdownView">
        <!--时间字体样式-->
        <attr name="timeTextAppearance" format="reference" />
        <attr name="dayTextAppearance" format="reference" />
        <attr name="hourTextAppearance" format="reference" />
        <attr name="minuteTextAppearance" format="reference" />
        <attr name="secondTextAppearance" format="reference" />
        <attr name="millisecondTextAppearance" format="reference" />
        <!--时间后缀字体样式-->
        <attr name="suffixTextAppearance" format="reference" />
        <attr name="suffixDayTextAppearance" format="reference" />
        <attr name="suffixHourTextAppearance" format="reference" />
        <attr name="suffixMinuteTextAppearance" format="reference" />
        <attr name="suffixSecondTextAppearance" format="reference" />
        <attr name="suffixMillisecondTextAppearance" format="reference" />
        <!--倒计时控制属性-->
        <attr name="isShowDay" format="boolean" />
        <attr name="isShowHour" format="boolean" />
        <attr name="isShowMinute" format="boolean" />
        <attr name="isShowSecond" format="boolean" />
        <attr name="isShowMillisecond" format="boolean" />
        <!--格式化显示位数两位00-->
        <attr name="isDayTwoDigits" format="boolean" />
        <attr name="isHourTwoDigits" format="boolean" />
        <attr name="isMinuteTwoDigits" format="boolean" />
        <attr name="isSecondTwoDigits" format="boolean" />
        <!--限制合并小时数时不超过位数-->
        <attr name="isConvertDaysToHours" format="boolean" />
        <attr name="limitHourDigits" format="integer" />
        <attr name="isConvertHoursToMinutes" format="boolean" />
        <attr name="limitMinuteDigits" format="integer" />
        <attr name="isConvertMinutesToSeconds" format="boolean" />
        <attr name="limitSecondDigits" format="integer" />
        <attr name="limitMillisecondDigits" format="enum">
            <enum name="one" value="1" />
            <enum name="two" value="2" />
            <enum name="three" value="3" />
        </attr>
        <!--格式符-->
        <attr name="dayFormat" format="string|reference" />
        <attr name="hourFormat" format="string|reference" />
        <attr name="minuteFormat" format="string|reference" />
        <attr name="secondFormat" format="string|reference" />
        <attr name="millisecondFormat" format="string|reference" />
        <!--后缀符-->
        <attr name="suffix" format="string|reference" />
        <attr name="suffixDay" format="string|reference" />
        <attr name="suffixHour" format="string|reference" />
        <attr name="suffixMinute" format="string|reference" />
        <attr name="suffixSecond" format="string|reference" />
        <attr name="suffixMillisecond" format="string|reference" />
        <!--字体颜色和大小-->
        <attr name="timeTextSize" format="dimension|reference" />
        <attr name="timeTextColor" format="color|reference" />
        <attr name="suffixTextSize" format="dimension|reference" />
        <attr name="suffixTextColor" format="color|reference" />
        <!--时间背景-->
        <attr name="timeBackground" format="reference|color" />
        <attr name="dayBackground" format="reference|color" />
        <attr name="hourBackground" format="reference|color" />
        <attr name="minuteBackground" format="reference|color" />
        <attr name="secondBackground" format="reference|color" />
        <attr name="millisecondBackground" format="reference|color" />
        <!--时间后缀背景-->
        <attr name="suffixBackground" format="reference|color" />
        <attr name="suffixDayBackground" format="reference|color" />
        <attr name="suffixHourBackground" format="reference|color" />
        <attr name="suffixMinuteBackground" format="reference|color" />
        <attr name="suffixSecondBackground" format="reference|color" />
        <attr name="suffixMillisecondBackground" format="reference|color" />
        <!--时间内边距-->
        <attr name="timePadding" format="reference|dimension" />
        <attr name="timePaddingStart" format="reference|dimension" />
        <attr name="timePaddingTop" format="reference|dimension" />
        <attr name="timePaddingEnd" format="reference|dimension" />
        <attr name="timePaddingBottom" format="reference|dimension" />

        <!--<attr name="timeDayPadding" format="reference|dimension" />-->
        <!--<attr name="timeHourPadding" format="reference|dimension" />-->
        <!--<attr name="timeMinutePadding" format="reference|dimension" />-->
        <!--<attr name="timeSecondPadding" format="reference|dimension" />-->
        <!--<attr name="timeMillisecondPadding" format="reference|dimension" />-->
        <!--时间后缀内边距-->
        <attr name="suffixPadding" format="reference|dimension" />
        <attr name="suffixPaddingStart" format="reference|dimension" />
        <attr name="suffixPaddingTop" format="reference|dimension" />
        <attr name="suffixPaddingEnd" format="reference|dimension" />
        <attr name="suffixPaddingBottom" format="reference|dimension" />

        <attr name="suffixDayPadding" format="reference|dimension" />
        <attr name="suffixHourPadding" format="reference|dimension" />
        <attr name="suffixMinutePadding" format="reference|dimension" />
        <attr name="suffixSecondPadding" format="reference|dimension" />
        <attr name="suffixMillisecondPadding" format="reference|dimension" />

        <!--时间外边距-->
        <attr name="timeMarginStart" format="reference|dimension" />
        <attr name="timeMarginTop" format="reference|dimension" />
        <attr name="timeMarginEnd" format="reference|dimension" />
        <attr name="timeMarginBottom" format="reference|dimension" />

        <!--时间后缀外边距-->
        <attr name="suffixMarginStart" format="reference|dimension" />
        <attr name="suffixMarginTop" format="reference|dimension" />
        <attr name="suffixMarginEnd" format="reference|dimension" />
        <attr name="suffixMarginBottom" format="reference|dimension" />
         <!--时间背景边线设置-->
        <attr name="timeBgColor" format="color|reference" />
        <attr name="timeBgRadius" format="dimension|reference" />
        <attr name="timeBgBorderColor" format="color|reference" />
        <attr name="timeBgBorderSize" format="dimension|reference" />
        <attr name="timeBgBorderRadius" format="dimension|reference" />
        <!--时间后缀背景边线设置-->
        <attr name="suffixBgColor" format="color|reference" />
        <attr name="suffixBgRadius" format="dimension|reference" />
        <attr name="suffixBgBorderColor" format="color|reference" />
        <attr name="suffixBgBorderSize" format="dimension|reference" />
        <attr name="suffixBgBorderRadius" format="dimension|reference" />
    </declare-styleable>
```

代码调用

```java
 final CountdownView cvCountdownTimer = findViewById(R.id.cv_countdown_timer);
 cvCountdownTimer.setVisibility(View.VISIBLE);
 cvCountdownTimer.start(countDownEndTime);
```

## 添加存储库

```py
 	allprojects {
 		repositories {
 			...
 			maven { url 'https://jitpack.io' }
 		}
 	}
```

## 添加依赖

```py
dependencies {
     implementation 'com.github.peihua8858:CountDownTimer:Tag'
}
```



