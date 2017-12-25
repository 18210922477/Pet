package com.example.administrator.pethouse.model.http.httpfactory;

import com.example.administrator.pethouse.model.http.Ihttp;
import com.example.administrator.pethouse.model.http.OkHttpUtils;

/**
 * Tap into soulful code @_阿钟 2017/12/9
 */

public class HttpFactory {

    //工厂模式  自定义网络框架
    public static Ihttp create(){
        return OkHttpUtils.getInstance();
    }
}
