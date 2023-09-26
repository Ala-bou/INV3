package com.scsi.inventaire3.divers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.database.SQLException;

import com.scsi.inventaire3.bdd.entity.T_EMPLACEMENT;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.scsi.inventaire3.divers.Popups.show_dialog_error;
import static com.scsi.inventaire3.divers.Popups.show_dialog_succes;
import static com.scsi.inventaire3.divers.Utils.GET_INT;
import static com.scsi.inventaire3.divers.Utils.GET_STRING;

public class Syncro {


    public static void PARSE_DATA(JSONObject DATA, ProgressDialog pDialog, String MESSAGE, Activity activity, int IS_DASHBOARD, int WITH_FINISH) throws Exception {

        AppDatabase db = AppDatabase.getAppDatabase(activity);

        JSONArray T_EMPLACEMENT_ARRAY = DATA.getJSONArray("T_EMPLACEMENT");


        try {


            db.beginTransaction();
            db.T_EMPLACEMENTDao().deleteAll();


            /**
             * T_EMPLACEMENT
             */
            for (int j = 0; j < T_EMPLACEMENT_ARRAY.length(); j++) {
                JSONObject POSTION_OBJECT = T_EMPLACEMENT_ARRAY.getJSONObject(j);
                T_EMPLACEMENT t_emplacement = new T_EMPLACEMENT();
                t_emplacement.setEMPLACEMENT_ID(GET_INT(POSTION_OBJECT.getString("EMPLACEMENT_ID")));
                t_emplacement.setEMPLACEMENT_CODE(GET_INT(POSTION_OBJECT.getString("EMPLACEMENT_CODE")));
                t_emplacement.set(GET_INT(POSTION_OBJECT.getString("POSID")));
                t_emplacement.set(GET_INT(POSTION_OBJECT.getString("POSID")));
                t_emplacement.set(GET_INT(POSTION_OBJECT.getString("POSID")));
                t_emplacement.set(GET_INT(POSTION_OBJECT.getString("POSID")));
                t_emplacement.set(GET_INT(POSTION_OBJECT.getString("POSID")));


                db.POSITIONDao().insertPOSITION(postion);
            }



            db.setTransactionSuccessful();
            show_dialog_succes(MESSAGE, activity, WITH_FINISH);

        } catch (SQLException e) {
            pDialog.dismiss();
            show_dialog_error("Problème de connexion avec le serveur", activity, WITH_FINISH);
        } finally {
            db.endTransaction();
            pDialog.dismiss();



        }


    }

}
