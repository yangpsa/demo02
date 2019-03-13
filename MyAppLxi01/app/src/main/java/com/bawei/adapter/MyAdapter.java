package com.bawei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.bean.Nxao;
import com.bawei.myapplxi01.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/2/28 16:56
 * @Description：描述信息
 */
public class MyAdapter extends BaseAdapter {

    private ArrayList<Nxao> list;
    private Context context;

    public MyAdapter(ArrayList<Nxao> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        switch (type){
            case 0:
                ViewHolder1 holder1;
                if (convertView==null){
                    holder1=new ViewHolder1();
                    convertView = View.inflate(context, R.layout.layout01,null);
                    holder1.img_v1=convertView.findViewById(R.id.img_v1);
                    holder1.text1 =convertView.findViewById(R.id.text1);
                    convertView.setTag(holder1);
                }else{
                    holder1= (ViewHolder1) convertView.getTag();
                }
                holder1.text1.setText(list.get(position).getAuthor_name());
                Glide.with(context).load(list.get(position).getBook_cover()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder1.img_v1);
                break;
            case 1:
                ViewHolder2 holder2;
                if (convertView==null){
                    holder2=new ViewHolder2();
                    convertView = View.inflate(context, R.layout.layout02,null);
                    holder2.img_v1=convertView.findViewById(R.id.img_v1);
                    holder2.text1 =convertView.findViewById(R.id.text1);
                    convertView.setTag(holder2);
                }else{
                    holder2= (ViewHolder2) convertView.getTag();
                }
                holder2.text1.setText(list.get(position).getAuthor_name());
                Glide.with(context).load(list.get(position).getBook_cover()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder2.img_v1);
                break;
            case 2:
                ViewHolder3 holder3;
                if (convertView==null){
                    holder3=new ViewHolder3();
                    convertView = View.inflate(context, R.layout.layout03,null);
                    holder3.img_v1=convertView.findViewById(R.id.img_v1);
                    holder3.text1 =convertView.findViewById(R.id.text1);
                    convertView.setTag(holder3);
                }else{
                    holder3= (ViewHolder3) convertView.getTag();
                }
                holder3.text1.setText(list.get(position).getAuthor_name());
                Glide.with(context).load(list.get(position).getBook_cover()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder3.img_v1);
                break;
        }

        return convertView;
    }

    class ViewHolder1{
        private ImageView img_v1;
        private TextView text1;
    }

    class ViewHolder2{
        private ImageView img_v1;
        private TextView text1;
    }

    class ViewHolder3{
        private ImageView img_v1;
        private TextView text1;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        return position%3;
    }
}
