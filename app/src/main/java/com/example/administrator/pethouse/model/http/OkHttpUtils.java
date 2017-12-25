package com.example.administrator.pethouse.model.http;

import android.text.style.TtsSpan;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.pethouse.app.AppSituation;
import com.example.administrator.pethouse.model.callback.INetworkcallback;
import com.example.administrator.pethouse.utils.CJSON;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Tap into soulful code @_阿钟 2017/12/8
 */

public class OkHttpUtils implements  Ihttp {
    private static OkHttpUtils utils;
    private OkHttpClient client;


    public OkHttpUtils(){
        //   缓存机制
      client=new OkHttpClient.Builder().cache(provideCache()).connectTimeout(20, TimeUnit.SECONDS).readTimeout(20,TimeUnit.SECONDS).build();
    }
    // 缓存区域大小
    public Cache provideCache() {
        return new Cache(AppSituation.context.getCacheDir(), 10240*1024);
    }
    //懒汉式
    public static OkHttpUtils getInstance(){
        if(utils==null){
            synchronized (OkHttpUtils.class){
                if(utils==null){
                    utils=new OkHttpUtils();
                }
            }
        }
        return utils;
    }

    @Override
    public <T> void get(String url, Map<String, String> params, final INetworkcallback<T> networkcallback) {

        if(params != null && params.size() > 0){
            //得到所有的key
            Set<String> keys = params.keySet();
            StringBuffer sb = new StringBuffer(url);
            sb.append("?");
            //遍历所有的key
            for (String key : keys){
                //根据key值获取value
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }

            url = sb.substring(0,sb.length()-1);

        }
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                AppSituation.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //失败的监听
                        networkcallback.onFailure(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String gsonString = response.body().string();
                AppSituation.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //成功的监听
                        networkcallback.onSuccess(getGeneric(gsonString,networkcallback));
                    }
                });


            }
        });
        

    }

    @Override
    public <T> void get(String url, final INetworkcallback<T> networkcallback) {
        final Request request = new Request.Builder().url(url).build();
          client.newCall(request).enqueue(new Callback() {
              @Override
              public void onFailure(Call call, final IOException e) {
                  AppSituation.context.runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          networkcallback.onFailure(e.getMessage());
                      }
                  });
              }

              @Override
              public void onResponse(Call call, final Response response) throws IOException {
                  final String jsonString = response.body().string();
                  AppSituation.context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                        networkcallback.onSuccess(getGeneric(jsonString,networkcallback));
                        }
                    });

              }
          });

    }

  /**
   * post
   *   请求*/
    @Override
    public <T> void post(String url, Map<String, String> params, final INetworkcallback<T> networkcallback) {
        FormBody.Builder builder = new FormBody.Builder();
        if(params != null && params.size() > 0){
            Set<String> keys = params.keySet();
            for (String key : keys){
                String value = params.get(key);
                builder.add(key,value);
            }

        }

        Request build = new Request.Builder().url(url).post(builder.build()).build();
        client.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                AppSituation.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        networkcallback.onFailure(e.getMessage());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonString = response.body().string();
                Log.e("TAG",jsonString);
                AppSituation.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        networkcallback.onSuccess(getGeneric(jsonString,networkcallback));
                    }
                });

            }
        });


    }

    @Override
    public <T> void posts(String url, Map<String, Object> params, final INetworkcallback<T> networkcallback) {
        FormBody.Builder builder = new FormBody.Builder();
        if(params != null && params.size() > 0){
            builder.add("data", CJSON.toJSONMap(params));
        }

        Request build = new Request.Builder().url(url).post(builder.build()).build();

        client.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                AppSituation.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        networkcallback.onFailure(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String string = response.body().string();
               Log.e("1111111111",""+string);
                Log.e("AAAAAAAAA",string);
                AppSituation.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        networkcallback.onSuccess(getGeneric(string,networkcallback));
                    }
                });
            }
        });


    }

    @Override
    public void loadImage(String imgUrl, ImageView imageView) {
        Glide.with(AppSituation.context).load(imgUrl).into(imageView);
    }

    // 动态解析 Gson
    public <T>T getGeneric(String result,INetworkcallback<T> callback){
        Gson gson = new Gson();
        Type[] types = callback.getClass().getGenericInterfaces();
        Type[] arguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = arguments[0];
        T t = gson.fromJson(result, type);
        return t;
    }

}
