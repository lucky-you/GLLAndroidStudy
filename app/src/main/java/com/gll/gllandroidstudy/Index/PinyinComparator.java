package com.gll.gllandroidstudy.Index;

import java.util.Comparator;

/**
 * Created by : Z_B on 2019/7/31.
 * describe：
 */
public class PinyinComparator implements Comparator<SortModel> {
    public PinyinComparator() {
    }

    public int compare(SortModel o1, SortModel o2) {
        if (!o1.getSortLetters().equals("@") && !o2.getSortLetters().equals("#")) {
            return !o1.getSortLetters().equals("#") && !o2.getSortLetters().equals("@") ? o1.getSortLetters().compareTo(o2.getSortLetters()) : 1;
        } else {
            return -1;
        }
    }
}
