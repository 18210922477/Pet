package com.example.administrator.pethouse.module.home.begin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.adapter.HomeTabAdapter;
import com.example.administrator.pethouse.adapter.MyHomeListAdapter;
import com.example.administrator.pethouse.adapter.PetTabListAdapter;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.entity.NearbyBean;
import com.example.administrator.pethouse.entity.PetTabBean;
import com.example.administrator.pethouse.module.home.HomeFamilyDetails;
import com.example.administrator.pethouse.module.home.begin.login.LoginActivity;
import com.example.administrator.pethouse.module.home.begin.map.MapActivity;
import com.example.administrator.pethouse.module.home.presenter.HomePresenter;
import com.example.administrator.pethouse.module.home.view.IHomeView;

import com.example.administrator.pethouse.module.user.MessageContainer.MessageContainerActivity;
import com.example.administrator.pethouse.module.user.konwcontainer.KonwContainerActivity;
import com.example.administrator.pethouse.module.user.ordercontainer.ui.OrderContainerActivity;
import com.example.administrator.pethouse.module.user.pettainer.ui.PetContainerActivity;
import com.example.administrator.pethouse.module.user.settingcontainer.SettingContainerActivity;
import com.example.administrator.pethouse.module.user.switchuser.activity.BtnSwitchUserActivity;


import com.example.administrator.pethouse.module.user.walletcontainer.WalletContainerActivity;


import com.zaaach.citypicker.CityPickerActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import butterknife.BindView;



/**
 * 轮播图跳转成此主界面
 *
 * @return userlogin  跳转登录界面
 */


public class HomeScreenActivity extends BaseActivity implements View.OnClickListener,IHomeView {
    @BindView(R.id.mAddressCheck)
    ImageView mAddressCheck;
    @BindView(R.id.mCheckPet)
    ImageView mCheckPet;
    @BindView(R.id.mScreen)
    ImageView mScreen;
    // Image

    private ImageView mDefaultHead;
    private ImageView my_image;
    private DrawerLayout drawer_layout;
    private ImageView checkMap;
    private RelativeLayout mMessageContainer, mPetContainer, mOrderContainer, mWalletContainer, mKonwContainer, mSettingContainer;
    private Button mBtnSwitchUser;
    private TextView home_nearby;
    // 记录点击次数
    private int i = 1;
    private TextView home_poodle;
    private TextView home_screen;
    private PopupWindow window;
    private LinearLayout mLinear;

