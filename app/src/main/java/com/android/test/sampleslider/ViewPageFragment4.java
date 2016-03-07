package com.android.test.sampleslider;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class ViewPageFragment4 extends Fragment {
    Context mContext;

    public static ViewPageFragment4 newInstance() {
        ViewPageFragment4 fragment = new ViewPageFragment4();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplication(), "Fragment 4 clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
