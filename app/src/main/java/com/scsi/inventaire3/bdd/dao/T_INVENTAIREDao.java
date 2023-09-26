package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.T_INVENTAIRE;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

@Dao
public interface T_INVENTAIREDao {
    @Query("Delete  FROM T_INVENTAIRE ")
    void deleteAll();

    @Query("SELECT * FROM T_INVENTAIRE ")
    List<T_INVENTAIRE> getAllINV_ENTETES();

    @Query("SELECT * FROM T_INVENTAIRE ")
    T_INVENTAIRE getINV_ENTETES();

    @Transaction
    @Insert
    long insertINV_ENTETES(T_INVENTAIRE inv_entetes);

    @Update
    void updateINV_ENTETES(T_INVENTAIRE inv_entetes);
}
