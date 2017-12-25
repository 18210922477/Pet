package com.example.administrator.pethouse.module.user.pettainer.presenter;

import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.module.user.pettainer.bean.PetContainerBean;
import com.example.administrator.pethouse.module.user.pettainer.modle.IPetmodle;
import com.example.administrator.pethouse.module.user.pettainer.modle.Petmodle;
import com.example.administrator.pethouse.module.user.pettainer.view.IPetContainerView;

import java.util.Map;

/**
 * It.Boss 红叶-QiYe
 */

public class PetContainerPresenter implements IPetContainerPresenter {

    private IPetmodle iPetmodle;

    private IPetContainerView iPetContainerView;

    public PetContainerPresenter(IPetContainerView iPetContainerView) {
        this.iPetmodle = new Petmodle();
        this.iPetContainerView=iPetContainerView;
    }

    @Override
    public void petlistpost(Map<String, String> map) {
        iPetmodle.postlistpet(map, new INetworkcallback<PetContainerBean>() {
            @Override
            public void onSuccess(PetContainerBean petContainerBean) {

            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
