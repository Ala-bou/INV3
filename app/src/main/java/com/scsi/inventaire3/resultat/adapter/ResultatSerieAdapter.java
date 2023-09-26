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

public class ResultatSerieAdapter extends BaseAdapter {
    static AppDatabase db;
    private Activity activity;
    private List<T_RESULTAT> liste_resultat;
    LayoutInflater mInflater;

    public ResultatSerieAdapter(Activity activity, List<T_RESULTAT> list) {
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
            ViewHolderSerie holder = new ViewHolderSerie();
            this.mInflater = (LayoutInflater) this.activity.getSystemService("layout_inflater");
            convertView2 = this.mInflater.inflate(R.layout.resultat_serie_item, (ViewGroup) null);
            holder.txt_artcode_serie = (TextView) convertView2.findViewById(R.id.txt_artcode_serie);
            holder.rel = (RelativeLayout) convertView2.findViewById(R.id.tiers_item);
            holder.txt_ls_serie = (TextView) convertView2.findViewById(R.id.txt_ls_serie);
            holder.txt_quantite = (TextView) convertView2.findViewById(R.id.txt_quantite);
            db = AppDatabase.getAppDatabase(this.activity);

            holder.rel.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.scsi.inventairestock.resultat.adapter.ResultatSerieAdapter.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    AlertDialog alertDialog = new AlertDialog.Builder(ResultatSerieAdapter.this.activity).create();
                    alertDialog.setTitle("Attention");
                    alertDialog.setMessage("Voulez vous supprimer cette ligne");
                    alertDialog.setButton(-1, "Oui", new DialogInterface.OnClickListener() { // from class: com.scsi.inventairestock.resultat.adapter.ResultatSerieAdapter.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            ResultatSerieAdapter.db.RESULTAT_INVENTAIREDao().deletetRESULTAT_INVENTAIRE((T_RESULTAT) ResultatSerieAdapter.this.liste_resultat.get(position));
                            ResultatSerieAdapter.this.activity.finish();
                            dialog.dismiss();
                        }
                    });
                    alertDialog.setButton(-2, "Non", new DialogInterface.OnClickListener() { // from class: com.scsi.inventairestock.resultat.adapter.ResultatSerieAdapter.1.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog.show();
                    return false;
                }
            });
            TextView textView = holder.txt_artcode_serie;
            textView.setText(this.liste_resultat.get(position).getART_CODE() + "");
            TextView textView2 = holder.txt_ls_serie;
            textView2.setText(this.liste_resultat.get(position).getMBR_LS_NO() + "");
            TextView textView3 = holder.txt_quantite;
            textView3.setText(this.liste_resultat.get(position).getMBR_QTE() + "");
            convertView2.setTag(holder);
        } else {
            ViewHolderSerie viewHolderSerie = (ViewHolderSerie) convertView2.getTag();
        }
        return convertView2;
    }
}
