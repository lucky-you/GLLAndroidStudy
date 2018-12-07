package com.gll.gllandroidstudy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.gll.gllandroidstudy.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2018/12/7
 * function  :
 */
public class NineGridViewImageAdapter extends BaseAdapter {


    private List<String> imageList;
    private Context mContext;

    public NineGridViewImageAdapter(List<String> imageList, Context mContext) {
        this.imageList = imageList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public String getItem(int position) {
        return imageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.include_nine_image_item_view, null);
            viewHolder.roundedImageView = convertView.findViewById(R.id.rivImageView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(imageList.get(position)).into(viewHolder.roundedImageView);
        return convertView;
    }


    public class ViewHolder {

        RoundedImageView roundedImageView;

    }
}
