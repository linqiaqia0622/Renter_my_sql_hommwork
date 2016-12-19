package com.qiaqia.renter.entity;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 洽洽 on 2016/12/16.
 */

public class Renter extends DataSupport {
 
    private int id;
    //租户id
    @Column(unique = true)
    private int renter_id;
    //价格
    @Column(nullable =false)
    private int price;
    //房间数
    @Column(defaultValue = "0")
    
    private int room_count;
    //租户名字
    @Column(nullable =false)
    private String name;
    //头像 图片号
    @Column(nullable =false)
    private int  picture_id;
    //地区 默认广州
    @Column(defaultValue = "广州")
    private String  district;

    private List<Progress> ps;
    private List<Contract> cs;

    public Renter() {
    }

    public Renter(String name) {
    
        this.name = name;
    }

    @Override
    public String toString() {
        return "Renter{" +
                "id=" + id +
             
                ", price=" + price +
                ", room_count=" + room_count +
                ", name='" + name + '\'' +
                ", picture_id=" + picture_id +
                ", district='" + district + '\'' +
                ", ps=" + ps +
                ", cs=" + cs +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRenter_id() {
        return renter_id;
    }

    public void setRenter_id(int renter_id) {
        this.renter_id = renter_id;
    }

    public int getRoom_count() {
        return room_count;
    }

    public void setRoom_count(int room_count) {
        this.room_count = room_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(int picture_id) {
        this.picture_id = picture_id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<Progress> getPs() {
        return ps;
    }

    public void setPs(List<Progress> ps) {
        this.ps = ps;
    }

    public List<Contract> getCs() {
        return cs;
    }

    public void setCs(List<Contract> cs) {
        this.cs = cs;
    }
}
