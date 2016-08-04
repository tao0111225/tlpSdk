package com.tlp.dreams.basesdk.Utils.HttpUitils;

import android.content.Context;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by Sun_tao on 2016/7/12.
 */
public class ServiceGenerator {
    public static final String API_BASE_URL = "";


    public static <S> S provideClientApi(Class<S> serviceClass, final String url, Context mcontext) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(genericClient(url, mcontext))
//        addCallAdapterFactory(RxJavaCallAdapterFactory.create())  Rxjava
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

    // 可以优化拦截器的点，怎么祛除Context。
    // http://mrljdx.com/2016/01/07/Retrofit2-0-%E6%96%B0%E7%89%B9%E6%80%A7%E7%AE%80%E4%BB%8B/
    public static OkHttpClient genericClient(final String url, final Context mcontext) {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        //集中处理 heads

//                        String myTimeStamp = getMyTimeStamp();
//                        String token = SharedConfiger.getString(mcontext, "token");
//
                        Request original = chain.request();
                        Request.Builder request = original
                                .newBuilder();
//                        // 集中处理 heads
//                        request
//                                .header("versionId", "member2.2.0")
//                                .header("timestamp", myTimeStamp)
//                                .header("sfToken", calcHash(myTimeStamp, url))
//                                .method(original.method(), original.body());
//
//                        //  登录之前没有Authorization
//                        if (token != null && !token.equals("")) {
//                            request.header("Authorization", token);
//                        }


                        return chain.proceed(request.build());
                    }

                })
                .build();
        return httpClient;
    }






}
