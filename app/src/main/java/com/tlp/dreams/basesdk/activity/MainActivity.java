package com.tlp.dreams.basesdk.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tlp.dreams.basesdk.R;
import com.tlp.dreams.basesdk.Utils.ImageLoadUitils.ImageLoadUtils;
import com.tlp.dreams.basesdk.Utils.album.PickOrTakeImageActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 进入
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.takePhoto:
                 // 拍照功能
                Intent getImageByCamera = new Intent(MainActivity.this, PickOrTakeImageActivity.class);
                getImageByCamera.putExtra(PickOrTakeImageActivity.EXTRA_NUMS, 1);
                startActivityForResult(getImageByCamera, 1);

                break;
        }
    }

    //获取图片路径 响应startActivityForResult
    ArrayList<String> mlistImage;
    //    从相册或照相机Activity中取出结果，上传图片
    String  ImageUrl;
    //    从相册或照相机Activity中取出结果，上传图片

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //打开图片
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                mlistImage = (ArrayList<String>) data.getSerializableExtra("data");
                ImageUrl = mlistImage.get(0);
                //   上传头像

            }

        }
    }
}
