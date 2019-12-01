package com.laoxu.simplecontractmvpframework.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.laoxu.simplecontractmvpframework.app.App;

import java.util.HashMap;
import java.util.Map;

public class VolleyUtils {

    private static VolleyUtils instance;
    private RequestQueue requestQueue;
    private  VolleyUtils(){
        requestQueue = Volley.newRequestQueue(App.getContext());

    }

    /**
     * 创建单例，双重校验锁
     * @param context
     * @return
     */
    public static VolleyUtils getInstance(){
        if (instance==null){
            synchronized (VolleyUtils.class){
                if (instance==null){
                    instance = new VolleyUtils();
                }
            }
        }
        return instance;
    }

    /**
     * get请求封装
     * @param url
     */
    public  void getData(String url, final NetCallback netCallback){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                netCallback.success(response);
                System.out.println("response:"+response);

                System.out.println("thread1=="+Thread.currentThread().getName());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                netCallback.failuree(error);
                System.out.println("thread2=="+Thread.currentThread().getName()+error);
            }
        });

        requestQueue.add(stringRequest);
    }

    public  void postData(String url,NetCallback netCallback){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


    public void showImg(String url,NetCallback netCallback){

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

            }
        }, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
