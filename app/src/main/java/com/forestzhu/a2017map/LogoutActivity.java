package com.forestzhu.a2017map;

<<<<<<< HEAD
import android.app.Activity;
=======
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import view.CircleImageView;
import view.Login;

<<<<<<< HEAD
public class LogoutActivity extends Activity  {
=======
public class LogoutActivity extends AppCompatActivity implements View.OnClickListener {
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    private Button logout;
    private Button own_more;
    private Button photograph;
    private Button album;
<<<<<<< HEAD
    private Button down_map;
=======
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    private TextView user_name;
    private Button log_cancel;
    private Button back_main;
    private Button car_number;
    private Button own_route;
    private Uri imagePhotoUri;
    private MyApplication1 trackap;
    private CircleImageView circleImageView;
    private PopupWindow mPopwindow;
    private SharedPreferences sharedPreferences;
    private static final int CODE_GALLERY_REQUEST = 0xa0;//本地
    private static final int CODE_CAMERA_REQUEST = 0xa1;//拍照
    private static final int CODE_RESULT_REQUEST = 0xa2;//最终裁剪后的结果

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.own);
        back_main = (Button) findViewById(R.id.back_main);
        logout = (Button) findViewById(R.id.logout);
        own_more = (Button) findViewById(R.id.own_more);
        car_number = (Button) findViewById(R.id.car_number);
<<<<<<< HEAD
        down_map=(Button)findViewById(R.id.offline);
        circleImageView = (CircleImageView) findViewById(R.id.own_picture);
        own_route = (Button) findViewById(R.id.own_route);
        user_name = (TextView) findViewById(R.id.owner_name);
        down_map.setOnClickListener(new downbaidu());
=======
        circleImageView = (CircleImageView) findViewById(R.id.own_picture);
        own_route = (Button) findViewById(R.id.own_route);
        user_name = (TextView) findViewById(R.id.owner_name);
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        back_main.setOnClickListener(new backlistener());
        own_more.setOnClickListener(new morelistener());
        logout.setOnClickListener(new logoutlistener());
        imagePhotoUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/com.foerstzhu", "image.png"));
<<<<<<< HEAD
=======
        Log.e("错误", Environment.getExternalStorageDirectory().getAbsolutePath());
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        circleImageView.setOnClickListener(new picturelistener());
        trackap = (MyApplication1) getApplicationContext();
        sharedPreferences = trackap.getPreference();
        if (!(sharedPreferences.getString("entityName", "").equals(""))) {
            user_name.setText(sharedPreferences.getString("entityName", ""));
            car_number.setText(sharedPreferences.getString("tripname", ""));
        } else {
            user_name.setText("X某某");
        }
        if (trackap.own_picture() != null) {
            Bitmap photoBitmap = trackap.own_picture();
            circleImageView.setImageBitmap(photoBitmap);

        } else {
            circleImageView.setImageResource(R.drawable.school_target);
        }
        if (trackap.trace_route == 1)
<<<<<<< HEAD
            own_route.setText("教学区-学生宿舍");
        if (trackap.trace_route == 2)
            own_route.setText("学生宿舍-教学区");
    }

  class choice implements View.OnClickListener {
      public void onClick(View v) {
          int id = v.getId();
          switch (id) {
              case R.id.album: {
                  mPopwindow.dismiss();
                  choseHeadImageFromGallery();
              }
              break;
              case R.id.photograph: {
                  mPopwindow.dismiss();
                  choseHeadImageFromCameraCapture();
              }
              break;
              case R.id.own_cancel: {
                  mPopwindow.dismiss();
              }
              break;
          }
      }
  }
