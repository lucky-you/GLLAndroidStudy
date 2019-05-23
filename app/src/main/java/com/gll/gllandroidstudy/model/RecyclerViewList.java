package com.gll.gllandroidstudy.model;

/**
 * Created by: Z_B on  2018/9/10.
 * Function: RecyclerViewList
 */
public class RecyclerViewList {


    public int resId;
    public String title;
    public String content;

    public RecyclerViewList(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public RecyclerViewList(int resId, String title, String content) {
        this.resId = resId;
        this.title = title;
        this.content = content;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
