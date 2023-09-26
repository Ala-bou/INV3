package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "T_HISTORIQUE_INVENTAIRE")
public class T_HISTORIQUE_INVENTAIRE {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;



    @ColumnInfo(name = "INVENTAIRE_HIST_ID")
    private int INVENTAIRE_HIST_ID;

    @ColumnInfo(name = "INVENTAIRE_ID")
    private int INVENTAIRE_ID;

    @ColumnInfo(name = "HIST_SCAN_DATE")
    private String HIST_SCAN_DATE;

    @ColumnInfo(name = "HIST_SCAN_ETAT")
    private int HIST_SCAN_ETAT;

    @ColumnInfo(name = "HIST_SCAN_DESCRIPTION")
    private String HIST_SCAN_DESCRIPTION;

    @ColumnInfo(name = "HIST_SCAN_COMMENTAIRE")
    private String HIST_SCAN_COMMENTAIRE;

    @ColumnInfo(name = "USER_ID")
    private int USER_ID;


    @ColumnInfo(name = "USER_NAME")
    private String USER_NAME;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getINVENTAIRE_HIST_ID() {
        return INVENTAIRE_HIST_ID;
    }

    public void setINVENTAIRE_HIST_ID(int INVENTAIRE_HIST_ID) {
        this.INVENTAIRE_HIST_ID = INVENTAIRE_HIST_ID;
    }

    public int getINVENTAIRE_ID() {
        return INVENTAIRE_ID;
    }

    public void setINVENTAIRE_ID(int INVENTAIRE_ID) {
        this.INVENTAIRE_ID = INVENTAIRE_ID;
    }

    public String getHIST_SCAN_DATE() {
        return HIST_SCAN_DATE;
    }

    public void setHIST_SCAN_DATE(String HIST_SCAN_DATE) {
        this.HIST_SCAN_DATE = HIST_SCAN_DATE;
    }

    public int getHIST_SCAN_ETAT() {
        return HIST_SCAN_ETAT;
    }

    public void setHIST_SCAN_ETAT(int HIST_SCAN_ETAT) {
        this.HIST_SCAN_ETAT = HIST_SCAN_ETAT;
    }

    public String getHIST_SCAN_DESCRIPTION() {
        return HIST_SCAN_DESCRIPTION;
    }

    public void setHIST_SCAN_DESCRIPTION(String HIST_SCAN_DESCRIPTION) {
        this.HIST_SCAN_DESCRIPTION = HIST_SCAN_DESCRIPTION;
    }

    public String getHIST_SCAN_COMMENTAIRE() {
        return HIST_SCAN_COMMENTAIRE;
    }

    public void setHIST_SCAN_COMMENTAIRE(String HIST_SCAN_COMMENTAIRE) {
        this.HIST_SCAN_COMMENTAIRE = HIST_SCAN_COMMENTAIRE;
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
}
