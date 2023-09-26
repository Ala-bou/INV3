package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.T_HISTORIQUE_INVENTAIRE;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;


@Dao
public interface T_HISTORIQUE_INVENTAIREDao {
    @Query("Delete  FROM T_HISTORIQUE_INVENTAIRE ")
    void deleteAll();

    @Query("SELECT * FROM T_HISTORIQUE_INVENTAIRE ")
    List<T_HISTORIQUE_INVENTAIRE> getAllHST_SCAN();

    @Query("SELECT MAX(_id) FROM T_HISTORIQUE_INVENTAIRE")
    int getMaxId();

    @Transaction
    @Insert
    long insertHST_SCAN(T_HISTORIQUE_INVENTAIRE hst_scan);
}
