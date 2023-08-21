package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.ARTICLES;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface ARTICLESDao {
    @Query("Delete  FROM ARTICLES ")
    void deleteAll();

    @Query("SELECT * FROM ARTICLES  where ART_CODE=:ARTCODE")
    ARTICLES getARTICLESByARTCODE(String ARTCODE);

    @Query("SELECT * FROM ARTICLES  where ART_BARCODE=:ARTCODE")
    ARTICLES getARTICLESByBARCODE(String ARTCODE);

    @Query("SELECT * FROM ARTICLES ")
    List<ARTICLES> getAllARTICLES();




    @Query("SELECT DISTINCT ART_GAMME1_INTITULE FROM ARTICLES  where ART_GAMME1=:ART_GAMME1 and ART_GAMME1!=''")
    String getGAMME1_INTITULE_ART_GAMME1(String ART_GAMME1);




    @Query("SELECT DISTINCT ART_GAMME2_INTITULE FROM ARTICLES  where ART_GAMME2=:ART_GAMME2")
    String getGAMME2_INTITULE_ART_GAMME2(String ART_GAMME2);


    @Query("SELECT * FROM ARTICLES  where ART_GAMME1 !='' and ART_GAMME1 is not NULL and ART_GAMME1 !='null'and ART_GAMME1 !='NULL' and ART_CODE=:ART_CODE GROUP by ART_GAMME1")
    List<ARTICLES> getlISTgAMME1(String ART_CODE);


    @Query("SELECT * FROM ARTICLES  where ART_GAMME1=:GAMME1")
    List<ARTICLES> getlISTgAMME2(String GAMME1);

    @Transaction
    @Insert
    long insertARTICLES(ARTICLES articles);


    @Transaction
    @Insert
    void insert_LIDT_OF_ARTICLE(List<ARTICLES> list);
}
