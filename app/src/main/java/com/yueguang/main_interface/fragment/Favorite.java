package com.yueguang.main_interface.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.yueguang.main_interface.Bean.DiscountFavoriteBean;
import com.yueguang.main_interface.utils.Ok;

import fengjie.baway.com.yueguangcharen.R;

/**
 * Created by FengJIe on 2017/2/15.
 */

public class Favorite extends Fragment {
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String s = (String) msg.obj;
            toGson(s);
        }

        private void toGson(String s) {
            Gson gson=new Gson();
            DiscountFavoriteBean discountFavoriteBean
                    = gson.fromJson(s, DiscountFavoriteBean.class);
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.discount_item,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Ok ok=new Ok("http://eleteamapi.ygcr8.com/v1/product/list-featured-price",handler);
        ok.sendRequestWithOkHttp();
    }
}
