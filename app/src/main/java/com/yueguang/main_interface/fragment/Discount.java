package com.yueguang.main_interface.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yueguang.main_interface.adapter.DiscountViewPager;

import java.util.ArrayList;
import java.util.List;

import fengjie.baway.com.yueguangcharen.R;

/**
 * Created by FengJIe on 2017/2/8.
 */

public class Discount extends Fragment {




    private View view;
    private String[] mTitle=new String[]{"天天优惠","为你精选","亲的最爱"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_discount,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();

    }

    private void initViews() {
        List<Fragment> fragments=new ArrayList<>();
        TabLayout tabLayout= (TabLayout) view.findViewById(R.id.id_tablelayout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        Favorite favorite=new Favorite();
        Sift sift=new Sift();
        Privilege privilege=new Privilege();
        fragments.add(privilege);
        fragments.add(sift);
        fragments.add(favorite);
        DiscountViewPager discountViewPager=new
                DiscountViewPager(getActivity().getSupportFragmentManager(),mTitle,fragments);
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(discountViewPager);
        tabLayout.setupWithViewPager(viewPager);


    }
}
