package com.example.administrator.pethouse.module.home.begin.login.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.app.AppSituation;
import com.example.administrator.pethouse.base.BaseFragment;
import com.example.administrator.pethouse.entity.LoginBean;
import com.example.administrator.pethouse.module.home.begin.HomeScreenActivity;
import com.example.administrator.pethouse.module.home.begin.login.LoginContract;
import com.example.administrator.pethouse.module.home.begin.login.presenter.LoginPresenter;
import com.example.administrator.pethouse.module.home.begin.sign.RegisterActivity;
import com.example.administrator.pethouse.utils.CJSON;
import com.example.administrator.pethouse.utils.TokenUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mMaster
 * on 2017/12/14.
 * at 北京
 */

public class LoginFragment extends BaseFragment<LoginPresenter> implements LoginContract.LoginView, View.OnClickListener {


    private ImageView image_return;
    private TextView mRegiest;
    private String phone;
    private String password;
    private Map<String, Object> parmes;
    private String loginValue;
    private Map<String, String> map;
    private View inflate;
    private Button buttonLogin;
    private ImageView imageReturn;;
    private EditText etphone;
    private EditText etpassword;
    private TextView tvmPsw;
    private TextView tvmWeixin;
    private TextView tvmQQ;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;

    @Override
    protected View getLayoutId() {
        inflate = LayoutInflater.from(AppSituation.context).inflate(R.layout.fragment_login, null);
        return inflate;
    }

    @Override
    protected void init() {



//        @BindView(R.id.tvmQQ)
//        TextView tvmQQ;
        // 返回键 按钮
        image_return = inflate.findViewById(R.id.image_return);
        mRegiest = inflate.findViewById(R.id.mRegiest);
        buttonLogin = inflate.findViewById(R.id.button_login);
        imageReturn = inflate.findViewById(R.id.image_return);
        etphone = inflate.findViewById(R.id.et_phone);
        etpassword = inflate.findViewById(R.id.et_password);
        tvmPsw = inflate.findViewById(R.id.tvmPsw);
        tvmWeixin = inflate.findViewById(R.id.tvmWeixin);
        tvmQQ = inflate.findViewById(R.id.tvmQQ);
        image_return.setOnClickListener(this);
        mRegiest.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);
        parmes = new HashMap();
        map = new HashMap<>();
    }

    @Override
    protected void loadData() {
        sharedPreferences=getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        edit = sharedPreferences.edit();

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
    public void onClick(View view) {
        switch (view.getId()) {
            //点击返回
            case R.id.image_return:
               AppSituation.context.finish();
                break;
            //点击进入注册界面
            case R.id.mRegiest:
                startActivity(new Intent(AppSituation.context, RegisterActivity.class));
                break;

            case R.id.button_login:
                TokenUtil.setToken();
                phone = etphone.getText().toString();
                password = etpassword.getText().toString();
                if (null!=etphone.getText().toString()&&!"".equals(etphone.getText().toString())){
                    if (null!=etpassword.getText().toString()&&!"".equals(etpassword.getText().toString())){
                        parmes.put("userPhone",phone);
                        parmes.put("password",password);
                        loginValue = CJSON.toJSONMap(parmes);
                        map.put("data",loginValue);
                        mPresenter.getLoginBean(map);
                    }else{
                        Toast.makeText(AppSituation.context, "请输入密码", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(AppSituation.context, "请输入手机号", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }



    @Override
    public void OngetLoginBean(LoginBean bean) {


        if (bean.isRet()){
            Toast.makeText(AppSituation.context,"登录成功",Toast.LENGTH_SHORT).show();
            LoginBean.ResultBean result = bean.getResult();
            String userId = bean.getResult().getUserId();
            edit.putString("userId",userId);

            String userName = result.getUserName();
            long userPhone = result.getUserPhone();
            Intent intent = new Intent(AppSituation.context, HomeScreenActivity.class);
            intent.putExtra("username",userName);
            edit.putString("userName",userName);
            edit.putString("userPhone",userPhone+"");
            intent.putExtra("userphone",userPhone+"");
            edit.commit();
            AppSituation.context.setResult(200,intent);
            AppSituation.context.finish();
        }else{
            Toast.makeText(AppSituation.context,"登录失败",Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void OnError(String ErrorCode) {

    }

}
