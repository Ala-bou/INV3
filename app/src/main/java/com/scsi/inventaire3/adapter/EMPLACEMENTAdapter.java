package com.scsi.inventaire3.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.scsi.inventaire3.R;
import com.scsi.inventaire3.bdd.entity.EMPLACEMENT;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;

import java.util.List;

/* loaded from: classes2.dex */
public class EMPLACEMENTAdapter extends BaseAdapter {
    static AppDatabase db;
    private Activity activity;
    private List<EMPLACEMENT> liste_emplacement;
    LayoutInflater mInflater;

    public EMPLACEMENTAdapter(Activity activity, List<EMPLACEMENT> list) {
        this.activity = activity;
        this.liste_emplacement = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.liste_emplacement.size();
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
    public View getView(int position, View convertView, ViewGroup arg2) {
        View convertView2 = null;
        if (0 == 0) {
            ViewHolder holder = new ViewHolder();
            this.mInflater = (LayoutInflater) this.activity.getSystemService("layout_inflater");
            convertView2 = this.mInflater.inflate(R.layout.emplacement_item, (ViewGroup) null);
            holder.txt_emplacement = (TextView) convertView2.findViewById(R.id.txt_emplacement);
            holder.img_empl =  convertView2.findViewById(R.id.img_empl);
              db = AppDatabase.getAppDatabase(this.activity);
            if (position % 2 != 0) {
                holder.img_empl.setImageDrawable(activity.getResources().getDrawable(R.drawable.emplacement_rouge));
            }else
            {
                holder.img_empl.setImageDrawable(activity.getResources().getDrawable(R.drawable.emplacement_vert));

            }

            TextView textView = holder.txt_emplacement;
            textView.setText(this.liste_emplacement.get(position).getEMP_CODE() + "");
            convertView2.setTag(holder);
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView2.getTag();
        }
        return convertView2;
    }
}
