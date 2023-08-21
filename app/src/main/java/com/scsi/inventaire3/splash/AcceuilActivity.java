package com.scsi.inventaire3.splash;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.scsi.inventaire3.ParametrageActivity;
import com.scsi.inventaire3.R;
import com.scsi.inventaire3.authentification.LoginActivity;
import com.scsi.inventaire3.bdd.entity.USERS;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;

import java.io.File;

import static android.os.Build.VERSION.SDK_INT;
import static com.scsi.inventaire3.divers.Utils.GET_SHARED_USER_ID;
import static com.scsi.inventaire3.divers.Utils.checkAndRequestPermissions;

public class AcceuilActivity extends AppCompatActivity {
     @BindView(R.id.txt_indication)
    TextView txt_indication;
    @BindView(R.id.txt_valider)
    TextView txt_valider;
    @BindView(R.id.txt_params)
    TextView txt_params;
    @BindView(R.id.txt_insert_user)
    TextView txt_insert_user;

    AppDatabase db;

    public static USERS USER_CONNECTED;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        this.db = AppDatabase.getAppDatabase(this);


        txt_insert_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                USERS users=new USERS();
                users.setUSR_LOGIN("1");
                users.setUSR_PWD("1");
                db.USERSDao().insertUSERS(users);
                finish();
            }
        });

        txt_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (Build.VERSION.SDK_INT >= 25) {
                    checkPermissions();
                } else {
                    init();
                }


            }
        });

        txt_params.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(AcceuilActivity.this, ParametrageActivity.class));



            }
        });


        YoYo.with(Techniques.FadeIn)
                .duration(1500)
                .repeat(500)
                .playOn(findViewById(R.id.txt_indication));
    }


    public void checkPermissions() {

        Log.e("cquestPermissions", checkAndRequestPermissions(this) + "");
        if (checkAndRequestPermissions(this)) {
            init();
        }
    }


    @Override
    protected void onResume() {


        CHECK_ALL();
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
                        startActivity(new Intent(this, LoginActivity.class));

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
                        startActivity(new Intent(this, LoginActivity.class));

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
                        startActivity(new Intent(this, LoginActivity.class));

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
                        startActivity(new Intent(this, LoginActivity.class));

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
                startActivity(new Intent(this, LoginActivity.class));

            } else if (SDK_INT == Build.VERSION_CODES.P)  //28
            {
                startActivity(new Intent(this, LoginActivity.class));

            } else if (SDK_INT == Build.VERSION_CODES.O_MR1)  //27
            {
                startActivity(new Intent(this, LoginActivity.class));

            }


        } catch (Exception e) {
            startActivity(new Intent(this, LoginActivity.class));

            e.printStackTrace();
        }


    }



    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }



    public void CHECK_ALL() {
        int COUNT_USER = 0;
        try {
            txt_indication.setVisibility(View.GONE);

            COUNT_USER = db.USERSDao().getAllUsers().size();
            if (COUNT_USER != 0) {
                int USER_ID = GET_SHARED_USER_ID(AcceuilActivity.this);
                if (USER_ID != -1) {
                    USER_CONNECTED = db.USERSDao().getUsersUSER_ID(USER_ID);
                    if (USER_CONNECTED != null) {

                    } else {

                        txt_indication.setVisibility(View.GONE);
                    }
                }
            } else {

                txt_indication.setVisibility(View.VISIBLE);
                txt_indication.setText("synchro_user");
                YoYo.with(Techniques.FadeIn)
                        .duration(1500)
                        .repeat(500)
                        .playOn(findViewById(R.id.txt_indication));
            }


        } catch (Exception e) {

            try {
                File file = new File("/sdcard/Android/MTD_V2/");
                if (!file.exists()) {
                    if (file.mkdirs())
                    {

                        txt_indication.setVisibility(View.VISIBLE);
                        txt_indication.setText("synchro_user");
                        YoYo.with(Techniques.FadeIn)
                                .duration(1500)
                                .repeat(500)
                                .playOn(findViewById(R.id.txt_indication));



                    }else
                    {

                        txt_indication.setVisibility(View.VISIBLE);
                        txt_indication.setText("verif_permission");
                        YoYo.with(Techniques.FadeIn)
                                .duration(1500)
                                .repeat(500)
                                .playOn(findViewById(R.id.txt_indication));
                    }




                }else
                {

                    txt_indication.setVisibility(View.VISIBLE);
                    txt_indication.setText("verif_permission");
                    YoYo.with(Techniques.FadeIn)
                            .duration(1500)
                            .repeat(500)
                            .playOn(findViewById(R.id.txt_indication));
                }
            } catch (Exception exception) {
                exception.printStackTrace();

                txt_indication.setVisibility(View.VISIBLE);
                txt_indication.setText("verif_permission");
                YoYo.with(Techniques.FadeIn)
                        .duration(1500)
                        .repeat(500)
                        .playOn(findViewById(R.id.txt_indication));
            }



            e.printStackTrace();
        }
    }


}