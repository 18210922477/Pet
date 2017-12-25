package com.example.administrator.pethouse.module.user.switchuser.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.module.user.switchuser.fragment.BtnSwitchUserFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BtnSwitchUserActivity extends BaseActivity {


    private FrameLayout mFramelayout;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private BtnSwitchUserFragment userFragment;

    @Override
    protected int getLayout() {
        return R.layout.activity_btnswitchuser;
    }

    @Override
    protected void init() {
        mFramelayout = findViewById(R.id.mBtnFrameLayout);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        userFragment = new BtnSwitchUserFragment();
    }

    @Override
    protected void initData() {

        transaction.add(R.id.mBtnFrameLayout,userFragment);
        transaction.commit();

    }

}
