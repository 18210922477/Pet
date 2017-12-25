package com.example.administrator.pethouse.module.user.switchuser;

import com.example.administrator.pethouse.base.BasePresenter;
import com.example.administrator.pethouse.base.BaseView;
import com.example.administrator.pethouse.entity.BtnSwitchUserBean;
import com.example.administrator.pethouse.entity.LoginBean;
import com.example.administrator.pethouse.module.home.begin.login.LoginContract;

import java.util.Map;

/**
 * Created by mMaster
 * on 2017/12/18.
 * at 北京
 */

public interface BtnSwitchUserContract {
    interface  BtnSwitchUserView extends BaseView {
        void getBtnSwitchUserBean(BtnSwitchUserBean bean);
        void OnError(String ErrorCode);
    }

    interface IBtnSwitchUserPresenter extends BasePresenter<BtnSwitchUserView> {
        void getBtnSwitchUserBean(Map<String, String> parmes);
    }
}
