package com.laoxu.simplecontractmvpframework.model.entity;

import java.util.List;

/**
 * 商品列表实体类
 */
public class ProductEntity {

    public String message;
    public String status;


    public List<Product> result;
    public static class Product{
        public String commodityId;
        public String commodityName;
        public String masterPic;
        public String price;
        public String saleNum;
    }




}
