package com.fz.countdowntimer;

import android.content.Context;
import android.text.TextUtils;

/**
 * 倒计工具类
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2019/5/8 20:31
 */
final class Utils {

    public static int dp2px(Context context, float dpValue) {
        if (dpValue <= 0) {
            return 0;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static float sp2px(Context context, float spValue) {
        if (spValue <= 0) {
            return 0;
        }
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return spValue * scale;
    }

    public static String formatNum(boolean isFormatTwoDigits, int time) {
        if (isFormatTwoDigits) {
            return time < 10 ? "0" + time : String.valueOf(time);
        }
        return String.valueOf(time);
    }


    public static String formatNum(boolean isFormatTwoDigits, String format, int time) {
        return TextUtils.isEmpty(format) ? formatNum(isFormatTwoDigits, time) : String.format(format, formatNum(isFormatTwoDigits, time));
    }

    public static String formatNum(String format, int time) {
        return TextUtils.isEmpty(format) ? formatNum(true, time) : String.format(format, formatNum(true, time));
    }

    public static String formatNum(boolean isFormatTwoDigits, String format, int limit, int time) {
        if (time > limit && limit > 0) {
            time = limit;
        }
        String result = formatNum(isFormatTwoDigits, format, time);
        return result;
    }

    public static String formatMillisecond(String format, int limit, int millisecond) {
        String retMillisecondStr = String.valueOf(millisecond);
        switch (limit) {
            case 1:
                if (millisecond > 9) {
                    retMillisecondStr = String.valueOf(millisecond / 100);
                }
                break;
            case 2:
                if (millisecond > 99) {
                    retMillisecondStr = String.valueOf(millisecond / 10);
                } else if (millisecond <= 9) {
                    retMillisecondStr = "0" + millisecond;
                }
                break;
            case 3:
                if (millisecond <= 9) {
                    retMillisecondStr = "00" + millisecond;
                } else if (millisecond <= 99) {
                    retMillisecondStr = "0" + millisecond;
                }
                break;
            default:
                break;
        }
        return TextUtils.isEmpty(format) ? retMillisecondStr : String.format(format, retMillisecondStr);
    }
}
