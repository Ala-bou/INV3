package com.scsi.inventaire3.bdd.dao;



import com.scsi.inventaire3.bdd.entity.T_STOCK_DETAIL;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface T_STOCK_DETAILDao {
    @Query("Delete  FROM T_STOCK_DETAIL ")
    void deleteAll();

    @Query("SELECT * FROM T_STOCK_DETAIL ")
    List<T_STOCK_DETAIL> getAllT_STOCK_DETAIL();


    @Transaction
    @Insert
    long insertT_STOCK_DETAIL(T_STOCK_DETAIL T_STOCK_DETAIL);
}
