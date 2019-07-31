package com.gll.gllandroidstudy.Index;

/**
 * Created by : Z_B on 2019/7/31.
 * describe：
 */
public class SortModel {
    public String name;
    public String sortLetters;

    public SortModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortLetters() {
        return this.sortLetters;
    }

    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }

    public String toString() {
        return "SortModel{name='" + this.name + '\'' + ", sortLetters='" + this.sortLetters + '\'' + '}';
    }
}
