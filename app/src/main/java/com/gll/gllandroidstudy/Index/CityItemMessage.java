package com.gll.gllandroidstudy.Index;

/**
 * Created by : Z_B on 2019/7/12.
 * describe：
 */
public class CityItemMessage {
    /**
     * id : 1
     * pid : 0
     * title : 北京
     */

    private String id;
    private String pid;
    private String name;
    private String firstWord;
    private boolean isIndex;


    public CityItemMessage(  ) {
    }
    public CityItemMessage(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityItemMessage(String id, String name, String firstWord) {
        this.id = id;
        this.name = name;
        this.firstWord = firstWord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public boolean isIndex() {
        return isIndex;
    }

    public void setIndex(boolean index) {
        isIndex = index;
    }
}
