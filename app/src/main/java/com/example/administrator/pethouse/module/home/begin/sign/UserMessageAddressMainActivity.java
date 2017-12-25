package com.example.administrator.pethouse.module.home.begin.sign;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserMessageAddressMainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.Address_image_return)
    ImageView AddressImageReturn;
    @BindView(R.id.address_text_title)
    TextView address_textTitle;
    @BindView(R.id.et_SetAddress)
    EditText etSetAddress;


    @Override
    protected int getLayout() {
        return R.layout.activity_user_message_address_main;
    }

    @Override
    protected void init() {
        ButterKnife.bind(this);
        AddressImageReturn.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        if (!"".equals(etSetAddress.getText().toString())&&null!=etSetAddress.getText().toString()){

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Address_image_return:
                finish();
                break;

        }
    }
}
