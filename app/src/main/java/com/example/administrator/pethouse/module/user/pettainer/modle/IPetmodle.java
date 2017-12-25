package com.example.administrator.pethouse.module.user.pettainer.modle;

import com.example.administrator.pethouse.model.callback.INetworkcallback;

import java.util.Map;

/**
 * It.Boss 红叶-QiYe
 */

public interface IPetmodle {

    <T>void postlistpet(Map<String, String> map, INetworkcallback<T> iNetworkcallback);
    //添加宠物
    <T>void postAddpet(Map<String, String> map, INetworkcallback<T> iNetworkcallback);
    //类型
    <T>void poststyepet(Map<String, String> map, INetworkcallback<T> iNetworkcallback);
}
