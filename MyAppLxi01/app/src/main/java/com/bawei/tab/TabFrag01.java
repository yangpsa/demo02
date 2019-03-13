package com.bawei.tab;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.adapter.MyAdapter;
import com.bawei.bean.JsonBean;
import com.bawei.bean.Nxao;
import com.bawei.fragment.BaseFragment;
import com.bawei.myapplxi01.Hepler;
import com.bawei.myapplxi01.HttpUtils;
import com.bawei.myapplxi01.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/2/28 16:05
 * @Description：描述信息
 */
public class TabFrag01 extends BaseFragment {

    private PullToRefreshListView pull_list;
    private Hepler hepler;
    private SQLiteDatabase database;
    private ArrayList<Nxao> list;
    private MyAdapter myAdapter;
    private String sturl="https://www.apiopen.top/novelApi";

    @Override
    public int bindLayou() {
        return R.layout.tab_frag01;
    }

    @Override
    protected void iniView() {

        pull_list = binView(R.id.pull_list);
        //设置刷新模式
        pull_list.setMode(PullToRefreshBase.Mode.BOTH);
        //是否允许刷新时滑动
        pull_list.setScrollingWhileRefreshingEnabled(true);

        //获取数据库操作类
        hepler = new Hepler(getActivity());
        database = hepler.getWritableDatabase();
    }

    @Override
    protected void iniData() {

        //判断如果有网就请求数据
        if (HttpUtils.isNet(getActivity())){
            HttpUtils.getHttp(sturl, new HttpUtils.CallBacko() {
                @Override
                public void getData(String s) {
                    Gson gson = new Gson();
                    JsonBean jsonBean = gson.fromJson(s, JsonBean.class);
                    list = jsonBean.getData();
                    //适配器
                    myAdapter = new MyAdapter(list,getActivity());
                    pull_list.setAdapter(myAdapter);


                  //查询数据库
                    Cursor query = database.query("user", null, null, null, null, null, null);
                    if (!query.moveToFirst()){
                        ContentValues values = new ContentValues();
                        values.put("name",s);
                        database.insert("user",null,values);
                    }
                }
            });

        }else{
            Cursor query = database.query("user", null, null, null, null, null, null);
            if (query.moveToFirst()){
                String s;
                do {
                   s = query.getString(query.getColumnIndex("name"));
                }while (query.moveToNext());
                    Gson gson = new Gson();
                JsonBean jsonBean = gson.fromJson(s, JsonBean.class);
                list = jsonBean.getData();
                //适配器
                myAdapter = new MyAdapter(list,getActivity());
                pull_list.setAdapter(myAdapter);

            }else{
                Toast.makeText(getActivity(),"没有网络",Toast.LENGTH_SHORT).show();
            }
            query.close();
        }
    }

    @Override
    protected void bindEven() {

        pull_list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                if (HttpUtils.isNet(getActivity())){
                    HttpUtils.getHttp(sturl, new HttpUtils.CallBacko() {
                        @Override
                        public void getData(String s) {
                            Gson gson = new Gson();
                            JsonBean jsonBean = gson.fromJson(s, JsonBean.class);
                            list = jsonBean.getData();
                            //适配器
                            myAdapter = new MyAdapter(list,getActivity());
                            pull_list.setAdapter(myAdapter);
                            pull_list.onRefreshComplete();
                        }
                    });

                }else{
                    Toast.makeText(getActivity(),"没有网络",Toast.LENGTH_SHORT).show();
                    pull_list.onRefreshComplete();
                }
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                if (HttpUtils.isNet(getActivity())){
                    HttpUtils.getHttp(sturl, new HttpUtils.CallBacko() {
                        @Override
                        public void getData(String s) {
                            Gson gson = new Gson();
                            JsonBean jsonBean = gson.fromJson(s, JsonBean.class);
                            ArrayList<Nxao> data = jsonBean.getData();
                            list.addAll(data);
                            myAdapter.notifyDataSetChanged();
                            pull_list.onRefreshComplete();
                        }
                    });

                }else{
                    Toast.makeText(getActivity(),"没有网络",Toast.LENGTH_SHORT).show();
                    pull_list.onRefreshComplete();
                }
            }
        });
    }
}
