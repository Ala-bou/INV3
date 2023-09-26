package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "T_ARTICLE")
public class T_ARTICLE {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;

    @ColumnInfo(name = "ARTICLE_ID")
    private int ARTICLE_ID;

    @ColumnInfo(name = "ARTICLE_CODE")
    private String ARTICLE_CODE;

    @ColumnInfo(name = "ARTICLE_INTITULE")
    private String ARTICLE_INTITULE;

    @ColumnInfo(name = "ARTICLE_NATURE_ID")
    private int ARTICLE_NATURE_ID;

    @ColumnInfo(name = "ARTICLE_BARCODE")
    private String ARTICLE_BARCODE;

    @ColumnInfo(name = "INVENTAIRE_ID")
    private int INVENTAIRE_ID;

    @ColumnInfo(name = "ARTICLE_UNITE_REFERENCE")
    private String ARTICLE_UNITE_REFERENCE;

    @ColumnInfo(name = "ARTICLE_UNITE_STOCKAGE")
    private String ARTICLE_UNITE_STOCKAGE;

    @ColumnInfo(name = "ARTICLE_ETAT")
    private int ARTICLE_ETAT;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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

    public int getARTICLE_NATURE_ID() {
        return ARTICLE_NATURE_ID;
    }

    public void setARTICLE_NATURE_ID(int ARTICLE_NATURE_ID) {
        this.ARTICLE_NATURE_ID = ARTICLE_NATURE_ID;
    }

    public String getARTICLE_BARCODE() {
        return ARTICLE_BARCODE;
    }

    public void setARTICLE_BARCODE(String ARTICLE_BARCODE) {
        this.ARTICLE_BARCODE = ARTICLE_BARCODE;
    }

    public int getINVENTAIRE_ID() {
        return INVENTAIRE_ID;
    }

    public void setINVENTAIRE_ID(int INVENTAIRE_ID) {
        this.INVENTAIRE_ID = INVENTAIRE_ID;
    }

    public String getARTICLE_UNITE_REFERENCE() {
        return ARTICLE_UNITE_REFERENCE;
    }

    public void setARTICLE_UNITE_REFERENCE(String ARTICLE_UNITE_REFERENCE) {
        this.ARTICLE_UNITE_REFERENCE = ARTICLE_UNITE_REFERENCE;
    }

    public String getARTICLE_UNITE_STOCKAGE() {
        return ARTICLE_UNITE_STOCKAGE;
    }

    public void setARTICLE_UNITE_STOCKAGE(String ARTICLE_UNITE_STOCKAGE) {
        this.ARTICLE_UNITE_STOCKAGE = ARTICLE_UNITE_STOCKAGE;
    }

    public int getARTICLE_ETAT() {
        return ARTICLE_ETAT;
    }

    public void setARTICLE_ETAT(int ARTICLE_ETAT) {
        this.ARTICLE_ETAT = ARTICLE_ETAT;
    }
}
