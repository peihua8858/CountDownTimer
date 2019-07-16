package com.fz.countdowntimer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * 可绘制背景文本控件
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2019/5/29 16:24
 */
public class DrawBgTextView extends AppCompatTextView {
    private Paint mBgPaint;
    private Paint mStrokePaint;
    private RectF mRectF;
    private int mRound;
    /**
     * 格式化字符{@link String#format(String, Object...)}
     */
    private String mFormat;
    /**
     * 限制显示最大值，如限制99，则大于99时显示99
     */
    private int limitMaximum = -1;
    /**
     * 限制两位数，如果不足，则补充0
     */
    private boolean isLimitTwoDigits;
    private int mValue;
    /**
     * 是不是毫秒
     */
    private boolean isMillisecond;
    public DrawBgTextView(Context context) {
        super(context);
    }

    public DrawBgTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawBgTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setRoundColor(@ColorInt int colorInt, int round) {
        this.mRound = round;
        mBgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBgPaint.setStyle(Paint.Style.FILL);
        mBgPaint.setColor(colorInt);
    }

    public void setStrokeWidth(@ColorInt int colorInt, int round, int width) {
        this.mRound = round;
        mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mStrokePaint.setStyle(Paint.Style.STROKE);
        mStrokePaint.setColor(colorInt);
        mStrokePaint.setStrokeWidth(width);
    }

    public void setLimitMaximum(int limitMaximum) {
        this.limitMaximum = limitMaximum;
    }

    public void setLimitTwoDigits(boolean limitTwoDigits) {
        isLimitTwoDigits = limitTwoDigits;
    }

    public void setMillisecond(boolean millisecond) {
        isMillisecond = millisecond;
    }

    public void setFormat(String format) {
        this.mFormat = format;
        if (mValue > 0) {
            setValue(mValue);
        }
    }

    public void setValue(int value, boolean isLimitTwoDigits, int limitMaximum) {
        mValue = value;
        if (isMillisecond) {
            setText(Utils.formatMillisecond(mFormat, limitMaximum, mValue));
        }else{
            setText(Utils.formatNum(isLimitTwoDigits, mFormat, limitMaximum, mValue));
        }
    }

    public void setValue(int value) {
        setValue(value, isLimitTwoDigits, limitMaximum);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mBgPaint != null) {
            if (mRectF == null) {
                mRectF = new RectF(0, 0, getWidth(), getHeight());
            } else {
                mRectF.set(0, 0, getWidth(), getHeight());
            }
            canvas.drawRoundRect(mRectF, mRound, mRound, mBgPaint);
        }
        if (mStrokePaint != null) {
            if (mRectF == null) {
                mRectF = new RectF(0, 0, getWidth(), getHeight());
            } else {
                mRectF.set(0, 0, getWidth(), getHeight());
            }
            canvas.drawRoundRect(mRectF, mRound, mRound, mStrokePaint);
        }
        super.onDraw(canvas);
    }

    public float measureTextWidth() {
        return measureTextWidth(getText());
    }

    public float measureTextWidth(CharSequence text) {
        if (text == null) {
            return 0;
        }
        if (text.length() == 0) {
            return 0;
        }
        return getPaint().measureText(text.toString());
    }
}
