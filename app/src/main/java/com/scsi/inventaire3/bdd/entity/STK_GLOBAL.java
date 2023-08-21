package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "STK_GLOBAL")
public class STK_GLOBAL {
    @ColumnInfo(name = "ART_CODE")
    private String ART_CODE;


    @ColumnInfo(name = "ART_INTITULE")
    private String ART_INTITULE;



    @ColumnInfo(name = "ART_TYPEGAMME")
    private int ART_TYPEGAMME;



    @ColumnInfo(name = "ART_TYPESTOCK")
    private int ART_TYPESTOCK;



    @ColumnInfo(name = "ART_UNITE_REF")
    private String ART_UNITE_REF;



    @ColumnInfo(name = "DEP_CODE")
    private String DEP_CODE;



    @ColumnInfo(name = "DEP_ID_ERP")
    private int DEP_ID_ERP;


    @ColumnInfo(name = "DEP_INTITULE")
    private String DEP_INTITULE;



    @ColumnInfo(name = "EMP_CODE")
    private String EMP_CODE;



    @ColumnInfo(name = "EMP_ID_ERP")
    private int EMP_ID_ERP;



    @ColumnInfo(name = "EMP_INTITULE")
    private String EMP_INTITULE;


    @ColumnInfo(name = "INV_ID")
    private int INV_ID;


    @ColumnInfo(name = "MB_DATE_SCAN")
    private String MB_DATE_SCAN;


    @ColumnInfo(name = "MB_EMP_SCANNE")
    private String MB_EMP_SCANNE;



    @ColumnInfo(name = "MB_FLAG")
    private int MB_FLAG;



    @ColumnInfo(name = "MB_QTE_SCANNE")
    private double MB_QTE_SCANNE;


    @ColumnInfo(name = "MB_USER_SCAN")
    private int MB_USER_SCAN;


    @ColumnInfo(name = "MB_ZONE_SCANNE")
    private int MB_ZONE_SCANNE;


    @ColumnInfo(name = "STK_CMUP")
    private double STK_CMUP;


    @ColumnInfo(name = "STK_CR")
    private double STK_CR;



    @ColumnInfo(name = "STK_DATE_INV")
    private String STK_DATE_INV;


    @ColumnInfo(name = "STK_DOS")
    private String STK_DOS;


    @ColumnInfo(name = "STK_ID")
    private int STK_ID;

    @ColumnInfo(name = "STK_ID_ERP")
    private int STK_ID_ERP;



    @ColumnInfo(name = "STK_NST")
    private String STK_NST;


    @ColumnInfo(name = "STK_QTE")
    private double STK_QTE;




    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;

    public int getART_TYPESTOCK() {
        return this.ART_TYPESTOCK;
    }

    public void setART_TYPESTOCK(int ART_TYPESTOCK) {
        this.ART_TYPESTOCK = ART_TYPESTOCK;
    }

    public int getSTK_ID() {
        return this.STK_ID;
    }

    public void setSTK_ID(int STK_ID) {
        this.STK_ID = STK_ID;
    }

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getDEP_ID_ERP() {
        return this.DEP_ID_ERP;
    }

    public void setDEP_ID_ERP(int DEP_ID_ERP) {
        this.DEP_ID_ERP = DEP_ID_ERP;
    }

    public int getEMP_ID_ERP() {
        return this.EMP_ID_ERP;
    }

    public void setEMP_ID_ERP(int EMP_ID_ERP) {
        this.EMP_ID_ERP = EMP_ID_ERP;
    }

    public int getART_TYPEGAMME() {
        return this.ART_TYPEGAMME;
    }

    public void setART_TYPEGAMME(int ART_TYPEGAMME) {
        this.ART_TYPEGAMME = ART_TYPEGAMME;
    }

    public int getINV_ID() {
        return this.INV_ID;
    }

    public void setINV_ID(int INV_ID) {
        this.INV_ID = INV_ID;
    }

    public int getMB_ZONE_SCANNE() {
        return this.MB_ZONE_SCANNE;
    }

