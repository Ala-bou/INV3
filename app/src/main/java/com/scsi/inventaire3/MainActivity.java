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
import com.scsi.inventaire3.bdd.entity.T_EMPLACEMENT;
import com.scsi.inventaire3.bdd.entity.T_ZONE;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;
import com.scsi.inventaire3.resultat.RESULT_INEXISTANTActivity;
import com.scsi.inventaire3.resultat.Resultat_existActivity;
import com.scsi.inventaire3.splash.SplashAuthActivity;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.scsi.inventaire3.authentification.LoginActivity.invEntetes;
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
    @BindView(R.id.txt_nom_inventaire)
    TextView txt_nom_inventaire;
    @BindView(R.id.txt_code_inventaire)
    TextView txt_code_inventaire;
    @BindView(R.id.txt_date_inventaire)
    TextView txt_date_inventaire;
    @BindView(R.id.txt_comptage_inventaire)
    TextView txt_comptage_inventaire;

    @BindView(R.id.txt_total_inv)
    TextView txt_total_inv;

    @BindView(R.id.total_inexistant)
    TextView total_inexistant;

    @BindView(R.id.lin_resultat_existe)
    LinearLayout lin_resultat_existe;
    @BindView(R.id.lin_resultat_inexistant)
    LinearLayout lin_resultat_inexistant;

    public static T_ZONE zonnesChoisen = new T_ZONE();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.db = AppDatabase.getAppDatabase(this);



         List<T_EMPLACEMENT> emplacementList = this.db.T_EMPLACEMENTDao().getAllEMPLACEMENT();

        EMPLACEMENTAdapter emplacementAdapter = new EMPLACEMENTAdapter(this, emplacementList);
        this.gridView_emplacement.setAdapter((ListAdapter) emplacementAdapter);

   List<T_ZONE> zonesList = this.db.ZONESDao().getAllZONES();
        ZONNESAdapter zonnesAdapter = new ZONNESAdapter(this, zonesList);
        this.gridView_zonne.setAdapter((ListAdapter) zonnesAdapter);

        txt_nom_inventaire.setText(invEntetes.getINVENTAIRE_INTITULE() + "");
        txt_code_inventaire.setText(invEntetes.getINVENTAIRE_CODE() + "");
        txt_date_inventaire.setText(invEntetes.getINVENTAIRE_DATE() + "");
        txt_comptage_inventaire.setText(invEntetes.getINVENTAIRE_COMPTAGE() + "");

        int SUM_INEXISTANT = this.db.T_RESULTATDao().getAllRESULTAT_INVENTAIRE_INEXISTANT().size();
        int SUM_EXISTE = this.db.T_RESULTATDao().getAllRESULTAT_INVENTAIRE_EXIST().size();
        total_inexistant.setText(SUM_INEXISTANT + "");
        txt_total_inv.setText(SUM_EXISTE + "");


        this.lin_resultat_existe.setOnClickListener(new View.OnClickListener() { // from class: com.scsi.inventairestock.MainActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Resultat_existActivity.class);
                MainActivity.this.startActivity(i);
            }
        });
        this.lin_resultat_inexistant.setOnClickListener(new View.OnClickListener() { // from class: com.scsi.inventairestock.MainActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RESULT_INEXISTANTActivity.class);
                MainActivity.this.startActivity(i);
            }
        });





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
                livreur.setText(USER_CONNECTED.getUSER_NAME() + "");

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