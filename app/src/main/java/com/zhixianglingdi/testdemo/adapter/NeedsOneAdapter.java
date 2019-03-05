package com.zhixianglingdi.testdemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.zhixianglingdi.testdemo.R;
import com.zhixianglingdi.testdemo.view.RingStatisticsView;

import butterknife.BindView;
import butterknife.ButterKnife;

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
 * 类描述：com.zhixianglingdi.testdemo.adapter
 * 创建人：kevin
 * 创建时间：2019/3/4
 * 修改人：kevin
 * 修改时间：
 * 修改备注：
 */
public class NeedsOneAdapter extends DelegateAdapter.Adapter<NeedsOneAdapter.MyViewHolder> {


    Context context;
    LayoutHelper layoutHelper;
    int count;

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    public NeedsOneAdapter(Context context, LayoutHelper layoutHelper, int count) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.count = count;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_needs_one, null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.rsvTwo.setPercentAndColors(new float[]{0.30f, 0.253f, 0.447f}, new int[]{Color.parseColor("#2df6a8"), Color.parseColor("#47e2f9"), Color.parseColor("#ee93ed")});
        myViewHolder.rsvTwo.setMarrRingWidth(new float[]{88, 54, 26});
       // myViewHolder.rsvTwo.refresh();
        myViewHolder.rsvTwo.startAnimation(2000);

        myViewHolder.tvNeedsOneSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }




    @Override
    public int getItemCount() {
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rsv_two)
        RingStatisticsView rsvTwo;
        @BindView(R.id.tv_needs_one_single)
        TextView tvNeedsOneSingle;
        public MyViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }



}
