package com.example.administrator.pethouse.base;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import butterknife.Unbinder;

/**
 * Tap into soulful code @_阿钟 2017/10/27
 */

public  abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    private Bundle params;
    protected P mPresenter;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return getLayoutId();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = getPresenter();
        mPresenter.attachView(this);
        init();
        loadData();
    }

    protected abstract View getLayoutId();
    /**
     * 统一管理数据的初始化
     */
    protected abstract void init();

    /**
     * 统一做数据加载
     */
    protected abstract void loadData();


    /**
     * 当Fragment隐藏、显示时改方法会被调用
     * @param hidden 当Fragment被隐藏时为true
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden)
            onHide();
        else
            onShow();
    }

    /**
     * 当Fragment可见时调用  可以在该方法中可以做数据刷新的操作
     */
    protected void onShow(){};

    /**
     * 当Fragment不可见时调用  可以做一下资源释放的操作
     */
    protected void onHide(){
    };
    public Bundle getParams() {
        return params;
    }

    public void setParams(Bundle params) {
        this.params = params;
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }

    private P getPresenter(){
        Type type = getClass().getGenericSuperclass();
        Type[] typeArguments = ((ParameterizedType) type).getActualTypeArguments();
        Class<P> p = (Class<P>) typeArguments[0];
        try {
            return p.newInstance();//动态创建Presenter对象
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }


}
