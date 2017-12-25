package com.example.administrator.pethouse.model.callback;

/**
 * Tap into soulful code @_阿钟 2017/12/8
 */

public interface INetworkcallback<T> {
    void onSuccess(T t);
    void onFailure(String message);
}
