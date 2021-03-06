package com.android.test.sampleslider;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class ViewPageFragment2 extends Fragment {
    Context mContext;

    public static ViewPageFragment2 newInstance() {
        ViewPageFragment2 fragment = new ViewPageFragment2();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
    view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity().getApplication(), R.string.fragment2, Toast.LENGTH_SHORT).show();
        }
    });
        return view;
    }
}
