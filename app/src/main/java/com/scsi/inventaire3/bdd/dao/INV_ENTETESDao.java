package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.INV_ENTETES;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

@Dao
public interface INV_ENTETESDao {
    @Query("Delete  FROM INV_ENTETES ")
    void deleteAll();

    @Query("SELECT * FROM INV_ENTETES ")
    List<INV_ENTETES> getAllINV_ENTETES();

    @Query("SELECT * FROM INV_ENTETES ")
    INV_ENTETES getINV_ENTETES();

    @Transaction
    @Insert
    long insertINV_ENTETES(INV_ENTETES inv_entetes);

    @Update
    void updateINV_ENTETES(INV_ENTETES inv_entetes);
}
