package com.example.administrator.pethouse.model.biz;

import com.example.administrator.pethouse.config.Config;
import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.model.http.httpfactory.HttpFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Tap into soulful code @_阿钟 2017/12/18
 */

public class HomeListModel implements IHomeListModel {


    @Override
    public <T> void doList(String beginIndex, String coordX, String coordY, String endIndex, String orderBy, INetworkcallback<T> callbacks) {
        Map<String, Object> map = new HashMap<>();
            map.put("beginIndex","0");
            map.put("coordX","40.116384");
            map.put("coordY","116.250374");
            map.put("endIndex","10");
            map.put("orderBy",orderBy);
            HttpFactory.create().posts(Config.HOMELIST,map,callbacks);
    }

    @Override
    public <T> void doPetList(String beginIndex, String endIndex, String petTypeCode, INetworkcallback<T> networkcallback) {
              Map<String,Object> map=new HashMap<>();
               map.put("beginIndex","0");
               map.put("endIndex",endIndex);
               map.put("petTypeCode",petTypeCode);
               HttpFactory.create().posts(Config.TYPECODE,map,networkcallback);
    }


}
