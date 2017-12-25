package com.example.administrator.pethouse.module.user.pettainer.presenter;

import android.util.Log;

import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.module.user.pettainer.bean.PetAddBean;
import com.example.administrator.pethouse.module.user.pettainer.modle.IPetmodle;
import com.example.administrator.pethouse.module.user.pettainer.modle.Petmodle;

import java.util.Map;

/**
 * It.Boss 红叶-QiYe
 */

public class PetAddPresenter implements IPetAddPresenter {
    private IPetmodle iPetmodle;

    public PetAddPresenter() {
        this.iPetmodle=new Petmodle();
    }

    @Override
    public void petAddpost(Map<String, String> map) {
        iPetmodle.postAddpet(map, new INetworkcallback<PetAddBean>() {
            @Override
            public void onSuccess(PetAddBean petaddbean) {
                Log.e("======","=="+petaddbean);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

    @Override
    public void pettype(Map<String, String> map) {
       iPetmodle.poststyepet(map, new INetworkcallback<String>() {
           @Override
           public void onSuccess(String s) {

           }

           @Override
           public void onFailure(String message) {

           }
       });
    }
}