    private ImageView mCheck;
    private TextView mTextView;
    private TextView mReputation;
    private ImageView mImageReputation;
    private TextView mOrderPriority;
    private ImageView mImagePriority;
    private TextView mPrice;
    private ImageView mImagePrice;
    private TextView mLowPrice;
    private ImageView mImagelow;
    private RelativeLayout mRelat;
    private RelativeLayout mRelatReputation;
    private RelativeLayout mRelatPrice;
    private RelativeLayout mRelatPriceLow;
    private RelativeLayout mRelatPriority;
    private PopupWindow poodleWindow;
    private ArrayList<String> stringList;
    private HomePresenter homePresenter;
    private Map<String, String> parmes;
    private ListView mList;
    private  List<NearbyBean.DescBean> dataList;
    private  List<PetTabBean.DescBean> petList;
    private HomeTabAdapter homeTabAdapter;
    private Button home_btn;
    private PopupWindow addressWindow;
    private TextView clear;
    private CheckBox newYearBox;
    private CheckBox mSpringBox;
    private CheckBox mQingmBox;
    private CheckBox mLabourBox;
    private CheckBox mMidBox;
    private CheckBox mChianDayBox;
    private CheckBox mDragonBox;
    private ListView mAnimal;
    private static boolean isExit = false;  // 标识是否退出
    private RelativeLayout mNoLoginContainer;
    private RelativeLayout mInfomation;
    // 用户名
    private TextView mMenuName;
    private TextView mMenuPhone;
    private String username;
    private SharedPreferences user;
    private String userPhone;
    private PetTabListAdapter listAdapter;
    private TextView select;
    private TextView select_address;
    private static Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };




    @Override
    protected int getLayout() {
        return R.layout.activity_home_screen;
    }

    @Override
    protected void init() {
        getId();
        mNoLoginContainer.setVisibility(View.VISIBLE);
        mInfomation.setVisibility(View.GONE);
        mNoLoginContainer.setOnClickListener(this);
        mInfomation.setOnClickListener(this);
        user = getSharedPreferences("user", Context.MODE_PRIVATE);
        username = user.getString("userName", null);
        userPhone = user.getString("userPhone", null);
        if(null==username&&null==userPhone){
            mNoLoginContainer.setVisibility(View.VISIBLE);
            mInfomation.setVisibility(View.GONE);
         }else{
            mNoLoginContainer.setVisibility(View.GONE);
            mInfomation.setVisibility(View.VISIBLE);
            mMenuName.setText(username);
            mMenuPhone.setText(userPhone);
        }

    }

    private void getId() {

        homePresenter = new HomePresenter(this);
        //侧拉 点击头像弹出侧拉菜单
        mDefaultHead = findViewById(R.id.mDefaultHead);
        // 侧拉菜单
        drawer_layout = findViewById(R.id.drawer_layout);
        // 点击弹处侧拉菜单
        my_image = findViewById(R.id.my_image);
        // 点击进入地图
        checkMap = findViewById(R.id.checkMap);
        // 附近优先
        home_nearby = findViewById(R.id.home_nearby);
        // 宠物类型
        home_poodle = findViewById(R.id.home_poodle);
        //城市
        home_screen = findViewById(R.id.home_screen);
        //消息
        mMessageContainer = findViewById(R.id.mMessageContainer);
        //宠物
        mPetContainer = findViewById(R.id.mPetContainer);
        //订单
        mOrderContainer = findViewById(R.id.mOrderContainer);
        //钱包
        mWalletContainer = findViewById(R.id.mWalletContainer);
        //需知
        mKonwContainer = findViewById(R.id.mKonwContainer);
        //设置
        mSettingContainer = findViewById(R.id.mSettingContainer);
        //申请成为寄养家庭
        mBtnSwitchUser = findViewById(R.id.mBtnSwitchUser);
        // linear
        mLinear = findViewById(R.id.mLinear);

        mList = findViewById(R.id.mList);

        mAnimal = findViewById(R.id.mAnimal);

        mNoLoginContainer = findViewById(R.id.mNoLoginContainer);
        mInfomation = findViewById(R.id.mInfomation);
        mMenuName = findViewById(R.id.mMenuName);
        mMenuPhone = findViewById(R.id.mMenuPhone);
        //this
        // 监听
        mDefaultHead.setOnClickListener(this);
        my_image.setOnClickListener(this);
        checkMap.setOnClickListener(this);
        mMessageContainer.setOnClickListener(this);
        mPetContainer.setOnClickListener(this);
        mOrderContainer.setOnClickListener(this);
        mWalletContainer.setOnClickListener(this);
        mKonwContainer.setOnClickListener(this);
        mSettingContainer.setOnClickListener(this);
        mBtnSwitchUser.setOnClickListener(this);
        home_nearby.setOnClickListener(this);
        home_screen.setOnClickListener(this);
        home_poodle.setOnClickListener(this);
        dataList=new ArrayList<>();
        petList=new ArrayList<>();
        listAdapter = new PetTabListAdapter(petList,HomeScreenActivity.this);
        mAnimal.setAdapter(listAdapter);
        homeTabAdapter = new HomeTabAdapter(dataList,HomeScreenActivity.this);
        mList.setAdapter(homeTabAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HomeScreenActivity.this, HomeFamilyDetails.class);
                intent.putExtra("id",dataList.get(i).getUsersId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        homePresenter.doList("distance asc");
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            /**
             * TODO: 点击头像跳转登录界面 -- LoginActivity
             * */
            case R.id.mDefaultHead:
                Intent intent = new Intent(HomeScreenActivity.this, LoginActivity.class);
                startActivityForResult(intent,1);
                break;
            /**
             * TODO: 点击弹出侧拉菜单
             * */
            case R.id.my_image:
                drawer_layout.openDrawer(Gravity.LEFT);
                break;
            /**
             * TODO: 点击跳转地图  -- MapActivity
             *
             * */
            case R.id.checkMap:
                startActivity(new Intent(HomeScreenActivity.this, MapActivity.class));
                break;
            case R.id.mMessageContainer:
                startActivity(new Intent(HomeScreenActivity.this, MessageContainerActivity.class));
                break;

            case R.id.mPetContainer:
                startActivity(new Intent(HomeScreenActivity.this, PetContainerActivity.class));
                break;
            case R.id.mOrderContainer:
                startActivity(new Intent(HomeScreenActivity.this, OrderContainerActivity.class));
                break;
            case R.id.mWalletContainer:
                startActivity(new Intent(HomeScreenActivity.this, WalletContainerActivity.class));
                break;
            case R.id.mKonwContainer:
                startActivity(new Intent(HomeScreenActivity.this, KonwContainerActivity.class));
                break;
            case R.id.mSettingContainer:
                startActivity(new Intent(HomeScreenActivity.this, SettingContainerActivity.class));
                break;
            case R.id.mBtnSwitchUser:
                startActivity(new Intent(HomeScreenActivity.this, BtnSwitchUserActivity.class));
                break;

            case R.id.home_nearby:
                mList.setVisibility(View.GONE);

                if (i % 2 == 0) {
                    mAddressCheck.setImageResource(R.mipmap.down_arrow);
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.alpha = (float) 1;
                    getWindow().setAttributes(attributes);
                    window.dismiss();
                } else {
                    mAddressCheck.setImageResource(R.mipmap.up_arrow);
//                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
//                    //全屏设置透明
//                    attributes.alpha = (float) 0.5;
//                    getWindow().setAttributes(attributes);
                    View pop = getLayoutInflater().inflate(R.layout.pop_address, null);
                    // 附近
                    mPopId(pop);
                    window = new PopupWindow(pop, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    window.setContentView(pop);
                    window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
                    window.setTouchable(true);
                    window.setFocusable(true);
                    window.setOutsideTouchable(true);
                    window.showAsDropDown(mLinear);

                    window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            mAddressCheck.setImageResource(R.mipmap.down_arrow);
                            mList.setVisibility(View.VISIBLE);
//                            WindowManager.LayoutParams attributes = getWindow().getAttributes();
//                            attributes.alpha = (float) 1;
//                            getWindow().setAttributes(attributes);
                            i++;
                        }
                    });
                }
                i++;
                break;

            case R.id.home_poodle:
                mList.setVisibility(View.GONE);
                if (i % 2 == 0) {
                    mCheckPet.setImageResource(R.mipmap.down_arrow);
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.alpha = (float) 1;
                    getWindow().setAttributes(attributes);
                    poodleWindow.dismiss();
                } else {
                    mCheckPet.setImageResource(R.mipmap.up_arrow);
                    View inflate = getLayoutInflater().inflate(R.layout.pop_poodle, null);
                    final ListView mListView = inflate.findViewById(R.id.mListView);
                    stringList = new ArrayList<>();
                    stringList.add("小型犬");
                    stringList.add("中型犬");
                    stringList.add("大型犬");
                    stringList.add("猫");
                    stringList.add("小宠");
                    stringList.add("幼犬");
                    poodleWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    poodleWindow.setContentView(inflate);
                    poodleWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
                    poodleWindow.setTouchable(true);
                    poodleWindow.setFocusable(true);
                    poodleWindow.setOutsideTouchable(true);
                    poodleWindow.showAsDropDown(mLinear);
                    MyHomeListAdapter myHomeListAdapter = new MyHomeListAdapter(this, stringList);
                    mListView.setAdapter(myHomeListAdapter);
                    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                if(stringList.get(i).equals("小型犬")){
                                    poodleWindow.dismiss();
//                                    mListView.setVisibility(View.GONE);
                                    homePresenter.petList("ffd1209b320c4bb382c5bdac4f722cf4");
                                }
                            if(stringList.get(i).equals("中型犬")){
                                    poodleWindow.dismiss();
                                }
                            if(stringList.get(i).equals("大型犬")){
                                poodleWindow.dismiss();
                            }
                            if(stringList.get(i).equals("猫")){
                                poodleWindow.dismiss();
                            }
                            if(stringList.get(i).equals("小宠")){
                                poodleWindow.dismiss();
                            }
                            if(stringList.get(i).equals("幼犬")){
                                poodleWindow.dismiss();
                            }

                        }
                    });
                    poodleWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            mCheckPet.setImageResource(R.mipmap.down_arrow);
