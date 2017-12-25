package com.example.administrator.pethouse.model.http;

import android.widget.ImageView;

import com.example.administrator.pethouse.model.callback.INetworkcallback;

import java.util.Map;

/**
 * Tap into soulful code @_阿钟 2017/12/8
 *  网络层 //
 */

public interface Ihttp {

    <T>void get(String url, Map<String,String> params, INetworkcallback<T> networkcallback);

    <T>void get(String url, INetworkcallback<T> networkcallback);

    <T>void post(String url, Map<String,String> params, INetworkcallback<T> networkcallback);

    <T> void posts(String url,Map<String,Object> params,INetworkcallback<T> networkcallback);

    void loadImage(String imgUrl, ImageView imageView);
}
