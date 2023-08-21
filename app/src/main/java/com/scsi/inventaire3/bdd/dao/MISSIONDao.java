package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.MISSION;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

@Dao

public interface MISSIONDao {
    @Query("Delete  FROM MISSION ")
    void deleteAll();

    @Query("SELECT * FROM MISSION order by M_STATUT ,ZONE DESC , EMP_CODE DESC")
    List<MISSION> getMISSION();

    @Query("SELECT * FROM MISSION where ART_CODE=:ART_CODE")
    List<MISSION> getMISSION_BY_ARTCODE(String ART_CODE);

    @Query("SELECT * FROM MISSION where ART_CODE=:ART_CODE and LS_NO=:LS_NO")
    MISSION getMISSION_BY_ARTCODE_LOT(String ART_CODE, String LS_NO);

    @Query("SELECT * FROM MISSION where M_STATUT!=1")
    List<MISSION> getMISSION_INVALID();

    @Query("SELECT * FROM MISSION where _id=:id")
    MISSION getMISSION_by_id(int id);

    @Transaction
    @Insert
    long insertMISSION(MISSION mission);

    @Transaction
    @Update
    void updateMISSION(MISSION mission);

    @Query("Update MISSION SET M_STATUT=1 where ART_CODE=:ART_CODE")
    void update_statut(String ART_CODE);
}
