package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.HST_SCAN;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;


@Dao
public interface HST_SCANDao {
    @Query("Delete  FROM HST_SCAN ")
    void deleteAll();

    @Query("SELECT * FROM HST_SCAN ")
    List<HST_SCAN> getAllHST_SCAN();

    @Query("SELECT MAX(_id) FROM HST_SCAN")
    int getMaxId();

    @Transaction
    @Insert
    long insertHST_SCAN(HST_SCAN hst_scan);
}
