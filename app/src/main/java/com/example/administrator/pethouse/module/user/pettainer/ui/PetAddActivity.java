package com.example.administrator.pethouse.module.user.pettainer.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bigkoo.pickerview.TimePickerView;
import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.module.user.pettainer.presenter.IPetAddPresenter;
import com.example.administrator.pethouse.module.user.pettainer.presenter.PetAddPresenter;
import com.example.administrator.pethouse.module.user.pettainer.presenter.PetContainerPresenter;
import com.example.administrator.pethouse.utils.CJSON;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * It.Boss 红叶-QiYe
 */

public class PetAddActivity extends BaseActivity implements View.OnClickListener {
    private TimePickerView pvTime;
    private Calendar startDate;
    private Calendar endDate;
    private ImageView maddpetReturn;
    private TextView maddpetPreservation, maddpetentertext,
            maddpettypetext, maddpetsterilizationtext, maddpetbirthtext,
            maddpetweighttext, mpetPhotograph, maddpetAlbum, maddpetcancel;
    private ImageView maddpetHeadportrait;
    private RelativeLayout maddpetenter;
    private RelativeLayout maddpettype;
    private RelativeLayout maddpetsterilization;
    private RelativeLayout maddpetbirth;
    private RelativeLayout maddpetweight;
    private RelativeLayout maddpetimmune;
    private EditText maddpetsynopsis, maddpetpopEditext;
    private View input, photograph;
    private Button maddpeteditextok;
    private PopupWindow popupWindow;
    private PopupWindow imagewindow;
    private PetAddPresenter presenter;
    private Map<String, String> map;
    private Map<String, Object> objectMap;
    private SharedPreferences sharedPreferences;
    private LinearLayout maddpetidpop;
    private String userId;
    private String usernames;

    @Override
    protected int getLayout() {
        return R.layout.activity_addpets;
    }

    @Override
    protected void init() {
        //PopupWindow录入
        input = LayoutInflater.from(this).inflate(R.layout.activity_addpetpopeditext, null);

        maddpetpopEditext = input.findViewById(R.id.maddpetpopEditext);

        maddpeteditextok = input.findViewById(R.id.maddpeteditextok);
        maddpeteditextok.setOnClickListener(this);
        //poppuwindow宠物头像
        photograph = LayoutInflater.from(this).inflate(R.layout.activity_petcontainerpops, null);
        photograph.setOnClickListener(this);
        //拍照
        mpetPhotograph = photograph.findViewById(R.id.mpetPhotograph);
        mpetPhotograph.setOnClickListener(this);
        //相册
        maddpetAlbum = photograph.findViewById(R.id.maddpetAlbum);
        maddpetAlbum.setOnClickListener(this);
        //取消
        maddpetcancel = photograph.findViewById(R.id.maddpetcancel);
        maddpetcancel.setOnClickListener(this);
        //返回
        maddpetReturn = findViewById(R.id.maddpetReturn);
        maddpetReturn.setOnClickListener(this);
        maddpetidpop = findViewById(R.id.maddpetidpop);
        //保存
        maddpetPreservation = findViewById(R.id.maddpetPreservation);
        maddpetPreservation.setOnClickListener(this);
        //头像
        maddpetHeadportrait = findViewById(R.id.maddpetHeadportrait);
        maddpetHeadportrait.setOnClickListener(this);
        //昵称
        maddpetenter = findViewById(R.id.maddpetenter);
        maddpetentertext = findViewById(R.id.maddpetentertext);
        maddpetenter.setOnClickListener(this);
        //类型
        maddpettype = findViewById(R.id.maddpettype);
        maddpettypetext = findViewById(R.id.maddpettypetext);
        maddpettype.setOnClickListener(this);
        //是否绝育
        maddpetsterilization = findViewById(R.id.maddpetsterilization);
        maddpetsterilizationtext = findViewById(R.id.maddpetsterilizationtext);
        maddpetsterilization.setOnClickListener(this);
        //出生日期
        maddpetbirth = findViewById(R.id.maddpetbirth);
        maddpetbirthtext = findViewById(R.id.maddpetbirthtext);
        maddpetbirth.setOnClickListener(this);
        //体重
        maddpetweight = findViewById(R.id.maddpetweight);
        maddpetweighttext = findViewById(R.id.maddpetweighttext);
        maddpetweight.setOnClickListener(this);
        //免疫情况
        maddpetimmune = findViewById(R.id.maddpetimmune);
        maddpetimmune.setOnClickListener(this);
        //简介
        maddpetsynopsis = findViewById(R.id.maddpetsynopsis);
    }

    @Override
    protected void initData() {
        sharedPreferences = this.getSharedPreferences("user", MODE_PRIVATE);
        map = new HashMap<>();
        objectMap = new HashMap<>();
        presenter = new PetAddPresenter();
        userId = sharedPreferences.getString("userId", "");
        usernames = sharedPreferences.getString("usernames", "");
        Log.d("====", userId);
        Log.d("====", usernames);


    }

