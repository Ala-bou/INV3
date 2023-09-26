package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "T_EMPLACEMENT")
public class T_EMPLACEMENT {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;


    @ColumnInfo(name = "EMPLACEMENT_ID")
    private int EMPLACEMENT_ID;


    @ColumnInfo(name = "EMPLACEMENT_CODE")
    private String EMPLACEMENT_CODE;



    @ColumnInfo(name = "EMPLACEMENT_INTITULE")
    private String EMPLACEMENT_INTITULE;


    @ColumnInfo(name = "ZONE_ID")
    private int ZONE_ID;


    @ColumnInfo(name = "INVENTAIRE_ID")
    private int INVENTAIRE_ID;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getEMPLACEMENT_ID() {
        return EMPLACEMENT_ID;
    }

    public void setEMPLACEMENT_ID(int EMPLACEMENT_ID) {
        this.EMPLACEMENT_ID = EMPLACEMENT_ID;
    }

    public String getEMPLACEMENT_CODE() {
        return EMPLACEMENT_CODE;
    }

    public void setEMPLACEMENT_CODE(String EMPLACEMENT_CODE) {
        this.EMPLACEMENT_CODE = EMPLACEMENT_CODE;
    }

    public String getEMPLACEMENT_INTITULE() {
        return EMPLACEMENT_INTITULE;
    }

    public void setEMPLACEMENT_INTITULE(String EMPLACEMENT_INTITULE) {
        this.EMPLACEMENT_INTITULE = EMPLACEMENT_INTITULE;
    }

    public int getZONE_ID() {
        return ZONE_ID;
    }

    public void setZONE_ID(int ZONE_ID) {
        this.ZONE_ID = ZONE_ID;
    }

    public int getINVENTAIRE_ID() {
        return INVENTAIRE_ID;
    }

    public void setINVENTAIRE_ID(int INVENTAIRE_ID) {
        this.INVENTAIRE_ID = INVENTAIRE_ID;
    }
}
