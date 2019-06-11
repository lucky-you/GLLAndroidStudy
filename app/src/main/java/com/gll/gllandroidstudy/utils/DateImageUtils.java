package com.gll.gllandroidstudy.utils;

import com.gll.gllandroidstudy.model.NineImageList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author      : Z_B
 * date       : 2019/6/11
 * function  :
 */
public class DateImageUtils {


    public static List<String> imageData(int count) {
        List<String> listTotalImage = Arrays.asList(ConstantValue.imageThumbUrls);
        List<String> imageList = listTotalImage.subList(0, count);
        return imageList;
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

}
