package com.gll.gllandroidstudy.find;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.section.StatelessSection;
import com.gll.gllandroidstudy.section.ViewHolder;
import com.gll.gllandroidstudy.utils.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2019/5/29
 * function  : 顶部banner的添加
 */
public class SectionBanner extends StatelessSection<String> {
    private List<String> bannerUrlList;


    public SectionBanner(int headerResourceId, int itemResourceId, List<String> data) {
        super(headerResourceId, itemResourceId, data);
        this.bannerUrlList = data;
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        Banner banner = holder.itemView.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(bannerUrlList);
        //设置轮播时间
        banner.setDelayTime(5000);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

}
