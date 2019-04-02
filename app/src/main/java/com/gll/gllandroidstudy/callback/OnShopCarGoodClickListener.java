package com.gll.gllandroidstudy.callback;

import com.gll.gllandroidstudy.model.GoodMessageList;

/**
 * Created by: Z_B on 2019/4/1.
 * Function: 购物车商品的回调
 */
public interface OnShopCarGoodClickListener {




    /**
     * 是否全选
     *
     * @param isAllSelect true  or false
     * @param totalPrice  选中商品的总金额
     */
    void isAllSelect(boolean isAllSelect, String totalPrice);


    /**
     * 商品数量的操作
     *
     * @param goodMessage 商品的数据
     * @param changeType  类型 增加 or 减少
     * @param goodNumber  数量
     */
    void changeTheNumberOfGood(GoodMessageList goodMessage, int changeType, int goodNumber);


}
