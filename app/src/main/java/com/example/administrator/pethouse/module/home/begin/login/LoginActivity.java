package com.example.administrator.pethouse.module.home.begin.login;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.FitWindowsFrameLayout;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.module.home.begin.login.fragment.LoginFragment;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.loginFm)
    FitWindowsFrameLayout loginFm;
    private LoginFragment loginFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        loginFragment = new LoginFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

    }

    @Override
    protected void initData() {
        transaction.add(R.id.loginFm,loginFragment);
        transaction.commit();
    }


}
