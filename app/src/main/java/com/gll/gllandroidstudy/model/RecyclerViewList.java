package com.gll.gllandroidstudy.model;

/**
 * Created by: Z_B on  2018/9/10.
 * Function: RecyclerViewList
 */
public class RecyclerViewList {


    public String imageUrl;
    public String title;
    public String content;

    public RecyclerViewList(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public RecyclerViewList(String imageUrl, String title, String content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
