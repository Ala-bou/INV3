package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "T_RESULTAT")
public class T_RESULTAT {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;

    @ColumnInfo(name = "RESULTAT_ID")
    private int RESULTAT_ID;


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



    @ColumnInfo(name = "RESULTAT_QUANTITE")
    private double RESULTAT_QUANTITE;



    @ColumnInfo(name = "INVENTAIRE_ID")
    private int INVENTAIRE_ID;


    @ColumnInfo(name = "RESULTAT_LOT")
    private String RESULTAT_LOT;


    @ColumnInfo(name = "RESULTAT_SERIE")
    private String RESULTAT_SERIE;

    @ColumnInfo(name = "RESULTAT_GAMME1")
    private String RESULTAT_GAMME1;

    @ColumnInfo(name = "RESULTAT_GAMME2")
    private String RESULTAT_GAMME2;


    @ColumnInfo(name = "RESULTAT_GAMME1_INTITULE")
    private String RESULTAT_GAMME1_INTITULE;


    @ColumnInfo(name = "RESULTAT_GAMME2_INTITULE")
    private String RESULTAT_GAMME2_INTITULE;


    @ColumnInfo(name = "RESULTAT_BARCODE")
    private String RESULTAT_BARCODE;


    @ColumnInfo(name = "RESULTAT_DATE_FABRICATION")
    private String RESULTAT_DATE_FABRICATION;


    @ColumnInfo(name = "RESULTAT_DATE_PEREMPTION")
    private String RESULTAT_DATE_PEREMPTION;



    @ColumnInfo(name = "USER_ID")
    private int USER_ID;



    @ColumnInfo(name = "USER_NAME")
    private String USER_NAME;



    @ColumnInfo(name = "RESULTAT_SCAN_DATE")
    private String RESULTAT_SCAN_DATE;



    @ColumnInfo(name = "ZONE_ID")
    private int ZONE_ID;



    @ColumnInfo(name = "ZONE_INTITULE")
    private String ZONE_INTITULE;



    @ColumnInfo(name = "EMPLACEMENT_ID")
    private int EMPLACEMENT_ID;



    @ColumnInfo(name = "EMPLACEMENT_CODE")
    private String EMPLACEMENT_CODE;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getRESULTAT_ID() {
        return RESULTAT_ID;
    }

    public void setRESULTAT_ID(int RESULTAT_ID) {
        this.RESULTAT_ID = RESULTAT_ID;
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

    public double getRESULTAT_QUANTITE() {
        return RESULTAT_QUANTITE;
    }

    public void setRESULTAT_QUANTITE(double RESULTAT_QUANTITE) {
        this.RESULTAT_QUANTITE = RESULTAT_QUANTITE;
    }

    public int getINVENTAIRE_ID() {
        return INVENTAIRE_ID;
    }

    public void setINVENTAIRE_ID(int INVENTAIRE_ID) {
        this.INVENTAIRE_ID = INVENTAIRE_ID;
    }

    public String getRESULTAT_LOT() {
        return RESULTAT_LOT;
    }

    public void setRESULTAT_LOT(String RESULTAT_LOT) {
        this.RESULTAT_LOT = RESULTAT_LOT;
    }

    public String getRESULTAT_SERIE() {
        return RESULTAT_SERIE;
    }

    public void setRESULTAT_SERIE(String RESULTAT_SERIE) {
        this.RESULTAT_SERIE = RESULTAT_SERIE;
    }

    public String getRESULTAT_GAMME1() {
        return RESULTAT_GAMME1;
    }

    public void setRESULTAT_GAMME1(String RESULTAT_GAMME1) {
        this.RESULTAT_GAMME1 = RESULTAT_GAMME1;
    }

    public String getRESULTAT_GAMME2() {
        return RESULTAT_GAMME2;
    }

    public void setRESULTAT_GAMME2(String RESULTAT_GAMME2) {
        this.RESULTAT_GAMME2 = RESULTAT_GAMME2;
    }

    public String getRESULTAT_GAMME1_INTITULE() {
        return RESULTAT_GAMME1_INTITULE;
    }

    public void setRESULTAT_GAMME1_INTITULE(String RESULTAT_GAMME1_INTITULE) {
        this.RESULTAT_GAMME1_INTITULE = RESULTAT_GAMME1_INTITULE;
    }

    public String getRESULTAT_GAMME2_INTITULE() {
        return RESULTAT_GAMME2_INTITULE;
    }

    public void setRESULTAT_GAMME2_INTITULE(String RESULTAT_GAMME2_INTITULE) {
        this.RESULTAT_GAMME2_INTITULE = RESULTAT_GAMME2_INTITULE;
    }

    public String getRESULTAT_BARCODE() {
        return RESULTAT_BARCODE;
    }

    public void setRESULTAT_BARCODE(String RESULTAT_BARCODE) {
        this.RESULTAT_BARCODE = RESULTAT_BARCODE;
    }

    public String getRESULTAT_DATE_FABRICATION() {
        return RESULTAT_DATE_FABRICATION;
    }

    public void setRESULTAT_DATE_FABRICATION(String RESULTAT_DATE_FABRICATION) {
        this.RESULTAT_DATE_FABRICATION = RESULTAT_DATE_FABRICATION;
    }

    public String getRESULTAT_DATE_PEREMPTION() {
        return RESULTAT_DATE_PEREMPTION;
    }

    public void setRESULTAT_DATE_PEREMPTION(String RESULTAT_DATE_PEREMPTION) {
        this.RESULTAT_DATE_PEREMPTION = RESULTAT_DATE_PEREMPTION;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getRESULTAT_SCAN_DATE() {
        return RESULTAT_SCAN_DATE;
    }

    public void setRESULTAT_SCAN_DATE(String RESULTAT_SCAN_DATE) {
        this.RESULTAT_SCAN_DATE = RESULTAT_SCAN_DATE;
    }

    public int getZONE_ID() {
        return ZONE_ID;
    }

    public void setZONE_ID(int ZONE_ID) {
        this.ZONE_ID = ZONE_ID;
    }

    public String getZONE_INTITULE() {
        return ZONE_INTITULE;
    }

    public void setZONE_INTITULE(String ZONE_INTITULE) {
        this.ZONE_INTITULE = ZONE_INTITULE;
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
}
