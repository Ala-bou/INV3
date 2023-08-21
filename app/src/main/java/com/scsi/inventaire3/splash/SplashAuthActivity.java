package com.scsi.inventaire3.splash;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;


import com.scsi.inventaire3.R;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;

import static android.os.Build.VERSION.SDK_INT;
import static com.scsi.inventaire3.divers.Utils.checkAndRequestPermissions;


public class SplashAuthActivity extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_splash_auth);

    }

    public void checkPermissions() {

        Log.e("cquestPermissions", checkAndRequestPermissions(this) + "");
        if (checkAndRequestPermissions(this)) {
            init();
        }
    }


    @Override
    protected void onResume() {


        if (Build.VERSION.SDK_INT >= 25) {
            checkPermissions();
        } else {
            init();
        }
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void init() {

        Log.e("RESUME", SDK_INT + " --------");
        try {
            if (SDK_INT == Build.VERSION_CODES.TIRAMISU)    //33
            {

                try {
                    if (Environment.isExternalStorageManager()) {
                        startActivity(new Intent(this, AcceuilActivity.class));

                        File file = new File("/sdcard/Android/INVENTAIRE_3/");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        finish();
                        // If you don't have access, launch a new activity to show the user the system's dialog
                        // to allow access to the external storage
                    } else {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (SDK_INT == Build.VERSION_CODES.S_V2)   //32
            {
                try {
                    if (Environment.isExternalStorageManager()) {
                        startActivity(new Intent(this, AcceuilActivity.class));
                        File file = new File("/sdcard/Android/INVENTAIRE_3/");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        finish();
                        // If you don't have access, launch a new activity to show the user the system's dialog
                        // to allow access to the external storage
                    } else {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (SDK_INT == Build.VERSION_CODES.S)   //31
            {
                try {
                    if (Environment.isExternalStorageManager()) {
                        startActivity(new Intent(this, AcceuilActivity.class));
                        File file = new File("/sdcard/Android/INVENTAIRE_3/");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        finish();
                        // If you don't have access, launch a new activity to show the user the system's dialog
                        // to allow access to the external storage
                    } else {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (SDK_INT == Build.VERSION_CODES.R)  //30
            {


                try {
                    if (Environment.isExternalStorageManager()) {
                        startActivity(new Intent(this, AcceuilActivity.class));
                        File file = new File("/sdcard/Android/INVENTAIRE_3/");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        finish();
                        // If you don't have access, launch a new activity to show the user the system's dialog
                        // to allow access to the external storage
                    } else {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else if (SDK_INT == Build.VERSION_CODES.Q)  //29
            {
                startActivity(new Intent(this, AcceuilActivity.class));
                File file = new File("/sdcard/Android/INVENTAIRE_3/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                finish();
            } else if (SDK_INT == Build.VERSION_CODES.P)  //28
            {
                startActivity(new Intent(this, AcceuilActivity.class));
                File file = new File("/sdcard/Android/INVENTAIRE_3/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                finish();
            } else if (SDK_INT == Build.VERSION_CODES.O_MR1)  //27
            {
                startActivity(new Intent(this, AcceuilActivity.class));
                File file = new File("/sdcard/Android/INVENTAIRE_3/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                finish();
            }


        } catch (Exception e) {
            startActivity(new Intent(this, AcceuilActivity.class));
            File file = new File("/sdcard/Android/INVENTAIRE_3/");
            if (!file.exists()) {
                file.mkdirs();
            }
            finish();
            e.printStackTrace();
        }


    }

    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}