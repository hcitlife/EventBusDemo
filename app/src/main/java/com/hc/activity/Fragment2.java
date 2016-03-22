package com.hc.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

public class Fragment2 extends Fragment {


    private TextView textView3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);
        textView3 = (TextView) view.findViewById(R.id.textView3);

        EventBus.getDefault().registerSticky(this);
        return view;
    }

    public void onEvent(TextView3Event event){
        String msg = "已经收藏：" +event.getMsg();
        textView3.setText(msg);
    }

}
