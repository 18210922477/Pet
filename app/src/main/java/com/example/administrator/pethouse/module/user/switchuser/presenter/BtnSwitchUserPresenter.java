package com.example.administrator.pethouse.module.user.switchuser.presenter;

import com.example.administrator.pethouse.base.BasePresenter;
import com.example.administrator.pethouse.base.BaseView;
import com.example.administrator.pethouse.config.Config;
import com.example.administrator.pethouse.entity.BtnSwitchUserBean;
import com.example.administrator.pethouse.model.biz.BtnSwitchUserModel;
import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.module.user.switchuser.BtnSwitchUserContract;

import java.util.Map;

/**
 * Created by mMaster
 * on 2017/12/18.
 * at 北京
 */

public class BtnSwitchUserPresenter implements BtnSwitchUserContract.IBtnSwitchUserPresenter {

    private BtnSwitchUserModel model;
    private BtnSwitchUserContract.BtnSwitchUserView view;
    public BtnSwitchUserPresenter(){
        model=new BtnSwitchUserModel();
    }
    @Override
    public void attachView(BtnSwitchUserContract.BtnSwitchUserView view) {
        this.view=view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void getBtnSwitchUserBean(Map<String, String> parmes) {
        model.getBtnSwitchUserBean(Config.SWITCHUSERURL, parmes, new INetworkcallback<BtnSwitchUserBean>() {
            @Override
            public void onSuccess(BtnSwitchUserBean btnSwitchUserBean) {
                view.getBtnSwitchUserBean(btnSwitchUserBean);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
