package com.example.administrator.pethouse.module.user.pettainer.modle;

import com.example.administrator.pethouse.config.Config;
import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.model.http.httpfactory.HttpFactory;

import java.util.Map;

/**
 * It.Boss 红叶-QiYe
 */

public class Petmodle implements IPetmodle {

//    String sign="EE2DCEEBB1EF53EBEF46A92B2BA91B7D";
//    String ip="172.16.55.15";
//    String channel="android";
//    String token=" EE2DCEEBB1EF53EBEF46A92B2BA91B7D";
//    String userId="18234834396";
//    String sign, String ip, String channel, String token, String userId
    @Override
    public <T> void postlistpet(Map<String,String> map,INetworkcallback<T> iNetworkcallback) {

        HttpFactory.create().post(Config.PETLISTURL,map,iNetworkcallback);
    }

    @Override
    public <T> void postAddpet(Map<String, String> map, INetworkcallback<T> iNetworkcallback) {
        HttpFactory.create().post(Config.MYADDPETRURL,map,iNetworkcallback);
    }

    @Override
    public <T> void poststyepet(Map<String, String> map, INetworkcallback<T> iNetworkcallback) {
        HttpFactory.create().post(Config.MYTYPEPETRURL,map,iNetworkcallback);
    }
}
