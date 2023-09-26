package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.P_USER;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface P_USERDao {
    @Query("Delete  FROM USERS ")
    void deleteAll();

    @Query("SELECT * FROM USERS ")
    List<P_USER> getAllUsers();

    @Query("SELECT * FROM USERS where USR_LOGIN=:USR_LOGIN and USR_PWD=:USR_PWD")
    P_USER getUserByLoginPWD(String USR_LOGIN, String USR_PWD);

    @Query(" SELECT * FROM USERS where USR_ID=:USER_ID  ")
    P_USER getUsersUSER_ID(int  USER_ID  );

    @Transaction
    @Insert
    long insertUSERS(P_USER users);
}
