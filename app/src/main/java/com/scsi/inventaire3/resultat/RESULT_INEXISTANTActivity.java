package com.scsi.inventaire3.resultat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;


import com.scsi.inventaire3.R;
import com.scsi.inventaire3.bdd.entity.T_RESULTAT;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;
import com.scsi.inventaire3.resultat.adapter.InexistantAdapter;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/* loaded from: classes2.dex */
public class RESULT_INEXISTANTActivity extends AppCompatActivity {
    AppDatabase db;
    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.list_result)
    ListView list_result;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_result__inexistant);
        ButterKnife.bind(this);
        this.db = AppDatabase.getAppDatabase(this);
        this.img_back.setOnClickListener(new View.OnClickListener() { // from class: com.scsi.inventairestock.resultat.RESULT_INEXISTANTActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RESULT_INEXISTANTActivity.this.finish();
            }
        });
        List<T_RESULTAT> resultat_inventaires = this.db.T_RESULTATDao().getAllRESULTAT_INVENTAIRE_INEXISTANT();
        InexistantAdapter resultatAdapter = new InexistantAdapter(this, resultat_inventaires);
        this.list_result.setAdapter((ListAdapter) resultatAdapter);
    }
}
