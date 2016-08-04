package com.tlp.dreams.basesdk.Base;

import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.socks.library.KLog;
import com.tlp.dreams.basesdk.customView.TitleView;
import com.tlp.dreams.basesdk.R;
import com.tlp.dreams.basesdk.app.GlobalApplication;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * author  ：tlp
 * create  ：16/7/26
 * email   ：18772115876@163.com
 * content ：base基类 临时替换
 */
public abstract class BaseActivity extends FragmentActivity {

    private Dialog dialog;
    public boolean ACTIVITY_STATUS;

    protected String TAG = getClass().getSimpleName();

    public Toast toast = null;
    public BaseActivity _this;
    private Toast toastProgress;
     protected TitleView titleView;


    @Subscribe
     @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        _this = this;
        KLog.d("activityName", "activity=" + TAG);
         EventBus.getDefault().register(this);
        GlobalApplication.getInstance().addActivity(this);
        beforeSetContentView();
        if (initcontentView() != 0) {
            setContentView(initcontentView());
        }
         titleView=getView(R.id.titleView);
        initView(savedInstanceState);
        initData();
        onClick();
        laterSetContentView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ACTIVITY_STATUS = true;//界面打开时标记为true
    }

    @Override
    protected void onPause() {
        super.onPause();
        ACTIVITY_STATUS = false;// 界面关闭时标记为false
    }


    /**
     * 在setContentView之前触发的方法
     */
    protected void beforeSetContentView() {

    }

    /**
     * 在setContentView之后触发的方法
     */
    protected void laterSetContentView() {

    }

    /**
     * 初始化控件
     */
    public abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    public void initData() {

    }

    public void onClick() {

    }

    protected abstract int initcontentView();

    /**
     * 通过泛型来简化findViewById
     */
    protected final <E extends View> E getView(int id) {
        try {
            return (E) findViewById(id);
        } catch (ClassCastException ex) {
            Log.e(TAG, "Could not cast View to concrete class.", ex);
            throw ex;
        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        GlobalApplication.getInstance().removeActivity(this);
        EventBus.getDefault().unregister(this);
    }
}
