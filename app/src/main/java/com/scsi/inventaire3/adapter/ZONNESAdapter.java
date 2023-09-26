package com.scsi.inventaire3.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.scsi.inventaire3.MainActivity;
import com.scsi.inventaire3.R;
import com.scsi.inventaire3.authentification.LoginActivity;
import com.scsi.inventaire3.bdd.entity.T_ZONE;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;
import com.scsi.inventaire3.scan.ScanActivity;
import com.tfb.fbtoast.FBToast;

import java.util.List;

/* loaded from: classes2.dex */
public class ZONNESAdapter extends BaseAdapter {
    static AppDatabase db;
    private Activity activity;
    private List<T_ZONE> liste_zonnes;
    LayoutInflater mInflater;

    public ZONNESAdapter(Activity activity, List<T_ZONE> list) {
        this.activity = activity;
        this.liste_zonnes = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.liste_zonnes.size();
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
            ViewHolder_zonne holder = new ViewHolder_zonne();
            this.mInflater = (LayoutInflater) this.activity.getSystemService("layout_inflater");
            convertView2 = this.mInflater.inflate(R.layout.zonne_item, (ViewGroup) null);
            holder.txt_zonne = (TextView) convertView2.findViewById(R.id.txt_zonne);
            holder.img_zonne =   convertView2.findViewById(R.id.img_zonne);
            holder.rel =   convertView2.findViewById(R.id.rel);

            db = AppDatabase.getAppDatabase(this.activity);


            TextView textView = holder.txt_zonne;
            textView.setText(this.liste_zonnes.get(position).getZONE_CODE() + "");

            if (position % 2 != 0) {
                holder.img_zonne.setImageDrawable(activity.getResources().getDrawable(R.drawable.zonne_vert));
            }else
            {
                holder.img_zonne.setImageDrawable(activity.getResources().getDrawable(R.drawable.zonne_rouge));

            }

            List<String> resultat_inventaires = db.T_RESULTATDao().getlISTZONNE_SCANNE();
            if (resultat_inventaires.contains(this.liste_zonnes.get(position).getZONE_INTITULE())) {
             } else {
             }
            holder.rel.setOnClickListener(new View.OnClickListener() { // from class: com.scsi.inventairestock.adapter.ZONNESAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (LoginActivity.invEntetes.getINVENTAIRE_COMPTAGE() == 1) {
                        AlertDialog alertDialog = new AlertDialog.Builder(ZONNESAdapter.this.activity).create();
                        alertDialog.setTitle("Attention");
                        alertDialog.setMessage("Etes vous sûr de choisir " + liste_zonnes.get(position).getZONE_INTITULE());
                        alertDialog.setButton(-1, "Oui", new DialogInterface.OnClickListener() {
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                if (LoginActivity.invEntetes.getINVENTAIRE_STATUT() == 2) {
                                    FBToast.errorToast(ZONNESAdapter.this.activity, "Inventaire déja cloturé ", 0);
                                    return;
                                }
                                LoginActivity.invEntetes.setINVENTAIRE_STATUT(1);
                                db.T_INVENTAIREDao().updateINV_ENTETES(LoginActivity.invEntetes);
                                MainActivity.zonnesChoisen =  liste_zonnes.get(position);
                                Intent i = new Intent(ZONNESAdapter.this.activity, ScanActivity.class);
                                ZONNESAdapter.this.activity.startActivity(i);
                            }
                        });
                        alertDialog.setButton(-2, "Non", new DialogInterface.OnClickListener() {
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        alertDialog.show();
                    }
                }
            });


            convertView2.setTag(holder);
        } else {
            ViewHolder_zonne viewHolder_zonne = (ViewHolder_zonne) convertView2.getTag();
        }
        return convertView2;
    }
}
