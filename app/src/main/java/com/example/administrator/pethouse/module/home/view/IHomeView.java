package com.example.administrator.pethouse.module.home.view;

import com.example.administrator.pethouse.entity.NearbyBean;
import com.example.administrator.pethouse.entity.PetTabBean;

/**
 * Tap into soulful code @_阿钟 2017/12/18
 */

public interface IHomeView {
  void getList(NearbyBean nearbyBean);
  void doPetList(PetTabBean petTabBean);
}
