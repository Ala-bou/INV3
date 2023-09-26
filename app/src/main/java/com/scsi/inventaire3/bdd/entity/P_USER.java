package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "P_USER")
public class P_USER {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;

    @ColumnInfo(name = "USER_ID")
    private int USER_ID;


    @ColumnInfo(name = "USER_CODE")
    private String USER_CODE;


    @ColumnInfo(name = "USER_NAME")
    private String USER_NAME;


    @ColumnInfo(name = "USER_TYPE_ID")
    private int USER_TYPE_ID;


    @ColumnInfo(name = "USER_ETAT")
    private int USER_ETAT;


    @ColumnInfo(name = "USER_TOKEN")
    private String USER_TOKEN;


    @ColumnInfo(name = "USER_LOGIN")
    private String USER_LOGIN;


    @ColumnInfo(name = "USER_PASSWORD")
    private String USER_PASSWORD;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_CODE() {
        return USER_CODE;
    }

    public void setUSER_CODE(String USER_CODE) {
        this.USER_CODE = USER_CODE;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public int getUSER_TYPE_ID() {
        return USER_TYPE_ID;
    }

    public void setUSER_TYPE_ID(int USER_TYPE_ID) {
        this.USER_TYPE_ID = USER_TYPE_ID;
    }

    public int getUSER_ETAT() {
        return USER_ETAT;
    }

    public void setUSER_ETAT(int USER_ETAT) {
        this.USER_ETAT = USER_ETAT;
    }

    public String getUSER_TOKEN() {
        return USER_TOKEN;
    }

    public void setUSER_TOKEN(String USER_TOKEN) {
        this.USER_TOKEN = USER_TOKEN;
    }

    public String getUSER_LOGIN() {
        return USER_LOGIN;
    }

    public void setUSER_LOGIN(String USER_LOGIN) {
        this.USER_LOGIN = USER_LOGIN;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }
}
