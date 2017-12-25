package com.example.administrator.pethouse.module.home.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.administrator.pethouse.app.AppSituation;
import com.example.administrator.pethouse.entity.HomeFamilyItemBean;
import com.example.administrator.pethouse.model.biz.HomeFamilyDetailsModel;
import com.example.administrator.pethouse.model.biz.IHomeFamilyDetails;
import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.module.home.view.IHomeItemView;
import com.example.administrator.pethouse.module.home.view.IHomeView;

/**
 * Tap into soulful code @_阿钟 2017/12/21
 */

public class HomeFamilyPresenter implements IHomeFamilyDetailsPresenter {
    private HomeFamilyDetailsModel model;
    private IHomeItemView iHomeView;
    public HomeFamilyPresenter(IHomeItemView iHomeView){
        model=new HomeFamilyDetailsModel();
        this.iHomeView=iHomeView;
    }
    @Override
    public void getList(String id) {
       model.doFamilyDetails(id, new INetworkcallback<HomeFamilyItemBean>() {
           @Override
           public void onSuccess(HomeFamilyItemBean o) {
               iHomeView.toList(o);
               
           }

           @Override
           public void onFailure(String message) {

           }
       });
    }
}
