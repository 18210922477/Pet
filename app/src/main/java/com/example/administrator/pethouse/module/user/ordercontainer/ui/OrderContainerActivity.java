package com.example.administrator.pethouse.module.user.ordercontainer.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.module.user.ordercontainer.adabte.OrderContainerAdabte;
import com.example.administrator.pethouse.module.user.ordercontainer.fragment.OrderContainerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * It.Boss 红叶-QiYe
 */

public class OrderContainerActivity extends BaseActivity {
    private TabLayout mOrderTableLayout;
    private ViewPager mOrderViewPager;
    private List<String>listtable;
    private List<Fragment>fragmentList;
    private OrderContainerAdabte adabte;
    private FragmentManager manager;
    private ImageView mOrderfanhui;
    @Override
    protected int getLayout() {
        return R.layout.activity_ordercontainer;
    }

    @Override
    protected void init() {
        mOrderTableLayout = findViewById(R.id.mOrderTableLayout);
        mOrderViewPager = findViewById(R.id.mOrderViewPager);
        mOrderfanhui = findViewById(R.id.mOrderfanhui);
        manager=getSupportFragmentManager();
        listtable=new ArrayList<>();
        fragmentList=new ArrayList<>();
        adabte=new OrderContainerAdabte(manager,listtable,fragmentList);
    }

    @Override
    protected void initData() {
       listtable.add("待确认");
       listtable.add("寄养中");
       listtable.add("待评价");
       listtable.add("已完成");
        for (int i = 0; i < listtable.size(); i++) {
            OrderContainerFragment fragment=new OrderContainerFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("name",i);
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }
        mOrderfanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
       mOrderViewPager.setAdapter(adabte);
       mOrderTableLayout.setupWithViewPager(mOrderViewPager);
    }

}
