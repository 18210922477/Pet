package com.example.administrator.pethouse.module.user.MessageContainer;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.module.user.MessageContainer.adabte.MessageAdabte;
import com.example.administrator.pethouse.module.user.MessageContainer.bean.MessageBean;
import java.util.ArrayList;
import java.util.List;

/**
 * It.Boss 红叶-QiYe
 */

public class MessageContainerActivity extends BaseActivity {
    private TextView mMeesageTitle;
    private ListView mMeesageListView;
    private List<MessageBean> list;
    private MessageAdabte messageAdabte;
    private ImageView mMessagefanhui;
    @Override
    protected int getLayout() {
        return R.layout.activity_messagecontainer;
    }

    @Override
    protected void init() {
        mMeesageListView = findViewById(R.id.mMeesageListView);
        mMessagefanhui = findViewById(R.id.mMessagefanhui);
        list = new ArrayList<>();
        messageAdabte = new MessageAdabte(list);
    }

    @Override
    protected void initData() {
        list.add(new MessageBean(R.mipmap.gao, "小宁", "今天你有空没"));
        mMessagefanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mMeesageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MessageContainerActivity.this, "找不到主订单", Toast.LENGTH_SHORT).show();
            }
        });
        mMeesageListView.setAdapter(messageAdabte);
    }


}
