package com.bawei.fragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.alanapi.banner.Banner;
import com.alanapi.banner.BannerImageLoader;
import com.bawei.myapplxi01.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/2/28 15:26
 * @Description：描述信息
 */
public class Fragment02 extends BaseFragment {

    private Banner ban_ner;
    private ArrayList<String> list;
    String st="https://api.apiopen.top/musicRankings";

    @Override
    public int bindLayou() {
        return R.layout.fragment02;
    }

    @Override
    protected void iniView() {
        ban_ner = binView(R.id.ban_ner);

    }

    @Override
    protected void iniData() {
        list = new ArrayList<>();

        list.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=426249697,2730327521&fm=26&gp=0.jpg");
        list.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3632449672,2677463305&fm=26&gp=0.jpg");
        list.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2116145824,3773530839&fm=26&gp=0.jpg");
        list.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2132268320,3356211790&fm=26&gp=0.jpg");



    }

    @Override
    protected void bindEven() {
    ban_ner.setBannerImageLoader(new BannerImageLoader() {
        @Override
        protected void displayImage(Context context, ImageView imageView, Object o) {
            Glide.with(getActivity()).load(o).into(imageView);
        }
    });

        ban_ner.setData(list);
        ban_ner.setDelayTime(2000);
        ban_ner.isAutoPlay(true);
        ban_ner.start();
    }
}
