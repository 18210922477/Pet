package com.example.administrator.pethouse.app;

/**
 * Tap into soulful code @_阿钟 2017/12/8
 *
 */

import android.app.Application;
import android.content.SharedPreferences;

import com.android.volley.toolbox.ImageLoader;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.model.http.OkHttpUtils;
import com.example.administrator.pethouse.utils.AppUtils;
import com.example.administrator.pethouse.utils.TokenUtil;
import com.example.administrator.pethouse.utils.UploadUtil;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;

/**
 * @PageMessage
 *
 *    全局初始化操作

 * */

public class AppSituation extends Application {

       public static BaseActivity context;


       @Override
       public void onCreate() {
              super.onCreate();
              //  极光推送
              JPushInterface.setDebugMode(true);
              JPushInterface.init(this);



              TokenUtil.init(this);
              UploadUtil.init(this);
              AppUtils.setAppContext(this);
//              OkHttpUtils.init(this);

       }

//
//       public String  getToken(){
//              SharedPreferences token = getSharedPreferences("Token", MODE_PRIVATE);
//              String mToken = token.getString("mToken", "");
//              return mToken;
//       }
//       public void setToken(String value){
//              SharedPreferences token = getSharedPreferences("Token", MODE_PRIVATE);
//              SharedPreferences.Editor edit = token.edit();
//              edit.putString("mToken",value);
//              edit.commit();
//       }

}
