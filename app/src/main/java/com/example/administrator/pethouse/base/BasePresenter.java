package com.example.administrator.pethouse.base;

/**
 * Tap into soulful code @_阿钟 2017/11/20
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
}
