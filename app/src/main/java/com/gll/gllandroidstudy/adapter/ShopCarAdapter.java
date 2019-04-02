package com.gll.gllandroidstudy.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.callback.OnShopCarGoodClickListener;
import com.gll.gllandroidstudy.model.GoodMessageList;
import com.gll.gllandroidstudy.model.ShopMessageList;
import com.gll.gllandroidstudy.widget.DivideLineItemDecoration;

import java.util.List;

/**
 * Created by: Z_B on 2019/4/1.
 * Function: 购物车的adapter
 */
public class ShopCarAdapter extends BaseQuickAdapter<ShopMessageList, BaseViewHolder> {

    public static final int GOOD_NUMBER_INCREASE_TYPE = 1; //增加
    public static final int GOOD_NUMBER_REDUCE_TYPE = 2;//减少
    public static final int GOOD_ITEM_CLICK_TYPE = 3;//商品的监听


    private OnShopCarGoodClickListener onShopCarGoodClickListener;

    public ShopCarAdapter(@Nullable List<ShopMessageList> data) {
        super(R.layout.include_shaop_car_item_view, data);
    }

    public void setOnShopCarGoodClickListener(OnShopCarGoodClickListener onShopCarGoodClickListener) {
        this.onShopCarGoodClickListener = onShopCarGoodClickListener;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final ShopMessageList item) {
        helper.setText(R.id.tvShopName, item.getShopName())
                .setImageResource(R.id.ivShopSelect, item.isShopSelect() ? R.drawable.ic_red_choice : R.drawable.ic_grey_choice)
                .getView(R.id.ivShopSelect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isShopSelect = !item.isShopSelect();
                item.setShopSelect(isShopSelect);
                for (GoodMessageList goodMessageList : item.getGoodList()) {
                    goodMessageList.setGoodSelect(isShopSelect);
                }
                //判断所有组是不是都选中了，都选中的话，通过接口告诉主界面的全选控件，并让其为选中状态的图片
                boolean isAllGroup = isAllGroupSelected(mData);
                if (onShopCarGoodClickListener != null) {
                    onShopCarGoodClickListener.isAllSelect(isAllGroup, getAllPrice());
                }
                notifyDataSetChanged();
            }
        });
        RecyclerView recyclerView = helper.getView(R.id.recyclerView);
        final ShopGoodListAdapter shopGoodListAdapter = new ShopGoodListAdapter(item.getGoodList());
        //判断item的分割线，处理刷新的时候分割线不断添加的问题
        if (recyclerView.getItemDecorationCount() > 0) {
            RecyclerView.ItemDecoration itemDecoration = recyclerView.getItemDecorationAt(0);
            if (itemDecoration == null) {
                recyclerView.addItemDecoration(new DivideLineItemDecoration(mContext, mContext.getResources().getColor(R.color.color_f3f3f3), 1));
            }
        } else {
            recyclerView.addItemDecoration(new DivideLineItemDecoration(mContext, mContext.getResources().getColor(R.color.color_f3f3f3), 1));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(shopGoodListAdapter);
        shopGoodListAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                GoodMessageList goodMessage = shopGoodListAdapter.getItem(position);
                if (onShopCarGoodClickListener != null) {
                    onShopCarGoodClickListener.changeTheNumberOfGood(goodMessage, GOOD_ITEM_CLICK_TYPE, 0);
                }
            }
        });
        shopGoodListAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                GoodMessageList goodMessage = shopGoodListAdapter.getItem(position);
                switch (view.getId()) {
                    case R.id.ivGoodSelect:
                        boolean isGoodSelect = !goodMessage.isGoodSelect();
                        shopGoodListAdapter.getItem(position).setGoodSelect(isGoodSelect);
                        boolean isSelectedGroup = isAllChildSelected(item.getGoodList());
                        mData.get(helper.getAdapterPosition()).setShopSelect(isSelectedGroup);
                        boolean isAllGroup = isAllGroupSelected(mData);
                        if (onShopCarGoodClickListener != null) {
                            onShopCarGoodClickListener.isAllSelect(isAllGroup, getAllPrice());
                        }
                        break;
                    case R.id.tvNumberReduce:
                        if (onShopCarGoodClickListener != null) {
                            onShopCarGoodClickListener.changeTheNumberOfGood(goodMessage, GOOD_NUMBER_REDUCE_TYPE, 1);
                        }
                        break;
                    case R.id.tvNumberAdd:
                        if (onShopCarGoodClickListener != null) {
                            onShopCarGoodClickListener.changeTheNumberOfGood(goodMessage, GOOD_NUMBER_INCREASE_TYPE, 1);
                        }
                        break;
                }
                notifyDataSetChanged();
            }
        });

    }

    /**
     * 所有组是不是都为选中状态，因为某一组选中的话，那么该组其下的所有子项也都选中了
     *
     * @param mLists 店铺的集合
     * @return true：所有组都选中，相当于全选
     */
    private boolean isAllGroupSelected(List<ShopMessageList> mLists) {
        for (int i = 0; i < mLists.size(); i++) {
            boolean isGroupSelected = mLists.get(i).isShopSelect();
            if (!isGroupSelected) {
                return false;
            }
        }
        return true;
    }

    /**
     * 组内所有的子项是否都选中
     *
     * @param childLists 商品的集合
     * @return true：表示某一组内所有的子项都选中
     */
    private boolean isAllChildSelected(List<GoodMessageList> childLists) {
        for (int i = 0; i < childLists.size(); i++) {
            boolean isChildSelected = childLists.get(i).isGoodSelect();
            if (!isChildSelected) {
                return false;
            }
        }
        return true;
    }

    /**
     * 设置全选/全不选
     */
    public void setAllShopSelect(boolean isSelect) {
        for (int i = 0; i < mData.size(); i++) {
            mData.get(i).setShopSelect(isSelect);
            for (GoodMessageList goodMessage : mData.get(i).getGoodList()) {
                goodMessage.setGoodSelect(isSelect);
            }
        }
        if (onShopCarGoodClickListener != null) {
            onShopCarGoodClickListener.isAllSelect(isSelect, getAllPrice());
        }
        notifyDataSetChanged();
    }

    /**
     * 获取总价
     */
    public String getAllPrice() {
        double totalPrice = 0;
        if (mData != null) {
            for (int i = 0; i < mData.size(); i++) {
                List<GoodMessageList> data = mData.get(i).getGoodList();
                for (int y = 0; y < data.size(); y++) {
                    if (data.get(y).isGoodSelect()) {
                        int Number = data.get(y).getGoodNumber();
                        int price = data.get(y).getGoodPrice();
                        totalPrice += (Number * price);
                    }
                }
            }
        }
        return String.valueOf(totalPrice);
    }

    /**
     * 获取需要删除的商品id
     *
     * @return 需要删除的商品的id字符串
     */
    public String getDeleteGoodID() {
        StringBuffer stringBuffer = new StringBuffer();
        if (mData != null) {
            for (int i = 0; i < mData.size(); i++) {
                List<GoodMessageList> goodList = mData.get(i).getGoodList();
                for (int y = 0; y < goodList.size(); y++) {
                    if (goodList.get(y).isGoodSelect()) {
                        stringBuffer.append(goodList.get(y).getGoodID());
                        if (y < goodList.size() - 1) {
                            stringBuffer.append(",");
                        }
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

}
