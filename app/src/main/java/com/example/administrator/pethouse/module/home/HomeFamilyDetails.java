package com.example.administrator.pethouse.module.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.adapter.OtherServiceAdapter;
import com.example.administrator.pethouse.adapter.ServiceAdapter;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.entity.HomeFamilyItemBean;
import com.example.administrator.pethouse.module.fosterage.activity.CommentActivity;
import com.example.administrator.pethouse.module.fosterage.activity.MakeApponintmentActivity;
import com.example.administrator.pethouse.module.home.presenter.HomeFamilyPresenter;
import com.example.administrator.pethouse.module.home.view.IHomeItemView;
import com.example.administrator.pethouse.module.home.view.IHomeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomeFamilyDetails extends BaseActivity  implements IHomeItemView, View.OnClickListener {


    private HomeFamilyPresenter familyPresenter;
    private String id;
    private ImageView show_iv;
    private RatingBar show_ratingBar;
    private TextView show_famile;
    private TextView show_desc;
    private TextView show_address;
    private Banner banner;
    private TextView show_message;
    private List<HomeFamilyItemBean.DescBean.FosterOtherServicesBean> otherList;
    List<HomeFamilyItemBean.DescBean.FosterServicesBean> list;
    private OtherServiceAdapter otherServiceAdapter;
    private ListView show_lv_fosterServices;
    private ServiceAdapter serviceAdapter;
    private ListView show_lv_fosterOtherServices;
    private ImageView show_user_back;
    private Button callperson;
    private TextView toCallme;
    private TextView toCallphone;
    private TextView toMessage;
    private TextView mReturn;
    private PopupWindow popupWindow;
    private RelativeLayout user_message;
    private RelativeLayout foster_evaluated;
    private Button show_jiyang;

    @Override
    protected int getLayout() {
        return R.layout.activity_home_family_details;
    }

    @Override
    protected void init() {
        familyPresenter = new HomeFamilyPresenter(this);
        show_iv = findViewById(R.id.show_iv);
        show_ratingBar = findViewById(R.id.show_ratingBar);
        show_famile = findViewById(R.id.show_famile);
        show_address = findViewById(R.id.show_address);
        show_message = findViewById(R.id.show_message);
        user_message = findViewById(R.id.user_message);
        foster_evaluated = findViewById(R.id.foster_evaluated);
        show_lv_fosterServices = findViewById(R.id.show_lv_fosterServices);
        show_user_back = findViewById(R.id.show_user_back);
        show_jiyang = findViewById(R.id.show_jiyang);
        callperson = findViewById(R.id.callperson);
        show_jiyang.setOnClickListener(this);
        show_user_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        show_lv_fosterOtherServices = findViewById(R.id.show_lv_fosterOtherServices);
        banner = findViewById(R.id.lvp);
        show_desc = findViewById(R.id.show_desc);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        otherList=new ArrayList<>();
        list=new ArrayList<>();
        otherServiceAdapter = new OtherServiceAdapter(otherList,this);
        show_lv_fosterServices.setAdapter(otherServiceAdapter);
        serviceAdapter = new ServiceAdapter(list, this);
        show_lv_fosterOtherServices.setAdapter(serviceAdapter);
        foster_evaluated.setOnClickListener(this);
        callperson.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        familyPresenter.getList(id);
    }

    @Override
    public void toList(HomeFamilyItemBean homeFamilyItemBean) {
        otherList.clear();
        list.clear();
        HomeFamilyItemBean.DescBean desc = homeFamilyItemBean.getDesc();
        List<HomeFamilyItemBean.DescBean.FosterImagesBean> fosterImages = desc.getFosterImages();
        int fosterCommentCount = desc.getFosterCommentCount();
        show_message.setText("寄养评价"+"("+fosterCommentCount+")");
        List<HomeFamilyItemBean.DescBean.FosterOtherServicesBean> fosterOtherServices = desc.getFosterOtherServices();
               otherList.addAll(fosterOtherServices);
        otherServiceAdapter.notifyDataSetChanged();

        List<HomeFamilyItemBean.DescBean.FosterServicesBean> fosterServices = desc.getFosterServices();
                    list.addAll(fosterServices);
        serviceAdapter.notifyDataSetChanged();

        banner.setImages(fosterImages).setDelayTime(2000).setBannerStyle(BannerConfig.CIRCLE_INDICATOR).setImageLoader(new ImageLoader() {
                  @Override
                  public void displayImage(Context context, Object path, ImageView imageView) {
                      Glide.with(context).load(path).into(imageView);
                  }
              }).setIndicatorGravity(BannerConfig.CENTER).start();
        HomeFamilyItemBean.DescBean.FosterInfoBean fosterInfo = desc.getFosterInfo();
        double fosterGrade = desc.getFosterGrade();
        String userName = fosterInfo.getUserName();
        String address = fosterInfo.getAddress();
        show_address.setText(address);
        String intro = fosterInfo.getIntro();
        show_desc.setText(intro);
        show_famile.setText(userName);
        show_ratingBar.setRating((float) fosterGrade);
        String userImage = fosterInfo.getUserImage();
        Glide.with(HomeFamilyDetails.this).load(userImage).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(show_iv);
                

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.callperson:
                View inflate = LayoutInflater.from(HomeFamilyDetails.this).inflate(R.layout.pop_message, null);
                toCallme = inflate.findViewById(R.id.toCallme);
                toCallphone = inflate.findViewById(R.id.toCallphone);
                toMessage = inflate.findViewById(R.id.toMessage);
                mReturn = inflate.findViewById(R.id.mReturn);
                toCallme.setOnClickListener(this);
                toCallphone.setOnClickListener(this);
                toMessage.setOnClickListener(this);
                mReturn.setOnClickListener(this);
                popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setContentView(inflate);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
                popupWindow.setTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAsDropDown(user_message);
                break;
            case R.id.mReturn:
                mReturn.setTextColor(R.color.colorblack);
                popupWindow.dismiss();
                break;
            case R.id.toCallme:
                toCallme.setTextColor(R.color.colorblack);
                break;
            case R.id.toCallphone:
                toCallphone.setTextColor(R.color.colorblack);
                break;
            case R.id.toMessage:
                toMessage.setTextColor(R.color.colorblack);
                break;
            case R.id.foster_evaluated:
                Intent intent = new Intent(HomeFamilyDetails.this, CommentActivity.class);
                startActivity(intent);
                Toast.makeText(this, "评论", Toast.LENGTH_SHORT).show();
                break;
            case R.id.show_jiyang:
                startActivity(new Intent(HomeFamilyDetails.this, MakeApponintmentActivity.class));
                Toast.makeText(this, "寄养", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
