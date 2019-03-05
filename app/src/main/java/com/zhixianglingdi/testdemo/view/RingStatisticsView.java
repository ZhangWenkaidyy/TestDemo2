package com.zhixianglingdi.testdemo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.zhixianglingdi.testdemo.R;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class RingStatisticsView extends View {
    private float[] mPercent;
    private String[] arrstr=new String[]{"Saving","Hospitalization","Life Protection"};
    private int[] mColors;

    private Paint mPaint, mPathPaint;
    private static final int DEFAULT_RINGWIDTH = 8;
    private static final int DEFAULT_TEXTSIZE1 = 15;
    private static final int DEFAULT_TEXTSIZE2 = 18;
    private static final int DEFAULT_TEXTSIZE3 = 13;

    private float mRingWidth = 0;
    private int textSize1 = 0, textSize2 = 0, textSize3 = 0;
    private TextPaint mTextPaint;
    private int mTextColor1 = Color.parseColor("#BBB9B8"), mTextColor2 = Color.parseColor("#FC824B");
    private RectF mRectF;

    private int width, height;
    private int radius;

    Context mContext;

    public RingStatisticsView(Context context) {
        super(context);
        initSize(context);
        init();



        mContext=context;
    }

    public RingStatisticsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttr(context, attrs);
        initSize(context);
        init();



        mContext=context;
    }

    public RingStatisticsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(context, attrs);
        initSize(context);
        init();



        mContext=context;
    }

    private void initAttr(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.RingStatisticsView);
        int n = array.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = array.getIndex(i);
            if (attr == R.styleable.RingStatisticsView_rsv_RingWidth) {
                mRingWidth = array.getInt(attr, dp2px(context, DEFAULT_RINGWIDTH));
            }  else if (attr == R.styleable.RingStatisticsView_rsv_PercentTextSize) {
                textSize3 = array.getDimensionPixelSize(attr, sp2px(context, DEFAULT_TEXTSIZE3));
            }
        }
        array.recycle();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mRingWidth);



        mPathPaint = new Paint(mPaint);
        mPathPaint.setStrokeWidth(1);

        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);

        mRectF = new RectF();

    }

    private void initSize(Context context) {
        if (mRingWidth == 0) {
            mRingWidth = dp2px(context, dp2px(context, DEFAULT_RINGWIDTH));
        }
        if (textSize1 == 0) {
            textSize1 = sp2px(context, DEFAULT_TEXTSIZE1);
        }
        if (textSize2 == 0) {
            textSize2 = sp2px(context, DEFAULT_TEXTSIZE2);
        }
        if (textSize3 == 0) {
            textSize3 = sp2px(context, DEFAULT_TEXTSIZE3);
        }
    }

    private int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    private int dp2px(Context context, float dpValue) {
        final float densityScale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * densityScale + 0.5f);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = Math.max(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(widthMeasureSpec));
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getWidth();
        height = getHeight();
       // radius = Math.max(width, height) / 4;
        radius = Math.max(width, height) / 4;



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float sweepAngle = 0f;
        //画圆的起始位置  3点方向为0
        float startAngle = 270f;
        float angle = 0f;
        float startX, startY, centerX, centerY, endX, endY, textX;
        int mCount = mPercent.length;

        for (int i = 0; i < mCount; i++) {

            mRingWidth= getMarrRingWidth()[i];

            //设置笔的宽度
            mPaint.setStrokeWidth(mRingWidth);


            //设置正方形的边长 也就是圆的半径
            mRectF.set(getPaddingLeft() - mRingWidth / 2 + radius, getPaddingTop() - mRingWidth / 2 + radius, width - getPaddingRight() + mRingWidth / 2 - radius, getHeight() - getPaddingBottom() + mRingWidth / 2 - radius);

            Log.i("kevin","—"+width+"—"+height+"—"+radius+"———"+"left=="+(getPaddingLeft() + mRingWidth / 2 + radius)+"top=="+(getPaddingTop() + mRingWidth / 2 + radius)+"right=="+(width - getPaddingRight() - mRingWidth / 2 - radius)+"bottom=="+(getHeight() - getPaddingBottom() - mRingWidth / 2 - radius));

            mPaint.setColor(mColors[i]);
            Log.i("kevin--","sweepAngle"+sweepAngle+"=animationValue="+animationValue);
            startAngle += sweepAngle;
            sweepAngle = 360 * mPercent[i];
            sweepAngle = sweepAngle * animationValue;
            //开始绘制
            canvas.drawArc(mRectF, startAngle, sweepAngle, false, mPaint);
            angle = (startAngle - 180) + sweepAngle / 2;
            startX = (float) (width / 2 - radius * Math.cos(angle * Math.PI / 180));
            startY = (float) (height / 2 - radius * Math.sin(angle * Math.PI / 180));
            if (angle <= 90) {
                centerX = startX - width / 8;
                centerY = startY - height / 8;
                endX = centerX - width / 4;
                endY = centerY;
                textX = centerX - width / 16;
            } else if (angle <= 180) {
                centerX = startX + width / 8;
                centerY = startY - height / 8;
                endX = centerX + width / 4;
                endY = centerY;
                textX = centerX + width / 16;
            } else if (angle <= 270) {
                centerX = startX + width / 8;
                centerY = startY + height / 8;
                endX = centerX + width / 4;
                endY = centerY;
                textX = centerX + width / 16;
            } else {
                centerX = startX - width / 8;
                centerY = startY + height / 8;
                endX = centerX - width / 4;
                endY = centerY;
                textX = centerX - width / 16;
            }
            Path path = new Path();
            path.moveTo(startX, startY);
            path.lineTo(centerX, centerY);
            path.lineTo(endX, endY);
            mPathPaint.setColor(mColors[i]);
            canvas.drawPath(path, mPathPaint);
            DecimalFormat df = new DecimalFormat("######0.0");
            BigDecimal b = new BigDecimal(mPercent[i] * 100);
            double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            String percent = df.format(f1) + "%";
            float text_width = mTextPaint.measureText(percent);
            mTextPaint.setColor(mColors[i]);
            mTextPaint.setTextSize(textSize3);
            canvas.drawText(percent, textX - text_width/4 , endY - (mTextPaint.getFontMetrics().descent - mTextPaint.getFontMetrics().ascent) / 2, mTextPaint);
            /*canvas.drawText(arrstr[i], textX - text_width / 2, endY - (mTextPaint.getFontMetrics().descent - mTextPaint.getFontMetrics().ascent)/8 , mTextPaint);*/

        }

        //mTextPaint.setTextSize(textSize1);
       /* float textwidth1 = mTextPaint.measureText(mstr_total_text);
        mTextPaint.setColor(mTextColor1);
        canvas.drawText(mstr_total_text, width / 2 - textwidth1 / 2, (height / 2 - (mTextPaint.getFontMetrics().descent - mTextPaint.getFontMetrics().ascent) / 2), mTextPaint);
        mTextPaint.setTextSize(textSize2);*/

       /* float textwidth2 = mTextPaint.measureText(mstr_total_number);
        mTextPaint.setColor(mTextColor2);
        canvas.drawText(mstr_total_number, width / 2 - textwidth2 / 2, (height / 2 + (mTextPaint.getFontMetrics().descent - mTextPaint.getFontMetrics().ascent) / 2) + 2, mTextPaint);
       */ canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.save();





    }




    public void setPercentAndColors(float[] percent, int[] colors) {
        if (percent != null && colors != null) {
            if (percent.length == colors.length) {
                mPercent = percent;
                mColors = colors;
            } else {
                throw new IllegalArgumentException("length of percent must equals length of colors");
            }
        }
    }

    public float[] getMarrRingWidth() {
        return marrRingWidth;
    }

    public void setMarrRingWidth(float[] marrRingWidth) {
        this.marrRingWidth = marrRingWidth;
    }

    float[] marrRingWidth;



    public void setRingWidth(float ringWindth) {
        mRingWidth = ringWindth;
    }


    public void setCenterTextColor(int color) {
        mTextColor1 = color;
    }

    public void setCenterNumberColor(int color) {
        mTextColor2 = color;
    }

    public void setCenterTextSize(int size) {
        textSize1 = size;
    }

    public void setCenterNumberSize(int size) {
        textSize2 = size;
    }

    public void setPercentTextSize(int size) {
        textSize3 = size;
    }

    public void refresh() {

       postInvalidate();



    }



    private float animationValue;

    public void startAnimation(int duration) {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animationValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(duration);
        animator.start();
    }





}
