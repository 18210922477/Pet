package com.example.administrator.pethouse.module.user.ordercontainer.modle;

import com.example.administrator.pethouse.config.Config;
import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.model.http.httpfactory.HttpFactory;

import java.util.Map;

/**
 * It.Boss 红叶-QiYe
 */

public class OrderContainerModle implements IOrderContainerModle {


    @Override
    public <T> void post(Map<String, String> map, INetworkcallback<T> iNetworkcallback) {
        HttpFactory.create().post(Config.MYUSERURL,map,iNetworkcallback);
    }
}
