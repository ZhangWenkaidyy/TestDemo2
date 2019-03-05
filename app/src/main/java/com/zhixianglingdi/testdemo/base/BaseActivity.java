package com.zhixianglingdi.testdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhixianglingdi.testdemo.MyApplication;
import com.zhixianglingdi.testdemo.utils.AutoDensityUtil;

import butterknife.internal.Utils;

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
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AutoDensityUtil.getInstance().setCustomDensity(this, MyApplication.getInstance());
        super.onCreate(savedInstanceState);
    }
}
