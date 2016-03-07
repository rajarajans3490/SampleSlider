package com.android.test.sampleslider;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class CustomFragmentPagerAdapter extends FragmentStatePagerAdapter {
    final int PAGE_COUNT = 4;
    private Context context;

    public CustomFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:return ViewPageFragment1.newInstance();
            case 1:return ViewPageFragment2.newInstance();
            case 2:return ViewPageFragment3.newInstance();
            case 3:return ViewPageFragment4.newInstance();

        }
        return null;
    }

}