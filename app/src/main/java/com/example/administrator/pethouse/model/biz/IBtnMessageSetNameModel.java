package com.example.administrator.pethouse.model.biz;

import com.example.administrator.pethouse.entity.BtnMessageSsetNameBean;
import com.example.administrator.pethouse.model.callback.INetworkcallback;

import java.util.Map;

/**
 * Created by mMaster
 * on 2017/12/22.
 * at 北京
 */

public interface IBtnMessageSetNameModel {
    void setMessageNameBean(String url, Map<String,String> map, INetworkcallback<BtnMessageSsetNameBean> callback);
}
