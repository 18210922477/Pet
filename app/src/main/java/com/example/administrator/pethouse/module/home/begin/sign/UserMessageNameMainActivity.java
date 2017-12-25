package com.example.administrator.pethouse.module.home.begin.sign;

import android.app.Instrumentation;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.app.AppSituation;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.config.Config;
import com.example.administrator.pethouse.entity.BtnMessageSsetNameBean;
import com.example.administrator.pethouse.module.home.begin.UserMessageActivity;
import com.example.administrator.pethouse.module.home.begin.sign.presenter.UserMessageNamePresenter;
import com.example.administrator.pethouse.utils.CJSON;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserMessageNameMainActivity extends BaseActivity implements View.OnClickListener, BtnMessageNameView {

    @BindView(R.id.Name_image_return)
    ImageView NameImageReturn;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.et_SetName)
    EditText etSetName;
    private UserMessageNamePresenter presenter;
    private Map<String, String> parmes;
    private Map<String, Object> map;
    private String userId;
    private TextView mNameTijiao;


    @Override
    protected int getLayout() {
        return R.layout.activity_user_message_name_main;
    }

    @Override
    protected void init() {
        ButterKnife.bind(this);
        mNameTijiao = findViewById(R.id.mNameTijiao);
        NameImageReturn.setOnClickListener(this);
        mNameTijiao.setOnClickListener(this);
        presenter = new UserMessageNamePresenter(this);
        parmes = new HashMap<String,String>();
        map = new HashMap<>();
    }

    @Override
    protected void initData() {

        SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
        userId = user.getString("userId","");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Name_image_return:
                finish();
                break;
            case R.id.mNameTijiao:
                if (!"".equals(etSetName.getText().toString())&&null!=etSetName.getText().toString()){
                   map.put("usersId",userId);
                   map.put("usersName",etSetName.getText().toString());
                    String json = CJSON.toJSONMap(map);
                    parmes.put("data",json);
                    presenter.setMessageName(Config.USERMESSAGEURL,parmes);
                }

                break;
        }
    }

    @Override
    public void setBtnMessageNameBean(BtnMessageSsetNameBean bean) {

        if (bean.isRet()){
            Intent intent = UserMessageNameMainActivity.this.getIntent();
            intent.putExtra("name",etSetName.getText().toString());
            UserMessageNameMainActivity.this.setResult(200,intent);
            finish();
        }
    }

    @Override
    public void Error() {

    }
}