//                            WindowManager.LayoutParams attributes = getWindow().getAttributes();
//                            attributes.alpha = (float) 1;
//                            getWindow().setAttributes(attributes);
                            mList.setVisibility(View.VISIBLE);
                            i++;
                        }
                    });
                }
                i++;
                break;
            case R.id.home_screen:
                mList.setVisibility(View.GONE);

                if (i % 2 == 0) {
                    mScreen.setImageResource(R.mipmap.up_arrow);
                } else {
                    mScreen.setImageResource(R.mipmap.down_arrow);
                    View inflate = getLayoutInflater().inflate(R.layout.pop_add, null);
                    select_address = inflate.findViewById(R.id.select_address);
                    select = inflate.findViewById(R.id.select);
                    newYearBox = inflate.findViewById(R.id.newYearBox);
                    mSpringBox = inflate.findViewById(R.id.mSpringBox);
                    mQingmBox = inflate.findViewById(R.id.mQingmBox);
                    mLabourBox = inflate.findViewById(R.id.mLabourBox);
                    mMidBox = inflate.findViewById(R.id.mMidBox);
                    mChianDayBox = inflate.findViewById(R.id.mChianDayBox);
                    mDragonBox = inflate.findViewById(R.id.mDragonBox);
                    home_btn = inflate.findViewById(R.id.home_btn);
                    clear = inflate.findViewById(R.id.clear);
                    clear.setOnClickListener(this);
                    home_btn.setOnClickListener(this);
                    select.setOnClickListener(this);
                    addressWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    addressWindow.setContentView(inflate);
                    addressWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
                    addressWindow.setTouchable(true);
                    addressWindow.setFocusable(true);
                    addressWindow.setOutsideTouchable(true);
                    addressWindow.showAsDropDown(mLinear);
                    addressWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            mScreen.setImageResource(R.mipmap.down_arrow);
//
                            mList.setVisibility(View.VISIBLE);
                            i++;
                        }
                    });
                }
                i++;
                break;
            case R.id.mRelat:
                window.dismiss();
                mCheck.setVisibility(View.VISIBLE);
                home_nearby.setText("附近优先");
                mImagePrice.setVisibility(View.GONE);
                mImagePriority.setVisibility(View.GONE);
                mImageReputation.setVisibility(View.GONE);
                mImagelow.setVisibility(View.GONE);
                homePresenter.doList("distance asc");
                break;

            case R.id.select:
                startActivityForResult(new Intent(HomeScreenActivity.this, CityPickerActivity.class),
                       0);
                break;

            case R.id.mRelatReputation:
                window.dismiss();
                home_nearby.setText("好评优先");
                mCheck.setVisibility(View.GONE);
                mImagePrice.setVisibility(View.GONE);
                mImagePriority.setVisibility(View.GONE);
                mImageReputation.setVisibility(View.VISIBLE);
                mImagelow.setVisibility(View.GONE);
                homePresenter.doList("score desc");
                break;
            case R.id.mRelatPriority:
                window.dismiss();
                home_nearby.setText("订单优先");
                mCheck.setVisibility(View.GONE);
                mImagePrice.setVisibility(View.GONE);
                mImagePriority.setVisibility(View.VISIBLE);
                mImageReputation.setVisibility(View.GONE);
                mImagelow.setVisibility(View.GONE);
                homePresenter.doList("orderCount desc");
                break;

            case R.id.mRelatPrice:
                window.dismiss();
                home_nearby.setText("价格从高到低");
                mCheck.setVisibility(View.GONE);
                mImagePrice.setVisibility(View.VISIBLE);
                mImagePriority.setVisibility(View.GONE);
                mImageReputation.setVisibility(View.GONE);
                mImagelow.setVisibility(View.GONE);
                homePresenter.doList("price desc");

                break;

            case R.id.mRelatPriceLow:
                window.dismiss();
                home_nearby.setText("价格从低到高");
                mCheck.setVisibility(View.GONE);
                mImagePrice.setVisibility(View.GONE);
                mImagePriority.setVisibility(View.GONE);
                mImageReputation.setVisibility(View.GONE);
                mImagelow.setVisibility(View.VISIBLE);
                homePresenter.doList("price asc");
                break;

            case R.id.home_btn:
                addressWindow.dismiss();
                break;
            case R.id.clear:
                mChianDayBox.setChecked(false);
                mDragonBox.setChecked(false);
                mMidBox.setChecked(false);
                mSpringBox.setChecked(false);
                mQingmBox.setChecked(false);
                newYearBox.setChecked(false);
                mLabourBox.setChecked(false);
                break;
            case R.id.mInfomation:
                startActivity(new Intent(HomeScreenActivity.this,UserMessageActivity.class));
                break;
            case R.id.mNoLoginContainer:
                Intent intent2 = new Intent(HomeScreenActivity.this, LoginActivity.class);
                startActivityForResult(intent2,1);
                break;

        }
    }

    private void mPopId(View pop) {
        mTextView = pop.findViewById(R.id.mTextView);
        mCheck = pop.findViewById(R.id.mCheck);
        mRelat = pop.findViewById(R.id.mRelat);
        mRelatPriority = pop.findViewById(R.id.mRelatPriority);
        mRelatReputation = pop.findViewById(R.id.mRelatReputation);
        mRelatPrice = pop.findViewById(R.id.mRelatPrice);
        mRelatPriceLow = pop.findViewById(R.id.mRelatPriceLow);

        // 好评
        mReputation = pop.findViewById(R.id.mReputation);
        mImageReputation = pop.findViewById(R.id.mImageReputation);
        //订单
        mOrderPriority = pop.findViewById(R.id.mOrderPriority);
        mImagePriority = pop.findViewById(R.id.mImagePriority);
        //价格
        mPrice = pop.findViewById(R.id.mPrice);
        mImagePrice = pop.findViewById(R.id.mImagePrice);
        //低排序
        mLowPrice = pop.findViewById(R.id.mLowPrice);
        mImagelow = pop.findViewById(R.id.mImagelow);
        mRelat.setOnClickListener(this);
        mRelatPrice.setOnClickListener(this);
        mRelatPriceLow.setOnClickListener(this);
        mRelatPriority.setOnClickListener(this);
        mRelatReputation.setOnClickListener(this);
        mTextView.setOnClickListener(this);
        mReputation.setOnClickListener(this);
        mOrderPriority.setOnClickListener(this);
        mLowPrice.setOnClickListener(this);
        mPrice.setOnClickListener(this);
    }


    @Override
    public void getList(NearbyBean nearbyBean) {
        dataList.clear();
        List<NearbyBean.DescBean> desc = nearbyBean.getDesc();
        dataList.addAll(desc);
        homeTabAdapter.notifyDataSetChanged();
    }

    @Override
    public void doPetList(PetTabBean petTabBean) {
        petList.clear();
        List<PetTabBean.DescBean> desc = petTabBean.getDesc();
        petList.addAll(desc);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        exit();
    }
    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(this, "再按一次后退键退出程序", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 2000);  // 利用handler延迟发送更改状态信息
        } else {
            this.finish();
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==200){
//            this.username = data.getStringExtra("username");
//            String userPhone = data.getStringExtra("userPhone");
            mNoLoginContainer.setVisibility(View.GONE);
            mInfomation.setVisibility(View.VISIBLE);

        }
        if(requestCode==0&&resultCode==RESULT_OK){
            if (data != null){
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                select_address.setText(city);
            }
        
        }


    }


}
