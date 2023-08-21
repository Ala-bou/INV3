package com.scsi.inventaire3.bdd.singleton;

import android.content.Context;

import com.scsi.inventaire3.bdd.dao.ARTICLESDao;
import com.scsi.inventaire3.bdd.dao.EMPLACEMENTDao;
import com.scsi.inventaire3.bdd.dao.HST_SCANDao;
import com.scsi.inventaire3.bdd.dao.INV_ENTETESDao;
import com.scsi.inventaire3.bdd.dao.MISSIONDao;
import com.scsi.inventaire3.bdd.dao.RESULTAT_INVENTAIREDao;
import com.scsi.inventaire3.bdd.dao.STK_GAMMEDao;
import com.scsi.inventaire3.bdd.dao.STK_GLOBALDao;
import com.scsi.inventaire3.bdd.dao.STK_LOT_SERIEDao;
import com.scsi.inventaire3.bdd.dao.USERSDao;
import com.scsi.inventaire3.bdd.dao.ZONESDao;
import com.scsi.inventaire3.bdd.entity.ARTICLES;
import com.scsi.inventaire3.bdd.entity.EMPLACEMENT;
import com.scsi.inventaire3.bdd.entity.HST_SCAN;
import com.scsi.inventaire3.bdd.entity.INV_ENTETES;
import com.scsi.inventaire3.bdd.entity.MISSION;
import com.scsi.inventaire3.bdd.entity.RESULTAT_INVENTAIRE;
import com.scsi.inventaire3.bdd.entity.STK_GAMME;
import com.scsi.inventaire3.bdd.entity.STK_GLOBAL;
import com.scsi.inventaire3.bdd.entity.STK_LOT_SERIE;
import com.scsi.inventaire3.bdd.entity.USERS;
import com.scsi.inventaire3.bdd.entity.ZONES;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {HST_SCAN.class, ARTICLES.class, EMPLACEMENT.class, INV_ENTETES.class, MISSION.class, RESULTAT_INVENTAIRE.class, STK_GAMME.class, STK_GLOBAL.class, STK_LOT_SERIE.class, USERS.class, ZONES.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract ARTICLESDao ARTICLESDao();

    public abstract EMPLACEMENTDao EMPLACEMENTDao();

    public abstract HST_SCANDao HST_SCANDao();

    public abstract INV_ENTETESDao INV_ENTETESDao();

    public abstract MISSIONDao MISSIONDao();

    public abstract RESULTAT_INVENTAIREDao RESULTAT_INVENTAIREDao();

    public abstract STK_GAMMEDao STK_GAMMEDao();

    public abstract STK_GLOBALDao STK_GLOBALDao();

    public abstract STK_LOT_SERIEDao STK_LOT_SERIEDao();

    public abstract USERSDao USERSDao();

    public abstract ZONESDao ZONESDao();

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
