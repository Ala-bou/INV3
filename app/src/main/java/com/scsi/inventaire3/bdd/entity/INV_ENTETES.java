package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "INV_ENTETES")
public class INV_ENTETES {

    @ColumnInfo(name = "COL_ID")
    private int COL_ID;

    @ColumnInfo(name = "DEP_ID")
    private int DEP_ID;

    @ColumnInfo(name = "ENT_CODE")
    private String ENT_CODE;

    @ColumnInfo(name = "ENT_COMPTAGE")
    private int ENT_COMPTAGE;

    @ColumnInfo(name = "ENT_DATE")
    private String ENT_DATE;

    @ColumnInfo(name = "ENT_DATECLOTURE")
    private String ENT_DATECLOTURE;

    @ColumnInfo(name = "ENT_DATECREATE")
    private String ENT_DATECREATE;

    @ColumnInfo(name = "ENT_DOS")
    private String ENT_DOS;

    @ColumnInfo(name = "ENT_ID")
    private int ENT_ID;

    @ColumnInfo(name = "ENT_INTITULE")
    private String ENT_INTITULE;

    @ColumnInfo(name = "ENT_NOTE_CLOTURE")
    private String ENT_NOTE_CLOTURE;

    @ColumnInfo(name = "ENT_NOTE_CREATE")
    private String ENT_NOTE_CREATE;

    @ColumnInfo(name = "ENT_PRINCIPAL_ID")
    private int ENT_PRINCIPAL_ID;

    @ColumnInfo(name = "ENT_STATUT")
    private int ENT_STATUT;

    @ColumnInfo(name = "ENT_TYPE_SCAN")
    private int ENT_TYPE_SCAN;

    @ColumnInfo(name = "ENT_USERCREATE")
    private String ENT_USERCREATE;

    @ColumnInfo(name = "USR_ID")
    private int USR_ID;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;

    public int getENT_TYPE_SCAN() {
        return this.ENT_TYPE_SCAN;
    }

    public void setENT_TYPE_SCAN(int ENT_TYPE_SCAN) {
        this.ENT_TYPE_SCAN = ENT_TYPE_SCAN;
    }

    public String getENT_DATE() {
        return this.ENT_DATE;
    }

    public void setENT_DATE(String ENT_DATE) {
        this.ENT_DATE = ENT_DATE;
    }

    public String getENT_DOS() {
        return this.ENT_DOS;
    }

    public void setENT_DOS(String ENT_DOS) {
        this.ENT_DOS = ENT_DOS;
    }

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getENT_ID() {
        return this.ENT_ID;
    }

    public void setENT_ID(int ENT_ID) {
        this.ENT_ID = ENT_ID;
    }

    public int getENT_COMPTAGE() {
        return this.ENT_COMPTAGE;
    }

    public void setENT_COMPTAGE(int ENT_COMPTAGE) {
        this.ENT_COMPTAGE = ENT_COMPTAGE;
    }

    public int getUSR_ID() {
        return this.USR_ID;
    }

    public void setUSR_ID(int USR_ID) {
        this.USR_ID = USR_ID;
    }

    public int getDEP_ID() {
        return this.DEP_ID;
    }

    public void setDEP_ID(int DEP_ID) {
        this.DEP_ID = DEP_ID;
    }

    public int getENT_PRINCIPAL_ID() {
        return this.ENT_PRINCIPAL_ID;
    }

    public void setENT_PRINCIPAL_ID(int ENT_PRINCIPAL_ID) {
        this.ENT_PRINCIPAL_ID = ENT_PRINCIPAL_ID;
    }

    public int getCOL_ID() {
        return this.COL_ID;
    }

    public void setCOL_ID(int COL_ID) {
        this.COL_ID = COL_ID;
    }

    public int getENT_STATUT() {
        return this.ENT_STATUT;
    }

    public void setENT_STATUT(int ENT_STATUT) {
        this.ENT_STATUT = ENT_STATUT;
    }

    public String getENT_CODE() {
        return this.ENT_CODE;
    }

    public void setENT_CODE(String ENT_CODE) {
        this.ENT_CODE = ENT_CODE;
    }

    public String getENT_INTITULE() {
        return this.ENT_INTITULE;
    }

    public void setENT_INTITULE(String ENT_INTITULE) {
        this.ENT_INTITULE = ENT_INTITULE;
    }

    public String getENT_NOTE_CREATE() {
        return this.ENT_NOTE_CREATE;
    }

    public void setENT_NOTE_CREATE(String ENT_NOTE_CREATE) {
        this.ENT_NOTE_CREATE = ENT_NOTE_CREATE;
    }

    public String getENT_NOTE_CLOTURE() {
        return this.ENT_NOTE_CLOTURE;
    }

    public void setENT_NOTE_CLOTURE(String ENT_NOTE_CLOTURE) {
        this.ENT_NOTE_CLOTURE = ENT_NOTE_CLOTURE;
    }

    public String getENT_DATECREATE() {
        return this.ENT_DATECREATE;
    }

    public void setENT_DATECREATE(String ENT_DATECREATE) {
        this.ENT_DATECREATE = ENT_DATECREATE;
    }

    public String getENT_USERCREATE() {
        return this.ENT_USERCREATE;
    }

    public void setENT_USERCREATE(String ENT_USERCREATE) {
        this.ENT_USERCREATE = ENT_USERCREATE;
    }

    public String getENT_DATECLOTURE() {
        return this.ENT_DATECLOTURE;
    }

    public void setENT_DATECLOTURE(String ENT_DATECLOTURE) {
        this.ENT_DATECLOTURE = ENT_DATECLOTURE;
    }
}
