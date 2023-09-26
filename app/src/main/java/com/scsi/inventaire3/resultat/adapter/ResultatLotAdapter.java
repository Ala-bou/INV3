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
import com.scsi.inventaire3.bdd.entity.T_RESULTAT;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;

import java.util.List;

public class ResultatLotAdapter extends BaseAdapter {
    static AppDatabase db;
    private Activity activity;
    private List<T_RESULTAT> liste_resultat;
    LayoutInflater mInflater;

    public ResultatLotAdapter(Activity activity, List<T_RESULTAT> list) {
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
            ViewHolderLot holder = new ViewHolderLot();
            this.mInflater = (LayoutInflater) this.activity.getSystemService("layout_inflater");
            convertView2 = this.mInflater.inflate(R.layout.resultat_lot_item, (ViewGroup) null);
            holder.txt_artcode_lot = (TextView) convertView2.findViewById(R.id.txt_artcode_lot);
            holder.rel = (RelativeLayout) convertView2.findViewById(R.id.tiers_item);
            holder.txt_ls = (TextView) convertView2.findViewById(R.id.txt_ls);
            holder.txt_zone_emp = (TextView) convertView2.findViewById(R.id.txt_zone_emp);
            holder.date_perm = (TextView) convertView2.findViewById(R.id.date_perm);
            holder.txt_quantite = (TextView) convertView2.findViewById(R.id.txt_quantite);
            db = AppDatabase.getAppDatabase(this.activity);

            holder.txt_artcode_lot.setText(this.liste_resultat.get(position).getART_CODE());
            if (this.liste_resultat.get(position).getMBR_LS_NO() != null) {
                TextView textView = holder.txt_ls;
                textView.setText(this.liste_resultat.get(position).getMBR_LS_NO() + "");
            } else {
                holder.txt_ls.setText("-");
            }
            TextView textView2 = holder.txt_zone_emp;
            textView2.setText(this.liste_resultat.get(position).getMBR_ZONE() + " / " + this.liste_resultat.get(position).getEMP_INTITULE());
            TextView textView3 = holder.date_perm;
            textView3.setText(this.liste_resultat.get(position).getMBR_DATE_PEREMPTION() + "");
            TextView textView4 = holder.txt_quantite;
            textView4.setText(this.liste_resultat.get(position).getMBR_QTE() + "");
            holder.rel.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.scsi.inventairestock.resultat.adapter.ResultatLotAdapter.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    AlertDialog alertDialog = new AlertDialog.Builder(ResultatLotAdapter.this.activity).create();
                    alertDialog.setTitle("Attention");
                    alertDialog.setMessage("Voulez vous supprimer cette ligne");
                    alertDialog.setButton(-1, "Oui", new DialogInterface.OnClickListener() { // from class: com.scsi.inventairestock.resultat.adapter.ResultatLotAdapter.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            db.RESULTAT_INVENTAIREDao().deletetRESULTAT_INVENTAIRE(liste_resultat.get(position));
                            try {
                                int MISSION_ID = ((T_RESULTAT) ResultatLotAdapter.this.liste_resultat.get(position)).getMISSION_ID();
                                int COUNT_SCANNED = ResultatLotAdapter.db.RESULTAT_INVENTAIREDao().getCOUNT_BY_MISSION_ID(MISSION_ID);
                                if (COUNT_SCANNED == 0) {
                                    MISSION mission = ResultatLotAdapter.db.MISSIONDao().getMISSION_by_id(((T_RESULTAT) ResultatLotAdapter.this.liste_resultat.get(position)).getMISSION_ID());
                                    mission.setM_STATUT(0);
                                    ResultatLotAdapter.db.MISSIONDao().updateMISSION(mission);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            dialog.dismiss();
                            ResultatLotAdapter.this.activity.finish();
                        }
                    });
                    alertDialog.setButton(-2, "Non", new DialogInterface.OnClickListener() { // from class: com.scsi.inventairestock.resultat.adapter.ResultatLotAdapter.1.2
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
            ViewHolderLot viewHolderLot = (ViewHolderLot) convertView2.getTag();
        }
        return convertView2;
    }
}
