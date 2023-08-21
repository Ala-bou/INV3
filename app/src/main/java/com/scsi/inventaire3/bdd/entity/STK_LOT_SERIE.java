package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "STK_LOT_SERIE")
public class STK_LOT_SERIE {

    @ColumnInfo(name = "ART_CODE")
    private String ART_CODE;

    @ColumnInfo(name = "ART_GAMME1")
    private String ART_GAMME1;

    @ColumnInfo(name = "ART_GAMME2")
    private String ART_GAMME2;

    @ColumnInfo(name = "ART_INTITULE")
    private String ART_INTITULE;

    @ColumnInfo(name = "ART_TYPESTOCK")
    private int ART_TYPESTOCK;

    @ColumnInfo(name = "ART_UNITE_REF")
    private String ART_UNITE_REF;

    @ColumnInfo(name = "EMP_CODE")
    private String EMP_CODE;

    @ColumnInfo(name = "LS_FABRICATION")
    private String LS_FABRICATION;

    @ColumnInfo(name = "LS_ID")
    private int LS_ID;

    @ColumnInfo(name = "LS_NO")
    private String LS_NO;

    @ColumnInfo(name = "LS_NST_STOCK")
    private String LS_NST_STOCK;

    @ColumnInfo(name = "LS_PEREMPTION")
    private String LS_PEREMPTION;

    @ColumnInfo(name = "STK_ID_ERP")
    private int STK_ID_ERP;

    @ColumnInfo(name = "STK_QTE")
    private double STK_QTE;



    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;



    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getART_CODE() {
        return this.ART_CODE;
    }

    public void setART_CODE(String ART_CODE) {
        this.ART_CODE = ART_CODE;
    }

    public String getART_GAMME1() {
        return this.ART_GAMME1;
    }

    public void setART_GAMME1(String ART_GAMME1) {
        this.ART_GAMME1 = ART_GAMME1;
    }

    public String getART_GAMME2() {
        return this.ART_GAMME2;
    }

    public void setART_GAMME2(String ART_GAMME2) {
        this.ART_GAMME2 = ART_GAMME2;
    }

    public String getART_INTITULE() {
        return this.ART_INTITULE;
    }

    public void setART_INTITULE(String ART_INTITULE) {
        this.ART_INTITULE = ART_INTITULE;
    }

    public int getART_TYPESTOCK() {
        return this.ART_TYPESTOCK;
    }

    public void setART_TYPESTOCK(int ART_TYPESTOCK) {
        this.ART_TYPESTOCK = ART_TYPESTOCK;
    }

    public String getART_UNITE_REF() {
        return this.ART_UNITE_REF;
    }

    public void setART_UNITE_REF(String ART_UNITE_REF) {
        this.ART_UNITE_REF = ART_UNITE_REF;
    }

    public String getEMP_CODE() {
        return this.EMP_CODE;
    }

    public void setEMP_CODE(String EMP_CODE) {
        this.EMP_CODE = EMP_CODE;
    }

    public String getLS_FABRICATION() {
        return this.LS_FABRICATION;
    }

    public void setLS_FABRICATION(String LS_FABRICATION) {
        this.LS_FABRICATION = LS_FABRICATION;
    }

    public int getLS_ID() {
        return this.LS_ID;
    }

    public void setLS_ID(int LS_ID) {
        this.LS_ID = LS_ID;
    }

    public String getLS_NO() {
        return this.LS_NO;
    }

    public void setLS_NO(String LS_NO) {
        this.LS_NO = LS_NO;
    }

    public String getLS_NST_STOCK() {
        return this.LS_NST_STOCK;
    }

    public void setLS_NST_STOCK(String LS_NST_STOCK) {
        this.LS_NST_STOCK = LS_NST_STOCK;
    }

    public String getLS_PEREMPTION() {
        return this.LS_PEREMPTION;
    }

    public void setLS_PEREMPTION(String LS_PEREMPTION) {
        this.LS_PEREMPTION = LS_PEREMPTION;
    }

    public int getSTK_ID_ERP() {
        return this.STK_ID_ERP;
    }

    public void setSTK_ID_ERP(int STK_ID_ERP) {
        this.STK_ID_ERP = STK_ID_ERP;
    }

    public double getSTK_QTE() {
        return this.STK_QTE;
    }

    public void setSTK_QTE(double STK_QTE) {
        this.STK_QTE = STK_QTE;
    }
}
