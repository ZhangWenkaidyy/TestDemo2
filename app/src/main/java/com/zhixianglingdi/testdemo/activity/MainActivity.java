package com.zhixianglingdi.testdemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhixianglingdi.testdemo.R;
import com.zhixianglingdi.testdemo.base.BaseActivity;
import com.zhixianglingdi.testdemo.fragment.FourFragment;
import com.zhixianglingdi.testdemo.fragment.OneFragment;
import com.zhixianglingdi.testdemo.fragment.ThreeFragment;
import com.zhixianglingdi.testdemo.fragment.TwoFragment;
import com.zhixianglingdi.testdemo.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    private int currentTabIndex;

    OneFragment mTab01;
    TwoFragment mTab02;
    ThreeFragment mTab03;
    FourFragment mTab04;



    Context mContext = this;
    @BindView(R.id.fl_main)
    FrameLayout flMain;
    @BindView(R.id.iv_bottom_1)
    ImageView ivBottom1;
    @BindView(R.id.bottom_img1)
    ImageView bottomImg1;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.bottom_btn1)
    LinearLayout bottomBtn1;
    @BindView(R.id.iv_bottom_2)
    ImageView ivBottom2;
    @BindView(R.id.bottom_img2)
    ImageView bottomImg2;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.bottom_btn2)
    LinearLayout bottomBtn2;
    @BindView(R.id.iv_bottom_3)
    ImageView ivBottom3;
    @BindView(R.id.bottom_img3)
    ImageView bottomImg3;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.bottom_btn3)
    LinearLayout bottomBtn3;
    @BindView(R.id.iv_bottom_4)
    ImageView ivBottom4;
    @BindView(R.id.bottom_img4)
    ImageView bottomImg4;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.bottom_btn4)
    LinearLayout bottomBtn4;
    @BindView(R.id.bottom)
    LinearLayout bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置透明状态栏
        StatusBarUtil.setImgTransparent(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        selectImage(0);

    }

    public void selectImage(int i) {

        resetImage();
        currentTabIndex = i;
        // 创建Fragment管理器，导包必须一直，全是v4包，或者android包
        FragmentManager fm = getSupportFragmentManager();
        // 创建事务
        FragmentTransaction transaction = fm.beginTransaction();

        // 隐藏Fragment
        hideFragment(transaction);

        switch (i) {
            case 0:
                initTab01(transaction);
                break;
            case 1:
                initTab02(transaction);
                break;
            case 2:
                initTab03(transaction);
                break;
            case 3:
                initTab04(transaction);
                break;


            default:
                break;
        }
        // 提交事务
        transaction.commitAllowingStateLoss();
    }

    private void resetImage() {

        // 选项卡，图片
        bottomImg1.setImageResource(R.drawable.layer35);
        bottomImg2.setImageResource(R.drawable.layer10copy);
        bottomImg3.setImageResource(R.drawable.layer35);
        bottomImg4.setImageResource(R.drawable.layer10copy);


        tv1.setTextColor(ContextCompat.getColor(mContext, R.color.kevinwhite));
        tv2.setTextColor(ContextCompat.getColor(mContext, R.color.kevinwhite));
        tv3.setTextColor(ContextCompat.getColor(mContext, R.color.kevinwhite));
        tv4.setTextColor(ContextCompat.getColor(mContext, R.color.kevinwhite));
        ivBottom1.setVisibility(View.GONE);
        ivBottom2.setVisibility(View.GONE);
        ivBottom3.setVisibility(View.GONE);
        ivBottom4.setVisibility(View.GONE);


    }

    private void hideFragment(FragmentTransaction transaction) {

        if (mTab01 != null) {
            transaction.hide(mTab01);
        }
        if (mTab02 != null) {
            transaction.hide(mTab02);
        }
        if (mTab03 != null) {
            transaction.hide(mTab03);
        }
        if (mTab04 != null) {
            transaction.hide(mTab04);
        }


    }

    private void initTab01(FragmentTransaction transaction) {

// 如果没有此Fragment将其添加并实例化，有则呈现出来
        if (mTab01 == null) {
            // 实例化fragment,并将其添加到指定位置
            mTab01 = OneFragment.newInstance();
            // 将指定Fragment 添加到指定位置
            transaction.add(R.id.fl_main, mTab01);
        } else {
            transaction.show(mTab01);
        }

        bottomImg1.setImageResource(R.drawable.layer37);
        ivBottom1.setVisibility(View.VISIBLE);
        tv1.setTextColor(ContextCompat.getColor(mContext, R.color.kevinwhite));


    }

    private void initTab02(FragmentTransaction transaction) {
        // 如果没有此Fragment将其添加并实例化，有则呈现出来
        if (mTab02 == null) {
            // 实例化fragment,并将其添加到指定位置
            mTab02 = TwoFragment.newInstance();
            // 将指定Fragment 添加到指定位置
            transaction.add(R.id.fl_main, mTab02);
        } else {
            transaction.show(mTab02);
        }

        bottomImg2.setImageResource(R.drawable.layer41);
        ivBottom2.setVisibility(View.VISIBLE);
        tv2.setTextColor(ContextCompat.getColor(mContext, R.color.kevinwhite));


    }

    private void initTab03(FragmentTransaction transaction) {
        // 如果没有此Fragment将其添加并实例化，有则呈现出来
        if (mTab03 == null) {
            // 实例化fragment,并将其添加到指定位置
            mTab03 = ThreeFragment.newInstance();
            // 将指定Fragment 添加到指定位置
            transaction.add(R.id.fl_main, mTab03);
        } else {
            transaction.show(mTab03);
        }

        bottomImg3.setImageResource(R.drawable.layer37);
        ivBottom3.setVisibility(View.VISIBLE);
        tv3.setTextColor(ContextCompat.getColor(mContext, R.color.kevinwhite));

    }

    private void initTab04(FragmentTransaction transaction) {
// 如果没有此Fragment将其添加并实例化，有则呈现出来
        if (mTab04 == null) {
            // 实例化fragment,并将其添加到指定位置
            mTab04 = FourFragment.newInstance();
            // 将指定Fragment 添加到指定位置
            transaction.add(R.id.fl_main, mTab04);
        } else {
            transaction.show(mTab04);
        }

        bottomImg4.setImageResource(R.drawable.layer41);
        ivBottom4.setVisibility(View.VISIBLE);
        tv4.setTextColor(ContextCompat.getColor(mContext, R.color.kevinwhite));
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

        if (mTab01 == null && fragment instanceof OneFragment)
            mTab01 = (OneFragment) fragment;
        if (mTab02 == null && fragment instanceof TwoFragment)
            mTab02 = (TwoFragment) fragment;
        if (mTab03 == null && fragment instanceof ThreeFragment)
            mTab03 = (ThreeFragment) fragment;
        if (mTab04 == null && fragment instanceof FourFragment)
            mTab04 = (FourFragment) fragment;
    }




    @OnClick({R.id.bottom_btn1, R.id.bottom_btn2, R.id.bottom_btn3, R.id.bottom_btn4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bottom_btn1:
                selectImage(0);
                break;
            case R.id.bottom_btn2:
                selectImage(1);
                break;
            case R.id.bottom_btn3:
                selectImage(2);
                break;
            case R.id.bottom_btn4:
                selectImage(3);
                break;
        }
    }
}
