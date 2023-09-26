package com.scsi.inventaire3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.scsi.inventaire3.bdd.entity.P_USER;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;
import com.scsi.inventaire3.divers.AppController;
import com.scsi.inventaire3.divers.Constant;
import com.scsi.inventaire3.divers.Utils;
import com.tfb.fbtoast.FBToast;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.scsi.inventaire3.divers.Constant.TYPE_SCAN_BARCODE_QR;
import static com.scsi.inventaire3.divers.Constant.TYPE_SCAN_GS1;
import static com.scsi.inventaire3.divers.Utils.GET_INT;
import static com.scsi.inventaire3.divers.Utils.GET_SHARED_TYPE_SCAN;
import static com.scsi.inventaire3.divers.Utils.GET_STRING;

public class ParametrageActivity extends AppCompatActivity {
    @BindView(R.id.img_back)
    ImageView img_back;


    AppDatabase db;
    @BindView(R.id.douchette)
    Switch douchette;
    @BindView(R.id.edit_ip)
    EditText edit_ip;
    @BindView(R.id.edit_port)
    EditText edit_port;

    @BindView(R.id.init)
    TextView init;
    @BindView(R.id.qte)
    Switch qte;

    @BindView(R.id.txt_valider)
    TextView txt_valider;


    @BindView(R.id.radio_gs1)
    RadioButton radio_gs1;


    @BindView(R.id.radio_barcode)
    RadioButton radio_barcode;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_parametrage);

        ButterKnife.bind(this);


        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ButterKnife.bind(this);
        this.db = AppDatabase.getAppDatabase(this);
        if (!Utils.GET_SHARED_IP(this).equals("")) {
            this.edit_ip.setText(Utils.GET_SHARED_IP(this));
            this.edit_port.setText(Utils.GET_SHARED_PORT(this));
            if (Utils.GET_SHARED_QTE(this) == 1) {
                this.qte.setChecked(true);
            } else {
                this.qte.setChecked(false);
            }
            if (Utils.GET_SHARED_DOUCHETTE(this) == 1) {
                this.douchette.setChecked(true);
            } else {
                this.douchette.setChecked(false);
            }


            if (GET_SHARED_TYPE_SCAN(this) == TYPE_SCAN_GS1) {
                radio_gs1.setChecked(true);
                radio_barcode.setChecked(false);

            } else {
                radio_gs1.setChecked(false);
                radio_barcode.setChecked(true);


            }
        }
        this.img_back.setOnClickListener(new View.OnClickListener() { // from class: com.scsi.inventairestock.parametre.ParametreActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                controle();
            }
        });
        this.txt_valider.setOnClickListener(new View.OnClickListener() { // from class: com.scsi.inventairestock.parametre.ParametreActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                controle();
            }
        });
        this.init.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.scsi.inventairestock.parametre.ParametreActivity.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(ParametrageActivity.this).create();
                alertDialog.setTitle("Initialisation");
                alertDialog.setMessage("Toutes les données seront supprimées de l'application . \n Voulez-vous continuer ?");
                alertDialog.setButton(-1, "Oui", new DialogInterface.OnClickListener() { // from class: com.scsi.inventairestock.parametre.ParametreActivity.4.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Utils.DELETE_ALL(ParametrageActivity.this.db);
                        ParametrageActivity.this.finish();
                    }
                });
                alertDialog.setButton(-2, "Annuler", new DialogInterface.OnClickListener() { // from class: com.scsi.inventairestock.parametre.ParametreActivity.4.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
                return false;
            }
        });



    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        controle();
    }

    public void controle() {
        if (this.edit_ip.getText().toString().equals("")) {
            this.edit_ip.setError("Adresse Ip obligatoire");
            this.edit_ip.requestFocus();
        } else if (this.edit_port.getText().toString().equals("")) {
            this.edit_port.setError("PORT obligatoire");
            this.edit_port.requestFocus();
        } else {
            int TYPE_SCAN = TYPE_SCAN_GS1;
            if (radio_barcode.isChecked()) {
                TYPE_SCAN = TYPE_SCAN_BARCODE_QR;

            }
            if (this.qte.isChecked()) {
                if (this.douchette.isChecked()) {
                    Utils.insert_shared(this, this.edit_ip.getText().toString(), this.edit_port.getText().toString(), 1, 1, TYPE_SCAN);
                } else {
                    Utils.insert_shared(this, this.edit_ip.getText().toString(), this.edit_port.getText().toString(), 1, 0, TYPE_SCAN);
                }
            } else if (this.douchette.isChecked()) {
                Utils.insert_shared(this, this.edit_ip.getText().toString(), this.edit_port.getText().toString(), 0, 1, TYPE_SCAN);
            } else {
                Utils.insert_shared(this, this.edit_ip.getText().toString(), this.edit_port.getText().toString(), 0, 0, TYPE_SCAN);
            }
            finish();
        }
    }

    public void SYNC_USERS() {
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Chargement...");
        pDialog.show();
        pDialog.setCancelable(false);
        String ADRESSE_IP = Utils.GET_SHARED_IP(this);
        String PORT = Utils.GET_SHARED_PORT(this);
        //  FirebaseInstanceId.getInstance().getToken();
        String url = "http://" + ADRESSE_IP + ":" + PORT + "/SenderMobile/get_USER_LIST/";
        Log.e("url", url + "");
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() { // from class: com.scsi.inventairestock.parametre.ParametreActivity.5
            @Override // com.android.volley.Response.Listener
            public void onResponse(JSONArray response) {
                Log.d("aaaaaa", response.toString());
             db.USERSDao().deleteAll();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        P_USER users = new P_USER();
                        users.setUSER_ID(obj.getInt("USER_ID"));
                        users.setUSER_NAME(GET_STRING(obj.getString("USER_NAME")));
                        users.setUSER_TYPE_ID(GET_INT(obj.getString("USER_TYPE_ID")));
                        users.setUSER_ETAT(GET_INT(obj.getString("USER_ETAT")));
                        users.setUSER_TOKEN(GET_STRING(obj.getString("USER_TOKEN")));
                        users.setUSER_LOGIN(GET_STRING(obj.getString("USER_LOGIN")));
                        users.setUSER_PASSWORD(GET_STRING(obj.getString("USER_PASSWORD")));


                    db.USERSDao().insertUSERS(users);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        FBToast.errorToast(ParametrageActivity.this, "Problème d'insertion des utlisisateurs", 0);
                        pDialog.dismiss();
                      db.USERSDao().deleteAll();
                        return;
                    }
                }
                FBToast.successToast(ParametrageActivity.this, "Synchronisation avec succès", 0);
                pDialog.dismiss();
             finish();
            }
        }, new Response.ErrorListener() { // from class: com.scsi.inventairestock.parametre.ParametreActivity.6
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError error) {
                Log.e("Volly Error", error.toString());
                pDialog.dismiss();
                db.USERSDao().deleteAll();
                FBToast.errorToast(ParametrageActivity.this, "Problème de connexion avec le serveur", 0);
            }
        });
        request.setRetryPolicy(new RetryPolicy() { // from class: com.scsi.inventairestock.parametre.ParametreActivity.7
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