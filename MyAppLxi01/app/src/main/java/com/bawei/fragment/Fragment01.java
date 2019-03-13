package com.bawei.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ListView;

import com.bawei.adapter.TabAdapter;
import com.bawei.myapplxi01.R;
import com.bawei.tab.TabFrag01;
import com.bawei.tab.TabFrag02;
import com.bawei.tab.TabFrag03;
import com.bawei.tab.TabFrag04;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/2/28 15:26
 * @Description：描述信息
 */
public class Fragment01 extends BaseFragment {

    private TabLayout tab_la;
    private ViewPager view_pag;
    private TabAdapter tabAdapter;
    private ArrayList<Fragment> lists;

    @Override
    public int bindLayou() {
        return R.layout.fragment01;
    }

    @Override
    protected void iniView() {

        tab_la = binView(R.id.tab_la);
        view_pag = binView(R.id.view_pag);

    }

    @Override
    protected void iniData() {

        //页面数据
        lists = new ArrayList<>();
        lists.add(new TabFrag01());
        lists.add(new TabFrag02());
        lists.add(new TabFrag03());
        lists.add(new TabFrag04());
        //TabLayout数据
        String[] str={"新闻","娱乐","科技","体育"};

        //适配器
        tabAdapter = new TabAdapter(getActivity().getSupportFragmentManager(), lists,str);
        view_pag.setAdapter(tabAdapter);

        tab_la.setupWithViewPager(view_pag);

    }

    @Override
    protected void bindEven() {

    }
}
