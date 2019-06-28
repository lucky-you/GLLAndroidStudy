package com.gll.gllandroidstudy.utils;

import com.gll.gllandroidstudy.model.NineImageList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * author      : Z_B
 * date       : 2019/6/11
 * function  : 图片数据资源
 */
public class DateImageUtils {


    public static List<String> imageData(int count) {
        List<String> listTotalImage = Arrays.asList(ConstantValue.imageThumbUrls);
        List<String> imageList = listTotalImage.subList(0, count);
        return imageList;
    }

    public static String getImageUrl() {
        List<String> listTotalImage = Arrays.asList(ConstantValue.imageThumbUrls);
        Random random = new Random();
        int position = random.nextInt(listTotalImage.size());
        return listTotalImage.get(position);
    }

    public static List<NineImageList> getNineImageList() {
        List<NineImageList> nineImageLists = new ArrayList<>();
        nineImageLists.add(new NineImageList("开水白菜", imageData(1)));
        nineImageLists.add(new NineImageList("百岁山", imageData(3)));
        nineImageLists.add(new NineImageList("百岁山", imageData(6)));
        nineImageLists.add(new NineImageList("农夫山泉", imageData(7)));
        nineImageLists.add(new NineImageList("娃哈哈", imageData(9)));
        return nineImageLists;
    }


    public static String getVideoUrl() {
        return "https://flv2.bn.netease.com/videolib1/1811/26/OqJAZ893T/HD/OqJAZ893T-mobile.mp4";//汽车视频
    }


}
