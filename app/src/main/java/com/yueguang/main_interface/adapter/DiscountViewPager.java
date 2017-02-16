package com.yueguang.main_interface.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by FengJIe on 2017/2/15.
 */

public class DiscountViewPager extends FragmentStatePagerAdapter {

    private String[] strings;
    private List<Fragment> list;

    public DiscountViewPager(FragmentManager fm, String[] strings, List<Fragment> list) {
        super(fm);
        this.strings = strings;
        this.list = list;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
