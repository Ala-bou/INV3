package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "T_STOCK_DETAIL")
public class T_STOCK_DETAIL {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;


    @ColumnInfo(name = "STOCK_DET_ID")
    private int STOCK_DET_ID;


    @ColumnInfo(name = "ARTICLE_ID")
    private int ARTICLE_ID;


    @ColumnInfo(name = "ARTICLE_CODE")
    private String ARTICLE_CODE;


    @ColumnInfo(name = "ARTICLE_INTITULE")
    private String ARTICLE_INTITULE;


    @ColumnInfo(name = "ARTICLE_BARCODE")
    private String ARTICLE_BARCODE;

    @ColumnInfo(name = "ARTICLE_NATURE_ID")
    private int ARTICLE_NATURE_ID;

    @ColumnInfo(name = "STOCK_DET_QUANTITE")
    private double STOCK_DET_QUANTITE;

    @ColumnInfo(name = "INVENTAIRE_ID")
    private int INVENTAIRE_ID;

    @ColumnInfo(name = "STOCK_DET_LOT")
    private String STOCK_DET_LOT;

    @ColumnInfo(name = "STOCK_DET_SERIE")
    private String STOCK_DET_SERIE;

    @ColumnInfo(name = "STOCK_DET_GAMME1")
    private String STOCK_DET_GAMME1;

    @ColumnInfo(name = "STOCK_DET_GAMME2")
    private String STOCK_DET_GAMME2;

    @ColumnInfo(name = "STOCK_DET_GAMME1_INTITULE")
    private String STOCK_DET_GAMME1_INTITULE;

    @ColumnInfo(name = "STOCK_DET_GAMME2_INTITULE")
    private String STOCK_DET_GAMME2_INTITULE;

    @ColumnInfo(name = "STOCK_DET_BARCODE")
    private String STOCK_DET_BARCODE;

    @ColumnInfo(name = "STOCK_DET_DATE_FABRICATION")
    private String STOCK_DET_DATE_FABRICATION;

    @ColumnInfo(name = "STOCK_DET_DATE_PEREMPTION")
    private String STOCK_DET_DATE_PEREMPTION;


    @ColumnInfo(name = "EMPLACEMENT_ID")
    private int EMPLACEMENT_ID;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getSTOCK_DET_ID() {
        return STOCK_DET_ID;
    }

    public void setSTOCK_DET_ID(int STOCK_DET_ID) {
        this.STOCK_DET_ID = STOCK_DET_ID;
    }

    public int getARTICLE_ID() {
        return ARTICLE_ID;
    }

    public void setARTICLE_ID(int ARTICLE_ID) {
        this.ARTICLE_ID = ARTICLE_ID;
    }

    public String getARTICLE_CODE() {
        return ARTICLE_CODE;
    }

    public void setARTICLE_CODE(String ARTICLE_CODE) {
        this.ARTICLE_CODE = ARTICLE_CODE;
    }

    public String getARTICLE_INTITULE() {
        return ARTICLE_INTITULE;
    }

    public void setARTICLE_INTITULE(String ARTICLE_INTITULE) {
        this.ARTICLE_INTITULE = ARTICLE_INTITULE;
    }

    public String getARTICLE_BARCODE() {
        return ARTICLE_BARCODE;
    }

    public void setARTICLE_BARCODE(String ARTICLE_BARCODE) {
        this.ARTICLE_BARCODE = ARTICLE_BARCODE;
    }

    public int getARTICLE_NATURE_ID() {
        return ARTICLE_NATURE_ID;
    }

    public void setARTICLE_NATURE_ID(int ARTICLE_NATURE_ID) {
        this.ARTICLE_NATURE_ID = ARTICLE_NATURE_ID;
    }

    public double getSTOCK_DET_QUANTITE() {
        return STOCK_DET_QUANTITE;
    }

    public void setSTOCK_DET_QUANTITE(double STOCK_DET_QUANTITE) {
        this.STOCK_DET_QUANTITE = STOCK_DET_QUANTITE;
    }

    public int getINVENTAIRE_ID() {
        return INVENTAIRE_ID;
    }

    public void setINVENTAIRE_ID(int INVENTAIRE_ID) {
        this.INVENTAIRE_ID = INVENTAIRE_ID;
    }

    public String getSTOCK_DET_LOT() {
        return STOCK_DET_LOT;
    }

    public void setSTOCK_DET_LOT(String STOCK_DET_LOT) {
        this.STOCK_DET_LOT = STOCK_DET_LOT;
    }

    public String getSTOCK_DET_SERIE() {
        return STOCK_DET_SERIE;
    }

    public void setSTOCK_DET_SERIE(String STOCK_DET_SERIE) {
        this.STOCK_DET_SERIE = STOCK_DET_SERIE;
    }

    public String getSTOCK_DET_GAMME1() {
        return STOCK_DET_GAMME1;
    }

    public void setSTOCK_DET_GAMME1(String STOCK_DET_GAMME1) {
        this.STOCK_DET_GAMME1 = STOCK_DET_GAMME1;
    }

    public String getSTOCK_DET_GAMME2() {
        return STOCK_DET_GAMME2;
    }

    public void setSTOCK_DET_GAMME2(String STOCK_DET_GAMME2) {
        this.STOCK_DET_GAMME2 = STOCK_DET_GAMME2;
    }

    public String getSTOCK_DET_GAMME1_INTITULE() {
        return STOCK_DET_GAMME1_INTITULE;
    }

    public void setSTOCK_DET_GAMME1_INTITULE(String STOCK_DET_GAMME1_INTITULE) {
        this.STOCK_DET_GAMME1_INTITULE = STOCK_DET_GAMME1_INTITULE;
    }

    public String getSTOCK_DET_GAMME2_INTITULE() {
        return STOCK_DET_GAMME2_INTITULE;
    }

    public void setSTOCK_DET_GAMME2_INTITULE(String STOCK_DET_GAMME2_INTITULE) {
        this.STOCK_DET_GAMME2_INTITULE = STOCK_DET_GAMME2_INTITULE;
    }

    public String getSTOCK_DET_BARCODE() {
        return STOCK_DET_BARCODE;
    }

    public void setSTOCK_DET_BARCODE(String STOCK_DET_BARCODE) {
        this.STOCK_DET_BARCODE = STOCK_DET_BARCODE;
    }

    public String getSTOCK_DET_DATE_FABRICATION() {
        return STOCK_DET_DATE_FABRICATION;
    }

    public void setSTOCK_DET_DATE_FABRICATION(String STOCK_DET_DATE_FABRICATION) {
        this.STOCK_DET_DATE_FABRICATION = STOCK_DET_DATE_FABRICATION;
    }

    public String getSTOCK_DET_DATE_PEREMPTION() {
        return STOCK_DET_DATE_PEREMPTION;
    }

    public void setSTOCK_DET_DATE_PEREMPTION(String STOCK_DET_DATE_PEREMPTION) {
        this.STOCK_DET_DATE_PEREMPTION = STOCK_DET_DATE_PEREMPTION;
    }

    public int getEMPLACEMENT_ID() {
        return EMPLACEMENT_ID;
    }

    public void setEMPLACEMENT_ID(int EMPLACEMENT_ID) {
        this.EMPLACEMENT_ID = EMPLACEMENT_ID;
    }
}
