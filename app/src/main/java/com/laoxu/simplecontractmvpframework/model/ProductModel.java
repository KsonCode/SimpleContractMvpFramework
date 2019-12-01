package com.laoxu.simplecontractmvpframework.model;

import com.google.gson.Gson;
import com.laoxu.simplecontractmvpframework.contract.IProductContract;
import com.laoxu.simplecontractmvpframework.model.api.Api;
import com.laoxu.simplecontractmvpframework.model.entity.ProductEntity;
import com.laoxu.simplecontractmvpframework.utils.NetCallback;
import com.laoxu.simplecontractmvpframework.utils.VolleyUtils;

import java.util.Map;

public class ProductModel implements IProductContract.IModel {
    @Override
    public void getProducts(Map<String, Object> paramsMap, final IModelCallback callback) {

        String url  = Api.PRODUCTS_URL+"?";
        for (Map.Entry<String, Object> stringObjectEntry : paramsMap.entrySet()) {
            url +=stringObjectEntry.getKey()+"="+stringObjectEntry.getValue()+"&";
        }

        System.out.println("url===="+url);
        VolleyUtils.getInstance().getData(url, new NetCallback() {
            @Override
            public void success(String result) {
                callback.onProductSuccess(new Gson().fromJson(result, ProductEntity.class));
            }

            @Override
            public void failuree(Throwable error) {

                callback.onProductFailure(error);
            }
        });

    }
}
