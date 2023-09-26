package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "T_INVENTAIRE")
public class T_INVENTAIRE {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;


    @ColumnInfo(name = "INVENTAIRE_ID")
    private int INVENTAIRE_ID;


    @ColumnInfo(name = "INVENTAIRE_CODE")
    private String INVENTAIRE_CODE;


    @ColumnInfo(name = "INVENTAIRE_INTITULE")
    private String INVENTAIRE_INTITULE;


    @ColumnInfo(name = "INVENTAIRE_DATE")
    private String INVENTAIRE_DATE;


    @ColumnInfo(name = "INVENTAIRE_COMPTAGE")
    private int INVENTAIRE_COMPTAGE;


    @ColumnInfo(name = "INVENTAIRE_DATE_CLOTURE")
    private String INVENTAIRE_DATE_CLOTURE;


    @ColumnInfo(name = "INVENTAIRE_SCAN_PREFIX")
    private int INVENTAIRE_SCAN_PREFIX;


    @ColumnInfo(name = "INVENTAIRE_SCAN_SUFFFIX")
    private int INVENTAIRE_SCAN_SUFFFIX;


    @ColumnInfo(name = "INVENTAIRE_SCAN_SEPARATEUR")
    private String INVENTAIRE_SCAN_SEPARATEUR;



    @ColumnInfo(name = "INVENTAIRE_STATUT")
    private int INVENTAIRE_STATUT;
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getINVENTAIRE_ID() {
        return INVENTAIRE_ID;
    }

    public void setINVENTAIRE_ID(int INVENTAIRE_ID) {
        this.INVENTAIRE_ID = INVENTAIRE_ID;
    }

    public String getINVENTAIRE_CODE() {
        return INVENTAIRE_CODE;
    }

    public void setINVENTAIRE_CODE(String INVENTAIRE_CODE) {
        this.INVENTAIRE_CODE = INVENTAIRE_CODE;
    }

    public String getINVENTAIRE_INTITULE() {
        return INVENTAIRE_INTITULE;
    }

    public void setINVENTAIRE_INTITULE(String INVENTAIRE_INTITULE) {
        this.INVENTAIRE_INTITULE = INVENTAIRE_INTITULE;
    }

    public String getINVENTAIRE_DATE() {
        return INVENTAIRE_DATE;
    }

    public void setINVENTAIRE_DATE(String INVENTAIRE_DATE) {
        this.INVENTAIRE_DATE = INVENTAIRE_DATE;
    }

    public int getINVENTAIRE_COMPTAGE() {
        return INVENTAIRE_COMPTAGE;
    }

    public void setINVENTAIRE_COMPTAGE(int INVENTAIRE_COMPTAGE) {
        this.INVENTAIRE_COMPTAGE = INVENTAIRE_COMPTAGE;
    }

    public String getINVENTAIRE_DATE_CLOTURE() {
        return INVENTAIRE_DATE_CLOTURE;
    }

    public void setINVENTAIRE_DATE_CLOTURE(String INVENTAIRE_DATE_CLOTURE) {
        this.INVENTAIRE_DATE_CLOTURE = INVENTAIRE_DATE_CLOTURE;
    }

    public int getINVENTAIRE_SCAN_PREFIX() {
        return INVENTAIRE_SCAN_PREFIX;
    }

    public void setINVENTAIRE_SCAN_PREFIX(int INVENTAIRE_SCAN_PREFIX) {
        this.INVENTAIRE_SCAN_PREFIX = INVENTAIRE_SCAN_PREFIX;
    }

    public int getINVENTAIRE_SCAN_SUFFFIX() {
        return INVENTAIRE_SCAN_SUFFFIX;
    }

    public void setINVENTAIRE_SCAN_SUFFFIX(int INVENTAIRE_SCAN_SUFFFIX) {
        this.INVENTAIRE_SCAN_SUFFFIX = INVENTAIRE_SCAN_SUFFFIX;
    }

    public String getINVENTAIRE_SCAN_SEPARATEUR() {
        return INVENTAIRE_SCAN_SEPARATEUR;
    }

    public void setINVENTAIRE_SCAN_SEPARATEUR(String INVENTAIRE_SCAN_SEPARATEUR) {
        this.INVENTAIRE_SCAN_SEPARATEUR = INVENTAIRE_SCAN_SEPARATEUR;
    }


    public int getINVENTAIRE_STATUT() {
        return INVENTAIRE_STATUT;
    }

    public void setINVENTAIRE_STATUT(int INVENTAIRE_STATUT) {
        this.INVENTAIRE_STATUT = INVENTAIRE_STATUT;
    }
}
