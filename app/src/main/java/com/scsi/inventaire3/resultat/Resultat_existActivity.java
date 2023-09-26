package com.scsi.inventaire3.resultat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.scsi.inventaire3.R;
import com.scsi.inventaire3.bdd.entity.T_RESULTAT;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;
import com.scsi.inventaire3.divers.Constant;
import com.scsi.inventaire3.divers.Utils;
import com.scsi.inventaire3.resultat.adapter.ResultatGammeAdapter;
import com.scsi.inventaire3.resultat.adapter.ResultatLotAdapter;
import com.scsi.inventaire3.resultat.adapter.ResultatQuantiteAdapter;
import com.scsi.inventaire3.resultat.adapter.ResultatSerieAdapter;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/* loaded from: classes2.dex */
public class Resultat_existActivity extends AppCompatActivity {
    AppDatabase db;
    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.lin_gamme)
    LinearLayout lin_gamme;
    @BindView(R.id.lin_lot)
    LinearLayout lin_lot;
    @BindView(R.id.lin_quantite)

    /* renamed from: lin_quantité  reason: contains not printable characters */
    LinearLayout lin_quantite;
    @BindView(R.id.lin_serie)
    LinearLayout lin_serie;
    @BindView(R.id.list_result)
    ListView list_result;

    @BindView(R.id.txt_title)
    TextView txt_title;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_resultat_existe);
        ButterKnife.bind(this);
        this.db = AppDatabase.getAppDatabase(this);
        this.img_back.setOnClickListener(new View.OnClickListener() { // from class: com.scsi.inventairestock.resultat.Resultat_existActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Resultat_existActivity.this.finish();
            }
        });
        this.lin_gamme.setOnClickListener(new View.OnClickListener() { // from class: com.scsi.inventairestock.resultat.Resultat_existActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                 List<T_RESULTAT> resultat_inventaires = Resultat_existActivity.this.db.T_RESULTATDao().getAllRESULTAT_EXIST_GAMME();
                ResultatGammeAdapter resultatAdapter = new ResultatGammeAdapter(Resultat_existActivity.this, resultat_inventaires);
                Resultat_existActivity.this.list_result.setAdapter((ListAdapter) resultatAdapter);
                Resultat_existActivity.this.txt_title.setTextColor(Resultat_existActivity.this.getResources().getColor(R.color.themePurple));
            }
        });
        this.lin_lot.setOnClickListener(new View.OnClickListener() { // from class: com.scsi.inventairestock.resultat.Resultat_existActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                 Resultat_existActivity.this.txt_title.setTextColor(Resultat_existActivity.this.getResources().getColor(R.color.themeOrange));
                List<T_RESULTAT> resultat_inventaires = Resultat_existActivity.this.db.T_RESULTATDao().getAllRESULTAT_EXIST(Constant.ARTICLE_LOT);
                ResultatLotAdapter resultatAdapter = new ResultatLotAdapter(Resultat_existActivity.this, resultat_inventaires);
                Resultat_existActivity.this.list_result.setAdapter((ListAdapter) resultatAdapter);
            }
        });
        this.lin_serie.setOnClickListener(new View.OnClickListener() { // from class: com.scsi.inventairestock.resultat.Resultat_existActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                 Resultat_existActivity.this.txt_title.setTextColor(Resultat_existActivity.this.getResources().getColor(R.color.themeGreen));
                 List<T_RESULTAT> resultat_inventaires = Resultat_existActivity.this.db.T_RESULTATDao().getAllRESULTAT_EXIST(Constant.ARTICLE_SERIE);
                ResultatSerieAdapter resultatAdapter = new ResultatSerieAdapter(Resultat_existActivity.this, resultat_inventaires);
                Resultat_existActivity.this.list_result.setAdapter((ListAdapter) resultatAdapter);
            }
        });
        this.lin_quantite.setOnClickListener(new View.OnClickListener() { // from class: com.scsi.inventairestock.resultat.Resultat_existActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                 Resultat_existActivity.this.txt_title.setTextColor(Resultat_existActivity.this.getResources().getColor(R.color.themeBlue));
                 List<T_RESULTAT> resultat_inventaires = Resultat_existActivity.this.db.T_RESULTATDao().getAllRESULTAT_EXIST(Constant.ARTICLE_CNUP);
                ResultatQuantiteAdapter resultatAdapter = new ResultatQuantiteAdapter(Resultat_existActivity.this, resultat_inventaires);
                Resultat_existActivity.this.list_result.setAdapter((ListAdapter) resultatAdapter);
            }
        });
        this.lin_quantite.performClick();
    }
}
