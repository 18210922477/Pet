package com.example.administrator.pethouse.module.user.walletcontainer;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;

/**
 * It.Boss 红叶-QiYe
 */

public class WalletContainerActivity extends BaseActivity {
    private ImageView mwalletfanhui;
    private TextView mMeesageTitle;

    @Override
    protected int getLayout() {
        return R.layout.activity_walletcontainer;
    }

    @Override
    protected void init() {
        mwalletfanhui=findViewById(R.id.mwalletfanhui);
        mwalletfanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

}
