package com.bawei.myapplxi01;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/2/28 16:30
 * @Description：描述信息
 */
public class HttpUtils {


    //封装 接口回调
    public static void getHttp(String url, final CallBacko backo){

        new AsyncTask<String,Void,String>(){

            @Override
            protected String doInBackground(String... strings) {
                return HttpUtils.eqStr(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                backo.getData(s);
            }
        }.execute(url);
    }
    public interface CallBacko{
        void getData(String s);
    }

    //GET请求数据
    public static String eqStr(String string){
        try {
            URL u = new URL(string);
            HttpURLConnection con = (HttpURLConnection) u.openConnection();
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setRequestMethod("GET");
            if (con.getResponseCode()==200){
                InputStream stream = con.getInputStream();
                InputStreamReader in = new InputStreamReader(stream, "utf-8");
                BufferedReader res = new BufferedReader(in);
                StringBuilder builder = new StringBuilder();
                String str ="";
                while ((str=res.readLine())!=null){
                    builder.append(str);
                }
                return builder.toString();


            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    //判断网络
    public static boolean isNet(Context context) {

        if (context!=null){
            ConnectivityManager comm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = comm.getActiveNetworkInfo();

        if (info!=null){
            return info.isAvailable();
        }
        }
        return false;
    }
}
