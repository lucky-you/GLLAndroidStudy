package com.gll.gllandroidstudy.Index;

/**
 * Created by : Z_B on 2019/7/12.
 * describe：
 */
public class CityItemMessage extends SortModel {
    /**
     * id : 1
     * pid : 0
     * title : 北京
     */

    private String id;
    private String title;


    public CityItemMessage() {
    }

    public CityItemMessage(String id, String title) {
        this.id = id;
        this.title = title;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
