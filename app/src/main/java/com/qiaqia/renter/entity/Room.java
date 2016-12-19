package com.qiaqia.renter.entity;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 洽洽 on 2016/12/16.
 */

public class Room extends DataSupport {
    private int id;
    //价格
    @Column(nullable = false)
    private int price;
    //底价
    @Column(defaultValue = "0")
    private int floor_p;
    //交易状态：0=正常；1=已成交；2=以作废；3=暂放
    @Column(defaultValue = "0")
    private int state;
    //面积
    @Column(nullable = false)
    private int area;
    //区域 默认广州
    @Column(defaultValue ="广州")
    private String district;
   //房间数
    @Column(nullable = false)
    private int room_count;
   //房主id
    @Column(nullable = false)
    private int owner_id;
   //房号 
    @Column(nullable = false,unique = true)
    private int room_id;
    //图片号
    @Column(defaultValue ="0")
    private int picture_id;
    private List<Progress> ps;
    private List<Contract> cs;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", price=" + price +
                ", floor_p=" + floor_p +
                ", state=" + state +
                ", area=" + area +
                ", district='" + district + '\'' +
                ", room_count=" + room_count +
                ", owner_id=" + owner_id +
                ", room_id=" + room_id +
                ", picture_id=" + picture_id +
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

    public int getFloor_p() {
        return floor_p;
    }

    public void setFloor_p(int floor_p) {
        this.floor_p = floor_p;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getRoom_count() {
        return room_count;
    }

    public void setRoom_count(int room_count) {
        this.room_count = room_count;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(int picture_id) {
        this.picture_id = picture_id;
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

    public Room(int room_id) {
    
        this.room_id = room_id;
    }
}
