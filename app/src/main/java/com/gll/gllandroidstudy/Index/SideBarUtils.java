package com.gll.gllandroidstudy.Index;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by : Z_B on 2019/7/31.
 * describe：
 */
public class SideBarUtils {
    public SideBarUtils() {
    }

    public static List<SortModel> filledData(String[] date) {
        CharacterParser characterParser = CharacterParser.getInstance();
        List<SortModel> mSortList = new ArrayList();
        for (int i = 0; i < date.length; ++i) {
            SortModel sortModel = new SortModel();
            sortModel.setName(date[i]);
            String pinyin = characterParser.getSelling(date[i]);
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
            } else {
                sortModel.setSortLetters("#");
            }
            mSortList.add(sortModel);
        }
        return mSortList;
    }

    public static void filledData(List<? extends SortModel> date) {
        CharacterParser characterParser = CharacterParser.getInstance();
        int i = 0;
        for (int length = date.size(); i < length; ++i) {
            SortModel sortModel = (SortModel) date.get(i);
            String pinyin = characterParser.getSelling(String.valueOf(date.get(i)));
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
            } else {
                sortModel.setSortLetters("#");
            }
        }

    }

    private void filterData(String filterStr, List<SortModel> SourceDateList) {
        List<SortModel> filterDateList = new ArrayList();
        CharacterParser characterParser = CharacterParser.getInstance();
        if (!TextUtils.isEmpty(filterStr)) {
            filterDateList.clear();
            Iterator var5 = SourceDateList.iterator();
            while (true) {
                SortModel sortModel;
                String name;
                do {
                    if (!var5.hasNext()) {
                        return;
                    }
                    sortModel = (SortModel) var5.next();
                    name = sortModel.getName();
                }
                while (name.indexOf(filterStr.toString()) == -1 && !characterParser.getSelling(name).startsWith(filterStr.toString()));

                filterDateList.add(sortModel);
            }
        }
    }
}
