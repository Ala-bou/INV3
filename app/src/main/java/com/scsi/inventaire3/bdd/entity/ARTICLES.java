package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ARTICLES")
public class ARTICLES {



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

    @ColumnInfo(name = "ART_ID")
    private int ART_ID;

    @ColumnInfo(name = "ART_INTITULE")
    private String ART_INTITULE;

    @ColumnInfo(name = "ART_POIDS_BRUT")
    private double ART_POIDS_BRUT;

    @ColumnInfo(name = "ART_POIDS_NET")
    private double ART_POIDS_NET;

    @ColumnInfo(name = "ART_TYPEGAMME")
    private int ART_TYPEGAMME;

    @ColumnInfo(name = "ART_TYPESTOCK")
    private int ART_TYPESTOCK;

    @ColumnInfo(name = "ART_UNITE_REF")
    private String ART_UNITE_REF;

    @ColumnInfo(name = "ART_UNITE_STK")
    private String ART_UNITE_STK;



    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;

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

    public int getART_TYPEGAMME() {
        return this.ART_TYPEGAMME;
    }

    public void setART_TYPEGAMME(int ART_TYPEGAMME) {
        this.ART_TYPEGAMME = ART_TYPEGAMME;
    }

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getART_ID() {
        return this.ART_ID;
    }

    public void setART_ID(int ART_ID) {
        this.ART_ID = ART_ID;
    }

    public String getART_BARCODE() {
        return this.ART_BARCODE;
    }

    public void setART_BARCODE(String ART_BARCODE) {
        this.ART_BARCODE = ART_BARCODE;
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

    public double getART_POIDS_BRUT() {
        return this.ART_POIDS_BRUT;
    }

    public void setART_POIDS_BRUT(double ART_POIDS_BRUT) {
        this.ART_POIDS_BRUT = ART_POIDS_BRUT;
    }

    public double getART_POIDS_NET() {
        return this.ART_POIDS_NET;
    }

    public void setART_POIDS_NET(double ART_POIDS_NET) {
        this.ART_POIDS_NET = ART_POIDS_NET;
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

    public String getART_UNITE_STK() {
        return this.ART_UNITE_STK;
    }

    public void setART_UNITE_STK(String ART_UNITE_STK) {
        this.ART_UNITE_STK = ART_UNITE_STK;
    }
}
