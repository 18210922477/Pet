package com.example.administrator.pethouse.module.user.settingcontainer;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.utils.CacheDataManager;

/**
 * It.Boss 红叶-QiYe
 */

public class SettingContainerActivity extends BaseActivity {

    private TextView mCache;
    private Handler handler = new Handler() {

        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {

                case 0:



                    try {

                        mCache.setText(CacheDataManager.getTotalCacheSize(SettingContainerActivity.this));
                        Toast.makeText(SettingContainerActivity.this,"清理完成",Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {

                        e.printStackTrace();

                    }

            }

        };

    };



    @Override
    protected int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init() {
        mCache = findViewById(R.id.mCache);
        try {
            mCache.setText(CacheDataManager.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }

        mCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 new Thread(new clearCache()).start();


            }
        });
    }

    @Override
    protected void initData() {

    }
    class clearCache implements Runnable {

        @Override

        public void run() {

            try {

                CacheDataManager.clearAllCache(SettingContainerActivity.this);

                Thread.sleep(3000);

                if (CacheDataManager.getTotalCacheSize(SettingContainerActivity.this).startsWith("0")) {

                    handler.sendEmptyMessage(0);

                }

            } catch (Exception e) {

                return;

            }

        }

    }


}
