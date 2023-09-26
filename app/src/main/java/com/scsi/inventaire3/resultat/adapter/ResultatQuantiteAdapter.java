package com.scsi.inventaire3.resultat.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.scsi.inventaire3.R;
import com.scsi.inventaire3.authentification.LoginActivity;
import com.scsi.inventaire3.bdd.entity.T_RESULTAT;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;

import java.util.List;

/* loaded from: classes2.dex */
public class ResultatQuantiteAdapter extends BaseAdapter {
    static AppDatabase db;
    private Activity activity;
    private List<T_RESULTAT> liste_resultat;
    LayoutInflater mInflater;

    public ResultatQuantiteAdapter(Activity activity, List<T_RESULTAT> list) {
        this.activity = activity;
        this.liste_resultat = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.liste_resultat.size();
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
            convertView2 = this.mInflater.inflate(R.layout.resultat_item, (ViewGroup) null);
            holder.txt_artcode_quantite = (TextView) convertView2.findViewById(R.id.txt_artcode_quantite);
            holder.rel = (RelativeLayout) convertView2.findViewById(R.id.tiers_item);
            holder.txt_quantite = (TextView) convertView2.findViewById(R.id.txt_quantite);
            holder.txt_zone_emp = (TextView) convertView2.findViewById(R.id.txt_zone_emp);
            db = AppDatabase.getAppDatabase(this.activity);

            TextView textView = holder.txt_artcode_quantite;
            textView.setText(this.liste_resultat.get(position).getART_CODE() + "");
            TextView textView2 = holder.txt_quantite;
            textView2.setText(this.liste_resultat.get(position).getMBR_QTE() + "");
            TextView textView3 = holder.txt_zone_emp;
            textView3.setText(this.liste_resultat.get(position).getMBR_ZONE() + " / " + this.liste_resultat.get(position).getEMP_INTITULE());
            holder.rel.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.scsi.inventairestock.resultat.adapter.ResultatQuantiteAdapter.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    AlertDialog alertDialog = new AlertDialog.Builder(ResultatQuantiteAdapter.this.activity).create();
                    alertDialog.setTitle("Attention");
                    alertDialog.setMessage("Voulez vous supprimer cette ligne");
                    alertDialog.setButton(-1, "Oui", new DialogInterface.OnClickListener() { // from class: com.scsi.inventairestock.resultat.adapter.ResultatQuantiteAdapter.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            if (LoginActivity.invEntetes.getENT_COMPTAGE() == 1) {
                                ResultatQuantiteAdapter.db.RESULTAT_INVENTAIREDao().deletetRESULTAT_INVENTAIRE((T_RESULTAT) ResultatQuantiteAdapter.this.liste_resultat.get(position));
                            } else {
                                ResultatQuantiteAdapter.db.RESULTAT_INVENTAIREDao().deletetRESULTAT_INVENTAIRE((T_RESULTAT) ResultatQuantiteAdapter.this.liste_resultat.get(position));
                                if (((T_RESULTAT) ResultatQuantiteAdapter.this.liste_resultat.get(position)).getMISSION_ID() != 0) {
                                    MISSION mission = ResultatQuantiteAdapter.db.MISSIONDao().getMISSION_by_id(((T_RESULTAT) ResultatQuantiteAdapter.this.liste_resultat.get(position)).getMISSION_ID());
                                    mission.setM_STATUT(0);
                                    ResultatQuantiteAdapter.db.MISSIONDao().updateMISSION(mission);
                                }
                            }
                            ResultatQuantiteAdapter.this.activity.finish();
                            dialog.dismiss();
                        }
                    });
                    alertDialog.setButton(-2, "Non", new DialogInterface.OnClickListener() { // from class: com.scsi.inventairestock.resultat.adapter.ResultatQuantiteAdapter.1.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog.show();
                    return false;
                }
            });
            convertView2.setTag(holder);
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView2.getTag();
        }
        return convertView2;
    }
}
