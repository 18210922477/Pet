package com.example.administrator.pethouse.module.home.begin.sign;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserMessageQQMainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.QQ_image_return)
    ImageView QQImageReturn;
    @BindView(R.id.qq_text_title)
    TextView qq_textTitle;
    @BindView(R.id.et_SetQQ)
    EditText etSetQQ;


    @Override

    protected int getLayout() {
        return R.layout.activity_user_message_qq_main;
    }

    @Override
    protected void init() {
        ButterKnife.bind(this);
        QQImageReturn.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        if (!"".equals(etSetQQ.getText().toString())&&null!=etSetQQ.getText().toString()){

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.QQ_image_return:
                finish();
                return;
        }
    }
}
