package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.T_EMPLACEMENT;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface T_EMPLACEMENTDao {
    @Query("Delete  FROM T_EMPLACEMENT ")
    void deleteAll();

    @Query("SELECT * FROM T_EMPLACEMENT ")
    List<T_EMPLACEMENT> getAllEMPLACEMENT();

    @Transaction
    @Insert
    long insertEMPLACEMENT(T_EMPLACEMENT emplacement);
}
