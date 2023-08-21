package com.scsi.inventaire3.bdd.dao;


import com.scsi.inventaire3.bdd.entity.USERS;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface USERSDao {
    @Query("Delete  FROM USERS ")
    void deleteAll();

    @Query("SELECT * FROM USERS ")
    List<USERS> getAllUsers();

    @Query("SELECT * FROM USERS where USR_LOGIN=:USR_LOGIN and USR_PWD=:USR_PWD")
    USERS getUserByLoginPWD(String USR_LOGIN, String USR_PWD);

    @Query(" SELECT * FROM USERS where USR_ID=:USER_ID  ")
    USERS getUsersUSER_ID(int  USER_ID  );

    @Transaction
    @Insert
    long insertUSERS(USERS users);
}
