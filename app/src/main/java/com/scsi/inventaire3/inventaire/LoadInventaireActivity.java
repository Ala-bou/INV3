package com.scsi.inventaire3.inventaire;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.scsi.inventaire3.R;
import com.scsi.inventaire3.authentification.LoginActivity;
import com.scsi.inventaire3.bdd.entity.INV_ENTETES;
import com.scsi.inventaire3.divers.AppController;
import com.scsi.inventaire3.divers.Utils;
import com.scsi.inventaire3.inventaire.adapter.InventaireAdapter;
import com.tfb.fbtoast.FBToast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.scsi.inventaire3.splash.AcceuilActivity.USER_CONNECTED;

public class LoadInventaireActivity extends AppCompatActivity {
    List<INV_ENTETES> ENTETE_LIST = new ArrayList();
    @BindView(R.id.shimmer)
    ShimmerFrameLayout Shimmer;
    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.list_inventaire)
    GridView list_inventaire;
    @BindView(R.id.rel_refresh)
    RelativeLayout rel_refresh;
    @BindView(R.id.txt_reset)
    TextView txt_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_load_inventaire);
        ButterKnife.bind(this);
        this.list_inventaire.setVisibility(View.GONE);
        this.rel_refresh.setVisibility(View.GONE);
        this.Shimmer.setVisibility(View.VISIBLE);
        this.Shimmer.startShimmer();
        this.img_back.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadInventaireActivity.this.finish();
            }
        });
        this.txt_reset.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });


        INV_ENTETES invEntetes = new INV_ENTETES();
        invEntetes.setENT_ID(1);
        invEntetes.setENT_COMPTAGE(1);
        invEntetes.setDEP_ID(1);
        invEntetes.setENT_STATUT(0);
        invEntetes.setENT_CODE("ENT_CODE");
        invEntetes.setENT_INTITULE("ENT_INTITULE");
        invEntetes.setENT_NOTE_CREATE("ENT_NOTE_CREATE");
        invEntetes.setENT_NOTE_CLOTURE("ENT_NOTE_CLOTURE");
        invEntetes.setENT_DATECREATE("ENT_DATECREATE");
        invEntetes.setENT_USERCREATE("ENT_USERCREATE");

        invEntetes.setENT_DOS("ENT_DOS");
        ENTETE_LIST.add(invEntetes);
        ENTETE_LIST.add(invEntetes);
        ENTETE_LIST.add(invEntetes);
        ENTETE_LIST.add(invEntetes);
        ENTETE_LIST.add(invEntetes);
        ENTETE_LIST.add(invEntetes);


        showLIST();
        InventaireAdapter prise_article = new InventaireAdapter(LoadInventaireActivity.this, ENTETE_LIST);
        list_inventaire.setAdapter((ListAdapter) prise_article);
    }


    public void showShimmer() {
        this.list_inventaire.setVisibility(View.GONE);
        this.rel_refresh.setVisibility(View.GONE);
        this.Shimmer.setVisibility(View.VISIBLE);
    }

    public void showLIST() {
        this.list_inventaire.setVisibility(View.VISIBLE);
        this.rel_refresh.setVisibility(View.GONE);
        this.Shimmer.setVisibility(View.GONE);
    }

    public void showRefresh() {
        this.list_inventaire.setVisibility(View.GONE);
        this.rel_refresh.setVisibility(View.VISIBLE);
        this.Shimmer.setVisibility(View.GONE);
    }

    public void SYNC_INV() {
        showShimmer();
        String ADRESSE_IP = Utils.GET_SHARED_IP(this);
        String PORT = Utils.GET_SHARED_PORT(this);
        String url = "http://" + ADRESSE_IP + ":" + PORT + "/SenderMobile/get_INV_ENTETE_LIST?USR_ID=" + USER_CONNECTED.getUSR_ID();
        Log.e("url", url + "");
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() { // from class: com.scsi.inventairestock.load_inventaire.LIST_INVENTAIREActivity.3
            @Override // com.android.volley.Response.Listener
            public void onResponse(JSONArray response) {
                Log.d("aaaaaa", response.toString());
                ENTETE_LIST = new ArrayList();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        INV_ENTETES invEntetes = new INV_ENTETES();
                        invEntetes.setENT_ID(obj.getInt("ENT_ID"));
                        invEntetes.setENT_COMPTAGE(obj.getInt("ENT_COMPTAGE"));
                        invEntetes.setDEP_ID(obj.getInt("DEP_ID"));
                        invEntetes.setENT_STATUT(0);
                        invEntetes.setENT_CODE(obj.getString("ENT_CODE"));
                        invEntetes.setENT_INTITULE(obj.getString("ENT_INTITULE"));
                        invEntetes.setENT_NOTE_CREATE(obj.getString("ENT_NOTE_CREATE"));
                        invEntetes.setENT_NOTE_CLOTURE(obj.getString("ENT_NOTE_CLOTURE"));
                        invEntetes.setENT_DATECREATE(Utils.data_from_json(obj.getString("ENT_DATECREATE")));
                        invEntetes.setENT_USERCREATE(obj.getString("ENT_USERCREATE"));
                        try {
                            invEntetes.setENT_DATECLOTURE(Utils.data_from_json(obj.getString("ENT_DATECLOTURE")));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            invEntetes.setENT_DATE(Utils.data_from_json(obj.getString("ENT_DATE")));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        invEntetes.setENT_DOS(obj.getString("ENT_DOS"));
                        invEntetes.setENT_TYPE_SCAN(obj.getInt("ENT_TYPE_SCAN"));
                        ENTETE_LIST.add(invEntetes);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        FBToast.errorToast(LoadInventaireActivity.this, "Problème d'insertion des utlisisateurs", 0);
                        showRefresh();
                        return;
                    }
                }
                if (ENTETE_LIST.size() == 0) {
                    showRefresh();
                    FBToast.warningToast(LoadInventaireActivity.this, "Aucun inventaire en cours", 0);
                    return;
                }
                showLIST();
                InventaireAdapter prise_article = new InventaireAdapter(LoadInventaireActivity.this, ENTETE_LIST);
                list_inventaire.setAdapter((ListAdapter) prise_article);
            }
        }, new Response.ErrorListener() {
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError error) {
                Log.e("Volly Error", error.toString());
                showRefresh();
                FBToast.errorToast(LoadInventaireActivity.this, "Problème de connexion avec le serveur", 0);
            }
        });
        request.setRetryPolicy(new RetryPolicy() {
            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
            }
        });
        AppController.getInstance().addToRequestQueue(request);
    }


}
