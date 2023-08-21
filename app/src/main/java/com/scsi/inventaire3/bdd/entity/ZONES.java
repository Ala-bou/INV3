package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ZONES")
public class ZONES {

    @ColumnInfo(name = "ZN_CODE")
    private String ZN_CODE;

    @ColumnInfo(name = "ZN_ID")
    private int ZN_ID;

    @ColumnInfo(name = "ZN_INTITULE")
    private String ZN_INTITULE;


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;

    public int getZN_ID() {
        return this.ZN_ID;
    }

    public void setZN_ID(int ZN_ID) {
        this.ZN_ID = ZN_ID;
    }

    public String getZN_INTITULE() {
        return this.ZN_INTITULE;
    }

    public void setZN_INTITULE(String ZN_INTITULE) {
        this.ZN_INTITULE = ZN_INTITULE;
    }

    public String getZN_CODE() {
        return this.ZN_CODE;
    }

    public void setZN_CODE(String ZN_CODE) {
        this.ZN_CODE = ZN_CODE;
    }

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
