package com.gll.gllandroidstudy.find;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.RecyclerViewList;
import com.gll.gllandroidstudy.section.StatelessSection;
import com.gll.gllandroidstudy.section.ViewHolder;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

/**
 * author      : Z_B
 * date       : 2019/5/29
 * function  : 列表栏目
 */
public class SectionMessageList extends StatelessSection<RecyclerViewList> {
    private List<RecyclerViewList> recyclerViewLists;


    public SectionMessageList(int headerResourceId, int itemResourceId, List<RecyclerViewList> data) {
        super(headerResourceId, itemResourceId, data);
        this.recyclerViewLists = data;
    }

    public SectionMessageList(int headerResourceId, int footerResourceId, int itemResourceId, List<RecyclerViewList> data) {
        super(headerResourceId, footerResourceId, itemResourceId, data);
        this.recyclerViewLists = data;
    }

    @Override
    public void convert(ViewHolder holder, RecyclerViewList recyclerViewList, int position) {
        holder.setText(R.id.tvMessageTitle, recyclerViewList.getTitle())
                .setText(R.id.tvMessageContent, recyclerViewList.getContent())
                .getView(R.id.item).setBackgroundResource(R.drawable.ic_bottom_lines);
        Glide.with(mContext)
                .load(recyclerViewList.getImageUrl())
                .apply(bitmapTransform(new RoundedCornersTransformation(6, 0)))
                .into((ImageView) holder.getView(R.id.ivMessageUrl));
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        holder
                .setText(R.id.headTitle, "分类列表")
                .setVisible(R.id.headMore, false);
        holder.itemView.setBackgroundResource(R.drawable.section_serial_gradient);
    }
}
