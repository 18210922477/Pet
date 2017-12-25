package com.example.administrator.pethouse.module.home.begin.sign;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.entity.RegisterBean;
import com.example.administrator.pethouse.module.home.begin.sign.fragment.RegisterFragment;
import com.example.administrator.pethouse.module.home.begin.sign.presenter.RegisterPresenter;
import com.example.administrator.pethouse.utils.CJSON;
import com.example.administrator.pethouse.utils.FileUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private RegisterFragment fragment;


    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
        fragment = new RegisterFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
    }

    @Override
    protected void initData() {
            transaction.add(R.id.mRegisterFrameLayout,fragment);
            transaction.commit();



    }





}
