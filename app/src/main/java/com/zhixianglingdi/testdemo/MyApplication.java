package com.zhixianglingdi.testdemo;

import android.app.Application;

import com.zhixianglingdi.testdemo.utils.AutoDensityUtil;

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
 * 项目名称：TestDemo2
 * 类描述：com.zhixianglingdi.testdemo
 * 创建人：kevin
 * 创建时间：2019/3/1
 * 修改人：kevin
 * 修改时间：
 * 修改备注：
 */
public class MyApplication extends Application{


    private static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        AutoDensityUtil.getInstance().init();
    }


    public static MyApplication getInstance() {
        return instance;
    }


}
