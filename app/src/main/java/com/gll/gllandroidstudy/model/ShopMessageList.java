package com.gll.gllandroidstudy.model;

import java.util.List;

/**
 * Created by: Z_B on 2019/4/1.
 * Function: 店铺的信息
 */
public class ShopMessageList {
    private int shopID;
    private String shopName;
    private String shopContent;
    private List<GoodMessageList> goodList;
    private boolean  isShopSelect;


    public ShopMessageList(String shopName, List<GoodMessageList> goodList) {
        this.shopName = shopName;
        this.goodList = goodList;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopContent() {
        return shopContent;
    }

    public void setShopContent(String shopContent) {
        this.shopContent = shopContent;
    }

    public List<GoodMessageList> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<GoodMessageList> goodList) {
        this.goodList = goodList;
    }

    public boolean isShopSelect() {
        return isShopSelect;
    }

    public void setShopSelect(boolean shopSelect) {
        isShopSelect = shopSelect;
    }
}
