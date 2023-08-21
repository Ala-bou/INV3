package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.ZONES;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface ZONESDao {
    @Query("Delete  FROM ZONES ")
    void deleteAll();

    @Query("SELECT * FROM ZONES ")
    List<ZONES> getAllZONES();

    @Query("SELECT * FROM ZONES where ZN_INTITULE=:ZN_INTITULE")
    ZONES getZONES_BY_INTITULE(String ZN_INTITULE);

    @Transaction
    @Insert
    long insertZONES(ZONES zones);
}
