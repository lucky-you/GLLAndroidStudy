package com.gll.gllandroidstudy.find;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.ColumnList;
import com.gll.gllandroidstudy.section.StatelessSection;
import com.gll.gllandroidstudy.section.ViewHolder;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

/**
 * author      : Z_B
 * date       : 2019/5/29
 * function  : 名师推荐栏目
 */
public class SectionColumnList extends StatelessSection<ColumnList> {

    private List<ColumnList> columnLists;

    public SectionColumnList(int headerResourceId, int itemResourceId, List<ColumnList> data) {
        super(headerResourceId, itemResourceId, data);
        this.columnLists = data;
    }

    @Override
    public void convert(ViewHolder holder, ColumnList columnList, int position) {
        holder.setText(R.id.special_title, columnList.title)
                .setText(R.id.special_teacherName, columnList.teacherName)
                .setText(R.id.special_teacherTag, columnList.teacherTag)
                .setText(R.id.special_content, columnList.introduction)
                .getView(R.id.item).setBackgroundResource(R.drawable.ic_bottom_lines);

        Glide.with(mContext)
                .load(columnList.userImage)
                .apply(bitmapTransform(new RoundedCornersTransformation(6, 0)))
                .into((ImageView) holder.getView(R.id.special_imgView));
    }


    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        holder.setText(R.id.headTitle, "名师推荐")
                .setVisible(R.id.headMore, true);
    }
}
