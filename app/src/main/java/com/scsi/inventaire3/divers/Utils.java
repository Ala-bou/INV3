package com.scsi.inventaire3.divers;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;

import com.scsi.inventaire3.bdd.singleton.AppDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Utils {
    public static int TYPE_SCAN_GS1 = 0;
    public static int TYPE_SCAN_BARCODE_QR = 1;
    public static boolean checkAndRequestPermissions(Activity activity) {

        List<String> listPermissionsNeeded = new ArrayList<>();
        int CAMERA = ContextCompat.checkSelfPermission(activity, "android.permission.CAMERA");
        int ACCESS_FINE_LOCATION = ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION");
        int WRITE_EXTERNAL_STORAGE = ContextCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        int READ_MEDIA_IMAGES = ContextCompat.checkSelfPermission(activity, "android.permission.READ_MEDIA_IMAGES");
        int READ_MEDIA_VIDEO = ContextCompat.checkSelfPermission(activity, "android.permission.READ_MEDIA_VIDEO");
        int READ_MEDIA_AUDIO = ContextCompat.checkSelfPermission(activity, "android.permission.READ_MEDIA_AUDIO");
        int POST_NOTIFICATIONS = ContextCompat.checkSelfPermission(activity, "android.permission.POST_NOTIFICATIONS");
        int CALL_PHONE = ContextCompat.checkSelfPermission(activity, "android.permission.CALL_PHONE");
        int READ_PHONE_STATE = ContextCompat.checkSelfPermission(activity, "android.permission.READ_PHONE_STATE");
        int BLUETOOTH_CONNECT = ContextCompat.checkSelfPermission(activity, "android.permission.BLUETOOTH_CONNECT");
        int BLUETOOTH_SCAN = ContextCompat.checkSelfPermission(activity, "android.permission.BLUETOOTH_SCAN");





        if (CAMERA != 0) {
            listPermissionsNeeded.add("android.permission.CAMERA");
        }
        if (READ_PHONE_STATE != 0) {
            listPermissionsNeeded.add("android.permission.READ_PHONE_STATE");
        }
        if (CALL_PHONE != 0) {
            listPermissionsNeeded.add("android.permission.CALL_PHONE");
        }

        if (ACCESS_FINE_LOCATION != 0) {
            listPermissionsNeeded.add("android.permission.ACCESS_FINE_LOCATION");
        }



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Log.e("SDK_INT", Build.VERSION.SDK_INT + "   --   ");

            if (BLUETOOTH_SCAN != 0) {
                listPermissionsNeeded.add("android.permission.BLUETOOTH_SCAN");
            }
            if (BLUETOOTH_CONNECT != 0) {
                listPermissionsNeeded.add("android.permission.BLUETOOTH_CONNECT");
            }
            if (READ_MEDIA_AUDIO != 0) {
                listPermissionsNeeded.add("android.permission.READ_MEDIA_AUDIO");
            }
            if (POST_NOTIFICATIONS != 0) {
                listPermissionsNeeded.add("android.permission.POST_NOTIFICATIONS");
            }
            if (READ_MEDIA_VIDEO != 0) {
                listPermissionsNeeded.add("android.permission.READ_MEDIA_VIDEO");
            }
            if (READ_MEDIA_IMAGES != 0) {
                listPermissionsNeeded.add("android.permission.READ_MEDIA_IMAGES");
            }


        } else {
            if (WRITE_EXTERNAL_STORAGE != 0) {
                listPermissionsNeeded.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
        }


        Log.e("listPermissionsNeeded", listPermissionsNeeded.size() + "");
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(activity, (String[]) listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
            return false;

        }
        return true;
    }


    public static int GET_SHARED_USER_ID(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences("shared_user_inv_3", 0);
        int USER_ID = prefs.getInt("USER_ID", -1);
        return USER_ID;
    }


    public static void insert_shared_user(Activity activity, int USER_ID) {
        SharedPreferences.Editor editor = activity.getSharedPreferences("shared_user_inv_3", 0).edit();
        editor.putInt("USER_ID", USER_ID);
        editor.apply();
    }



    public static void insert_shared(Activity activity, String ip, String port, int qte, int douchette,int type_scan) {
        SharedPreferences.Editor editor = activity.getSharedPreferences("shared_user_inv_3", 0).edit();
        editor.putString("adr_ip", ip);
        editor.putString("port", port);
        editor.putInt("qte", qte);
        editor.putInt("douchette", douchette);
        editor.putInt("type_scan", type_scan);
        editor.apply();
    }

    public static String GET_SHARED_PORT(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences("shared_user_inv_3", 0);
        String port = prefs.getString("port", "");
        return port;
    }

    public static int GET_SHARED_QTE(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences("shared_user_inv_3", 0);
        int qte = prefs.getInt("qte", 0);
        return qte;
    }

    public static int GET_SHARED_TYPE_SCAN(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences("shared_user_inv_3", 0);
        int qte = prefs.getInt("type_scan", 0);
        return qte;
    }

    public static int GET_SHARED_DOUCHETTE(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences("shared_user_inv_3", 0);
        int qte = prefs.getInt("douchette", 0);
        return qte;
    }

    public static String GET_SHARED_IP(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences("shared_user_inv_3", 0);
        String adr_ip = prefs.getString("adr_ip", "");
        return adr_ip;
    }

    public static void DELETE_ALL(AppDatabase db) {
        db.INV_ENTETESDao().deleteAll();
        db.ARTICLESDao().deleteAll();
        db.EMPLACEMENTDao().deleteAll();
        db.ZONESDao().deleteAll();
        db.RESULTAT_INVENTAIREDao().deleteAll();
    }

    public static String data_from_json(String date) {
        Calendar calendar = Calendar.getInstance();
        String format_json = date.replace("/Date(", "").replace(")/", "");
        Long timeInMillis = Long.valueOf(format_json);
        calendar.setTimeInMillis(timeInMillis.longValue());
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(calendar.getTime());
    }


    public static String GET_STRING(String VALUE) {
        if (VALUE == null || VALUE.equals("null") || VALUE.equals("NULL") || VALUE.equals("Null")) {
            return "";
        }
        return VALUE;
    }

    public static int GET_INT(String VALUE) {
        if (VALUE == null || VALUE.equals("null") || VALUE.equals("NULL") || VALUE.equals("Null")) {
            return 0;
        }
        try {
            int VAL = Integer.parseInt(VALUE);
            return VAL;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static double GET_DOUBLE(String VALUE) {
        if (VALUE == null || VALUE.equals("null") || VALUE.equals("NULL") || VALUE.equals("Null")) {
            return 0;
        }
        try {
            double VAL = Double.parseDouble(VALUE);
            return VAL;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
