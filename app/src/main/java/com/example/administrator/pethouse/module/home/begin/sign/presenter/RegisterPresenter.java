package com.example.administrator.pethouse.module.home.begin.sign.presenter;

import com.example.administrator.pethouse.base.BasePresenter;
import com.example.administrator.pethouse.base.BaseView;
import com.example.administrator.pethouse.config.Config;
import com.example.administrator.pethouse.entity.RegisterBean;
import com.example.administrator.pethouse.model.biz.RegisterModel;
import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.module.home.begin.sign.RegisterContract;

import java.util.Map;

/**
 * Created by mMaster
 * on 2017/12/14.
 * at 北京
 */

public class RegisterPresenter implements RegisterContract.IRegisterPresenter {
    private RegisterModel model;
    private RegisterContract.RegisterView view;
    public RegisterPresenter(){
        model=new RegisterModel();
    }
    @Override
    public void getRegisterBean(Map<String, String> parmes) {
        model.getRegisterBean(Config.REGISTERURL, parmes, new INetworkcallback<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean bean) {
                view.OnRegisterBean(bean);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

    @Override
    public void attachView(RegisterContract.RegisterView view) {
        this.view=view;
    }

    @Override
    public void detachView() {

    }
}
