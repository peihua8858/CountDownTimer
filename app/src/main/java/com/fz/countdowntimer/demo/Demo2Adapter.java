package com.fz.countdowntimer.demo;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.fz.countdowntimer.CountdownView;
import com.fz.countdowntimer.OnCountdownListener;
import com.gb.bind.adapter.GBBaseBindAdapter;
import com.gb.bind.annotations.BindItem;

import java.util.ArrayList;

public class Demo2Adapter extends GBBaseBindAdapter<Demo2Bean, BaseViewHolder> {
    public Demo2Adapter() {
        super(new ArrayList<>());
    }

    RecyclerView recyclerView;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @BindItem(type = 0, layout = R.layout.item_demo2)
    public void bindItem(BaseViewHolder viewHolder, Demo2Bean bean) {
        viewHolder.setText(R.id.tv_title, bean.getItemValue());
        CountdownView countdownView = viewHolder.getView(R.id.cv_countdown_timer);
        countdownView.start(bean.getCountDownEndTime());
        countdownView.setOnCountdownListener(new OnCountdownListener() {
            @Override
            public void onFinish(CountdownView cv) {
                viewHolder.setText(R.id.tv_title, bean.getItemValue());
                Log.d("Demo2Adapter", "Demo2Adapter>>>倒计时" + bean.getTitle() + "结束");
            }

            @Override
            public void onTick(CountdownView cv, long remainTime) {
//                bean.setCountdownTime(remainTime);
                Log.d("Demo2Adapter", "Demo2Adapter>>>倒计时" + bean.getTitle() + ">>" + remainTime);
            }
        });
    }
}
