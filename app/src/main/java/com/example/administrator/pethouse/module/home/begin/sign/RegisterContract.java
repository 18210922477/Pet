package com.example.administrator.pethouse.module.home.begin.sign;

import com.example.administrator.pethouse.base.BasePresenter;
import com.example.administrator.pethouse.base.BaseView;
import com.example.administrator.pethouse.entity.LoginBean;
import com.example.administrator.pethouse.entity.RegisterBean;
import com.example.administrator.pethouse.module.home.begin.login.LoginContract;

import java.util.Map;

/**
 * Created by mMaster
 * on 2017/12/19.
 * at 北京
 */

public interface RegisterContract {
    interface  RegisterView extends BaseView {
        void OnRegisterBean(RegisterBean bean);
        void OnError(String ErrorCode);
    }

    interface IRegisterPresenter extends BasePresenter<RegisterView> {
        void getRegisterBean(Map<String, String> parmes);
    }

}
