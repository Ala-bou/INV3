package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "T_ZONE")
public class T_ZONE {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;


    @ColumnInfo(name = "ZONE_ID")
    private int ZONE_ID;

    @ColumnInfo(name = "ZONE_CODE")
    private String ZONE_CODE;


    @ColumnInfo(name = "ZONE_INTITULE")
    private String ZONE_INTITULE;



    @ColumnInfo(name = "INVENTAIRE_ID")
    private int INVENTAIRE_ID;



    @ColumnInfo(name = "USER_ID")
    private int USER_ID;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getZONE_ID() {
        return ZONE_ID;
    }

    public void setZONE_ID(int ZONE_ID) {
        this.ZONE_ID = ZONE_ID;
    }

    public String getZONE_CODE() {
        return ZONE_CODE;
    }

    public void setZONE_CODE(String ZONE_CODE) {
        this.ZONE_CODE = ZONE_CODE;
    }

    public String getZONE_INTITULE() {
        return ZONE_INTITULE;
    }

    public void setZONE_INTITULE(String ZONE_INTITULE) {
        this.ZONE_INTITULE = ZONE_INTITULE;
    }

    public int getINVENTAIRE_ID() {
        return INVENTAIRE_ID;
    }

    public void setINVENTAIRE_ID(int INVENTAIRE_ID) {
        this.INVENTAIRE_ID = INVENTAIRE_ID;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }
}
