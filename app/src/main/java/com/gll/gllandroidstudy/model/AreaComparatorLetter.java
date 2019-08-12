package com.gll.gllandroidstudy.model;

import java.util.Comparator;

/**
 * Created by : Z_B on 2019/8/12.
 * describe：全国所有城市排序
 */
public class AreaComparatorLetter implements Comparator<AllAreaList> {
    @Override
    public int compare(AllAreaList o1, AllAreaList o2) {
        if (o1 == null || o2 == null) {
            return 0;
        }
        String lhsSortLetters = o1.pys.substring(0, 1).toUpperCase();
        String rhsSortLetters = o2.pys.substring(0, 1).toUpperCase();
        if (lhsSortLetters == null || rhsSortLetters == null) {
            return 0;
        }
        return lhsSortLetters.compareTo(rhsSortLetters);
    }
}
