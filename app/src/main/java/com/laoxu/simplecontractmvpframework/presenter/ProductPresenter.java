package com.laoxu.simplecontractmvpframework.presenter;

import com.laoxu.simplecontractmvpframework.base.BasePresenter;
import com.laoxu.simplecontractmvpframework.contract.IProductContract;
import com.laoxu.simplecontractmvpframework.model.ProductModel;
import com.laoxu.simplecontractmvpframework.model.entity.ProductEntity;

import java.util.Map;

public class ProductPresenter extends BasePresenter<ProductModel,IProductContract.IView> implements IProductContract.IPresenter {
    @Override
    public void getProducts(Map<String, Object> paramsMap) {

        mModel.getProducts(paramsMap, new IProductContract.IModel.IModelCallback() {
            @Override
            public void onProductSuccess(ProductEntity productEntity) {

                getView().onProductSuccess(productEntity);

            }

            @Override
            public void onProductFailure(Throwable e) {

                getView().onProductFailure(e);
            }
        });
    }

    @Override
    protected ProductModel initModel() {
        return new ProductModel();
    }
}
