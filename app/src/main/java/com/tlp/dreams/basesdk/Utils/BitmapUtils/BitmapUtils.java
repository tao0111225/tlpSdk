package com.tlp.dreams.basesdk.Utils.BitmapUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapUtils {
    /**
     * 旋转图片
     *
     * @param bitmap
     * @param rotate 三星内存溢出
     * @return
     */
    private static Bitmap rotateBitmap(Bitmap bitmap, int rotate) {
        if (bitmap == null)
            return null;
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        // Setting post rotate to 90
        Matrix mtx = new Matrix();
        mtx.postRotate(rotate);
        return Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, true);
    }


    /**
     * 三星手机慢
     * 思路:方法执行时间过长怎么办？ 三星手机内存溢出
     *
     * @param filePath
     * @return
     */
    public static File getSmallBitmap(String filePath) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, 640, 1136);
        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        Bitmap bm = BitmapFactory.decodeFile(filePath, options);

        if (bm == null) {
            return null;
        }
        //旋转角度
        int degree = readPictureDegree(filePath);

        bm = rotateBitmap(bm, degree);
        return saveBitmap(bm, filePath, 70);
    }

    /**
     * 根据View(主要是ImageView)的宽和高来计算Bitmap缩放比例。默认不缩放
     *
     * @param options
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }


    /**
     * 添加图片到sd卡并规定压缩比例，100默认原图
     */
    public static File saveBitmap(Bitmap bitmap, String savePath, int quality) {
        if (bitmap == null)
            return null;
        try {
            File f = new File(savePath);
            if (f.exists()) f.delete();
            FileOutputStream fos = new FileOutputStream(f);
            f.createNewFile();
            // 把Bitmap对象解析成流
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fos);
            Log.d("bitmap", bitmap.getRowBytes() + "");
            fos.flush();
            fos.close();
            bitmap.recycle();
            return f;
        } catch (IOException e) {
            e.printStackTrace();
            bitmap.recycle();
            return null;
        }
    }


    public static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

}
