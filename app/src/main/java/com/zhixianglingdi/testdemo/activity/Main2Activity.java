package com.zhixianglingdi.testdemo.activity;

import android.os.Bundle;


import com.zhixianglingdi.testdemo.R;
import com.zhixianglingdi.testdemo.base.BaseActivity;
import com.zhixianglingdi.testdemo.utils.StatusBarUtil;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class Main2Activity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置透明状态栏
        StatusBarUtil.setImgTransparent(this);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);



    }









}
