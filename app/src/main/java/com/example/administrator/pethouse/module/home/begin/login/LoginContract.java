package com.example.administrator.pethouse.module.home.begin.login;

import com.example.administrator.pethouse.base.BasePresenter;
import com.example.administrator.pethouse.base.BaseView;
import com.example.administrator.pethouse.entity.LoginBean;

import java.util.Map;

/**
 * Created by mMaster
 * on 2017/12/14.
 * at 北京
 */

public interface LoginContract {
        interface  LoginView extends BaseView {
            void OngetLoginBean(LoginBean bean);
            void OnError(String ErrorCode);
    }

        interface ILoginPresenter extends BasePresenter<LoginView> {
            void getLoginBean(Map<String, String> parmes);
        }
}
