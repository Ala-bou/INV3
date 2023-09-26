package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.T_ZONE;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface T_ZONEDao {
    @Query("Delete  FROM T_ZONE ")
    void deleteAll();

    @Query("SELECT * FROM T_ZONE ")
    List<T_ZONE> getAllZONES();

    @Query("SELECT * FROM T_ZONE where ZN_INTITULE=:ZN_INTITULE")
    T_ZONE getZONES_BY_INTITULE(String ZN_INTITULE);

    @Transaction
    @Insert
    long insertZONES(T_ZONE zones);
}
