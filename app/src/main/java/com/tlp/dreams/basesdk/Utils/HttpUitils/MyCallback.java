package com.tlp.dreams.basesdk.Utils.HttpUitils;

import android.content.Context;


import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * author  ：tlp
 * create  ： 16/7/28
 * email   ：18772115876@163.com
 * content ：  集中过滤类
 */
public abstract class MyCallback<T extends RetrofitBaseCall> implements Callback<T> {

    private Context mcontext;


    public MyCallback(Context context) {
        mcontext = context;
    }


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        //响应成功
        if (response.isSuccessful()) {
            //  逻辑处理

        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
          // 网络处理
        if (t instanceof SocketTimeoutException) {
            onFail("网络超时");
        } else if (t instanceof ConnectException) {
            onFail("网络连接失败，请检查网络。");
        } else if (t instanceof RuntimeException) {
            onFail("网络连接失败，请检查网络。");
        }
        onFail(t.getMessage());

    }


    public abstract void onSuccess(Response<T> response);

    public abstract void onFail(String message);





}
