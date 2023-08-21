package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.STK_GAMME;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

@Dao
public interface STK_GAMMEDao {



    @Query("Delete  FROM STK_GAMME ")
    void deleteAll();

    @Query("SELECT * FROM STK_GAMME where  MB_FLAG=2")
    List<STK_GAMME> getALL_STK_ADDED();

    @Query("SELECT * FROM STK_GAMME ")
    List<STK_GAMME> getALL_STK_GAMME();
    @Query("SELECT * FROM STK_GAMME where MB_FLAG!=0")

    List<STK_GAMME> getALL_STK_GAMME_cloture();
    @Query("SELECT * FROM STK_GAMME where  MB_FLAG=1 or MB_FLAG=2 or MB_FLAG=3")

    List<STK_GAMME> getALL_STK_SUM();

    @Query("SELECT * FROM STK_GAMME where  MB_FLAG=1")
    List<STK_GAMME> getALL_STK_UPDATED();

    @Query("SELECT * FROM STK_GAMME ")
    List<STK_GAMME> getAllSTK_GAMME();

    @Query("SELECT MAX(_id) FROM STK_GAMME")
    int getMaxId();

    @Query("SELECT * FROM STK_GAMME where ART_CODE=:ART_CODE and ART_GAMME1=:ART_GAMME1 and ART_GAMME2=:ART_GAMME2 and MB_EMP_SCANNE=:MB_EMP_SCANNE")
    STK_GAMME getSTK_GAMME(String ART_CODE, String ART_GAMME1, String ART_GAMME2, String MB_EMP_SCANNE);

    @Query("SELECT * FROM STK_GAMME")
    STK_GAMME getUser();
    @Transaction
    @Insert
    long insertSTK_GAMME(STK_GAMME stk_gamme);
    @Update
    void updateSTK_GAMME(STK_GAMME stk_gamme);
}
