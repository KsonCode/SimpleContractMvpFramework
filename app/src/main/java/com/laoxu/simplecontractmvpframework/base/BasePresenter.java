package com.laoxu.simplecontractmvpframework.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M ,V extends IBaseView> {


    protected   M mModel;
    private WeakReference<V> mWeakReference;

    public BasePresenter(){

        mModel = initModel();
    }

    /**
     * 初始化model数据模型类
     */
    protected abstract M initModel();

    /**
     * 绑定View
     */
    protected void attachView(V v) {
        mWeakReference = new WeakReference<>(v);
    }

    /**
     * 解绑View
     */
    protected void detachView() {
        if (mWeakReference != null) {
            mWeakReference.clear();
            mWeakReference = null;
        }
    }

    /**
     * 判断view是否挂载
     * <p>
     * 防止出现 presenter 层 view 调用空指针
     * 每次调用业务请求的时候都要先调用方法检查是否与 View 绑定
     * 只有返回ture才进行回调
     */
    protected boolean isViewAttached() {
        if (mWeakReference == null || mWeakReference.get() == null) {
            return false;
        }
        return true;
    }

    /**
     * 获取view接口
     * <p>
     * 每只有 isViewAttached 返回ture的时候，才能调用他
     */
    protected V getView() {
        return mWeakReference.get();
    }
}
