package com.example.administrator.pethouse.module.user.switchuser.fragment;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.app.AppSituation;
import com.example.administrator.pethouse.base.BaseFragment;
import com.example.administrator.pethouse.entity.BtnSwitchUserBean;
import com.example.administrator.pethouse.module.user.switchuser.BtnSwitchUserContract;
import com.example.administrator.pethouse.module.user.switchuser.presenter.BtnSwitchUserPresenter;

import static android.app.Activity.RESULT_OK;

/**
 * Created by mengYao on 2017/12/12.
 */

public class BtnSwitchUserFragment extends BaseFragment<BtnSwitchUserPresenter> implements View.OnClickListener, BtnSwitchUserContract.BtnSwitchUserView{

    private ImageView tuichu;
    private EditText real_name;
    private EditText phone_number;
    private EditText home_address;
    private EditText realname;
    private ImageView positive_photo;
    private CheckBox puppy_Img;
    private EditText puppyPrice;
    private CheckBox doggy_Img;
    private EditText smallPrice;
    private CheckBox midsizedog_Img;
    private EditText midsizedogPrice;
    private CheckBox largedog_Img;
    private EditText dagouPrice;
    private CheckBox cat_Img;
    private EditText catPrice;
    private CheckBox other_Img;
    private EditText otherPrice;
    private CheckBox takeaShowerImg;
    private EditText takeAShowerPrice;
    private CheckBox shuttleImg;
    private EditText shuttlePrice;
    private EditText myIntroduction;
    private ImageView photo;
    private ImageView photo1;
    private ImageView photo2;
    private ImageView photo3;
    private ImageView photo4;
    private CheckBox agreement_Img;
    private Button determine_Button;
    private Context context;
    private PopupWindow pop;
    private View inflate;
    private RelativeLayout upload;
    private RelativeLayout photograph;
    private RelativeLayout album;
    private TextView cancel;
    private Intent intent;
    private String filePath;
    private Uri imageUri;
    private Uri uriForFile;
    private ImageView tempImage;
    public static final int TAKE_PHOTO = 100;
    public static final int CHOOS_PHOTO = 2;
    private Bitmap bitmap;
    private static final int IMAGE = 1;
    private java.lang.String imaePath;
    private String imagePath;
    private View inflate1;

    @Override
    protected View getLayoutId() {
        inflate1 = LayoutInflater.from(AppSituation.context).inflate(R.layout.fragment_btnswitchuser, null);
        return inflate1;
    }

