package com.gll.gllandroidstudy.model;

/**
 * Created by : Z_B on 2018/1/23.
 */

public class NoticeMessage {

    public String messageTitle;
    public String messageUrl;
    public boolean isFired;

    public NoticeMessage(String messageTitle, String messageUrl) {
        this.messageTitle = messageTitle;
        this.messageUrl = messageUrl;
    }

    public NoticeMessage(String messageTitle, String messageUrl, boolean isFired) {
        this.messageTitle = messageTitle;
        this.messageUrl = messageUrl;
        this.isFired = isFired;
    }
}