=======
            own_route.setText("开发区校区-本部");
        if (trackap.trace_route == 2)
            own_route.setText("本部-开发区校区");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.album: {
                mPopwindow.dismiss();
                choseHeadImageFromGallery();
            }
            break;
            case R.id.photograph: {
                mPopwindow.dismiss();
                choseHeadImageFromCameraCapture();
            }
            break;
            case R.id.own_cancel: {
                mPopwindow.dismiss();
            }
            break;
        }
    }
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab

    private void choseHeadImageFromGallery() {
        Intent intentFromGallery = new Intent();
// 设置文件类型
        intentFromGallery.setType("image/*");//选择图片
        intentFromGallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intentFromGallery, CODE_GALLERY_REQUEST);
    }

    // 启动手机相机拍摄照片作为头像
    private void choseHeadImageFromCameraCapture() {
        Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, imagePhotoUri);
        startActivityForResult(intentFromCapture, CODE_CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        // 用户没有进行有效的设置操作，返回
        if (resultCode == RESULT_CANCELED) {//取消
            Toast.makeText(getApplication(), "取消", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent_crop = new Intent("com.android.camera.action.CROP");
        switch (requestCode) {
            case CODE_GALLERY_REQUEST://如果是来自本地的
<<<<<<< HEAD
=======
                Log.e("erro", "开始执行裁剪");
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
                Uri originalUri = intent.getData();
                intent_crop.setDataAndType(originalUri, "image/*");
                //下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
                intent_crop.putExtra("crop", true);
                // 设置裁剪尺寸
                intent_crop.putExtra("aspectX", 1);
                intent_crop.putExtra("aspectY", 1);
                intent_crop.putExtra("outputX", 320);
                intent_crop.putExtra("outputY", 320);
                intent_crop.putExtra("return-data", true);
                intent_crop.putExtra(MediaStore.EXTRA_OUTPUT, originalUri);
                startActivityForResult(intent_crop, CODE_RESULT_REQUEST);
                break;
              /* try {
                    //使用ContentProvider通过URI获取原始图片
                    Bitmap photo = MediaStore.Images.Media.getBitmap(resolver, originalUri);
                    if (photo != null) {
                        //为防止原始图片过大导致内存溢出，这里先缩小原图显示，然后释放原始Bitmap占用的内存
                        Bitmap smallBitmap = ImageTools.zoomBitmap(photo, photo.getWidth() /5, photo.getHeight() / 5);
                        //释放原始图片占用的内存，防止out of memory异常发生
                        photo.recycle();
                        circleImageView.setImageBitmap(smallBitmap);
                        ImageTools.savePhotoToSDCard(smallBitmap,Environment.getExternalStorageDirectory().getAbsolutePath(),"image");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;*/
            case CODE_CAMERA_REQUEST:
<<<<<<< HEAD
=======
                Log.e("错误", "执行到开始存储图片！");
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
                intent_crop.setDataAndType(imagePhotoUri, "image/*");
                //下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
                // 设置裁剪尺寸
                intent_crop.putExtra("crop", "true");
                intent_crop.putExtra("aspectX", 1);
                intent_crop.putExtra("aspectY", 1);
                intent_crop.putExtra("outputX", 320);
                intent_crop.putExtra("outputY", 320);
                intent_crop.putExtra("return-data", true);
                intent_crop.putExtra(MediaStore.EXTRA_OUTPUT, imagePhotoUri);
                startActivityForResult(intent_crop, CODE_RESULT_REQUEST);
               /* Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/com.foerstzhu"+"/image.png");
                Bitmap newBitmap = ImageTools.zoomBitmap(bitmap, bitmap.getWidth() / 5, bitmap.getHeight() /5);
                //由于Bitmap内存占用较大，这里需要回收内存，否则会报out of memory异常
                bitmap.recycle();
                //将处理过的图片显示在界面上，并保存到本地
                circleImageView.setImageBitmap(newBitmap);*/
                break;
            case CODE_RESULT_REQUEST:
                if (intent != null) {
                    Bundle bundle = intent.getExtras();
                    Bitmap myBitmap = bundle.getParcelable("data");
                    if (myBitmap != null) {
                        //为防止原始图片过大导致内存溢出，这里先缩小原图显示，然后释放原始Bitmap占用的内存
                        //  Bitmap smallBitmap = ImageTools.zoomBitmap(myBitmap, myBitmap.getWidth() /5, myBitmap.getHeight() / 5);
                        //释放原始图片占用的内存，防止out of memory异常发生
                        // myBitmap.recycle();
                        circleImageView.setImageBitmap(myBitmap);
                        ImageTools.savePhotoToSDCard(myBitmap, Environment.getExternalStorageDirectory().getAbsolutePath(), "image");
                    }
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }

    class picturelistener implements View.OnClickListener {

        @Override

        public void onClick(View v) {
            showpopwindow();
        }
    }/*
    弹出小框，头像选择！！
    */

    private void showpopwindow() {
        View contentView = LayoutInflater.from(LogoutActivity.this).inflate(R.layout.own_popwindow, null);
        mPopwindow = new PopupWindow(contentView, Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.MATCH_PARENT, true);
        mPopwindow.setContentView(contentView);
        photograph = (Button) contentView.findViewById(R.id.photograph);
        album = (Button) contentView.findViewById(R.id.album);
        log_cancel = (Button) contentView.findViewById(R.id.own_cancel);
<<<<<<< HEAD
        photograph.setOnClickListener(new choice());
        album.setOnClickListener(new choice());
        log_cancel.setOnClickListener(new choice());
=======
        photograph.setOnClickListener(this);
        album.setOnClickListener(this);
        log_cancel.setOnClickListener(this);
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        mPopwindow.setBackgroundDrawable(new BitmapDrawable());//设置一个空的Bitmap
        View root_view = LayoutInflater.from(LogoutActivity.this).inflate(R.layout.own, null);
        mPopwindow.setAnimationStyle(R.style.contextMenuAnim);
        mPopwindow.setOutsideTouchable(true);
        mPopwindow.showAtLocation(root_view, Gravity.TOP, 0, 0);
    }
<<<<<<< HEAD
=======

>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    class logoutlistener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            trackap.saveLoginInfo("", "");
            Intent intent = new Intent(LogoutActivity.this, Login.class);
            startActivity(intent);
        }
    }

    class backlistener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent_back = new Intent(LogoutActivity.this, Main1Activity.class);
            startActivity(intent_back);
        }
    }

    class morelistener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent_information = new Intent(LogoutActivity.this, informaTion.class);
            startActivity(intent_information);
        }
    }
<<<<<<< HEAD
    class downbaidu implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent_downmap=new Intent(LogoutActivity.this,OfflineMap.class);
            startActivity(intent_downmap);
        }
    }
=======
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
}
