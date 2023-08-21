package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.EMPLACEMENT;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface EMPLACEMENTDao {
    @Query("Delete  FROM EMPLACEMENT ")
    void deleteAll();

    @Query("SELECT * FROM EMPLACEMENT ")
    List<EMPLACEMENT> getAllEMPLACEMENT();

    @Transaction
    @Insert
    long insertEMPLACEMENT(EMPLACEMENT emplacement);
}
