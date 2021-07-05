package com.gll.gllandroidstudy.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author      : Z_B
 * date       : 2019/2/15
 * function  :
 */
@Entity
public class GoodMessage {

    @Id(autoincrement = true)
    private Long id;
    private String goodName;
    private String goodNumber;

    @Generated(hash = 1853866406)
    public GoodMessage(Long id, String goodName, String goodNumber) {
        this.id = id;
        this.goodName = goodName;
        this.goodNumber = goodNumber;
    }

    @Generated(hash = 1059673566)
    public GoodMessage() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodName() {
        return this.goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodNumber() {
        return this.goodNumber;
    }

    public void setGoodNumber(String goodNumber) {
        this.goodNumber = goodNumber;
    }

    @Override
    public String toString() {
        return "GoodMessage{" +
                "id=" + id +
                ", goodName='" + goodName + '\'' +
                ", goodNumber='" + goodNumber + '\'' +
                '}';
    }
}
