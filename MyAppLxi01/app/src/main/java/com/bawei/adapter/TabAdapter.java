package com.bawei.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/2/28 16:16
 * @Description：描述信息
 */
public class TabAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> lists;
    private String[] str;

    public TabAdapter(FragmentManager fm, ArrayList<Fragment> lists, String[] str) {
        super(fm);
        this.lists = lists;
        this.str = str;
    }

    @Override
    public Fragment getItem(int i) {
        return lists.get(i);
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
