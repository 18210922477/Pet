package com.example.administrator.pethouse.module.user.ordercontainer.adabte;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * It.Boss 红叶-QiYe
 */

public class OrderContainerAdabte extends FragmentPagerAdapter {
    private List<String>listtable;
    private List<Fragment>fragmentList;

    public OrderContainerAdabte(FragmentManager fm, List<String> listtable, List<Fragment> fragmentList) {
        super(fm);
        this.listtable = listtable;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listtable.get(position);
    }
}
