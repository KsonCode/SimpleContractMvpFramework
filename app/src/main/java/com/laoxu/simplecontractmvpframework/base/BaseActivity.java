package com.laoxu.simplecontractmvpframework.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.NetworkUtils;

import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView{

    public P mPresenter;

    private Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initView();
        initData();


    }

    /**
     * 初始化p层对象
     * @return
     */
    protected abstract P initPresenter();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 绑定根布局
     * @return
     */
    protected abstract int bindLayoutId();


    /**
     * 是否联网
     * @return
     */
    public boolean isNet(){
        //androidutilcode工具类
        return NetworkUtils.isConnected();
    }

    /**
     * toast提示
     * @param msg
     */
    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }


    /**
     * 释放资源
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind();
        }

        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
