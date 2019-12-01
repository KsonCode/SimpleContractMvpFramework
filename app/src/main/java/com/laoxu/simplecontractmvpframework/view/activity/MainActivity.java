package com.laoxu.simplecontractmvpframework.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.laoxu.simplecontractmvpframework.R;
import com.laoxu.simplecontractmvpframework.base.BaseActivity;
import com.laoxu.simplecontractmvpframework.contract.IProductContract;
import com.laoxu.simplecontractmvpframework.model.entity.ProductEntity;
import com.laoxu.simplecontractmvpframework.presenter.ProductPresenter;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity<ProductPresenter> implements IProductContract.IView {



    @Override
    protected ProductPresenter initPresenter() {
        return new ProductPresenter();
    }

    @Override
    protected void initData() {

        Map<String,Object> params = new HashMap<>();
        params.put("keyword","1");
        params.put("page","1");
        params.put("count","5");

        mPresenter.getProducts(params);


    }

    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onProductSuccess(ProductEntity productEntity) {

        showToast(productEntity.message);
    }

    @Override
    public void onProductFailure(Throwable e) {

    }
}
