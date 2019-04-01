package com.gll.gllandroidstudy.model;

import java.security.PrivateKey;

/**
 * Created by: Z_B on 2019/4/1.
 * Function: 商品的信息
 */
public class GoodMessageList {
    private int goodID;
    private String goodUrl;
    private String goodName;
    private int goodNumber;
    private int goodPrice;
    private boolean isGoodSelect;

    public GoodMessageList(String goodUrl, String goodName, int goodNumber, int goodPrice) {
        this.goodUrl = goodUrl;
        this.goodName = goodName;
        this.goodNumber = goodNumber;
        this.goodPrice = goodPrice;
    }

    public int getGoodID() {
        return goodID;
    }

    public void setGoodID(int goodID) {
        this.goodID = goodID;
    }

    public String getGoodUrl() {
        return goodUrl;
    }

    public void setGoodUrl(String goodUrl) {
        this.goodUrl = goodUrl;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(int goodNumber) {
        this.goodNumber = goodNumber;
    }

    public int getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(int goodPrice) {
        this.goodPrice = goodPrice;
    }

    public boolean isGoodSelect() {
        return isGoodSelect;
    }

    public void setGoodSelect(boolean goodSelect) {
        isGoodSelect = goodSelect;
    }
}
