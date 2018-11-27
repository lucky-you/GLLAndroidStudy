package com.gll.gllandroidstudy.model;

/**
 * author      : Z_B
 * date       : 2018/11/27
 * function  :
 */
public class YearAndMouthBean {

    private String yearLeft;
    private String yearRight;

    public YearAndMouthBean(String yearLeft, String yearRight) {
        this.yearLeft = yearLeft;
        this.yearRight = yearRight;
    }

    public String getYearLeft() {
        return yearLeft;
    }

    public void setYearLeft(String yearLeft) {
        this.yearLeft = yearLeft;
    }

    public String getYearRight() {
        return yearRight;
    }

    public void setYearRight(String yearRight) {
        this.yearRight = yearRight;
    }
}
