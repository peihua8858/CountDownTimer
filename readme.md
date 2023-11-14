:heartpulse:CountDownTimer:heartpulse:
 一款针对Android平台下的 Android 倒计时组件，支持自定义样式<br>

[![Jitpack](https://jitpack.io/v/peihua8858/CountDownTimer.svg)](https://github.com/peihua8858)
[![PRs Welcome](https://img.shields.io/badge/PRs-Welcome-brightgreen.svg)](https://github.com/peihua8858)
[![Star](https://img.shields.io/github/stars/peihua8858/CountDownTimer.svg)](https://github.com/peihua8858/CountDownTimer)

## 目录
-[最新版本](https://github.com/peihua8858/CountDownTimer/releases/tag/1.0.4)<br>
-[如何引用](#如何引用)<br>
-[进阶使用](#进阶使用)<br>
-[演示效果](#演示效果)<br>
-[如何提Issues](https://github.com/peihua8858/CountDownTimer/wiki/%E5%A6%82%E4%BD%95%E6%8F%90Issues%3F)<br>
-[License](#License)<br>

## 如何引用
* 把 `maven { url 'https://jitpack.io' }` 加入到 repositories 中
* 添加如下依赖，末尾的「latestVersion」指的是CountDownTimer [![Download](https://jitpack.io/v/peihua8858/CountDownTimer.svg)](https://jitpack.io/#peihua8858/CountDownTimer) 里的版本名称，请自行替换。
使用Gradle
```sh
repositories {
  google()
  maven { url 'https://jitpack.io' }
}

dependencies {
  // CountDownTimer
  implementation 'com.github.peihua8858:CountDownTimer:${latestVersion}'
}
```

或者Maven:

```xml
<dependency>
  <groupId>com.github.peihua8858</groupId>
  <artifactId>CountDownTimer</artifactId>
  <version>${latestVersion}</version>
</dependency>
```

## 进阶使用
通过XML将RatioImageView添加为布局文件，可以将其与任何其他视图一样使用

```xml
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
代码调用

```java
 final CountdownView cvCountdownTimer = findViewById(R.id.cv_countdown_timer);
 cvCountdownTimer.setVisibility(View.VISIBLE);
 cvCountdownTimer.start(countDownEndTime);
```

属性名 | 说明 | 默认值
:----------- | :----------- | :-----------
timeTextAppearance         | 全局时间文本样式        | 0
dayTextAppearance         | 天数文本样式        | 0
hourTextAppearance         | 小时文本样式        | 0
minuteTextAppearance         | 分钟文本样式        | 0
secondTextAppearance         | 秒数文本样式        | 0
millisecondTextAppearance         | 毫秒文本样式        | 0
 |  | 
suffixTextAppearance         | 全局时间后缀文本样式        | 0
suffixDayTextAppearance         | 天数后缀文本样式        | 0
suffixHourTextAppearance         | 小时后缀文本样式        | 0
suffixMinuteTextAppearance         | 分钟后缀文本样式        | 0
suffixSecondTextAppearance         | 秒数后缀文本样式        | 0
suffixMillisecondTextAppearance         | 毫秒数后缀文本样式        | 0
 |  | 
isShowDay         | 是否显示天数        | false
isShowHour         | 是否显示小时数        | false
isShowMinute         | 是否显示分钟数        | true
isShowSecond         | 是否显示秒数        | true
isShowMillisecond         | 是否显示毫秒数        | false
  |  | 
isDayTwoDigits         | 天数是否保留两位数        | true
isHourTwoDigits         | 小时数是否保留两位数        | true
isMinuteTwoDigits         | 分钟数是否保留两位数        | true
isSecondTwoDigits         | 秒数是否保留两位数        | true
  |  | 
isConvertDaysToHours         | 是否将天数转成小时数        | false
isConvertHoursToMinutes         | 是否将小时数转成分钟数        | false
isConvertMinutesToSeconds         | 是否将分钟数转成秒数        | false
limitHourDigits         | 小时数显示位数限制        | true
limitMinuteDigits         | 分钟数显示位数限制        | true
limitSecondDigits         | 秒数显示位数限制        | true
limitMillisecondDigits         | 毫秒数显示位数限制 ，取值范围是{1,2,3}，即表示要显示的位数，如该值为2，则值显示两位数       | true
   |  | 
dayFormat         | 天数格式化字符        | 空
hourFormat         | 小时数格式化字符        | 空
minuteFormat         | 分钟数格式化字符        | 空
secondFormat         | 秒数格式化字符       | 空
millisecondFormat         | 毫秒数格式化字符       | 空
  |  | 
suffix         | 全局后缀符        | :
suffixDay         | 天数后缀符        | :
suffixHour         | 分钟数格式化字符        | :
suffixMinute         | 分钟数后缀符       | :
suffixSecond         | 秒数后缀符       | :
suffixMillisecond         | 毫秒数后缀符       | :
  |  | 
timeTextSize         | 时间字体大小，单位px        | 12sp
timeTextColor         | 时间字体颜色         | Color.BLACK
suffixTextSize         | 后缀符号字体大小        | 12sp
suffixTextColor         | 后缀符号字体颜色       | Color.BLACK
  |  | 
timeBackground         | 全局时间背景       | 0
dayBackground         | 天数背景       | 0
hourBackground         | 小时数背景       | 0
minuteBackground         | 分钟数背景       | 0
secondBackground         | 秒数背景       | 0
millisecondBackground         | 毫秒数背景       | 0
  |  | 
suffixBackground         | 全局时间后缀符背景       | 0
suffixDayBackground         | 天数后缀符背景       | 0
suffixHourBackground         | 小时数后缀符背景       | 0
suffixMinuteBackground         | 分钟数后缀符背景       | 0
suffixSecondBackground         | 秒数后缀符背景       | 0
suffixMillisecondBackground         | 毫秒数后缀符背景       | 0
  |  | 
timePadding         | 全局时间内边距       | 0
timePaddingStart         | 全局时间左内边距       | 0
timePaddingTop         | 全局时间上内边距       | 0
timePaddingEnd         | 全局时间右内边距       | 0
timePaddingBottom         | 全局时间下内边距       | 0
 |  | 
suffixPadding         | 全局时间后缀内边距       | 0
suffixPaddingStart         | 全局时间后缀左内边距       | 0
suffixPaddingTop         | 全局时间后缀上内边距       | 0
suffixPaddingEnd         | 全局时间后缀右内边距       | 0
suffixPaddingBottom         | 全局时间后缀下内边距       | 0
 |  | 
timeMarginStart         | 全局时间后缀左外边距       | 0
timeMarginTop         | 全局时间后缀上外边距       | 0
timeMarginEnd         | 全局时间后缀右外边距       | 0
timeMarginBottom         | 全局时间后缀下外边距       | 0
 |  | 
suffixMarginStart         | 全局时间后缀左外边距       | 0
suffixMarginTop         | 全局时间后缀上外边距       | 0
suffixMarginEnd         | 全局时间后缀右外边距       | 0
suffixMarginBottom         | 全局时间后缀下外边距       | 0
 |  | 
timeBgColor         | 全局时间背景颜色      | 0
timeBgRadius         | 时间背景圆角半径       | 0
timeBgBorderColor         | 时间边框颜色       | 0
timeBgBorderSize         | 时间边框宽度       | 0
timeBgBorderRadius         | 时间边框圆角半径       | 0
 |  | 
suffixBgColor         | 全局后缀背景颜色      | 0
suffixBgRadius         | 后缀背景圆角半径       | 0
suffixBgBorderColor         | 后缀边框颜色       | 0
suffixBgBorderSize         | 后缀边框宽度       | 0
suffixBgBorderRadius         | 后缀边框圆角半径       | 0

## 演示效果
<img width="360" height="640" src="/images/16263343157578.png"/>

## License
```sh
Copyright 2023 peihua

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```



