package com.example.administrator.pethouse.base;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


import com.example.administrator.pethouse.app.AppSituation;

import butterknife.ButterKnife;

/**
 * Tap into soulful code @_阿钟 2017/10/27
 */

public abstract class BaseActivity extends AppCompatActivity {

    public static BaseFragment lastFragment;

    private String fragmentName;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        AppSituation.context=this;
        ButterKnife.bind(this);
        AppSituation.context=this;
        init();
        initData();
    }

    protected abstract int getLayout();

    protected abstract void init();

    protected abstract void initData();
    @Override
    protected void onResume() {
        super.onResume();
        AppSituation.context = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        //避免内存泄漏
//        AppSituation.context = null;
    }


    /**
     * 该方法用于Fragment切换
     *
     * @param containerId   容器ID              x
     * @param fragmentClass 要切换的Fragment 目标Fragment
     * @param bundle        跳转Fragment是要传递的参数
     * @param isReplace     是否替换当前Fragment true：replace替换 false :hind 隐藏
     * @param isBack        该Fragment是否要添加至回退栈
     */
//    public void changFragment(int containerId, Class<? extends BaseFragment> fragmentClass, Bundle bundle, boolean isReplace, boolean isBack) {
//        //第一步 获取Fragment管理器
//        FragmentManager manager = getSupportFragmentManager();
//        //第二步 获取Fragment类名 下面会用到类名做Tag
//        fragmentName = fragmentClass.getSimpleName();
//        //第三步 开启事务
//        FragmentTransaction transaction = manager.beginTransaction();
//        //第四步 通过Tag来查找Fragment  如果查找到返回的就是该Fragment对象 否则是null 代表该Fragment没有被创建过
//        BaseFragment currentFragment = (BaseFragment) manager.findFragmentByTag(fragmentName);
//        //第五步 如果Fragment为null 就通过Java动态代理创建对应的Fragment对象
//        if (currentFragment == null) {
//            try {
//                //通过Java动态代理创建Fragment
//                currentFragment = fragmentClass.newInstance();
//                transaction.add(containerId, currentFragment, fragmentName);
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        if (isReplace) {
//            transaction.replace(containerId, currentFragment, fragmentName);
//        } else {
//            if (lastFragment != null)
//                transaction.hide(lastFragment);
//            transaction.show(currentFragment);
//        }
//        if (bundle != null) {
//            currentFragment.setParams(bundle);
//
//        }
//        //isBack为true是添加至回退栈
//        if (isBack) {
//            transaction.addToBackStack(fragmentName);
//        }
//
//        transaction.commit();
//        lastFragment = currentFragment;
//
//    }


}







