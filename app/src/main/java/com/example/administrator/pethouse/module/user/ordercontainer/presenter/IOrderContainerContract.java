package com.example.administrator.pethouse.module.user.ordercontainer.presenter;

import com.example.administrator.pethouse.base.BasePresenter;
import com.example.administrator.pethouse.base.BaseView;

import java.util.Map;

/**
 * It.Boss 红叶-QiYe
 */

public interface IOrderContainerContract {

    interface IOrderContainerView extends BaseView{

    }
    interface IOrderContainerPresenter extends BasePresenter<IOrderContainerView>{
       void postOrder(Map<String,String>map);
    }
}
