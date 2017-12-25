package com.example.administrator.pethouse.module.home.begin.sign.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.app.AppSituation;
import com.example.administrator.pethouse.base.BaseFragment;
import com.example.administrator.pethouse.entity.RegisterBean;
import com.example.administrator.pethouse.module.home.begin.login.LoginActivity;
import com.example.administrator.pethouse.module.home.begin.login.fragment.LoginFragment;
import com.example.administrator.pethouse.module.home.begin.sign.RegisterActivity;
import com.example.administrator.pethouse.module.home.begin.sign.RegisterContract;
import com.example.administrator.pethouse.module.home.begin.sign.presenter.RegisterPresenter;
import com.example.administrator.pethouse.utils.CJSON;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by mMaster
 * on 2017/12/19.
 * at 北京
 */

public class RegisterFragment extends BaseFragment<RegisterPresenter> implements View.OnClickListener,RegisterContract.RegisterView {

    private Map<String, Object> map;
    private Map<String, String> parmes;
    private String phone;
    private String username;
    private String password;
    private View inflate;
    private Button btnRegister;
    private EditText etPhone;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etCode;
    private TextView mSecondlogin;

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
    protected View getLayoutId() {
        inflate = LayoutInflater.from(AppSituation.context).inflate(R.layout.fragment_register, null);
        return inflate;
    }

    @Override
    protected void init() {
        map = new HashMap<>();
        parmes = new HashMap<>();
        etPhone = inflate.findViewById(R.id.et_phone);
        etUsername = inflate.findViewById(R.id.et_username);
        etPassword = inflate.findViewById(R.id.et_password);
        etCode = inflate.findViewById(R.id.et_code);
        btnRegister = inflate.findViewById(R.id.btn_register);
        mSecondlogin = inflate.findViewById(R.id.mSecondlogin);
        btnRegister.setOnClickListener(this);
        mSecondlogin.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                phone = etPhone.getText().toString();
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                if (null!=etPhone.getText().toString()&&!"".equals(etPhone.getText().toString())){
                    if (null!=etUsername.getText().toString()&&!"".equals(etUsername.getText().toString())){
                        if (null!=etPassword.getText().toString()&&!"".equals(etPassword.getText().toString())){
                            if (null!=etCode.getText().toString()&&!"".equals(etCode.getText().toString())){
                                map.put("userPhone",phone);
                                map.put("userName",username);
                                map.put("password",password);
                                String value = CJSON.toJSONMap(map);
                                parmes.put("data",value);
                                mPresenter.getRegisterBean(parmes);

                            }else{
                                Toast.makeText(AppSituation.context,"请输入验证码",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(AppSituation.context,"请输入密码",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(AppSituation.context,"请输入用户名",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(AppSituation.context,"请输入手机号",Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.mSecondlogin:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
                break;
        }
    }

    @Override
    public void OnRegisterBean(RegisterBean bean) {
        if (bean.isRet()){
            Toast.makeText(AppSituation.context,"注册成功",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(AppSituation.context,"注册失败",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void OnError(String ErrorCode) {

    }
}
