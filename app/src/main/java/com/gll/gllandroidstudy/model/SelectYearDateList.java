package com.gll.gllandroidstudy.model;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2018/11/27
 * function  :
 */
public class SelectYearDateList {


    private String yearList;
    private List<YearAndMouthBean> yearAndMouthBeans;

    public SelectYearDateList(String yearList, List<YearAndMouthBean> yearAndMouthBeans) {
        this.yearList = yearList;
        this.yearAndMouthBeans = yearAndMouthBeans;
    }

    public String getYearList() {
        return yearList;
    }

    public void setYearList(String yearList) {
        this.yearList = yearList;
    }

    public List<YearAndMouthBean> getYearAndMouthBeans() {
        return yearAndMouthBeans;
    }

    public void setYearAndMouthBeans(List<YearAndMouthBean> yearAndMouthBeans) {
        this.yearAndMouthBeans = yearAndMouthBeans;
    }
}
