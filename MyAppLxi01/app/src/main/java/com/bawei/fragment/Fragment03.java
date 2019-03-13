package com.bawei.fragment;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.myapplxi01.R;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/2/28 15:26
 * @Description：描述信息
 */
public class Fragment03 extends BaseFragment implements View.OnClickListener {

    private DrawerLayout draw_la;
    private Button btn1;
    private Button btn2;

    @Override
    public int bindLayou() {
        return R.layout.fragment03;
    }

    @Override
    protected void iniView() {
        draw_la = binView(R.id.draw_la);
        btn1 = binView(R.id.btn1);
        btn2 = binView(R.id.btn2);

    }

    @Override
    protected void iniData() {

    }

    @Override
    protected void bindEven() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        draw_la.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                Toast.makeText(getActivity(),"进入侧滑页面",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                Toast.makeText(getActivity(),"回到主页面",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                draw_la.openDrawer(Gravity.RIGHT);
                break;
            case R.id.btn2:
                draw_la.closeDrawer(Gravity.RIGHT);
                break;
        }
    }
}
