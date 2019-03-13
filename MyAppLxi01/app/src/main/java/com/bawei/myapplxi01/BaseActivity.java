package com.bawei.myapplxi01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/2/28 15:15
 * @Description：描述信息
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());

        initView();
        initData();
        bindEvent();
    }

    //绑定布局
    public abstract int bindLayout();
    //初始化控件
    protected abstract void initView();
    //初始化数据
    protected abstract void initData();
    //绑定事件
    protected abstract void bindEvent();

    protected <T extends View> T bindView(int resId){
        return (T) findViewById(resId);
    }
}
