package com.tlp.dreams.basesdk.Utils.ImageLoadUitils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;

import java.io.File;

/**
 * Created by Sun_tao on 2016/7/6.
 */
public class ImageLoadUtils {

    static volatile ImageLoadUtils defaultInstance;


    private ImageLoadUtils() {
    }

    public static ImageLoadUtils getDefault() {
        if (defaultInstance == null) {
            synchronized (ImageLoadUtils.class) {
                if (defaultInstance == null) {
                    defaultInstance = new ImageLoadUtils();
                }
            }
        }
        return defaultInstance;
    }


    /**
     * 加载网络图片
     *
     * @param context
     * @param image
     * @param url
     */
    public void loadImage(Context context, ImageView image, String url) {
        if (TextUtils.isEmpty(url)) return;
        Glide.with(context).load(url).into(image);
    }


    /**
     * 加载网络图片 比例缩放
     *
     * @param context
     * @param image
     * @param url
     */
    public void loadImagefitCenter(Context context, ImageView image, String url) {
        if (TextUtils.isEmpty(url)) return;
        Glide.with(context).load(url).fitCenter().into(image);
    }


    //根据屏幕宽度和图片宽度进行等比例拉升。
    public void loadImageScreen(Context context, ImageView image, String url, int resourceId) {
        Glide.with(context)
                .load(url)
                .placeholder(resourceId)
                .bitmapTransform(new ForWindowsWidth(context))
                .into(image);

    }


    /**
     * 加载SdCard
     *
     * @param context
     * @param image
     * @param Uri
     */
    public void loadImageSDCard(Context context, ImageView image, String Uri) {
        File file = new File(Uri);
        Glide.with(context).load(file).into(image);
    }


    /**
     * 加载网络图片
     *
     * @param context
     * @param image
     * @param url
     */
    public void loadImageListner(Context context, ImageView image, String url, RequestListener<String, GlideDrawable> builder) {
        Glide.with(context).load(url).listener(builder).into(image);
    }


    /**
     * 加载网络图片 自定义设置占位符
     *
     * @param context
     * @param image
     * @param url
     */
    public void loadImageAndZWF(Context context, ImageView image, String url, int resourceId) {
        Glide.with(context)
                .load(url)
                .placeholder(resourceId)
                .into(image);

    }

    /**
     * 加载本地图片
     *
     * @param context
     * @param image
     * @param uri
     */
    public void loadImage(Context context, ImageView image, Uri uri, int defauImageID, int errorImageID) {
        Glide.with(context)
                .load(uri)
                .placeholder(defauImageID)
                .error(errorImageID)
                .into(image);

    }

    /**
     * 加载网络图片
     *
     * @param context
     * @param image
     * @param uri
     */
    public void loadImage(Context context, ImageView image, String uri, int defauImageID, int errorImageID) {
        Glide.with(context)
                .load(uri)
                .placeholder(defauImageID)
                .error(errorImageID)
                .into(image);

    }

    /**
     * 加载资源文件
     *
     * @param context
     * @param image
     * @param resourceId
     */
    public void loadImage(Context context, ImageView image, int resourceId) {
        Glide.with(context)
                .load(resourceId)
                .into(image);

    }

    /**
     * 加载网络图片 并设置圆形
     *
     * @param context
     * @param image
     * @param url
     */
    public void loadImageCircle(Context context, ImageView image, String url, int defauImageID) {
        Glide.with(context)
                .load(url)
                .placeholder(defauImageID)
                .bitmapTransform(new CropCircleTransformation(context))
                .into(image);

    }


    /**
     * 加载网络图片 自定义设置占位符
     *
     * @param context
     * @param image
     * @param url
     */
    public void loadImage(Context context, ImageView image, String url, int resourceId) {
        Glide.with(context)
                .load(url)
                .placeholder(resourceId)
                .bitmapTransform(new CropCircleTransformation(context))
                .into(image);

    }


    /**
     * 后台下载
     *
     * @param url
     */
    public void downloadOnly(String url, Context context, ImageView imageView) {

    }


}
