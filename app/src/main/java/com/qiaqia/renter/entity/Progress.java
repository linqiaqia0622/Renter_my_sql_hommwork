package com.qiaqia.renter.entity;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by 洽洽 on 2016/12/16.
 */

public class Progress extends DataSupport {
    //房间
    @Column(nullable = false)
    private Room room;
    //租户
    @Column(nullable = false)
    private Renter renter;
    //进度
    @Column(nullable = false)
    private  int progress;
    //时间
    @Column(nullable = false)
    private int date;
    @Column(unique = true,nullable = false)
    private int pid;
    private  int id;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
}
