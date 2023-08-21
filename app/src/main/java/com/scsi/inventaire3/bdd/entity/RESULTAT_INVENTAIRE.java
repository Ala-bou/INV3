package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "RESULTAT_INVENTAIRE")
public class RESULTAT_INVENTAIRE {

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

    @ColumnInfo(name = "EMP_CODE")
    private String EMP_CODE;

    @ColumnInfo(name = "EMP_INTITULE")
    private String EMP_INTITULE;

    @ColumnInfo(name = "INV_ID")
    private int INV_ID;

    @ColumnInfo(name = "MBR_DATE_FABRICATION")
    private String MBR_DATE_FABRICATION;

    @ColumnInfo(name = "MBR_DATE_PEREMPTION")
    private String MBR_DATE_PEREMPTION;

    @ColumnInfo(name = "MBR_DATE_SCAN")
    private String MBR_DATE_SCAN;

    @ColumnInfo(name = "MBR_FLAG")
    private int MBR_FLAG;

    @ColumnInfo(name = "MBR_GAMME1")
    private String MBR_GAMME1;

    @ColumnInfo(name = "MBR_GAMME1_INTITULE")
    private String MBR_GAMME1_INTITULE;

    @ColumnInfo(name = "MBR_GAMME2")
    private String MBR_GAMME2;

    @ColumnInfo(name = "MBR_GAMME2_INTITULE")
    private String MBR_GAMME2_INTITULE;

    @ColumnInfo(name = "MBR_LS_NO")
    private String MBR_LS_NO;

    @ColumnInfo(name = "MBR_NST")
    private String MBR_NST;

    @ColumnInfo(name = "MBR_QTE")
    private double MBR_QTE;

    @ColumnInfo(name = "MBR_USER_SCAN")
    private int MBR_USER_SCAN;

    @ColumnInfo(name = "MBR_ZONE")
    private String MBR_ZONE;

    @ColumnInfo(name = "MISSION_ID")
    private int MISSION_ID;




    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;

    public String getMBR_GAMME1_INTITULE() {
        return this.MBR_GAMME1_INTITULE;
    }

    public void setMBR_GAMME1_INTITULE(String MBR_GAMME1_INTITULE) {
        this.MBR_GAMME1_INTITULE = MBR_GAMME1_INTITULE;
    }

    public String getMBR_GAMME2_INTITULE() {
        return this.MBR_GAMME2_INTITULE;
    }

    public void setMBR_GAMME2_INTITULE(String MBR_GAMME2_INTITULE) {
        this.MBR_GAMME2_INTITULE = MBR_GAMME2_INTITULE;
    }

    public int getMISSION_ID() {
        return this.MISSION_ID;
    }

    public void setMISSION_ID(int MISSION_ID) {
        this.MISSION_ID = MISSION_ID;
    }

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getMBR_ZONE() {
        return this.MBR_ZONE;
    }

    public void setMBR_ZONE(String MBR_ZONE) {
        this.MBR_ZONE = MBR_ZONE;
    }

    public String getEMP_CODE() {
        return this.EMP_CODE;
    }

    public int getINV_ID() {
        return this.INV_ID;
    }

    public void setINV_ID(int INV_ID) {
        this.INV_ID = INV_ID;
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

    public String getART_UNITE_REF() {
        return this.ART_UNITE_REF;
    }

    public void setART_UNITE_REF(String ART_UNITE_REF) {
        this.ART_UNITE_REF = ART_UNITE_REF;
    }

    public int getART_TYPESTOCK() {
        return this.ART_TYPESTOCK;
    }

    public void setART_TYPESTOCK(int ART_TYPESTOCK) {
        this.ART_TYPESTOCK = ART_TYPESTOCK;
    }

    public int getART_TYPEGAMME() {
        return this.ART_TYPEGAMME;
    }

    public void setART_TYPEGAMME(int ART_TYPEGAMME) {
        this.ART_TYPEGAMME = ART_TYPEGAMME;
    }

    public double getMBR_QTE() {
        return this.MBR_QTE;
    }

    public void setMBR_QTE(double MBR_QTE) {
        this.MBR_QTE = MBR_QTE;
    }

    public String getMBR_GAMME1() {
        return this.MBR_GAMME1;
    }

    public void setMBR_GAMME1(String MBR_GAMME1) {
        this.MBR_GAMME1 = MBR_GAMME1;
    }

    public String getMBR_GAMME2() {
        return this.MBR_GAMME2;
    }

    public void setMBR_GAMME2(String MBR_GAMME2) {
        this.MBR_GAMME2 = MBR_GAMME2;
    }

    public String getMBR_LS_NO() {
        return this.MBR_LS_NO;
    }

    public void setMBR_LS_NO(String MBR_LS_NO) {
        this.MBR_LS_NO = MBR_LS_NO;
    }

    public String getMBR_DATE_FABRICATION() {
        return this.MBR_DATE_FABRICATION;
    }

    public void setMBR_DATE_FABRICATION(String MBR_DATE_FABRICATION) {
        this.MBR_DATE_FABRICATION = MBR_DATE_FABRICATION;
    }

    public String getMBR_DATE_PEREMPTION() {
        return this.MBR_DATE_PEREMPTION;
    }

    public void setMBR_DATE_PEREMPTION(String MBR_DATE_PEREMPTION) {
        this.MBR_DATE_PEREMPTION = MBR_DATE_PEREMPTION;
    }

    public String getMBR_NST() {
        return this.MBR_NST;
    }

    public void setMBR_NST(String MBR_NST) {
        this.MBR_NST = MBR_NST;
    }

    public String getMBR_DATE_SCAN() {
        return this.MBR_DATE_SCAN;
    }

    public void setMBR_DATE_SCAN(String MBR_DATE_SCAN) {
        this.MBR_DATE_SCAN = MBR_DATE_SCAN;
    }

    public int getMBR_USER_SCAN() {
        return this.MBR_USER_SCAN;
    }

    public void setMBR_USER_SCAN(int MBR_USER_SCAN) {
        this.MBR_USER_SCAN = MBR_USER_SCAN;
    }

    public int getMBR_FLAG() {
        return this.MBR_FLAG;
    }

    public void setMBR_FLAG(int MBR_FLAG) {
        this.MBR_FLAG = MBR_FLAG;
    }
}
