package com.gll.gllandroidstudy.Index;

/**
 * Created by : Z_B on 2019/7/12.
 * describe： 基础的字段
 */
public class SortBaseModel {
    public String name;
    public String sortLetters;

    public SortBaseModel() {
    }

    public SortBaseModel(String name, String sortLetters) {
        this.name = name;
        this.sortLetters = sortLetters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortLetters() {
        return sortLetters;
    }

    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }

    @Override
    public String toString() {
        return "SortBaseModel{" +
                "name='" + name + '\'' +
                ", sortLetters='" + sortLetters + '\'' +
                '}';
    }
}
