package com.tlp.dreams.basesdk.Utils.ImageLoadUitils;

import android.content.Context;
import android.graphics.Bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.tlp.dreams.basesdk.Utils.ScreenUtils;

/**
 * author  ：tlp
 * create  ： 16/8/1
 * email   ：18772115876@163.com
 * content ：
 */
public class ForWindowsWidth extends BitmapTransformation

    {

        private  int width,height;

        private  float scale; // 比例。

        public ForWindowsWidth(Context context) {
        super(context);
        width= ScreenUtils.getScreenWidth(context);
    }



        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        scale=width*1.0f/toTransform.getWidth();
        height= (int) (toTransform.getHeight()*scale);
        return Bitmap.createScaledBitmap(toTransform, width, height, false);
    }





        @Override
        public String getId() {
        return "com.wt.wutang.main.utils.GlideTransformation";
    }
    }

