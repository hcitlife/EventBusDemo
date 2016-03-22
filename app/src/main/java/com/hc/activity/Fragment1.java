package com.hc.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.greenrobot.event.EventBus;


public class Fragment1 extends Fragment {

    private TextView textView1;
    private TextView textView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        textView1 = (TextView) view.findViewById(R.id.textView1);
        textView2 = (TextView) view.findViewById(R.id.textView2);

        EventBus.getDefault().register(this);//注册EventBus
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);//取消注册
    }


    public void onEventMainThread(TextView1Event event) {
        String msg = "已经收藏：" +event.getMsg();
        textView1.setText(msg);
    }

    public void onEvent(TextView2Event event){
        String msg = "已经收藏：" +event.getMsg();
        textView2.setText(msg);
    }





}
