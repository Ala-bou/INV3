package com.scsi.inventaire3.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.scsi.inventaire3.MainActivity;
import com.scsi.inventaire3.R;
import com.scsi.inventaire3.authentification.LoginActivity;
import com.scsi.inventaire3.bdd.entity.ZONES;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;
import com.tfb.fbtoast.FBToast;

import java.util.List;

import androidx.core.content.ContextCompat;

/* loaded from: classes2.dex */
public class ZONNESAdapter extends BaseAdapter {
    static AppDatabase db;
    private Activity activity;
    private List<ZONES> liste_zonnes;
    LayoutInflater mInflater;

    public ZONNESAdapter(Activity activity, List<ZONES> list) {
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

            db = AppDatabase.getAppDatabase(this.activity);


            TextView textView = holder.txt_zonne;
            textView.setText(this.liste_zonnes.get(position).getZN_CODE() + "");

            if (position % 2 != 0) {
                holder.img_zonne.setImageDrawable(activity.getResources().getDrawable(R.drawable.zonne_rouge));
            }else
            {
                holder.img_zonne.setImageDrawable(activity.getResources().getDrawable(R.drawable.zonne_vert));

            }
            convertView2.setTag(holder);
        } else {
            ViewHolder_zonne viewHolder_zonne = (ViewHolder_zonne) convertView2.getTag();
        }
        return convertView2;
    }
}