    int a = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.maddpetReturn:
                //fan hui
                finish();
                break;
            case R.id.maddpetPreservation:
                //保存
                Date date = new Date();
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = format.format(date);
                String petentertext = maddpetentertext.getText().toString();//昵称
                String pettypetext = maddpettypetext.getText().toString();//类型
                String petbirthtext = maddpetbirthtext.getText().toString();//出生日期
                String petsynopsis = maddpetsynopsis.getText().toString().trim();//简介
                String petsterilizationtext = maddpetsterilizationtext.getText().toString();//是否绝育
                String petweighttext = maddpetweighttext.getText().toString();//体重
                objectMap.put("petName", petentertext);
                objectMap.put("PetType", "0");
                objectMap.put("userName", usernames);
                objectMap.put("CreateTime", time);
                objectMap.put("petBirthTime", petbirthtext);
                objectMap.put("petInfo", petsynopsis);
                objectMap.put("petTypeName", "猫");
                objectMap.put("isSterilization", petsterilizationtext);
                objectMap.put("petWeight", petweighttext);
                objectMap.put("isimmune", "0");
                objectMap.put("userId", userId);
                map.put(CJSON.DATA, CJSON.toJSONMap(objectMap));
                presenter.petAddpost(map);

                break;
            case R.id.maddpetHeadportrait:
                initpopimage();
                break;
            case R.id.maddpetenter:
                a = 1;
                initpop();
                break;
            case R.id.maddpettype:
                Intent intent = new Intent(this, pettypeActivity.class);
                startActivity(intent);
                break;
            case R.id.maddpetsterilization:
                a = 2;
                initpop();
                break;
            case R.id.maddpetbirth:
//                //日期
//                a = 4;
//                initpop();
                Calendar selectedDate = Calendar.getInstance();
                startDate = Calendar.getInstance();
                //startDate.set(2013,1,1);
                endDate = Calendar.getInstance();
//                endDate.set(2020,1,1);
                //正确设置方式 原因：注意事项有说明
                startDate.set(1900, 0, 1);
                endDate.set(2100, 11, 31);
                //选中事件回调
                // 默认全部显示
                maddpetbirth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pvTime = new TimePickerView.Builder(PetAddActivity.this, new TimePickerView.OnTimeSelectListener() {
                            @Override
                            public void onTimeSelect(Date date, View v) {//选中事件回调
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String format = simpleDateFormat.format(date);
                                maddpetbirthtext.setVisibility(View.VISIBLE);
                                maddpetbirthtext.setText(format);
                            }
                        })
                                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                                .setCancelText("取消")//取消按钮文字
                                .setSubmitText("确定")//确认按钮文字
                                .setContentSize(18)//滚轮文字大小
                                .setTitleSize(20)//标题文字大小
                                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                                .isCyclic(true)//是否循环滚动
                                .setTitleColor(Color.BLACK)//标题文字颜色
                                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                                .setCancelColor(Color.BLUE)//取消按钮文字颜色
                                .setTitleBgColor(0x000000)//标题背景颜色 Night mode
                                .setBgColor(0x000000)//滚轮背景颜色 Night mode
                                .setDate(Calendar.getInstance())// 如果不设置的话，默认是系统时间*/
                                .setRangDate(startDate, endDate)//起始终止年月日设定
                                .setLabel("年", "月", "日", null, null, null)//默认设置为年月日时分秒
                                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                                .isDialog(false)//是否显示为对话框样式
                                .build();
                        //注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                        pvTime.show();
                    }
                });


                break;
            case R.id.maddpetweight:
                a = 3;
                initpop();
                break;
            case R.id.maddpetimmune:
                //免疫的完善
                Intent intents = new Intent(this, PetimmuneActivity.class);
                startActivity(intents);
                break;
            case R.id.mpetPhotograph:
                //paizhao

                break;
            case R.id.maddpetAlbum:
                //xiangce

                break;
            case R.id.maddpetcancel:
                //quxiao
                imagewindow.dismiss();
                break;
            case R.id.maddpeteditextok:
                switch (a) {
                    case 1:
                        maddpetentertext.setText(maddpetpopEditext.getText().toString().trim());
                        maddpetentertext.setVisibility(View.VISIBLE);
                        popupWindow.dismiss();
                        break;
                    case 2:
                        maddpetsterilizationtext.setVisibility(View.VISIBLE);
                        maddpetsterilizationtext.setText(maddpetpopEditext.getText().toString().trim());
                        popupWindow.dismiss();
                        break;
                    case 3:
                        maddpetweighttext.setVisibility(View.VISIBLE);
                        maddpetweighttext.setText(maddpetpopEditext.getText().toString().trim());
                        popupWindow.dismiss();
                        break;
                    case 4:
                        maddpetbirthtext.setVisibility(View.VISIBLE);
                        maddpetbirthtext.setText(maddpetpopEditext.getText().toString().trim());
                        popupWindow.dismiss();
                        break;
                }
                break;
        }
    }

    //popupwindow 录入信息
    void initpop() {
        popupWindow = new PopupWindow(PetAddActivity.this);
        popupWindow.setContentView(input);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.showAtLocation(maddpetidpop, Gravity.BOTTOM, 0, 0);

    }

    //poppuwindow宠物头像
    void initpopimage() {
        imagewindow = new PopupWindow(PetAddActivity.this);
        imagewindow.setContentView(photograph);
        imagewindow.setOutsideTouchable(true);
        imagewindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        imagewindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        imagewindow.showAtLocation(maddpetidpop, Gravity.BOTTOM, 0, 0);
    }
}
