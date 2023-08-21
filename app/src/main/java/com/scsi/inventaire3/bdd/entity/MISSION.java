package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "MISSION")
public class MISSION {

    @ColumnInfo(name = "ART_BARCODE")
    private String ART_BARCODE;

    @ColumnInfo(name = "ART_CODE")
    private String ART_CODE;

    @ColumnInfo(name = "ART_GAMME1")
    private String ART_GAMME1;

    @ColumnInfo(name = "ART_GAMME1_INTITULE")
    private String ART_GAMME1_INTITULE;

    @ColumnInfo(name = "ART_GAMME2")
    private String ART_GAMME2;

    @ColumnInfo(name = "ART_GAMME2_INTITULE")
    private String ART_GAMME2_INTITULE;

    @ColumnInfo(name = "ART_INTITULE")
    private String ART_INTITULE;

    @ColumnInfo(name = "ART_TYPEGAMME")
    private int ART_TYPEGAMME;

    @ColumnInfo(name = "ART_TYPESTOCK")
    private int ART_TYPESTOCK;

    @ColumnInfo(name = "EMP_CODE")
    private String EMP_CODE;

    @ColumnInfo(name = "FLAG")
    private int FLAG;

    @ColumnInfo(name = "INV_COMPTAGE")
    private int INV_COMPTAGE;

    @ColumnInfo(name = "INV_ID")
    private int INV_ID;

    @ColumnInfo(name = "LS_NO")
    private String LS_NO;

    @ColumnInfo(name = "M_ID")
    private int M_ID;

    @ColumnInfo(name = "M_STATUT")
    private int M_STATUT;

    @ColumnInfo(name = "ZONE")
    private String ZONE;



    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;

    public int getART_TYPESTOCK() {
        return this.ART_TYPESTOCK;
    }

    public void setART_TYPESTOCK(int ART_TYPESTOCK) {
        this.ART_TYPESTOCK = ART_TYPESTOCK;
    }

    public String getLS_NO() {
        return this.LS_NO;
    }

    public void setLS_NO(String LS_NO) {
        this.LS_NO = LS_NO;
    }

    public int getART_TYPEGAMME() {
        return this.ART_TYPEGAMME;
    }

    public void setART_TYPEGAMME(int ART_TYPEGAMME) {
        this.ART_TYPEGAMME = ART_TYPEGAMME;
    }

    public String getART_GAMME1_INTITULE() {
        return this.ART_GAMME1_INTITULE;
    }

    public void setART_GAMME1_INTITULE(String ART_GAMME1_INTITULE) {
        this.ART_GAMME1_INTITULE = ART_GAMME1_INTITULE;
    }

    public String getART_GAMME2_INTITULE() {
        return this.ART_GAMME2_INTITULE;
    }

    public void setART_GAMME2_INTITULE(String ART_GAMME2_INTITULE) {
        this.ART_GAMME2_INTITULE = ART_GAMME2_INTITULE;
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

    public String getART_BARCODE() {
        return this.ART_BARCODE;
    }

    public void setART_BARCODE(String ART_BARCODE) {
        this.ART_BARCODE = ART_BARCODE;
    }

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getM_ID() {
        return this.M_ID;
    }

    public void setM_ID(int m_ID) {
        this.M_ID = m_ID;
    }

    public int getINV_ID() {
        return this.INV_ID;
    }

    public void setINV_ID(int INV_ID) {
        this.INV_ID = INV_ID;
    }

    public int getINV_COMPTAGE() {
        return this.INV_COMPTAGE;
    }

    public void setINV_COMPTAGE(int INV_COMPTAGE) {
        this.INV_COMPTAGE = INV_COMPTAGE;
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

    public String getEMP_CODE() {
        return this.EMP_CODE;
    }

    public void setEMP_CODE(String EMP_CODE) {
        this.EMP_CODE = EMP_CODE;
    }

    public int getM_STATUT() {
        return this.M_STATUT;
    }

    public void setM_STATUT(int m_STATUT) {
        this.M_STATUT = m_STATUT;
    }

    public String getZONE() {
        return this.ZONE;
    }

    public void setZONE(String ZONE) {
        this.ZONE = ZONE;
    }

    public int getFLAG() {
        return this.FLAG;
    }

    public void setFLAG(int FLAG) {
        this.FLAG = FLAG;
    }
}
