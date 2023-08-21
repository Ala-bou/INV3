package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "HST_SCAN")
public class HST_SCAN {

    @ColumnInfo(name = "HST_DATE")
    private String HST_DATE;

    @ColumnInfo(name = "HST_EMP")
    private String HST_EMP;

    @ColumnInfo(name = "HST_ID")
    private int HST_ID;

    @ColumnInfo(name = "HST_INV")
    private int HST_INV;

    @ColumnInfo(name = "HST_USR")
    private int HST_USR;

    @ColumnInfo(name = "HST_ZONE")
    private int HST_ZONE;




    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;


    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getHST_ID() {
        return this.HST_ID;
    }

    public void setHST_ID(int HST_ID) {
        this.HST_ID = HST_ID;
    }

    public int getHST_ZONE() {
        return this.HST_ZONE;
    }

    public void setHST_ZONE(int HST_ZONE) {
        this.HST_ZONE = HST_ZONE;
    }

    public int getHST_USR() {
        return this.HST_USR;
    }

    public void setHST_USR(int HST_USR) {
        this.HST_USR = HST_USR;
    }

    public int getHST_INV() {
        return this.HST_INV;
    }

    public void setHST_INV(int HST_INV) {
        this.HST_INV = HST_INV;
    }

    public String getHST_EMP() {
        return this.HST_EMP;
    }

    public void setHST_EMP(String HST_EMP) {
        this.HST_EMP = HST_EMP;
    }

    public String getHST_DATE() {
        return this.HST_DATE;
    }

    public void setHST_DATE(String HST_DATE) {
        this.HST_DATE = HST_DATE;
    }
}
