package com.example.administrator.pethouse.module.home.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.administrator.pethouse.app.AppSituation;
import com.example.administrator.pethouse.entity.NearbyBean;
import com.example.administrator.pethouse.model.biz.HomeListModel;
import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.module.home.view.IHomeView;

import java.util.HashMap;
import java.util.Map;

/**
 * Tap into soulful code @_阿钟 2017/12/18
 */

public class HomePresenter implements IHomePresenter {
    private HomeListModel homeListModel;
    private IHomeView iHomeView;

    public  HomePresenter(IHomeView iHomeView){
              homeListModel=new HomeListModel();
              this.iHomeView=iHomeView;
    }


    @Override
    public void doList(String page) {
        homeListModel.doList("0", "40.116384", "116.250374", "10", page, new INetworkcallback<NearbyBean>() {
            @Override
            public void onSuccess(NearbyBean nearbyBean) {
               iHomeView.getList(nearbyBean);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

    @Override
    public void petList(String pageName) {
     homeListModel.doPetList("0", 10 + "", pageName, new INetworkcallback<Object>() {
         @Override
         public void onSuccess(Object o) {
             
            Log.e("AAAAAA",o.toString());
         }

         @Override
         public void onFailure(String message) {
             Log.e("AAA",message);
         }
     });
    }
}
