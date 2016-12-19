package com.qiaqia.renter.entity;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by 洽洽 on 2016/12/16.
 */

public class Contract extends DataSupport {
    private int id;
    //房间
    @Column(nullable = false)
    private Room room;
    //租户
    @Column(nullable = false)
    private Renter renter;
    //成交价
    @Column(nullable = false)
   
    private int price;
    //价格
     @Column(nullable = false)
   
    private int date;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Column(unique = true,nullable = false)
    private int cid;
    public Contract(Room room, Renter renter) {
        this.room = room;
        this.renter = renter;
    }
    public Contract() {
       
    }

    public Room getRoom() {
    
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
    public Contract(Room room, Renter renter, int id, int price, int date) {
    
        this.room = room;
        this.renter = renter;
        this.id = id;
        this.price = price;
        this.date = date;
    }
}
