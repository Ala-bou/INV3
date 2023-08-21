package com.scsi.inventaire3.bdd.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "EMPLACEMENT")
public class EMPLACEMENT {

    @ColumnInfo(name = "DEP_CODE")
    private String DEP_CODE;

    @ColumnInfo(name = "DEP_DOS")
    private String DEP_DOS;

    @ColumnInfo(name = "DEP_ID_ERP")
    private int DEP_ID_ERP;

    @ColumnInfo(name = "DEP_INTITULE")
    private String DEP_INTITULE;

    @ColumnInfo(name = "EMP_CODE")
    private String EMP_CODE;

    @ColumnInfo(name = "EMP_ID")
    private int EMP_ID;

    @ColumnInfo(name = "EMP_INTITULE")
    private String EMP_INTITULE;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;

    public int getEMP_ID() {
        return this.EMP_ID;
    }

    public void setEMP_ID(int EMP_ID) {
        this.EMP_ID = EMP_ID;
    }

    public int getDEP_ID_ERP() {
        return this.DEP_ID_ERP;
    }

    public void setDEP_ID_ERP(int DEP_ID_ERP) {
        this.DEP_ID_ERP = DEP_ID_ERP;
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

    public String getDEP_DOS() {
        return this.DEP_DOS;
    }

    public void setDEP_DOS(String DEP_DOS) {
        this.DEP_DOS = DEP_DOS;
    }

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
