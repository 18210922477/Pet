package com.example.administrator.pethouse.config;

/**
 * Created by mMaster
 * on 2017/12/14.
 * at 北京
 */

public class Config {
    //总接口
    public static final String BASEURL="http://123.56.150.230:8885/dog_family/";
    //注册
    public static final String REGISTERURL=BASEURL+"user/register.jhtml";
    //登录
    public static final String LOGINURL=BASEURL+"user/login.jhtml";
    //宠物列表
    public static final String PETLISTURL=BASEURL+"petInfo/getPetInfoByUserId.jhtml";
     //首页 优先
    public static final String HOMELIST=BASEURL+"users/getUsersInfoByVO.jhtml";
    //首页 宠物分类
    public static  final String TYPECODE=BASEURL+"petType/getPetTypesByVO.jhtml";
    //申请成为寄养师
    public static final String SWITCHUSERURL=BASEURL+"petType/getPetTypesByVO.jhtml";
    //用户订单
    public static final String MYUSERURL=BASEURL+"orderInfo/getOrderInfoByUserId.jhtml";
    //宠物详情
    public static final String MYPETLISTURL=BASEURL+"petInfo/getPetInfoByPetId.jhtml";
    //添加宠物
    public static final String MYADDPETRURL=BASEURL+"petInfo/savePetInfo.jhtml";
    //详情
    public  static final String DETAILS=BASEURL+"users/getUsersInfos.jhtml";
    //修改个人信息
    public static final String USERMESSAGEURL=BASEURL+"user/getUserInfoByVO.jhtml";

    //宠物类型
    public static final String MYTYPEPETRURL=BASEURL+"petType/getPetTypesByVO.jhtml";



}
