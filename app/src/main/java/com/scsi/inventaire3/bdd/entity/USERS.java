package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "USERS")
public class USERS {


    @ColumnInfo(name = "COL_CODE")
    private String COL_CODE;


    @ColumnInfo(name = "COL_ID")
    private int COL_ID;


    @ColumnInfo(name = "USR_ACTIF")
    private int USR_ACTIF;


    @ColumnInfo(name = "USR_ID")
    private int USR_ID;


    @ColumnInfo(name = "USR_LOGIN")
    private String USR_LOGIN;


    @ColumnInfo(name = "USR_MAIL")
    private String USR_MAIL;


    @ColumnInfo(name = "USR_NOM_COMPLET")
    private String USR_NOM_COMPLET;


    @ColumnInfo(name = "USR_PWD")
    private String USR_PWD;

    @ColumnInfo(name = "USR_TEL")
    private String USR_TEL;


    @ColumnInfo(name = "USR_TOKEN")
    private String USR_TOKEN;


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getUSR_ID() {
        return this.USR_ID;
    }

    public void setUSR_ID(int USR_ID) {
        this.USR_ID = USR_ID;
    }

    public int getUSR_ACTIF() {
        return this.USR_ACTIF;
    }

    public void setUSR_ACTIF(int USR_ACTIF) {
        this.USR_ACTIF = USR_ACTIF;
    }

    public int getCOL_ID() {
        return this.COL_ID;
    }

    public void setCOL_ID(int COL_ID) {
        this.COL_ID = COL_ID;
    }

    public String getCOL_CODE() {
        return this.COL_CODE;
    }

    public void setCOL_CODE(String COL_CODE) {
        this.COL_CODE = COL_CODE;
    }

    public String getUSR_NOM_COMPLET() {
        return this.USR_NOM_COMPLET;
    }

    public void setUSR_NOM_COMPLET(String USR_NOM_COMPLET) {
        this.USR_NOM_COMPLET = USR_NOM_COMPLET;
    }

    public String getUSR_LOGIN() {
        return this.USR_LOGIN;
    }

    public void setUSR_LOGIN(String USR_LOGIN) {
        this.USR_LOGIN = USR_LOGIN;
    }

    public String getUSR_PWD() {
        return this.USR_PWD;
    }

    public void setUSR_PWD(String USR_PWD) {
        this.USR_PWD = USR_PWD;
    }

    public String getUSR_TEL() {
        return this.USR_TEL;
    }

    public void setUSR_TEL(String USR_TEL) {
        this.USR_TEL = USR_TEL;
    }

    public String getUSR_MAIL() {
        return this.USR_MAIL;
    }

    public void setUSR_MAIL(String USR_MAIL) {
        this.USR_MAIL = USR_MAIL;
    }

    public String getUSR_TOKEN() {
        return this.USR_TOKEN;
    }

    public void setUSR_TOKEN(String USR_TOKEN) {
        this.USR_TOKEN = USR_TOKEN;
    }
}
