package com.zhixianglingdi.testdemo.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

import com.zhixianglingdi.testdemo.MyApplication;

/*** ----------BigGod be here!----------/
 * ***┏┓******┏┓*********
 * *┏━┛┻━━━━━━┛┻━━┓*******
 * *┃             ┃*******
 * *┃     ━━━     ┃*******
 * *┃             ┃*******
 * *┃  ━┳┛   ┗┳━  ┃*******
 * *┃             ┃*******
 * *┃     ━┻━     ┃*******
 * *┃             ┃*******
 * *┗━━━┓     ┏━━━┛*******
 * *****┃     ┃神兽保佑*****
 * *****┃     ┃代码无BUG！***
 * *****┃     ┗━━━━━━━━┓*****
 * *****┃              ┣┓****
 * *****┃              ┏┛****
 * *****┗━┓┓┏━━━━┳┓┏━━━┛*****
 * *******┃┫┫****┃┫┫********
 * *******┗┻┛****┗┻┛*********
 * ━━━━━━神兽出没━━━━━━
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 *
 * 项目名称：Yearn
 * 类描述：com.zhixianglingdi.library.utils
 * 创建人：kevin
 * 创建时间：2018/8/21
 * 修改人：kevin
 * 修改时间：
 * 修改备注：今日头条  https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA
 */
public class AutoDensityUtil {

    // android中的dp在渲染前会将dp转为px，计算公式：
    // px = density * dp;
    // density = dpi / 160;
    // px = dp * (dpi / 160)

    private float widthUiPx = 1125f; // 设计图宽度的像素
    private float heightUiPx = 2436f; // 设计图高度的像素
    private float sizeUi = 5.8f; // 设计图屏幕的尺寸
    private float densityUi = 0f;
    private double targetUiDpi = 0.0;
    private float widthUiDp = 360f;

    private float sNonCompatDensity = 0f; // 原始的Density
    private float sNonCompatScaledDensity = 0f; // 原始的ScaledDensity
    private AutoDensityUtil(){


    }


    public static AutoDensityUtil INSTANCE=new AutoDensityUtil();

    public static AutoDensityUtil getInstance(){

        return INSTANCE;
    }



    public void init(float widthUiPx, float heightUiPx, float sizeUi) {

        this.widthUiPx = widthUiPx;
        this.heightUiPx = heightUiPx;
        this.sizeUi = sizeUi;
        init();


    }

    /**
     * 初始化
     */
    public void init() {


        targetUiDpi = Math.sqrt((widthUiPx * widthUiPx + heightUiPx * heightUiPx)) / sizeUi;
        densityUi = (float) (targetUiDpi / 160);
        widthUiDp = widthUiPx / densityUi;



    }

    public void setCustomDensity(Activity activity, final Application application) {
       final DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();


        if (sNonCompatDensity == 0f) {
            sNonCompatDensity = appDisplayMetrics.density;
            sNonCompatScaledDensity = appDisplayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sNonCompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }


                }

                @Override
                public void onLowMemory() {

                }
            });


        }


        final  float targetDensity = appDisplayMetrics.widthPixels / widthUiDp;
        final  float targetScaledDensity = targetDensity * (sNonCompatScaledDensity / sNonCompatDensity);
        final int targetDensityDpi = (int) (160 * targetDensity);

        appDisplayMetrics.density = targetDensity;
        appDisplayMetrics.scaledDensity = targetScaledDensity;
        appDisplayMetrics.densityDpi = targetDensityDpi;

        final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.scaledDensity = targetScaledDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;

        diytargetScaledDensity=targetDensity;
    }


    public static float diytargetScaledDensity=0;



    public static int dp2pxdiy(final float dpValue) {
        if (AutoDensityUtil.diytargetScaledDensity!=0){

            return (int) (dpValue * AutoDensityUtil.diytargetScaledDensity + 0.5f);
        }else {
            final float scale = MyApplication.getInstance().getResources().getDisplayMetrics().density;
            return (int) (dpValue * scale + 0.5f);
        }

    }


}
