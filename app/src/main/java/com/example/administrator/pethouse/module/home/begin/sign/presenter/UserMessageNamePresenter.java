package com.example.administrator.pethouse.module.home.begin.sign.presenter;

import com.example.administrator.pethouse.entity.BtnMessageSsetNameBean;
import com.example.administrator.pethouse.model.biz.BtnMessageSetNameModel;
import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.module.home.begin.sign.BtnMessageNameView;

import java.util.Map;

/**
 * Created by mMaster
 * on 2017/12/22.
 * at 北京
 */

public class UserMessageNamePresenter {
    private BtnMessageSetNameModel model;
    private BtnMessageNameView view;
    public UserMessageNamePresenter(BtnMessageNameView view){
        model=new BtnMessageSetNameModel();
        this.view=view;
    }
    public void setMessageName(String url, Map<String,String>map){
        model.setMessageNameBean(url, map, new INetworkcallback<BtnMessageSsetNameBean>() {
            @Override
            public void onSuccess(BtnMessageSsetNameBean btnMessageSsetNameBean) {
                view.setBtnMessageNameBean(btnMessageSsetNameBean);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
