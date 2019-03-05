package com.zhixianglingdi.testdemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.zhixianglingdi.testdemo.adapter.HomeOneAdapter;
import com.zhixianglingdi.testdemo.adapter.HomeTopAdapter;
import com.zhixianglingdi.testdemo.base.BaseKevinFragment;
import com.zhixianglingdi.testdemo.R;
import com.zhixianglingdi.testdemo.adapter.HomeTwoAdapter;

import java.util.LinkedList;
import java.util.List;

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
 * 类描述：com.zhixianglingdi.testdemo.fragment
 * 创建人：kevin
 * 创建时间：2019/3/1
 * 修改人：kevin
 * 修改时间：
 * 修改备注：
 */
public class OneFragment extends BaseKevinFragment {

    RecyclerView rcv_one;


    public static OneFragment newInstance() {

        Bundle args = new Bundle();

        OneFragment fragment = new OneFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_one;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        rcv_one= (RecyclerView) view.findViewById(R.id.rcv_one);



        final VirtualLayoutManager layoutManager = new VirtualLayoutManager(mActivity);
        rcv_one.setLayoutManager(layoutManager);

        //设置recyclerview 的复用   回收
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcv_one.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);

        List<DelegateAdapter.Adapter> adapters = new LinkedList<>();

        StickyLayoutHelper stickyLayoutHelper=new StickyLayoutHelper();
        adapters.add(new HomeTopAdapter(mActivity, stickyLayoutHelper, 1));


        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        adapters.add(new HomeOneAdapter(mActivity, singleLayoutHelper, 1));
        adapters.add(new HomeTwoAdapter(mActivity, singleLayoutHelper, 1));




        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager);
        delegateAdapter.setAdapters(adapters);
        rcv_one.setAdapter(delegateAdapter);





    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }
}
