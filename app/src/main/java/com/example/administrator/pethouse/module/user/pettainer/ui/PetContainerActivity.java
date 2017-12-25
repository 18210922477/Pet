package com.example.administrator.pethouse.module.user.pettainer.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.module.user.pettainer.adabte.PetContainerAdabte;
import com.example.administrator.pethouse.module.user.pettainer.presenter.PetContainerPresenter;
import com.example.administrator.pethouse.module.user.pettainer.view.IPetContainerView;
import com.example.administrator.pethouse.utils.CJSON;

import java.util.HashMap;
import java.util.Map;

/**
 * It.Boss 红叶-QiYe
 */

/**
 * 宠物列表页面
 */
public class PetContainerActivity extends BaseActivity implements View.OnClickListener, IPetContainerView, AdapterView.OnItemClickListener {


    private ImageView maddpetrevert;
    private TextView mPetTitle;
    private TextView maddpetvisibi;
    private ListView mPetListView;
    private PetContainerAdabte petContainerAdabte;
    private PetContainerPresenter presenter;
    private Map<String, String> map;
    private Map<String, Object> objectMap;
    private SharedPreferences sharedPreferences;

    @Override
    protected int getLayout() {
        return R.layout.activity_petcontainer;
    }

    @Override
    protected void init() {
        //返回键
        maddpetrevert = findViewById(R.id.maddpetrevert);
        maddpetrevert.setOnClickListener(this);
        //消失的添加宠物按钮
        maddpetvisibi = findViewById(R.id.maddpetvisibi);
        maddpetvisibi.setOnClickListener(this);
        //listview pet展示数据列表
        mPetListView = findViewById(R.id.mPetListView);
        mPetListView.setOnItemClickListener(this);
        map = new HashMap<>();
        objectMap = new HashMap<>();
        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        petContainerAdabte = new PetContainerAdabte();
        presenter = new PetContainerPresenter(this);
    }

    @Override
    protected void initData() {
        String userId = sharedPreferences.getString("userId", "");
        Log.d("------", userId);
        objectMap.put("userId", userId);
        map.put(CJSON.DATA, CJSON.toJSONMap(objectMap));
        presenter.petlistpost(map);
        mPetListView.setAdapter(petContainerAdabte);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.maddpetrevert:
                finish();
                break;
            case R.id.maddpetvisibi:
                //跳入添加宠物页面
                Intent intent = new Intent(this, PetAddActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                startActivity(intent);
    }

    @Override
    public void postlist() {
        int count = mPetListView.getCount();
        if (count<0){
            Toast.makeText(this, "您还未添加宠物，请添加", Toast.LENGTH_SHORT).show();
        }
    }

}