    @Override
    protected void init() {
        tuichu = (ImageView) inflate1.findViewById(R.id.tuichu);
        tuichu.setOnClickListener(this);
        real_name = (EditText) inflate1.findViewById(R.id.real_name);
        real_name.setOnClickListener(this);
        phone_number = (EditText) inflate1.findViewById(R.id.phone_number);
        phone_number.setOnClickListener(this);
        home_address = (EditText) inflate1.findViewById(R.id.home_address);
        home_address.setOnClickListener(this);
        realname = (EditText) inflate1.findViewById(R.id.realname);
        realname.setOnClickListener(this);
        puppy_Img = (CheckBox) inflate1.findViewById(R.id.puppy_Img);
        puppy_Img.setOnClickListener(this);
        puppyPrice = (EditText) inflate1.findViewById(R.id.puppyPrice);
        puppyPrice.setOnClickListener(this);
        doggy_Img = (CheckBox) inflate1.findViewById(R.id.doggy_Img);
        doggy_Img.setOnClickListener(this);
        smallPrice = (EditText) inflate1.findViewById(R.id.smallPrice);
        smallPrice.setOnClickListener(this);
        midsizedog_Img = (CheckBox) inflate1.findViewById(R.id.midsizedog_Img);
        midsizedog_Img.setOnClickListener(this);
        midsizedogPrice = (EditText) inflate1.findViewById(R.id.midsizedogPrice);
        midsizedogPrice.setOnClickListener(this);
        largedog_Img = (CheckBox) inflate1.findViewById(R.id.largedog_Img);
        largedog_Img.setOnClickListener(this);
        dagouPrice = (EditText) inflate1.findViewById(R.id.dagouPrice);
        dagouPrice.setOnClickListener(this);
        cat_Img = (CheckBox) inflate1.findViewById(R.id.cat_Img);
        cat_Img.setOnClickListener(this);
        catPrice = (EditText) inflate1.findViewById(R.id.catPrice);
        catPrice.setOnClickListener(this);
        other_Img = (CheckBox) inflate1.findViewById(R.id.other_Img);
        other_Img.setOnClickListener(this);
        otherPrice = (EditText) inflate1.findViewById(R.id.otherPrice);
        otherPrice.setOnClickListener(this);
        takeaShowerImg = (CheckBox) inflate1.findViewById(R.id.takeaShowerImg);
        takeaShowerImg.setOnClickListener(this);
        takeAShowerPrice = (EditText) inflate1.findViewById(R.id.takeAShowerPrice);
        takeAShowerPrice.setOnClickListener(this);
        shuttlePrice = (EditText) inflate1.findViewById(R.id.shuttlePrice);
        shuttlePrice.setOnClickListener(this);
        myIntroduction = (EditText) inflate1.findViewById(R.id.myIntroduction);
        myIntroduction.setOnClickListener(this);
        photo = (ImageView) inflate1.findViewById(R.id.photo);
        photo.setOnClickListener(this);
        photo1 = (ImageView) inflate1.findViewById(R.id.photo1);
        photo1.setOnClickListener(this);
        photo2 = (ImageView) inflate1.findViewById(R.id.photo2);
        photo2.setOnClickListener(this);
        photo3 = (ImageView) inflate1.findViewById(R.id.photo3);
        photo3.setOnClickListener(this);
        photo4 = (ImageView) inflate1.findViewById(R.id.photo4);
        photo4.setOnClickListener(this);
        agreement_Img = (CheckBox) inflate1.findViewById(R.id.agreement_Img);
        agreement_Img.setOnClickListener(this);
        determine_Button = (Button) inflate1.findViewById(R.id.determine_Button);
        determine_Button.setOnClickListener(this);
        positive_photo = (ImageView) inflate1.findViewById(R.id.positive_photo);
        positive_photo.setOnClickListener(this);
        shuttleImg = (CheckBox) inflate1.findViewById(R.id.shuttleImg);
        shuttleImg.setOnClickListener(this);
        inflate = getLayoutInflater().inflate(R.layout.popup, null);
        upload = inflate.findViewById(R.id.upload);
        upload.setOnClickListener(this);
        photograph = inflate.findViewById(R.id.photograph);
        photograph.setOnClickListener(this);
        album = inflate.findViewById(R.id.album);
        album.setOnClickListener(this);
        cancel = inflate.findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
        String string = phone_number.getText().toString();
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View view) {
        if (view instanceof ImageView) {
            tempImage = (ImageView) view;
        }
        switch (view.getId()) {
            case R.id.tuichu:
                AppSituation.context.finish();
                break;
            case R.id.real_name:
                break;
            case R.id.home_address:
                break;
            case R.id.realname:
                break;
            case R.id.positive_photo:
                pop = new PopupWindow(inflate,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        true);
                pop.setBackgroundDrawable(new ColorDrawable(0xffffff));//支持点击Back虚拟键退出
                pop.showAtLocation(inflate1.findViewById(R.id.positive_photo), Gravity.NO_GRAVITY, 0, 0);
                startAlphAnimotion();

                pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        endAlphAnimotion();
                    }
                });
                break;
            case R.id.puppy_Img:
                break;
            case R.id.puppyPrice:
                break;
            case R.id.doggy_Img:
                break;
            case R.id.smallPrice:
                break;
            case R.id.midsizedog_Img:
                break;
            case R.id.midsizedogPrice:
                break;
            case R.id.largedog_Img:
                break;
            case R.id.dagouPrice:
                break;
            case R.id.cat_Img:
                break;
            case R.id.catPrice:
                break;
            case R.id.other_Img:
                break;
            case R.id.otherPrice:
                break;
            case R.id.takeaShowerImg:
                break;
            case R.id.takeAShowerPrice:
                break;
            case R.id.shuttleImg:
                break;
            case R.id.shuttlePrice:
                break;
            case R.id.myIntroduction:
                break;
            case R.id.photo:
                pop = new PopupWindow(inflate,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        true);
                pop.setBackgroundDrawable(new ColorDrawable(0xffffff));//支持点击Back虚拟键退出
                pop.showAtLocation(inflate1.findViewById(R.id.positive_photo), Gravity.NO_GRAVITY, 0, 0);
                startAlphAnimotion();
                pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        endAlphAnimotion();
                    }
                });
                break;
            case R.id.photo1:
                pop = new PopupWindow(inflate,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        true);
                pop.setBackgroundDrawable(new ColorDrawable(0xffffff));//支持点击Back虚拟键退出
                pop.showAtLocation(inflate1.findViewById(R.id.positive_photo), Gravity.NO_GRAVITY, 0, 0);
                startAlphAnimotion();

                pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        endAlphAnimotion();
                    }
                });
                if (tempImage!=null){
                    photo2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.photo2:
                pop = new PopupWindow(inflate,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        true);
                pop.setBackgroundDrawable(new ColorDrawable(0xffffff));//支持点击Back虚拟键退出
                pop.showAtLocation(inflate1.findViewById(R.id.positive_photo), Gravity.NO_GRAVITY, 0, 0);
                startAlphAnimotion();

                pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        endAlphAnimotion();
                    }
                });
                if (tempImage!=null){
                    photo3.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.photo3:
                pop = new PopupWindow(inflate,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        true);
                pop.setBackgroundDrawable(new ColorDrawable(0xffffff));//支持点击Back虚拟键退出
                pop.showAtLocation(inflate1.findViewById(R.id.positive_photo), Gravity.NO_GRAVITY, 0, 0);
                startAlphAnimotion();

                pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        endAlphAnimotion();
                    }
                });
                if (tempImage!=null){
                    photo4.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.photo4:
                pop = new PopupWindow(inflate,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        true);
                pop.setBackgroundDrawable(new ColorDrawable(0xffffff));//支持点击Back虚拟键退出
                pop.showAtLocation(inflate1.findViewById(R.id.positive_photo), Gravity.NO_GRAVITY, 0, 0);
                startAlphAnimotion();

                pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        endAlphAnimotion();
                    }
                });
                break;
            case R.id.agreement_Img:
                break;
            case R.id.determine_Button:
                AppSituation.context.finish();
                break;
            case R.id.upload:
                break;
            //这个是拍照的ID
            case R.id.photograph:
                openTakePhoto();
                pop.dismiss();
                break;
            //这个是手机相册的
            case R.id.album:
                //申请手机权限
                if (ContextCompat.checkSelfPermission(AppSituation.context, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(AppSituation.context,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2);
                    openAlbum();
                }else {
                    openAlbum();
                }
                pop.dismiss();
                break;
            case R.id.cancel:
                pop.dismiss();
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



    @Override
    public void onShow() {

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
                        tempImage.setImageResource(R.mipmap.ic_launcher);
                    }
                    if (bitmap == null) {
                        Bundle bundle = data.getExtras();
                        if (bundle != null) {
                            bitmap = (Bitmap) bundle.get("data");
                           /* Bitmap bitmap1 = new CircleBitmapTransformation(this).getBitmap(this.bitmap);*/
                            tempImage.setImageBitmap(bitmap);
                        } else {

                            Toast.makeText(context.getApplicationContext(), "找不到图片", Toast.LENGTH_SHORT).show();
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
    private void hanleImageOnKitKat(Intent data) {
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
    private void handleImageBeforeKitKat(Intent data) {
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
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            tempImage.setImageBitmap(bitmap);
        }else {
            Toast.makeText(AppSituation.context,"failed to get image", Toast.LENGTH_SHORT).show();
        }
    }

    //加载图片
    private void showImage(String imaePath) {
        Bitmap bm = BitmapFactory.decodeFile(imaePath);
        tempImage.setImageBitmap(bm);
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
    public void showProgress() {

    }

    @Override
    public void dismiss() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void getBtnSwitchUserBean(BtnSwitchUserBean bean) {

    }

    @Override
    public void OnError(String ErrorCode) {

    }
}
