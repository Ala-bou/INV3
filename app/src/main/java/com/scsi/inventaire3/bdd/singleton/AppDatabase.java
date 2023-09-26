package com.scsi.inventaire3.bdd.singleton;

import android.content.Context;

import com.scsi.inventaire3.bdd.dao.P_USERDao;
import com.scsi.inventaire3.bdd.dao.T_ARTICLEDao;
import com.scsi.inventaire3.bdd.dao.T_EMPLACEMENTDao;
import com.scsi.inventaire3.bdd.dao.T_HISTORIQUE_INVENTAIREDao;
import com.scsi.inventaire3.bdd.dao.T_INVENTAIREDao;
import com.scsi.inventaire3.bdd.dao.T_RESULTATDao;
import com.scsi.inventaire3.bdd.dao.T_STOCK_DETAILDao;
import com.scsi.inventaire3.bdd.dao.T_ZONEDao;
import com.scsi.inventaire3.bdd.entity.T_ARTICLE;
import com.scsi.inventaire3.bdd.entity.T_EMPLACEMENT;
import com.scsi.inventaire3.bdd.entity.T_HISTORIQUE_INVENTAIRE;
import com.scsi.inventaire3.bdd.entity.T_INVENTAIRE;
import com.scsi.inventaire3.bdd.entity.P_USER;
import com.scsi.inventaire3.bdd.entity.T_RESULTAT;
import com.scsi.inventaire3.bdd.entity.T_STOCK_DETAIL;
import com.scsi.inventaire3.bdd.entity.T_ZONE;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {T_HISTORIQUE_INVENTAIRE.class, T_ARTICLE.class, T_EMPLACEMENT.class, T_INVENTAIRE.class,   T_RESULTAT.class, T_STOCK_DETAIL.class,  P_USER.class, T_ZONE.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract P_USERDao P_USERDao();

    public abstract T_ARTICLEDao T_ARTICLEDao();

    public abstract T_EMPLACEMENTDao T_EMPLACEMENTDao();

    public abstract T_HISTORIQUE_INVENTAIREDao T_HISTORIQUE_INVENTAIREDao();

    public abstract T_INVENTAIREDao T_INVENTAIREDao();

    public abstract T_RESULTATDao T_RESULTATDao();

    public abstract T_STOCK_DETAILDao T_STOCK_DETAILDao();

    public abstract T_ZONEDao T_ZONEDao();


    public abstract P_USERDao USERSDao();

    public abstract T_ZONEDao ZONESDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = (AppDatabase) Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "/sdcard/Android/INVENTAIRE_3/INVENTAIRE.db")
                    .allowMainThreadQueries()

                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
