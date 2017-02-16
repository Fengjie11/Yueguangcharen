package com.yueguang.main_interface.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fengjie.baway.com.yueguangcharen.R;

/**
 * Created by FengJIe on 2017/2/15.
 */

public class Privilege extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.discount_item,null);
        return view;
    }
}
