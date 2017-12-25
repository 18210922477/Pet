package com.example.administrator.pethouse.module.home.begin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.adapter.ImgaePageAdapter;
import com.example.administrator.pethouse.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeUserActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.mStartPager)
    ViewPager mStartPager;
    @BindView(R.id.mLinearPoint)
    LinearLayout mLinearPoint;
    @BindView(R.id.mBtnStart)
    Button mBtnStart;
    private List<ImageView> imageList;
    private List<ImageView> pointList;
    private int[] images;
    private ImgaePageAdapter pageAdapter;
    private SharedPreferences preferences;

    /**
     * tag : 首页轮播图
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_welcome_user;
    }

    @Override
    protected void init() {
        // 存储状态
        preferences = getSharedPreferences("HC", MODE_PRIVATE);
        int params = preferences.getInt("params", 3);
        if(params==2){
            startActivity(new Intent(WelcomeUserActivity.this,HomeScreenActivity.class));
            finish();
        }

        // 放图片的集合
      imageList=new ArrayList<>();

      // 图片适配器
        pageAdapter = new ImgaePageAdapter(imageList,this);
        mStartPager.setAdapter(pageAdapter);
        mStartPager.addOnPageChangeListener(this);
    }

    @Override
    protected void initData() {
        // 轮播图 三张
        images = new int[]{R.mipmap.pager01,R.mipmap.pager02,R.mipmap.pager03};
        for (int i = 0; i < images.length ; i++) {
            ImageView imagePage = new ImageView(this);
             imagePage.setScaleType(ImageView.ScaleType.FIT_XY);
             imagePage.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
             imagePage.setImageResource(images[i]);
             imageList.add(imagePage);
        }
        pageAdapter.notifyDataSetChanged();
        //  三小点集合
        pointList=new ArrayList<>();
        for (int i = 0; i <imageList.size() ; i++) {
            ImageView pointImgae = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(10, 10);
            layoutParams.rightMargin=10;

            pointImgae.setLayoutParams(layoutParams);
          pointImgae.setPadding(10,0,10,0);
          
            if (i==0){
                pointImgae.setBackgroundResource(R.drawable.shape1);
            }else{
                pointImgae.setBackgroundResource(R.drawable.shape2);
            }
            mLinearPoint.addView(pointImgae);
            pointList.add(pointImgae);
            
        }


    }



    @OnClick(R.id.mBtnStart)
    public void onViewClicked() {
        preferences=getSharedPreferences("HC",MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt("params",2);
        edit.commit();
        startActivity(new Intent(WelcomeUserActivity.this,HomeScreenActivity.class));

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        
    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i <imageList.size() ; i++) {
            if(position==i){
                pointList.get(i).setBackgroundResource(R.drawable.shape1);
            }else {
                pointList.get(i).setBackgroundResource(R.drawable.shape2);
            }
            if (position==imageList.size()-1){
                mBtnStart.setVisibility(View.VISIBLE);
                mLinearPoint.setVisibility(View.GONE);
            }else{
                mBtnStart.setVisibility(View.GONE);
                mLinearPoint.setVisibility(View.VISIBLE);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
