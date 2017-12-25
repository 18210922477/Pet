package com.example.administrator.pethouse.model.biz;

import com.example.administrator.pethouse.entity.LoginBean;
import com.example.administrator.pethouse.entity.RegisterBean;
import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.model.http.httpfactory.HttpFactory;

import java.util.Map;

/**
 * Created by mMaster
 * on 2017/12/14.
 * at 北京
 */

public class LoginModel implements ILoginModel{


    @Override
    public void getRegisterBean(String url, Map<String, String> map, INetworkcallback<LoginBean> callback) {
        HttpFactory.create().post(url,map,callback);
    }
}
