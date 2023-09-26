package com.scsi.inventaire3.inventaire.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.scsi.inventaire3.MainActivity;
import com.scsi.inventaire3.R;
import com.scsi.inventaire3.bdd.entity.T_ARTICLE;
import com.scsi.inventaire3.bdd.entity.T_EMPLACEMENT;
import com.scsi.inventaire3.bdd.entity.T_INVENTAIRE;
import com.scsi.inventaire3.bdd.entity.T_ZONE;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;
import com.scsi.inventaire3.divers.AppController;
import com.scsi.inventaire3.divers.Utils;
import com.tfb.fbtoast.FBToast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.scsi.inventaire3.authentification.LoginActivity.invEntetes;
import static com.scsi.inventaire3.splash.AcceuilActivity.USER_CONNECTED;

/* loaded from: classes2.dex */
public class InventaireAdapter extends BaseAdapter {
    static AppDatabase db;
    public static T_INVENTAIRE entetesChoisen = new T_INVENTAIRE();
    private List<T_ARTICLE> ARTICLE_LIST;
     private Activity activity;
    private List<T_INVENTAIRE> liste_inventaire;
    LayoutInflater mInflater;
    ProgressDialog pDialog;

    public InventaireAdapter(Activity activity, List<T_INVENTAIRE> list) {
        this.activity = activity;
        this.liste_inventaire = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.liste_inventaire.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int arg0) {
        return Integer.valueOf(arg0);
    }

    @Override // android.widget.Adapter
    public long getItemId(int arg0) {
        return arg0;
    }

    @SuppressLint("WrongConstant")
    @Override // android.widget.Adapter
    public View getView(final int position, View convertView, ViewGroup arg2) {
        View convertView2 = null;
        if (0 == 0) {
            ViewHolder holder = new ViewHolder();
            this.mInflater = (LayoutInflater) this.activity.getSystemService("layout_inflater");
            convertView2 = this.mInflater.inflate(R.layout.inv_item, (ViewGroup) null);
            holder.DESIGNATION = (TextView) convertView2.findViewById(R.id.nom_inv);
            holder.CODE = (TextView) convertView2.findViewById(R.id.inv_code);
            holder.rel = (RelativeLayout) convertView2.findViewById(R.id.tiers_item);
            db = AppDatabase.getAppDatabase(this.activity);

            this.pDialog = new ProgressDialog(this.activity);
            holder.rel.setOnLongClickListener(new View.OnLongClickListener() {
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {


                    invEntetes=liste_inventaire.get(position);
                    db.T_INVENTAIREDao().insertINV_ENTETES(invEntetes);
                    Intent i = new Intent( activity, MainActivity.class);
                    activity.finish();
                    activity.startActivity(i);
                 /*       INV_ENTETES inv_entetes = InventaireAdapter.db.INV_ENTETESDao().getINV_ENTETES();
                    try {

                        if (inv_entetes==null)
                        {
                            InventaireAdapter.entetesChoisen = (INV_ENTETES) InventaireAdapter.this.liste_inventaire.get(position);
                            InventaireAdapter.this.SYNC_EMPLACEMENT();
                        }else
                        {
                            if (inv_entetes.getENT_ID() != (liste_inventaire.get(position)).getENT_ID()) {
                                InventaireAdapter.entetesChoisen = (INV_ENTETES) InventaireAdapter.this.liste_inventaire.get(position);
                                InventaireAdapter.this.SYNC_EMPLACEMENT();
                            } else {
                                FBToast.warningToast(InventaireAdapter.this.activity, "Inventaire déja synchronisée", 0);
                            }
                        }

                    } catch (Exception e) {
                        InventaireAdapter.entetesChoisen = (INV_ENTETES) InventaireAdapter.this.liste_inventaire.get(position);
                        InventaireAdapter.this.SYNC_EMPLACEMENT();
                        e.printStackTrace();
                    }*/
                    return false;
                }
            });
            TextView textView = holder.DESIGNATION;
            textView.setText(this.liste_inventaire.get(position).getINVENTAIRE_INTITULE() + "");
            TextView textView2 = holder.CODE;
            textView2.setText(this.liste_inventaire.get(position).getINVENTAIRE_CODE() + "");
            convertView2.setTag(holder);
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView2.getTag();
        }
        return convertView2;
    }

