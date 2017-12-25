package com.example.administrator.pethouse.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.pethouse.module.home.begin.WelcomeUserActivity;

import java.util.List;

/**
 * Tap into soulful code @_阿钟 2017/12/12
 */

public class ImgaePageAdapter extends PagerAdapter {
    private  List<ImageView> imageList;
    private Context context;
    public ImgaePageAdapter(List<ImageView> imageList, WelcomeUserActivity welcomeUserActivity) {
    this.imageList=imageList;
    this.context=welcomeUserActivity;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageList.get(position));
        return imageList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
     container.removeView(imageList.get(position));
    }
}
