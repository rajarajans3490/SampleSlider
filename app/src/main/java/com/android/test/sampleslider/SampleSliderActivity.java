package com.android.test.sampleslider;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SampleSliderActivity extends AppCompatActivity implements OnClickListener,ViewPager.OnPageChangeListener {
    private RelativeLayout mRelativelayout =null;
    private LinearLayout mLinearLayout =null;
    private Button mButton1 = null;
    private Button mButton2 = null;
    private Button mButton3 = null;
    private TextView mtextview1 = null;
    private TextView mtextview2 = null;
    private TextView mtextview3 = null;
    private TextView mtextview4 = null;
    private TextView mtextview5 = null;
    private TextView mTextview4 = null;
    private Context mContext = null;
    private ViewPager mViewPager = null;
    private String TAG = "SampleSliderActivity";
    private CustomFragmentPagerAdapter mCustomFragmentPagerAdapter = null;
    private int mPageCount;
    private int mImagePadding;
    private int mMargin;
    private int mNoMargin;
    private ImageView[] mImages = null;

    public SampleSliderActivity (){
        mContext = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRelativelayout = (RelativeLayout) findViewById(R.id.relativeid4);
        mButton1 = (Button) findViewById(R.id.Button1);
        mButton2 = (Button) findViewById(R.id.Button2);
        mButton3 = (Button) findViewById(R.id.Button3);
        mtextview1 = (TextView) findViewById(R.id.itemtext1);
        mtextview2 = (TextView) findViewById(R.id.itemtext2);
        mtextview3 = (TextView) findViewById(R.id.itemtext3);
        mtextview4 = (TextView) findViewById(R.id.itemtext4);
        mtextview5 = (TextView) findViewById(R.id.itemtext5);

        mTextview4 = (TextView) findViewById(R.id.textview4);
        mCustomFragmentPagerAdapter = new CustomFragmentPagerAdapter(getSupportFragmentManager(), mContext);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mCustomFragmentPagerAdapter);
        setPageIndicators();
        mButton1.setOnClickListener((OnClickListener) mContext);
        mButton2.setOnClickListener((OnClickListener) mContext);
        mButton3.setOnClickListener((OnClickListener) mContext);
        mtextview1.setOnClickListener((OnClickListener) mContext);
        mtextview2.setOnClickListener((OnClickListener) mContext);
        mtextview3.setOnClickListener((OnClickListener) mContext);
        mtextview4.setOnClickListener((OnClickListener) mContext);
        mtextview5.setOnClickListener((OnClickListener) mContext);
        mViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener) mContext);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Button1:
                mRelativelayout.setBackgroundResource(R.color.red);
                break;
            case R.id.Button2:
                mRelativelayout.setBackgroundResource(R.color.blue);
                break;
            case R.id.Button3:
                mRelativelayout.setBackgroundResource(R.color.green);
                break;
            case R.id.itemtext1:
                mTextview4.setText(R.string.itemtext1);
                break;
            case R.id.itemtext2:
                mTextview4.setText(R.string.itemtext2);
                break;
            case R.id.itemtext3:
                mTextview4.setText(R.string.itemtext3);
                break;
            case R.id.itemtext4:
                mTextview4.setText(R.string.itemtext4);
                break;
            case R.id.itemtext5:
                mTextview4.setText(R.string.itemtext5);
                break;
            default:
                break;
        }
    }

    //To set PageIndicators to the ViewPager Fragments.
    private void setPageIndicators()
        {
            mLinearLayout = (LinearLayout)findViewById(R.id.pageind);
            mPageCount = mCustomFragmentPagerAdapter.getCount();
            mImages = new ImageView[mPageCount];
            mImagePadding = (int) (getResources().getDimension(R.dimen.image_padding)/getResources().getDisplayMetrics().density);
            mMargin = (int) (getResources().getDimension(R.dimen.Linearlayout_margin)/getResources().getDisplayMetrics().density);
            mNoMargin = (int) (getResources().getDimension(R.dimen.Linearlayout_nomargin)/getResources().getDisplayMetrics().density);
            for (int i = 0; i < mPageCount; i++) {
                mImages[i] = new ImageView(this);
                mImages[i].setPadding(mImagePadding, mImagePadding, mImagePadding, mImagePadding);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    mImages[i].setImageDrawable(getResources().getDrawable(R.drawable.unselect, getApplicationContext().getTheme()));
                } else {
                    mImages[i].setImageDrawable(getResources().getDrawable(R.drawable.unselect));
                }

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );
                params.setMargins(mMargin, mNoMargin, mMargin, mNoMargin);
                params.gravity = (Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
                mLinearLayout.addView(mImages[i], params);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mImages[0].setImageDrawable(getResources().getDrawable(R.drawable.select,getApplicationContext().getTheme()));

            } else {
                mImages[0].setImageDrawable(getResources().getDrawable(R.drawable.select));
            }
        }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        for (int i = 0; i < mPageCount; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mImages[i].setImageDrawable(getResources().getDrawable(R.drawable.unselect, getApplicationContext().getTheme()));
            } else {
                mImages[i].setImageDrawable(getResources().getDrawable(R.drawable.unselect));
            }

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mImages[position].setImageDrawable(getResources().getDrawable(R.drawable.select,getApplicationContext().getTheme()));

        } else {
             mImages[position].setImageDrawable(getResources().getDrawable(R.drawable.select));
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
