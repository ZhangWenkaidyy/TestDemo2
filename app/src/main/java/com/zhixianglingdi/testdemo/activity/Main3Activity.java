package com.zhixianglingdi.testdemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zhixianglingdi.testdemo.R;
import com.zhixianglingdi.testdemo.view.RingStatisticsView;



public class Main3Activity extends AppCompatActivity {


    RingStatisticsView idRsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        idRsv = (RingStatisticsView) findViewById(R.id.id_rsv);
        idRsv.setPercentAndColors(new float[]{0.3f,0.35f,0.35f},new int[]{Color.parseColor("#F9AA28"), Color.parseColor("#009752"), Color.parseColor("#2EC1FB")});

        idRsv.setMarrRingWidth(new float[]{88,54,26});
        idRsv.refresh();
    }
}
