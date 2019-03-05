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
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.zhixianglingdi.testdemo.R;

import java.util.ArrayList;
import java.util.List;

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
 * 创建时间：2019/3/1
 * 修改人：kevin
 * 修改时间：
 * 修改备注：
 */
public class HomeOneAdapter extends DelegateAdapter.Adapter<HomeOneAdapter.MyViewHolder> {

    Context context;
    LayoutHelper layoutHelper;
    int count;


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    public HomeOneAdapter(Context context, LayoutHelper layoutHelper, int count) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.count = count;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_one, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.banner);
        list.add(R.drawable.banner);
        list.add(R.drawable.banner);
        list.add(R.drawable.banner);

        myViewHolder.cb_one.setPages(
                new CBViewHolderCreator() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }


                }, list);


        Glide.with(context).load(R.drawable.top10).into(myViewHolder.ivHome1);
        Glide.with(context).load(R.drawable.special).into(myViewHolder.ivHome2);
        Glide.with(context).load(R.drawable.medicalservice).into(myViewHolder.ivHome3);


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


        @BindView(R.id.cb_one)
        ConvenientBanner cb_one;
        @BindView(R.id.iv_home_1)
        ImageView ivHome1;
        @BindView(R.id.iv_home_2)
        ImageView ivHome2;
        @BindView(R.id.iv_home_3)
        ImageView ivHome3;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }


    public class LocalImageHolderView implements Holder<Integer> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, final int position, Integer data) {
            Glide.with(context).load(data).into(imageView);

        }
    }

}
