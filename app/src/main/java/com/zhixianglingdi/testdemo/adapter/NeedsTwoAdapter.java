package com.zhixianglingdi.testdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.zhixianglingdi.testdemo.R;

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
public class NeedsTwoAdapter extends DelegateAdapter.Adapter<NeedsTwoAdapter.MyViewHolder> {


    Context context;
    LayoutHelper layoutHelper;
    int count;

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    public NeedsTwoAdapter(Context context, LayoutHelper layoutHelper, int count) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.count = count;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_needs_two, null);

        ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Glide.with(context).load(R.drawable.top10).into(myViewHolder.ivNeedsTwo11);
        Glide.with(context).load(R.drawable.top10).into(myViewHolder.ivNeedsTwo21);


        Glide.with(context).load(R.drawable.special).into(myViewHolder.ivNeedsTwo12);
        Glide.with(context).load(R.drawable.special).into(myViewHolder.ivNeedsTwo22);

        Glide.with(context).load(R.drawable.medicalservice).into(myViewHolder.ivNeedsTwo13);
        Glide.with(context).load(R.drawable.medicalservice).into(myViewHolder.ivNeedsTwo23);

    }

    @Override
    public int getItemCount() {
        return count;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_needs_two_11)
        ImageView ivNeedsTwo11;
        @BindView(R.id.iv_needs_two_12)
        ImageView ivNeedsTwo12;
        @BindView(R.id.iv_needs_two_13)
        ImageView ivNeedsTwo13;
        @BindView(R.id.iv_needs_two_21)
        ImageView ivNeedsTwo21;
        @BindView(R.id.iv_needs_two_22)
        ImageView ivNeedsTwo22;
        @BindView(R.id.iv_needs_two_23)
        ImageView ivNeedsTwo23;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }



}