    public void setMB_ZONE_SCANNE(int MB_ZONE_SCANNE) {
        this.MB_ZONE_SCANNE = MB_ZONE_SCANNE;
    }

    public String getMB_EMP_SCANNE() {
        return this.MB_EMP_SCANNE;
    }

    public void setMB_EMP_SCANNE(String MB_EMP_SCANNE) {
        this.MB_EMP_SCANNE = MB_EMP_SCANNE;
    }

    public int getMB_USER_SCAN() {
        return this.MB_USER_SCAN;
    }

    public void setMB_USER_SCAN(int MB_USER_SCAN) {
        this.MB_USER_SCAN = MB_USER_SCAN;
    }

    public int getMB_FLAG() {
        return this.MB_FLAG;
    }

    public void setMB_FLAG(int MB_FLAG) {
        this.MB_FLAG = MB_FLAG;
    }

    public String getSTK_DOS() {
        return this.STK_DOS;
    }

    public void setSTK_DOS(String STK_DOS) {
        this.STK_DOS = STK_DOS;
    }

    public String getSTK_DATE_INV() {
        return this.STK_DATE_INV;
    }

    public void setSTK_DATE_INV(String STK_DATE_INV) {
        this.STK_DATE_INV = STK_DATE_INV;
    }

    public String getDEP_CODE() {
        return this.DEP_CODE;
    }

    public void setDEP_CODE(String DEP_CODE) {
        this.DEP_CODE = DEP_CODE;
    }

    public String getDEP_INTITULE() {
        return this.DEP_INTITULE;
    }

    public void setDEP_INTITULE(String DEP_INTITULE) {
        this.DEP_INTITULE = DEP_INTITULE;
    }

    public String getEMP_CODE() {
        return this.EMP_CODE;
    }

    public void setEMP_CODE(String EMP_CODE) {
        this.EMP_CODE = EMP_CODE;
    }

    public String getEMP_INTITULE() {
        return this.EMP_INTITULE;
    }

    public void setEMP_INTITULE(String EMP_INTITULE) {
        this.EMP_INTITULE = EMP_INTITULE;
    }

    public String getART_CODE() {
        return this.ART_CODE;
    }

    public void setART_CODE(String ART_CODE) {
        this.ART_CODE = ART_CODE;
    }

    public String getART_INTITULE() {
        return this.ART_INTITULE;
    }

    public void setART_INTITULE(String ART_INTITULE) {
        this.ART_INTITULE = ART_INTITULE;
    }

    public String getSTK_NST() {
        return this.STK_NST;
    }

    public void setSTK_NST(String STK_NST) {
        this.STK_NST = STK_NST;
    }

    public String getART_UNITE_REF() {
        return this.ART_UNITE_REF;
    }

    public void setART_UNITE_REF(String ART_UNITE_REF) {
        this.ART_UNITE_REF = ART_UNITE_REF;
    }

    public String getMB_DATE_SCAN() {
        return this.MB_DATE_SCAN;
    }

    public void setMB_DATE_SCAN(String MB_DATE_SCAN) {
        this.MB_DATE_SCAN = MB_DATE_SCAN;
    }

    public double getSTK_QTE() {
        return this.STK_QTE;
    }

    public void setSTK_QTE(double STK_QTE) {
        this.STK_QTE = STK_QTE;
    }

    public double getSTK_CR() {
        return this.STK_CR;
    }

    public void setSTK_CR(double STK_CR) {
        this.STK_CR = STK_CR;
    }

    public double getSTK_CMUP() {
        return this.STK_CMUP;
    }

    public void setSTK_CMUP(double STK_CMUP) {
        this.STK_CMUP = STK_CMUP;
    }

    public double getMB_QTE_SCANNE() {
        return this.MB_QTE_SCANNE;
    }

    public void setMB_QTE_SCANNE(double MB_QTE_SCANNE) {
        this.MB_QTE_SCANNE = MB_QTE_SCANNE;
    }

    public int getSTK_ID_ERP() {
        return this.STK_ID_ERP;
    }

    public void setSTK_ID_ERP(int STK_ID_ERP) {
        this.STK_ID_ERP = STK_ID_ERP;
    }
}
