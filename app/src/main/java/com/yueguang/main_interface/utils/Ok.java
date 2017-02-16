package com.yueguang.main_interface.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import static android.content.ContentValues.TAG;

/**
 * Created by FengJIe on 2017/2/14.
 */

public class Ok {


    private String url;
    private Handler handler;


    public Ok(String url,Handler handler) {
        this.handler=handler;
        this.url = url;
    }

    public void sendRequestWithOkHttp() {
        /*new Thread(){
            @Override
            public void run() {
                Message message=new Message()
            }
        }.start();*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //创建一个Request
                final Request request = new Request.Builder()
                        .url(url)
                        .build();
                //new call
                Call call = mOkHttpClient.newCall(request);
                //请求加入调度
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                    }

                    @Override
                    public void onResponse(final Response response) throws IOException {
                        String htmlStr = response.body().string();
                        Log.d(TAG, "onResponse: " + htmlStr);

                        Message message=Message.obtain();
                        message.obj=htmlStr;
                        handler.sendMessage(message);


                    }
                });


            }
        }).start();













    }
}

