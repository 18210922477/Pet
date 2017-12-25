package com.example.administrator.pethouse.module.user.ordercontainer.modle;

import com.example.administrator.pethouse.model.callback.INetworkcallback;

import java.util.Map;

/**
 * It.Boss 红叶-QiYe
 */

public interface IOrderContainerModle  {
   <T> void post(Map<String,String>map,INetworkcallback<T> iNetworkcallback);
}
