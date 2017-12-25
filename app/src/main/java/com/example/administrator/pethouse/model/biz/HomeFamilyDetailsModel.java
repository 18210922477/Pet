package com.example.administrator.pethouse.model.biz;

import com.example.administrator.pethouse.config.Config;
import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.model.http.httpfactory.HttpFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Tap into soulful code @_阿钟 2017/12/21
 */

public class HomeFamilyDetailsModel implements IHomeFamilyDetails {
    @Override
    public <T> void doFamilyDetails(String userId, INetworkcallback<T> iNetworkcallback) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId",userId);
        HttpFactory.create().posts(Config.DETAILS,map,iNetworkcallback);
    }
}