    public void SYNC_EMPLACEMENT() {
        if (this.activity.getWindow().getDecorView().isShown()) {
            this.pDialog.setMessage("Chargement des emplacements...");
            this.pDialog.setCancelable(false);
            ProgressDialog progressDialog = this.pDialog;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.pDialog.cancel();
            }
            try {
                this.pDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String ADRESSE_IP = Utils.GET_SHARED_IP(this.activity);
        String PORT = Utils.GET_SHARED_PORT(this.activity);
        String url = "http://" + ADRESSE_IP + ":" + PORT + "/SenderMobile/get_EMPLACEMENT_LIST?ENT_ID=" + entetesChoisen.getINVENTAIRE_ID();
        Log.e("url", url + "");
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.2
            @Override // com.android.volley.Response.Listener
            public void onResponse(JSONArray response) {
                Log.d("aaaaaa", response.toString());
                int index = 0;
                try {
                    InventaireAdapter.db.T_EMPLACEMENTDao().deleteAll();
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject obj = response.getJSONObject(i);
                        T_EMPLACEMENT emplacement = new T_EMPLACEMENT();
                        emplacement.setEMP_ID(Utils.GET_INT(obj.getString("EMP_ID")));
                        emplacement.setEMP_CODE(Utils.GET_STRING(obj.getString("EMP_CODE")));
                        emplacement.setEMP_INTITULE(Utils.GET_STRING(obj.getString("EMP_INTITULE")));
                        emplacement.setDEP_CODE(Utils.GET_STRING(obj.getString("DEP_CODE")));
                        emplacement.setDEP_INTITULE(Utils.GET_STRING(obj.getString("DEP_INTITULE")));
                        emplacement.setDEP_DOS(Utils.GET_STRING(obj.getString("DEP_DOS")));
                        emplacement.setDEP_ID_ERP(Utils.GET_INT(obj.getString("DEP_ID_ERP")));
                        InventaireAdapter.db.T_EMPLACEMENTDao().insertEMPLACEMENT(emplacement);
                        index = i + 1;
                        Log.e("index123", i + "");
                    }
                    Log.e("index123", index + "   ---   " + response.length());
                    if (index == response.length()) {
                        InventaireAdapter.this.SYNC_ZONE();
                        return;
                    }
                    InventaireAdapter.this.pDialog.dismiss();
                    FBToast.errorToast(InventaireAdapter.this.activity, "Problème d'insertion des emplacements", 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    FBToast.errorToast(InventaireAdapter.this.activity, "Problème d'insertion des emplacements", 0);
                    InventaireAdapter.this.pDialog.dismiss();
                }
            }
        }, new Response.ErrorListener() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.3
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError error) {
                Log.e("Volly Error", error.toString());
                FBToast.errorToast(InventaireAdapter.this.activity, "Problème de connexion avec le serveur", 0);
                InventaireAdapter.this.pDialog.dismiss();
            }
        });
        request.setRetryPolicy(new RetryPolicy() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.4
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

    public void SYNC_ZONE() {
        this.pDialog.setMessage("Chargement des zones...");
        String ADRESSE_IP = Utils.GET_SHARED_IP(this.activity);
        String PORT = Utils.GET_SHARED_PORT(this.activity);
        String url = "http://" + ADRESSE_IP + ":" + PORT + "/SenderMobile/get_ZONE_LIST?ENT_ID=" + entetesChoisen.getINVENTAIRE_ID() + "&USR_ID=" + USER_CONNECTED.getUSER_ID();
        Log.e("url", url + "");
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.5
            @Override // com.android.volley.Response.Listener
            public void onResponse(JSONArray response) {
                Log.d("aaaaaa", response.toString());
                int index = 0;
                try {
                    InventaireAdapter.db.ZONESDao().deleteAll();
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject obj = response.getJSONObject(i);
                        T_ZONE zones = new T_ZONE();
                        zones.setZN_ID(Utils.GET_INT(obj.getString("ZN_ID")));
                        zones.setZN_INTITULE(Utils.GET_STRING(obj.getString("ZN_INTITULE")));
                        zones.setZN_CODE(Utils.GET_STRING(obj.getString("ZN_CODE")));
                        InventaireAdapter.db.ZONESDao().insertZONES(zones);
                        index = i + 1;
                        Log.e("index123", i + "");
                    }
                    Log.e("index123", index + "   ---   " + response.length());
                    if (index == response.length()) {
                        try {
                            InventaireAdapter.this.ARTICLE_LIST = new ArrayList();
                            InventaireAdapter.this.GET_COUNT_OF_ARTICLES();
                        } catch (Exception e) {
                            FBToast.errorToast(InventaireAdapter.this.activity, "Problème d'insertion des articles", 0);
                        }
                        return;
                    }
                    InventaireAdapter.this.pDialog.dismiss();
                    FBToast.errorToast(InventaireAdapter.this.activity, "Problème d'insertion des zonnes", 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    FBToast.errorToast(InventaireAdapter.this.activity, "Problème d'insertion des zonnes", 0);
                    InventaireAdapter.this.pDialog.dismiss();
                }
            }
        }, new Response.ErrorListener() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.6
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError error) {
                Log.e("Volly Error", error.toString());
                FBToast.errorToast(InventaireAdapter.this.activity, "Problème de connexion avec le serveur", 0);
                InventaireAdapter.this.pDialog.dismiss();
            }
        });
        request.setRetryPolicy(new RetryPolicy() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.7
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


    public void SYNC_ARTICLE_ALL() throws IOException {
        this.pDialog.setMessage("Chargement des articles... ");
        String ADRESSE_IP = Utils.GET_SHARED_IP(this.activity);
        String PORT = Utils.GET_SHARED_PORT(this.activity);
        final String url = "http://" + ADRESSE_IP + ":" + PORT + "/SenderMobile/get_ARTICLE_LIST?ENT_ID=" + entetesChoisen.getINVENTAIRE_ID();
        Log.e("url", url + "");
        this.activity.runOnUiThread(new Runnable() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.11
            @Override // java.lang.Runnable
            public void run() {
                InventaireAdapter.deleteCache(InventaireAdapter.this.activity);
                JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.11.1
                    @Override // com.android.volley.Response.Listener
                    public void onResponse(JSONArray response) {
                        Log.d("aaaaaa", response.toString());
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                T_ARTICLE articles = new T_ARTICLE();
                                articles.setART_CODE(Utils.GET_STRING(obj.getString("A")));
                                articles.setART_INTITULE(Utils.GET_STRING(obj.getString("B")));
                                articles.setART_BARCODE(Utils.GET_STRING(obj.getString("C")));
                                articles.setART_GAMME1(Utils.GET_STRING(obj.getString("D")));
                                articles.setART_GAMME2(Utils.GET_STRING(obj.getString("E")));
                                articles.setART_GAMME1_INTITULE(Utils.GET_STRING(obj.getString("F")));
                                articles.setART_GAMME2_INTITULE(Utils.GET_STRING(obj.getString("G")));
                                articles.setART_TYPESTOCK(Utils.GET_INT(obj.getString("H")));
                                articles.setART_TYPEGAMME(Utils.GET_INT(obj.getString("I")));
                                articles.setART_UNITE_REF(Utils.GET_STRING(obj.getString("J")));
                                InventaireAdapter.this.ARTICLE_LIST.add(articles);
                                InventaireAdapter.this.pDialog.setMessage("Chargement des articles  \n" + InventaireAdapter.this.ARTICLE_LIST.size() + "/" + response.length());
                            } catch (Exception e) {
                                e.printStackTrace();
                                InventaireAdapter.this.ARTICLE_LIST = new ArrayList();
                                FBToast.errorToast(InventaireAdapter.this.activity, "Problème d'insertion des articles", 0);
                                InventaireAdapter.this.pDialog.dismiss();
                                Utils.DELETE_ALL(InventaireAdapter.db);
                                return;
                            }
                        }
                        int COUNT_LOCAL = InventaireAdapter.this.ARTICLE_LIST.size();
                        if (COUNT_LOCAL == response.length()) {
                            InventaireAdapter.this.pDialog.setMessage("Insertion  du+" + InventaireAdapter.this.ARTICLE_LIST.size() + " articles  ");
                            InventaireAdapter.db.T_ARTICLEDao().insert_LIDT_OF_ARTICLE(InventaireAdapter.this.ARTICLE_LIST);
                            InventaireAdapter.this.SYNC_STK_LOT();
                            return;
                        }
                        Utils.DELETE_ALL(InventaireAdapter.db);
                        InventaireAdapter.this.ARTICLE_LIST = new ArrayList();
                        InventaireAdapter.this.pDialog.dismiss();
                        FBToast.errorToast(InventaireAdapter.this.activity, "Problème d'insertion des articles", 0);
                    }
                }, new Response.ErrorListener() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.11.2
                    @Override // com.android.volley.Response.ErrorListener
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volly Error", error.toString());
                        FBToast.errorToast(InventaireAdapter.this.activity, "Problème de connexion avec le serveur", 0);
                        InventaireAdapter.this.pDialog.dismiss();
                        Utils.DELETE_ALL(InventaireAdapter.db);
                    }
                });
                request.setRetryPolicy(new RetryPolicy() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.11.3
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
        });
    }

    public void SYNC_ARTICLE(final int COUNT_FROM_WS, int COUNT_LOCAL) throws IOException {
        this.pDialog.setMessage("Chargement des articles... " + COUNT_LOCAL + "/" + COUNT_FROM_WS);
        String ADRESSE_IP = Utils.GET_SHARED_IP(this.activity);
        String PORT = Utils.GET_SHARED_PORT(this.activity);
        final String url = "http://" + ADRESSE_IP + ":" + PORT + "/SenderMobile/get_ARTICLE_LIST_LIMIT?ENT_ID=" + entetesChoisen.getINVENTAIRE_ID() + "&recu=" + COUNT_LOCAL;
        Log.e("url", url + "");
        this.activity.runOnUiThread(new Runnable() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InventaireAdapter.deleteCache(InventaireAdapter.this.activity);
                    JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.12.1
                        @Override // com.android.volley.Response.Listener
                        public void onResponse(JSONArray response) {
                            Log.d("aaaaaa", response.toString());
                            int index = 0;
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject obj = response.getJSONObject(i);
                                    T_ARTICLE articles = new T_ARTICLE();
                                    articles.setART_CODE(Utils.GET_STRING(obj.getString("A")));
                                    articles.setART_INTITULE(Utils.GET_STRING(obj.getString("B")));
                                    articles.setART_BARCODE(Utils.GET_STRING(obj.getString("C")));
                                    articles.setART_GAMME1(Utils.GET_STRING(obj.getString("D")));
                                    articles.setART_GAMME2(Utils.GET_STRING(obj.getString("E")));
                                    articles.setART_GAMME1_INTITULE(Utils.GET_STRING(obj.getString("F")));
                                    articles.setART_GAMME2_INTITULE(Utils.GET_STRING(obj.getString("G")));
                                    articles.setART_TYPESTOCK(Utils.GET_INT(obj.getString("H")));
                                    articles.setART_TYPEGAMME(Utils.GET_INT(obj.getString("I")));
                                    articles.setART_UNITE_REF(Utils.GET_STRING(obj.getString("J")));
                                    InventaireAdapter.this.ARTICLE_LIST.add(articles);
                                    index = i + 1;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    FBToast.errorToast(InventaireAdapter.this.activity, "Problème d'insertion des articles", 0);
                                    InventaireAdapter.this.pDialog.dismiss();
                                    Utils.DELETE_ALL(InventaireAdapter.db);
                                    InventaireAdapter.this.ARTICLE_LIST = new ArrayList();
                                    return;
                                }
                            }
                            Log.e("index123", index + "   ---   " + response.length() + "   ---   " + InventaireAdapter.this.ARTICLE_LIST.size());
                            if (index == response.length()) {
                                int COUNT_LOCAL2 = InventaireAdapter.this.ARTICLE_LIST.size();
                                if (COUNT_LOCAL2 == COUNT_FROM_WS) {
                                    InventaireAdapter.this.pDialog.setMessage("Insertion des articles... ");
                                    InventaireAdapter.db.T_ARTICLEDao().insert_LIDT_OF_ARTICLE(InventaireAdapter.this.ARTICLE_LIST);
                                    InventaireAdapter.this.SYNC_STK_LOT();
                                } else {
                                    try {
                                        InventaireAdapter.this.SYNC_ARTICLE(COUNT_FROM_WS, COUNT_LOCAL2);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                return;
                            }
                            Utils.DELETE_ALL(InventaireAdapter.db);
                            InventaireAdapter.this.ARTICLE_LIST = new ArrayList();
                            InventaireAdapter.this.pDialog.dismiss();
                            FBToast.errorToast(InventaireAdapter.this.activity, "Problème d'insertion des articles", 0);
                        }
                    }, new Response.ErrorListener() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.12.2
                        @Override // com.android.volley.Response.ErrorListener
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Volly Error", error.toString());
                            FBToast.errorToast(InventaireAdapter.this.activity, "Problème de connexion avec le serveur", 0);
                            InventaireAdapter.this.pDialog.dismiss();
                            Utils.DELETE_ALL(InventaireAdapter.db);
                            InventaireAdapter.this.ARTICLE_LIST = new ArrayList();
                        }
                    });
                    request.setRetryPolicy(new RetryPolicy() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.12.3
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
                } catch (Exception e) {
                    FBToast.errorToast(InventaireAdapter.this.activity, "1111111111Out of memory", 0);
                } catch (OutOfMemoryError e2) {
                    Log.e("OutOfMemoryError", "OutOfMemoryErrorOutOfMemoryErrorOutOfMemoryErrorOutOfMemoryError");
                    InventaireAdapter.this.pDialog.dismiss();
                    FBToast.errorToast(InventaireAdapter.this.activity, "Out of memory", 0);
                }
            }
        });
    }

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (String str : children) {
                boolean success = deleteDir(new File(dir, str));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if (dir == null || !dir.isFile()) {
            return false;
        } else {
            return dir.delete();
        }
    }


    public void WS_EN_COURS() {
        this.pDialog.setMessage("Chargement...");
        String ADRESSE_IP = Utils.GET_SHARED_IP(this.activity);
        String PORT = Utils.GET_SHARED_PORT(this.activity);
        String url = "http://" + ADRESSE_IP + ":" + PORT + "/ReceiverMobile/set_SYNC?ENT_ID=" + entetesChoisen.getINVENTAIRE_ID() + "&USR_ID=" + USER_CONNECTED.getUSER_ID();
        Log.e("url", url + "");
        Log.e("url2454", url + "");
        StringRequest request = new StringRequest(0, url, new Response.Listener<String>() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.16
            @Override // com.android.volley.Response.Listener
            public void onResponse(String response) {
                Log.e("Response", response);
                try {
                    if (response.equals("True")) {
                        InventaireAdapter.db.T_HISTORIQUE_INVENTAIREDao().deleteAll();
                        InventaireAdapter.this.pDialog.dismiss();
                        Intent i = new Intent(InventaireAdapter.this.activity, MainActivity.class);
                        InventaireAdapter.this.activity.startActivity(i);
                        FBToast.successToast(InventaireAdapter.this.activity, "Synchronisation avec succes", 0);
                        InventaireAdapter.this.activity.finish();
                    } else {
                        InventaireAdapter.this.pDialog.dismiss();
                        Utils.DELETE_ALL(InventaireAdapter.db);
                        FBToast.errorToast(InventaireAdapter.this.activity, "Problème au niveau du modification du statut d'inventaire", 0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FBToast.errorToast(InventaireAdapter.this.activity, "Problème d'insertion des gammes", 0);
                    InventaireAdapter.this.pDialog.dismiss();
                    Utils.DELETE_ALL(InventaireAdapter.db);
                }
            }
        }, new Response.ErrorListener() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.17
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError error) {
                InventaireAdapter.this.pDialog.dismiss();
            }
        });
        request.setRetryPolicy(new RetryPolicy() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.18
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

    public void GET_COUNT_OF_ARTICLES() {
        this.pDialog.setMessage("Vérification des articles...");
        String ADRESSE_IP = Utils.GET_SHARED_IP(this.activity);
        String PORT = Utils.GET_SHARED_PORT(this.activity);
        String url = "http://" + ADRESSE_IP + ":" + PORT + "/SenderMobile/get_count_article?ENT_ID=" + entetesChoisen.getINVENTAIRE_ID();
        Log.e("url", url + "");
        Log.e("url2454", url + "");
        StringRequest request = new StringRequest(0, url, new Response.Listener<String>() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.19
            @Override // com.android.volley.Response.Listener
            public void onResponse(String response) {
                Log.e("Response", response);
                int COUNT = 0;
                try {
                    try {
                        COUNT = Integer.parseInt(response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (COUNT > 0) {
                        InventaireAdapter.this.SYNC_ARTICLE(COUNT, 0);
                        return;
                    }
                    FBToast.errorToast(InventaireAdapter.this.activity, "Aucun articles ", 0);
                    Utils.DELETE_ALL(InventaireAdapter.db);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    FBToast.errorToast(InventaireAdapter.this.activity, "Problème de chargement de nombre des articles", 0);
                    InventaireAdapter.this.pDialog.dismiss();
                    Utils.DELETE_ALL(InventaireAdapter.db);
                }
            }
        }, new Response.ErrorListener() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.20
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError error) {
                InventaireAdapter.this.pDialog.dismiss();
            }
        });
        request.setRetryPolicy(new RetryPolicy() { // from class: com.scsi.inventairestock.load_inventaire.adapter.InventaireAdapter.21
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
