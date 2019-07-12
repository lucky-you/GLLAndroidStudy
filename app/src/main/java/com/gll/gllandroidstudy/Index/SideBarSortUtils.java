package com.gll.gllandroidstudy.Index;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by : Z_B on 2019/7/12.
 * describe：
 */
public class SideBarSortUtils {


    /**
     * 拼音排序的比较器
     */
    private PinyinComparator pinyinComparator = new PinyinComparator();
    /**
     * 实例化汉字转拼音类
     */
    private CharacterParser characterParser = CharacterParser.getInstance();

    public SideBarSortUtils() {

    }

//    public void setSourceDateList(List<CityItemMessage> SourceDate) {
//        setNewDataList(SourceDate);
//    }

    public List<CityItemMessage> setSourceDateList(List<CityItemMessage> SourceDate) {
        List<CityItemMessage> cityItemList = new ArrayList<>();
        CharacterParser characterParser = CharacterParser.getInstance();
        for (CityItemMessage cityItem : SourceDate) {
            String pinyin = characterParser.getSelling(cityItem.getName());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                cityItem.setFirstWord(sortString.toUpperCase());
            } else {
                cityItem.setFirstWord("#");
            }
            Log.e("xy", "name=" + cityItem.getName() + "<-->FirstWord=" + cityItem.getFirstWord());
            cityItemList.add(new CityItemMessage("101", cityItem.getName(), cityItem.getFirstWord()));
        }
        return cityItemList;

    }


}
