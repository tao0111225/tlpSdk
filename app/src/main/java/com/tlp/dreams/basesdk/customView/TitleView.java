package com.tlp.dreams.basesdk.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tlp.dreams.basesdk.R;


/**
 * Author  : ZzGhY
 * Date    : 2016-07-25 10:46
 * Email   : 18772115876@163.com
 * Content : 自定义标题栏。
 */
public class TitleView extends LinearLayout {

    private LinearLayout left_LL, right_LL;
    private TextView titleContext,title_right_tv;
    private ImageView title_right_bt ;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.widget_view_title, this);
        left_LL = (LinearLayout) findViewById(R.id.left_LL);
        right_LL = (LinearLayout) findViewById(R.id.right_LL);
        titleContext = (TextView) findViewById(R.id.titleContext);
        title_right_bt= (ImageView) findViewById(R.id.title_right_bt);
        title_right_tv= (TextView) findViewById(R.id.title_right_tv);

    }

    /**
     * 标题内容
     *
     * @param str
     */
    public void setTitleContent(String str) {
        titleContext.setText(str);
    }

    /**
     * leftOnclick
     */
    public void setLeftOnClickListener(OnClickListener leftOnClickListener) {
        left_LL.setOnClickListener(leftOnClickListener);
    }

    /**
     * rightOnclick
     */
    public void setRightOnClickListener(OnClickListener RightOnClickListener) {
        right_LL.setOnClickListener(RightOnClickListener);
    }
    public void setLeftVisibility(boolean show){
        left_LL.setVisibility(show==true? View.VISIBLE:INVISIBLE);
    }

    public void setRightVisibility(boolean show){
        right_LL.setVisibility(show==true? View.VISIBLE:INVISIBLE);
    }

    public void setRight_image(int resoucre){
        title_right_bt.setVisibility(VISIBLE);
        title_right_bt.setImageResource(resoucre);
    }
    // right  文字
    public  void setRight_tv(String str){
        title_right_tv.setVisibility(VISIBLE);
        title_right_tv.setText(str);
    }




}
