package com.zhixianglingdi.testdemo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.zhixianglingdi.testdemo.R;
import com.zhixianglingdi.testdemo.adapter.HomeTopAdapter;
import com.zhixianglingdi.testdemo.adapter.NeedsOneAdapter;
import com.zhixianglingdi.testdemo.adapter.NeedsTopadapter;
import com.zhixianglingdi.testdemo.adapter.NeedsTwoAdapter;
import com.zhixianglingdi.testdemo.base.BaseKevinFragment;
import com.zhixianglingdi.testdemo.view.RingStatisticsView;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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
public class TwoFragment extends BaseKevinFragment implements SwipeRefreshLayout.OnRefreshListener {



    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    @BindView(R.id.rcv_home_two)
    RecyclerView rcvHomeTwo;



    public static TwoFragment newInstance() {

        Bundle args = new Bundle();

        TwoFragment fragment = new TwoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_two;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {

        srl.setOnRefreshListener(this);



        final VirtualLayoutManager layoutManager = new VirtualLayoutManager(mActivity);
        rcvHomeTwo.setLayoutManager(layoutManager);

        //设置recyclerview 的复用   回收
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcvHomeTwo.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);

        List<DelegateAdapter.Adapter> adapters = new LinkedList<>();

        //
        StickyLayoutHelper stickyLayoutHelper=new StickyLayoutHelper();
        adapters.add(new NeedsTopadapter(mActivity, stickyLayoutHelper, 1));


        SingleLayoutHelper singleLayoutHelper=new SingleLayoutHelper();

        adapters.add(new NeedsOneAdapter(mActivity, singleLayoutHelper, 1));

        adapters.add(new NeedsTwoAdapter(mActivity, singleLayoutHelper, 1));



        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager);
        delegateAdapter.setAdapters(adapters);
        rcvHomeTwo.setAdapter(delegateAdapter);




    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }

    @Override
    public void onRefresh() {

        Toast.makeText(mActivity, "正在刷新", Toast.LENGTH_SHORT).show();

        srl.setRefreshing(false);
    }


}
