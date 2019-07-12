package com.gll.gllandroidstudy.Index;

import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Object> setSourceDateList(List<CityItemMessage> SourceDate) {
        List<CityItemMessage> cityItemList = new ArrayList<>();
//        Collections.sort(SourceDate, pinyinComparator);
        for (CityItemMessage cityItem : SourceDate) {
            String pinyin = characterParser.getSelling(cityItem.getName());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                cityItem.setFirstWord(sortString.toUpperCase());
            } else {
                cityItem.setFirstWord("#");
            }
            Log.e("xy", "name=" + cityItem.getName() + "<-->FirstWord=" + cityItem.getFirstWord());
            cityItemList.add(cityItem);
        }

        HashMap<String, List<CityItemMessage>> map = new HashMap<>();
        for (CityItemMessage item : cityItemList) {
            String firstWord;
            if (TextUtils.isEmpty(item.getFirstWord())) {
                firstWord = "#";
            } else {
                firstWord = item.getFirstWord().toUpperCase();
            }
            if (map.containsKey(firstWord)) {
                map.get(firstWord).add(item);
            } else {
                List<CityItemMessage> mList = new ArrayList<>();
                mList.add(item);
                map.put(firstWord, mList);
            }
        }
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        List<CityItemMessage> sortList = new ArrayList<>();
        for (Object key : keys) {
            CityItemMessage item = getIndexItem(key.toString());
            sortList.add(item);
            sortList.addAll(map.get(key.toString()));
        }
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("sortList", sortList);
        resultMap.put("keys", keys);
        return resultMap;
    }

    private CityItemMessage getIndexItem(String firstWord) {
        CityItemMessage entity = new CityItemMessage();
        entity.setFirstWord(firstWord);
        entity.setIndex(true);
        return entity;
    }
}
