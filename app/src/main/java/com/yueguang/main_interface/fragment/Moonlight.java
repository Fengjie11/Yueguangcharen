package com.yueguang.main_interface.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.yueguang.main_interface.Bean.MoonlightBean;
import com.yueguang.main_interface.adapter.MoonlightLife;
import com.yueguang.main_interface.utils.Ok;

import java.util.List;

import fengjie.baway.com.yueguangcharen.R;

/**
 * Created by FengJIe on 2017/2/8.
 */

public class Moonlight extends Fragment {
    Handler handler=new Handler(){



        @Override
        public void handleMessage(Message msg) {

           String s = (String) msg.obj;

            //Gson解析数据
            togson(s);


        }
    };
    private ListView listViewLift;
    private ListView listViewRight;
   //private List<MoonlightBean.DataBean.CategoriesBean.ProductsBean> products;

    private void togson(String s) {
        Gson gson=new Gson();
        MoonlightBean moonlightBean = gson.fromJson(s, MoonlightBean.class);


        //Moonlight左半边的数据
        List<MoonlightBean.DataBean.CategoriesBean>
                categories = moonlightBean.getData().getCategories();
        MoonlightLife moonlightLife=new MoonlightLife(getContext(),categories,listViewRight);
        listViewLift.setAdapter(moonlightLife);

        /*//Moonlight右半边的数据

        products = moonlightBean.getData()
                .getCategories().get(0).getProducts();

        MoonlightRight moonlightRight=new MoonlightRight(getContext(),products);
        listViewRight.setAdapter(moonlightRight);*/




    }

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_moonlight,null);
        listViewLift = (ListView) view.findViewById(R.id.moonlight_view_lift);
        listViewRight = (ListView) view.findViewById(R.id.moonlight_view_right);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Ok ok=new Ok("http://eleteamapi.ygcr8.com/v1/category/list-with-product",handler);
        ok.sendRequestWithOkHttp();



    }

}
