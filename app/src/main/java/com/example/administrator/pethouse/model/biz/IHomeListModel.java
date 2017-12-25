package com.example.administrator.pethouse.model.biz;

import com.example.administrator.pethouse.model.callback.INetworkcallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Tap into soulful code @_阿钟 2017/12/17
 */

public interface IHomeListModel {
      <T> void doList(String beginIndex,String coordX,String coordY,String endIndex,String orderBy,INetworkcallback<T> callbacks);
      <T> void doPetList(String beginIndex,String endIndex,String petTypeCode,INetworkcallback<T> networkcallback);

}
