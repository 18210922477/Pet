package com.example.administrator.pethouse.module.user.pettainer.ui;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.module.user.pettainer.presenter.PetAddPresenter;
import com.example.administrator.pethouse.views.SideBar;

import java.util.HashMap;
import java.util.Map;

/**
 * It.Boss 红叶-QiYe
 */

public class pettypeActivity extends BaseActivity implements View.OnClickListener {
    private PetAddPresenter petAddPresenter;
    private Map<String, String> map;
    private Map<String, Object> objectMap;
    private ImageView Get_back;
    private TabLayout TabLayout_pet;
    private ListView mpettypelist;
    private TextView mpettypemm;
    private TextView mpettypecar;
    private TextView mpettyperemen;
    private SideBar mpettypesweachlist;

    @Override
    protected int getLayout() {
        return R.layout.activity_pettype;
    }

    @Override
    protected void init() {
        Get_back=findViewById(R.id.Get_back);
        Get_back.setOnClickListener(this);
        TabLayout_pet=findViewById(R.id.TabLayout_pet);
        mpettypelist=findViewById(R.id.mpettypelist);
        mpettypesweachlist=findViewById(R.id.mpettypesweachlist);
        petAddPresenter = new PetAddPresenter();
        map = new HashMap<>();
        objectMap = new HashMap<>();
    }

    @Override
    protected void initData() {
        TabLayout_pet.addTab( TabLayout_pet.newTab().setText("狗"));
        TabLayout_pet.addTab( TabLayout_pet.newTab().setText("猫"));
        TabLayout_pet.addTab( TabLayout_pet.newTab().setText("小宠"));

    }

    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case  R.id.Get_back:
             finish();
             break;
     }
    }
}
