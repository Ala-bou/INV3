package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "STK_GAMME")
public class STK_GAMME {
    @ColumnInfo(name = "ART_CODE")
    private String ART_CODE;


    @ColumnInfo(name = "ART_GAMME1")
    private String ART_GAMME1;


    @ColumnInfo(name = "ART_GAMME2")
    private String ART_GAMME2;


    @ColumnInfo(name = "ART_ID")
    private int ART_ID;



    @ColumnInfo(name = "ART_INTITULE")
    private String ART_INTITULE;


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



    @ColumnInfo(name = "GAM_ID")
    private int GAM_ID;



    @ColumnInfo(name = "GAM_NST")
    private String GAM_NST;



    @ColumnInfo(name = "GAM_QTE")
    private double GAM_QTE;



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
    private int STK_DOS;


    @ColumnInfo(name = "STK_ID_ERP")
    private int STK_ID_ERP;





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

    public int getART_ID() {
        return this.ART_ID;
    }

    public void setART_ID(int ART_ID) {
        this.ART_ID = ART_ID;
    }

    public String getART_INTITULE() {
        return this.ART_INTITULE;
    }

    public void setART_INTITULE(String ART_INTITULE) {
        this.ART_INTITULE = ART_INTITULE;
    }

    public String getART_UNITE_REF() {
        return this.ART_UNITE_REF;
    }

    public void setART_UNITE_REF(String ART_UNITE_REF) {
        this.ART_UNITE_REF = ART_UNITE_REF;
    }

    public String getDEP_CODE() {
        return this.DEP_CODE;
    }

    public void setDEP_CODE(String DEP_CODE) {
        this.DEP_CODE = DEP_CODE;
    }

    public int getDEP_ID_ERP() {
        return this.DEP_ID_ERP;
    }

    public void setDEP_ID_ERP(int DEP_ID_ERP) {
        this.DEP_ID_ERP = DEP_ID_ERP;
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

    public int getEMP_ID_ERP() {
        return this.EMP_ID_ERP;
    }

    public void setEMP_ID_ERP(int EMP_ID_ERP) {
        this.EMP_ID_ERP = EMP_ID_ERP;
    }

    public String getEMP_INTITULE() {
        return this.EMP_INTITULE;
    }

    public void setEMP_INTITULE(String EMP_INTITULE) {
        this.EMP_INTITULE = EMP_INTITULE;
    }

    public int getGAM_ID() {
        return this.GAM_ID;
    }

    public void setGAM_ID(int GAM_ID) {
        this.GAM_ID = GAM_ID;
    }

    public String getGAM_NST() {
        return this.GAM_NST;
    }

    public void setGAM_NST(String GAM_NST) {
        this.GAM_NST = GAM_NST;
    }

    public double getGAM_QTE() {
        return this.GAM_QTE;
    }

    public void setGAM_QTE(double GAM_QTE) {
        this.GAM_QTE = GAM_QTE;
    }

    public int getINV_ID() {
        return this.INV_ID;
    }

    public void setINV_ID(int INV_ID) {
        this.INV_ID = INV_ID;
    }

    public String getMB_DATE_SCAN() {
        return this.MB_DATE_SCAN;
    }

    public void setMB_DATE_SCAN(String MB_DATE_SCAN) {
        this.MB_DATE_SCAN = MB_DATE_SCAN;
    }

    public String getMB_EMP_SCANNE() {
        return this.MB_EMP_SCANNE;
    }

    public void setMB_EMP_SCANNE(String MB_EMP_SCANNE) {
        this.MB_EMP_SCANNE = MB_EMP_SCANNE;
    }

    public int getMB_FLAG() {
        return this.MB_FLAG;
    }

    public void setMB_FLAG(int MB_FLAG) {
        this.MB_FLAG = MB_FLAG;
    }

    public double getMB_QTE_SCANNE() {
        return this.MB_QTE_SCANNE;
    }

    public void setMB_QTE_SCANNE(double MB_QTE_SCANNE) {
        this.MB_QTE_SCANNE = MB_QTE_SCANNE;
    }

    public int getMB_USER_SCAN() {
        return this.MB_USER_SCAN;
    }

    public void setMB_USER_SCAN(int MB_USER_SCAN) {
        this.MB_USER_SCAN = MB_USER_SCAN;
    }

    public int getMB_ZONE_SCANNE() {
        return this.MB_ZONE_SCANNE;
    }

    public void setMB_ZONE_SCANNE(int MB_ZONE_SCANNE) {
        this.MB_ZONE_SCANNE = MB_ZONE_SCANNE;
    }

    public double getSTK_CMUP() {
        return this.STK_CMUP;
    }

    public void setSTK_CMUP(double STK_CMUP) {
        this.STK_CMUP = STK_CMUP;
    }

    public double getSTK_CR() {
        return this.STK_CR;
    }

    public void setSTK_CR(double STK_CR) {
        this.STK_CR = STK_CR;
    }

    public String getSTK_DATE_INV() {
        return this.STK_DATE_INV;
    }

    public void setSTK_DATE_INV(String STK_DATE_INV) {
        this.STK_DATE_INV = STK_DATE_INV;
    }

    public int getSTK_DOS() {
        return this.STK_DOS;
    }

    public void setSTK_DOS(int STK_DOS) {
        this.STK_DOS = STK_DOS;
    }

    public int getSTK_ID_ERP() {
        return this.STK_ID_ERP;
    }

    public void setSTK_ID_ERP(int STK_ID_ERP) {
        this.STK_ID_ERP = STK_ID_ERP;
    }
}
