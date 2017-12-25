package com.example.administrator.pethouse.module.user.ordercontainer.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseFragment;
import com.example.administrator.pethouse.module.user.ordercontainer.adabte.OrderListviewAdabte;
import com.example.administrator.pethouse.module.user.ordercontainer.presenter.IOrderContainerContract;
import com.example.administrator.pethouse.module.user.ordercontainer.presenter.OrderContainerPresenter;
import com.example.administrator.pethouse.module.user.ordercontainer.ui.OrderparticularsActivity;
import com.example.administrator.pethouse.utils.CJSON;

import java.util.HashMap;
import java.util.Map;

/**
 * It.Boss 红叶-QiYe
 */

public class OrderContainerFragment extends BaseFragment<OrderContainerPresenter> implements IOrderContainerContract.IOrderContainerView,AdapterView.OnItemClickListener {
    private View inflate;
    private ListView mOrderlistView;
    private Map<String, String> map;
    private Map<String, Object> objectMap;
    private OrderListviewAdabte adabte;
    private SharedPreferences sharedPreferences;
    private String userId;

    @Override
    protected View getLayoutId() {
        inflate = LayoutInflater.from(getContext()).inflate(R.layout.activity_orderlistview, null);
        return inflate;
    }

    @Override
    protected void init() {
        sharedPreferences = getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        mOrderlistView = inflate.findViewById(R.id.mOrderlistView);
        mOrderlistView.setOnItemClickListener(this);
        map = new HashMap<>();
        objectMap = new HashMap<>();
        adabte = new OrderListviewAdabte();
        userId = sharedPreferences.getString("userId", "");
    }

    @Override
    protected void loadData() {
        Bundle arguments = getArguments();
        int name = arguments.getInt("name");
        switch (name) {
            case 0:
                objectMap.put("userId", userId);
                objectMap.put("orderState", "25");
                map.put(CJSON.DATA, CJSON.toJSONMap(objectMap));
                mPresenter.postOrder(map);
                break;
            case 1:
                objectMap.put("userId", userId);
                objectMap.put("orderState", "45");

                map.put(CJSON.DATA, CJSON.toJSONMap(objectMap));
                mPresenter.postOrder(map);
                break;
            case 2:
                objectMap.put("userId", userId);
                objectMap.put("orderState", "35");

                map.put(CJSON.DATA, CJSON.toJSONMap(objectMap));
                mPresenter.postOrder(map);
                break;
            case 3:
                objectMap.put("orderState", "40");
                objectMap.put("userId", userId);
                map.put(CJSON.DATA, CJSON.toJSONMap(objectMap));
                mPresenter.postOrder(map);
                break;
        }

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismiss() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(getContext(), OrderparticularsActivity.class);
        startActivity(intent);
    }
}
