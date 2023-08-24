package com.scsi.inventaire3;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.jess.ui.TwoWayGridView;
import com.scsi.inventaire3.adapter.EMPLACEMENTAdapter;
import com.scsi.inventaire3.adapter.ZONNESAdapter;
import com.scsi.inventaire3.authentification.LoginActivity;
import com.scsi.inventaire3.bdd.entity.EMPLACEMENT;
import com.scsi.inventaire3.bdd.entity.ZONES;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;
import com.scsi.inventaire3.splash.SplashAuthActivity;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.scsi.inventaire3.divers.Utils.GET_SHARED_USER_ID;
import static com.scsi.inventaire3.divers.Utils.insert_shared_user;
import static com.scsi.inventaire3.splash.AcceuilActivity.USER_CONNECTED;

public class MainActivity extends AppCompatActivity {
    SlidingRootNavBuilder slidingRootNavBuilder;
    SlidingRootNav slidingRootNav;
    AppDatabase db;

    @BindView(R.id.img_menu)
    ImageView img_menu;

    @BindView(R.id.gridView_emplacement)
    TwoWayGridView gridView_emplacement;
    @BindView(R.id.gridView_zonne)
    TwoWayGridView gridView_zonne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.db = AppDatabase.getAppDatabase(this);




        EMPLACEMENT emplacement =new EMPLACEMENT();
        emplacement.setEMP_CODE("EMP1");
        List<EMPLACEMENT> emplacementList=new ArrayList<>();
       // List<EMPLACEMENT> emplacementList = this.db.EMPLACEMENTDao().getAllEMPLACEMENT();

        emplacementList.add(emplacement);
        emplacementList.add(emplacement);
        emplacementList.add(emplacement);
        emplacementList.add(emplacement);
        emplacementList.add(emplacement);
        EMPLACEMENTAdapter emplacementAdapter = new EMPLACEMENTAdapter(this, emplacementList);
        this.gridView_emplacement.setAdapter((ListAdapter) emplacementAdapter);
        List<ZONES> zonesList = new ArrayList<>();
        ZONES zones=new ZONES();
        zones.setZN_CODE("ZN1");
        zonesList.add(zones);
        zonesList.add(zones);
        zonesList.add(zones);
        zonesList.add(zones);
        zonesList.add(zones);
       // List<ZONES> zonesList = this.db.ZONESDao().getAllZONES();
        ZONNESAdapter zonnesAdapter = new ZONNESAdapter(this, zonesList);
        this.gridView_zonne.setAdapter((ListAdapter) zonnesAdapter);

    }


    @Override
    protected void onResume() {

        SETUP_DRAWER();
        super.onResume();
    }

    public void SETUP_DRAWER() {
        this.slidingRootNavBuilder = new SlidingRootNavBuilder(this).withMenuLayout(R.layout.menu_layout);
        this.slidingRootNav = this.slidingRootNavBuilder.inject();


        img_menu.setOnClickListener(new View.OnClickListener() { // from class: com.scsi.mtd_verion_2.MainActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (slidingRootNav.isMenuOpened()) {
                    slidingRootNav.closeMenu();
                } else {
                    slidingRootNav.openMenu();
                }
            }
        });


        TextView livreur = findViewById(R.id.livreur);
        LinearLayout lin_deconnexion = findViewById(R.id.lin_deconnexion);
        LinearLayout lin_parametrage = (LinearLayout) findViewById(R.id.lin_parametrage);

            try {
                 if (USER_CONNECTED == null) {
                     insert_shared_user(MainActivity.this, -1);

                    Intent intent = new Intent(getApplicationContext(), SplashAuthActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK |
                            Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {
                    livreur.setText(USER_CONNECTED.getUSR_NOM_COMPLET()+"");

                }
            } catch (Exception e) {
                insert_shared_user(MainActivity.this, -1);

                Intent intent = new Intent(getApplicationContext(), SplashAuthActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }


        lin_deconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert_shared_user(MainActivity.this, -1);

                Intent intent = new Intent(getApplicationContext(), SplashAuthActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        lin_parametrage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cloture = new Intent(MainActivity.this, ParametrageActivity.class);
                startActivity(cloture);
            }
        });



}
}