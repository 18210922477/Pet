package com.example.administrator.pethouse.model.biz;

import com.example.administrator.pethouse.entity.BtnSwitchUserBean;
import com.example.administrator.pethouse.entity.LoginBean;
import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.model.http.httpfactory.HttpFactory;

import java.util.Map;

/**
 * Created by mMaster
 * on 2017/12/20.
 * at 北京
 */

public class BtnSwitchUserModel implements IBtnSwitchUserModel{


    @Override
    public void getBtnSwitchUserBean(String url, Map<String, String> map, INetworkcallback<BtnSwitchUserBean> callback) {
        HttpFactory.create().post(url,map,callback);
    }
}
