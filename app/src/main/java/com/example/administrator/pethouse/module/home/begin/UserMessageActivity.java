package com.example.administrator.pethouse.module.home.begin;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bigkoo.pickerview.TimePickerView;
import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.app.AppSituation;
import com.example.administrator.pethouse.base.BaseActivity;
import com.example.administrator.pethouse.module.home.begin.sign.UserMessageAddressMainActivity;
import com.example.administrator.pethouse.module.home.begin.sign.UserMessageNameMainActivity;
import com.example.administrator.pethouse.module.home.begin.sign.UserMessageQQMainActivity;
import com.example.administrator.pethouse.module.home.begin.sign.UserMessageWeiXinMainActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.example.administrator.pethouse.module.user.switchuser.fragment.BtnSwitchUserFragment.CHOOS_PHOTO;
public class UserMessageActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.image_return)
    ImageView imageReturn;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.mUserPhoto)
    ImageView mUserPhoto;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.mUserName)
    RelativeLayout mUserName;
    @BindView(R.id.mUserSex)
    RelativeLayout mUserSex;
    @BindView(R.id.mUserAge)
    RelativeLayout mUserAge;
    @BindView(R.id.mUserPhone)
    RelativeLayout mUserPhone;
    @BindView(R.id.mUserWeiXin)
    RelativeLayout mUserWeiXin;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.mUserQQ)
    RelativeLayout mUserQQ;
    @BindView(R.id.mUserAddress)
    RelativeLayout mUserAddress;
    private PopupWindow pop;
    private PopupWindow Sexpopu;
    private View inflate;
    private Bitmap bitmap;
    private RelativeLayout photograph;
    private RelativeLayout album;
    private TextView cancel;
    private View sexpopu;
    private RelativeLayout sexmen;
    private RelativeLayout sexwemen;
    private TimePickerView pvTime;
    private Calendar startDate;
    private Calendar endDate;
    private TextView data;


    @Override
    protected int getLayout() {
        return R.layout.activity_user_message;
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void init() {
        ButterKnife.bind(this);
        inflate = getLayoutInflater().inflate(R.layout.popup_userphone, null);
        sexpopu = getLayoutInflater().inflate(R.layout.popup_sexphone, null);
        photograph = this.inflate.findViewById(R.id.userphotograph);
        album = this.inflate.findViewById(R.id.useralbum);
        cancel = this.inflate.findViewById(R.id.usercancel);
        photograph.setOnClickListener(this);
        album.setOnClickListener(this);
        cancel.setOnClickListener(this);
        sexmen = sexpopu.findViewById(R.id.sexmen);
        sexwemen = sexpopu.findViewById(R.id.sexwemen);
        sexmen.setOnClickListener(this);
        sexwemen.setOnClickListener(this);
        data = findViewById(R.id.data);
        mUserAge.setOnClickListener(this);
        mUserName.setOnClickListener(this);
        mUserSex.setOnClickListener(this);
        mUserQQ.setOnClickListener(this);
        mUserWeiXin.setOnClickListener(this);
        mUserAddress.setOnClickListener(this);
        imageReturn.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Calendar selectedDate = Calendar.getInstance();
        startDate = Calendar.getInstance();
        //startDate.set(2013,1,1);
        endDate = Calendar.getInstance();
        //endDate.set(2020,1,1);

        //正确设置方式 原因：注意事项有说明
        startDate.set(1900,0,1);
        endDate.set(2100,11,31);
    }


    @OnClick({R.id.image_return, R.id.mUserPhoto})
    public void onViewClicked(View view) {
            switch (view.getId()){
                case R.id.mUserPhoto:
                    pop = new PopupWindow(inflate,
                            WindowManager.LayoutParams.MATCH_PARENT,
                            WindowManager.LayoutParams.MATCH_PARENT,
                            true);
                    pop.setBackgroundDrawable(new ColorDrawable(0xffffff));//支持点击Back虚拟键退出
                    pop.showAtLocation(findViewById(R.id.mUserPhoto), Gravity.NO_GRAVITY, 0, 0);
                    startAlphAnimotion();
                    pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            endAlphAnimotion();
                        }
                    });
                    break;
            }

    }




    /**
     * 用onActivityResult()接收传回的图像，当用户拍完照片，或者取消后，系统都会调用这个函数
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                //两种方式 获取拍好的图片
                if (data.getData() != null || data.getExtras() != null) { //防止没有返回结果
                    Uri originalUri = data.getData();
                    if (originalUri != null) {
                        //拿到图片
                        bitmap = BitmapFactory.decodeFile(originalUri.getPath());
                        mUserPhoto.setImageResource(R.mipmap.ic_launcher);
                    }
                    if (bitmap == null) {
                        Bundle bundle = data.getExtras();
                        if (bundle != null) {
                            bitmap = (Bitmap) bundle.get("data");
                           /* Bitmap bitmap1 = new CircleBitmapTransformation(this).getBitmap(this.bitmap);*/
                            mUserPhoto.setImageBitmap(bitmap);
                        } else {

                            Toast.makeText(AppSituation.context.getApplicationContext(), "找不到图片", Toast.LENGTH_SHORT).show();
                        }
                    }
                    //处理图片
                    //裁剪图片
                }

                break;
            case CHOOS_PHOTO:
                if (resultCode == RESULT_OK){
                    //判断手机版本号
                    if (Build.VERSION.SDK_INT >= 19){
                        //4.4及以上系统使用这个方法处理图片
                        hanleImageOnKitKat(data);
                    }else {
                        //4.4以下系统使用这个方法处理图片
                        handleImageBeforeKitKat(data);
                    }
                }
                break;
            default:
                break;
        }
    }
    @TargetApi(19)
    private void hanleImageOnKitKat(android.content.Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(AppSituation.context,uri)){
            //如果是document类型的uri，则通过document id处理
            String docid = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())){
                String id = docid.split(":")[1];//解析出数字格式的ID
                String selection = MediaStore.Images.Media._ID+ "="+id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
            }else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),Long.valueOf(docid));
                imagePath = getImagePath(contentUri,null);
            }
        }else if ("content".equalsIgnoreCase(uri.getScheme())){
            //如果是content类型的uri，则使用普通的处理方式
            imagePath = getImagePath(uri,null);
        }else if ("file".equalsIgnoreCase(uri.getScheme())){
            //如果是file类型的uri，直接获取图片路径即可
            imagePath = uri.getPath();
        }
        displayImage(imagePath);//根据图片路径显示图片
    }
    private void handleImageBeforeKitKat(android.content.Intent data) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri,null);
        displayImage(imagePath);
    }
    private String getImagePath(Uri uri, String selection){
        String path = null;
        //通过Uri 和 selection 来获取真实的图片路径
        Cursor cursor = AppSituation.context.getContentResolver().query(uri,null,selection,null,null);
        if (cursor != null){
            if (cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }
    private void  displayImage(String imagePath){
        if (imagePath != null){
            mUserPhoto.setImageBitmap(bitmap);
        }else {
            Toast.makeText(AppSituation.context,"failed to get image", Toast.LENGTH_SHORT).show();
        }
    }

    //加载图片
    private void showImage(String imaePath) {
        Bitmap bm = BitmapFactory.decodeFile(imaePath);
        mUserPhoto.setImageBitmap(bm);
    }

    //改变屏幕透明度
    public void startAlphAnimotion() {
        WindowManager.LayoutParams ll = AppSituation.context.getWindow().getAttributes();
        ll.alpha = 0.7f;
        AppSituation.context.getWindow().setAttributes(ll);
    }

    //恢复屏幕透明度
    public void endAlphAnimotion() {
        WindowManager.LayoutParams ll = AppSituation.context.getWindow().getAttributes();
        ll.alpha = 1;
        AppSituation.context.getWindow().setAttributes(ll);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.mUserName:
                startActivity(new Intent(UserMessageActivity.this, UserMessageNameMainActivity.class));
                break;
            case R.id.mUserSex:
                Sexpopu = new PopupWindow(sexpopu,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        true);
                Sexpopu.setBackgroundDrawable(new ColorDrawable(0xffffff));//支持点击Back虚拟键退出
                Sexpopu.showAtLocation(findViewById(R.id.mUserPhoto), Gravity.NO_GRAVITY, 0, 0);
                startAlphAnimotion();
                Sexpopu.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        endAlphAnimotion();
                    }
                });

                break;
            case R.id.mUserAge:

                pvTime = new TimePickerView.Builder(AppSituation.context, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String format = simpleDateFormat.format(date);
                        data.setText(format);
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
                        .setLabel("年","月","日",null,null,null)//默认设置为年月日时分秒
                        .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        .isDialog(true)//是否显示为对话框样式
                        .build();
                //注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                pvTime.show();

                break;
            case R.id.mUserPhone:

                break;
            case R.id.image_return:
             finish();
                break;

            case R.id.mUserWeiXin:
                startActivityForResult(new Intent(UserMessageActivity.this, UserMessageWeiXinMainActivity.class),100);

                break;
            case R.id.mUserQQ:
                startActivityForResult(new Intent(UserMessageActivity.this, UserMessageQQMainActivity.class),101);
                break;
            case R.id.mUserAddress:
                startActivityForResult(new Intent(UserMessageActivity.this, UserMessageAddressMainActivity.class),102);
                break;
            //这个是拍照的ID
            case R.id.userphotograph:
                Toast.makeText(AppSituation.context, "点击事件", Toast.LENGTH_SHORT).show();
                openTakePhoto();
                pop.dismiss();
                break;
            //这个是手机相册的
            case R.id.useralbum:
                //申请手机权限
                if (ContextCompat.checkSelfPermission(AppSituation.context, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(AppSituation.context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 2);
                    openAlbum();
                } else {
                    openAlbum();
                }
                pop.dismiss();
                break;
            case R.id.usercancel:
                pop.dismiss();
                break;
            case R.id.sexmen:
                Toast.makeText(AppSituation.context,"男",Toast.LENGTH_SHORT).show();
                Sexpopu.dismiss();
                break;
            case R.id.sexwemen:
                Toast.makeText(AppSituation.context,"女",Toast.LENGTH_SHORT).show();
                Sexpopu.dismiss();
                break;

        }
    }
    private void openTakePhoto() {
        /**
         * 在启动拍照之前最好先判断一下sdcard是否可用
         */
        String state = Environment.getExternalStorageState(); //拿到sdcard是否可用的状态码
        if (state.equals(Environment.MEDIA_MOUNTED)) {   //如果可用
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent, 1);
        } else {
            Toast.makeText(AppSituation.context, "sdcard不可用", Toast.LENGTH_SHORT).show();
        }
    }
    private void openAlbum() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        //设置照片存放的目录
        startActivityForResult(intent,CHOOS_PHOTO);//打开手机相册
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 100:
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults.length>0&&grantResults[i] == PackageManager
                            .PERMISSION_GRANTED){
                        Toast.makeText(AppSituation.context,"You denied the permission",Toast.LENGTH_SHORT).show();
                    }else {
//                        openAlbum();

                    }
                }
                break;
            case 2:
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults.length>0&&grantResults[i] == PackageManager
                            .PERMISSION_GRANTED){
                        Toast.makeText(AppSituation.context,"You denied the permission",Toast.LENGTH_SHORT).show();
                    }else {
//                        openAlbum();
                    }
                }
                break;
            default:
        }

    }




}





