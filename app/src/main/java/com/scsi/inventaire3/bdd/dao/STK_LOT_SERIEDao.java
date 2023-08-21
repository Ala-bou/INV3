package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.STK_LOT_SERIE;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

@Dao
public interface STK_LOT_SERIEDao {
    @Query("Delete  FROM STK_LOT_SERIE ")
    void deleteAll();

    @Query("select DISTINCT LS_NO FROM STK_LOT_SERIE where LS_NO is not NULL and LS_NO !='' and LS_NO!='null' and ART_TYPESTOCK=:ART_TYPESTOCK and ART_CODE=:ART_CODE ")
    List<String> getAllLS_NO(int ART_TYPESTOCK, String ART_CODE);


    @Query("SELECT * FROM STK_LOT_SERIE  where ART_CODE=:ART_CODE and  LS_NO =:LS_NO ")
    STK_LOT_SERIE getLOT_SERIE(String ART_CODE, String LS_NO);

    @Query("SELECT * FROM STK_LOT_SERIE  where  LS_NO =:LS_NO ")
    STK_LOT_SERIE getLOT_SERIE_BY_LS_NO(String LS_NO);



    @Query("SELECT MAX(_id) FROM STK_LOT_SERIE")
    int getMaxId();

    @Transaction
    @Insert
    long insertSTK_LOT_SERIE(STK_LOT_SERIE stk_lot_serie);

    @Transaction
    @Insert
    void insert_GROUP_OF_LOT(List<STK_LOT_SERIE> list);

    @Update
    void updateSTK_LOT_SERIE(STK_LOT_SERIE stk_lot_serie);
}
