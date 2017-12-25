package com.example.administrator.pethouse.module.user.ordercontainer.ui;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.base.BaseActivity;

/**
 * It.Boss 红叶-QiYe
 */

public class OrderparticularsActivity extends BaseActivity {

    private ImageView image_OrderContainer;            //返回
    private TextView OrderContainer_title;             //标题
    private TextView OrderContainer_numbering;         //编号
    private ImageView OrderContainer_image;            //宠物头像
    private TextView OrderContainer_name;              //宠物名字
    private ImageView OrderContainer_sex;              // 性别
    private TextView OrderContainer_introduction;      //简介
    private TextView OrderContainer_fostercaretime;    //寄养时间
    private TextView OrderContainer_pet;               //
    private TextView OrderContainer_petname;            //名字
    private TextView OrderContainer_lement;
    private TextView OrderContainer_lement1;           //一晚
    private TextView OrderContainer_late;
    private TextView OrderContainer_late1;             //晚
    private TextView OrderContainer_money;
    private TextView OrderContainer_money1;             //钱
    private TextView OrderContainer_Other;
    private TextView OrderContainer_projects;
    private TextView OrderContainer_huttle;              //接送
    private TextView OrderAmountpayable;                   //应付金额
    private TextView OrderContainer_kilometres;            //单价
    private TextView Ordertimes;                            //订单时间
    private TextView OrderContainer_next;                 //数量
    private TextView Ordermoneys;                         //订单金额
    private TextView OrderContainer_money2;               //金额
    private ImageView OrderContainer_headportrait;         //评论头像
    private TextView OrderContainer_username;             //名字
    private RatingBar OrderContainer_ratingBar;        //星星好评
    private Button app_order;                          //评价
    @Override
    protected int getLayout() {
        return R.layout.fragment_ordercontainer;
    }

    @Override
    protected void init() {
        image_OrderContainer = findViewById(R.id.image_OrderContainer);
        OrderContainer_title = findViewById(R.id.OrderContainer_title);
        OrderContainer_numbering = findViewById(R.id.OrderContainer_numbering);
        OrderContainer_image = findViewById(R.id.OrderContainer_image);
        OrderContainer_name = findViewById(R.id.OrderContainer_name);
        OrderContainer_sex = findViewById(R.id.OrderContainer_sex);
        OrderContainer_introduction = findViewById(R.id.OrderContainer_introduction);
        OrderContainer_fostercaretime = findViewById(R.id.OrderContainer_fostercaretime);
        OrderContainer_pet = findViewById(R.id.OrderContainer_pet);
        OrderContainer_petname = findViewById(R.id.OrderContainer_petname);
        OrderContainer_lement = findViewById(R.id.OrderContainer_lement);
        OrderContainer_lement1 = findViewById(R.id.OrderContainer_lement1);
        OrderContainer_late = findViewById(R.id.OrderContainer_late);
        OrderContainer_late1 =findViewById(R.id.OrderContainer_late1);
        OrderContainer_money = findViewById(R.id.OrderContainer_money);
        OrderContainer_money1 = findViewById(R.id.OrderContainer_money1);
        OrderContainer_Other = findViewById(R.id.OrderContainer_Other);
        OrderContainer_projects = findViewById(R.id.OrderContainer_projects);
        OrderContainer_huttle = findViewById(R.id.OrderContainer_huttle);
        OrderAmountpayable = findViewById(R.id.OrderAmountpayable);
        OrderContainer_kilometres = findViewById(R.id.OrderContainer_kilometres);
        Ordertimes = findViewById(R.id.Ordertimes);
        OrderContainer_next = findViewById(R.id.OrderContainer_next);
        Ordermoneys = findViewById(R.id.Ordermoneys);
        OrderContainer_money2 = findViewById(R.id.OrderContainer_money2);
        OrderContainer_headportrait = findViewById(R.id.OrderContainer_headportrait);
        OrderContainer_username = findViewById(R.id.OrderContainer_username);
        OrderContainer_ratingBar = findViewById(R.id.OrderContainer_ratingBar);
        app_order = findViewById(R.id.app_order);
    }

    @Override
    protected void initData() {

    }
}
