package com.example.administrator.pethouse.module.user.ordercontainer.presenter;

import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.module.user.ordercontainer.bean.OrdercontainerBean;
import com.example.administrator.pethouse.module.user.ordercontainer.modle.IOrderContainerModle;
import com.example.administrator.pethouse.module.user.ordercontainer.modle.OrderContainerModle;
import com.example.administrator.pethouse.module.user.ordercontainer.ui.OrderparticularsActivity;

import java.util.Map;

/**
 * It.Boss 红叶-QiYe
 */

public class OrderContainerPresenter implements IOrderContainerContract.IOrderContainerPresenter {

    private IOrderContainerModle iOrderContainerModle;

    public OrderContainerPresenter(){
        iOrderContainerModle=new OrderContainerModle();
    }
    private IOrderContainerContract.IOrderContainerView view;

    @Override
    public void attachView(IOrderContainerContract.IOrderContainerView view) {
      this.view=view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void postOrder(Map<String,String> map) {
        iOrderContainerModle.post(map, new INetworkcallback<OrdercontainerBean>() {
            @Override
            public void onSuccess(OrdercontainerBean ordercontainerBean) {

            }

            @Override
            public void onFailure(String message) {

            }
        });
     }
}
