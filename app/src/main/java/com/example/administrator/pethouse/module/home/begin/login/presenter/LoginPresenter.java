package com.example.administrator.pethouse.module.home.begin.login.presenter;

import com.example.administrator.pethouse.config.Config;
import com.example.administrator.pethouse.entity.LoginBean;
import com.example.administrator.pethouse.model.biz.LoginModel;
import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.module.home.begin.login.LoginContract;

import java.util.Map;

/**
 * Created by mMaster
 * on 2017/12/14.
 * at 北京
 */

public class LoginPresenter implements LoginContract.ILoginPresenter{
    private LoginModel model;
    private LoginContract.LoginView iview;
    public LoginPresenter(){

        model=new LoginModel();
    }
    @Override
    public void getLoginBean(Map<String, String> parmes) {
        model.getRegisterBean(Config.LOGINURL, parmes, new INetworkcallback<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                iview.OngetLoginBean(loginBean);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

    @Override
    public void attachView(LoginContract.LoginView view) {
        this.iview=view;
    }

    @Override
    public void detachView() {

    }
}
