package com.hc.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import de.greenrobot.event.EventBus;


public class Fragment3 extends Fragment {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        btn1 = (Button) view.findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new TextView1Event("5"));
            }
        });

        btn2 = (Button) view.findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        EventBus.getDefault().post(new TextView2Event("6"));
                    }
                }).start();
            }
        });

        btn3 = (Button) view.findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        EventBus.getDefault().postSticky(new TextView3Event("8"));
                    }
                }).start();
            }
        });

        return view;
    }
}
