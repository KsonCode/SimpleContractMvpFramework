package com.laoxu.simplecontractmvpframework.contract;

import com.laoxu.simplecontractmvpframework.base.IBaseView;
import com.laoxu.simplecontractmvpframework.model.entity.ProductEntity;

import java.util.Map;

/**
 * 商品列表mvp统一管理类
 */
public interface IProductContract {
    /**
     * view层  命名必须是IView
     */
    interface IView extends IBaseView {
        void onProductSuccess(ProductEntity productEntity);

        void onProductFailure(Throwable e);
    }

    /**
     * presenter层   命名必须是IPresenter
     */
    interface IPresenter {
        void getProducts(Map<String, Object> paramsMap);
    }

    /**
     * model层   命名必须是IModel
     */
    interface IModel {
        void getProducts(Map<String, Object> paramsMap, IModelCallback callback);

        /**
         * model层中的接口回调
         */
        interface IModelCallback {
            void onProductSuccess(ProductEntity productEntity);

            void onProductFailure(Throwable e);
        }
    }
}
