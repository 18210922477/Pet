package com.example.administrator.pethouse.module.home.begin.sign;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserMessageWeiXinMainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.WeiXin_image_return)
    ImageView WeiXinImageReturn;
    @BindView(R.id.weixin_text_title)
    TextView weixin_textTitle;
    @BindView(R.id.et_SetWeiXin)
    EditText etSetWeiXin;


    @Override
    protected int getLayout() {
        return R.layout.activity_user_message_weixin_main;
    }

    @Override
    protected void init() {
        ButterKnife.bind(this);
        WeiXinImageReturn.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        if (!"".equals(etSetWeiXin.getText().toString())&&null!=etSetWeiXin.getText().toString()){

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.WeiXin_image_return:
                finish();
                return;
        }
    }
}
