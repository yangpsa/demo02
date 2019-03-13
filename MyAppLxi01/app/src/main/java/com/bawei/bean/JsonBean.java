package com.bawei.bean;

import java.util.ArrayList;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/2/28 16:54
 * @Description：描述信息
 */
public class JsonBean {
    private ArrayList<Nxao> data;

    @Override
    public String toString() {
        return "JsonBean{" +
                "data=" + data +
                '}';
    }

    public ArrayList<Nxao> getData() {
        return data;
    }

    public void setData(ArrayList<Nxao> data) {
        this.data = data;
    }

    public JsonBean(ArrayList<Nxao> data) {
        this.data = data;
    }

    public JsonBean() {
    }
}
