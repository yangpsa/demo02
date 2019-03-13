package com.bawei.myapplxi01;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bawei.fragment.Fragment01;
import com.bawei.fragment.Fragment02;
import com.bawei.fragment.Fragment03;

public class MainActivity extends BaseActivity {


    private FrameLayout frame_la;
    private RadioGroup rad_gro;
    private Fragment01 fragment01;
    private Fragment02 fragment02;
    private Fragment03 fragment03;
    private FragmentManager manager;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        frame_la = bindView(R.id.frame_la);
        rad_gro = bindView(R.id.rad_gro);

    }

    @Override
    protected void initData() {

        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03 = new Fragment03();
        //获取Fragment管理者
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frame_la,fragment01)//添加Fragment
                .add(R.id.frame_la,fragment02)
                .add(R.id.frame_la,fragment03)
                .show(fragment01)//展示Fragment
                .hide(fragment02)//隐藏Fragment
                .hide(fragment03)
                .commit();
    }

    @Override
    protected void bindEvent() {
        rad_gro.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();

                switch (checkedId){

                    case R.id.ra1:
                        transaction.show(fragment01).hide(fragment02).hide(fragment03);
                        break;
                    case R.id.ra2:
                        transaction.show(fragment02).hide(fragment01).hide(fragment03);
                        break;
                    case R.id.ra3:
                        transaction.show(fragment03).hide(fragment02).hide(fragment01);
                        break;
                }
                transaction.commit();
            }
        });
    }
}
