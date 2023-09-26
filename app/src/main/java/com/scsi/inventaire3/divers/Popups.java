package com.scsi.inventaire3.divers;

import android.app.Activity;
import android.app.Dialog;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding4.view.RxView;
import com.scsi.inventaire3.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

public class Popups {


    public static void show_dialog_error(String m, Activity activity, int WITH_FINISH) {
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.custom_dialog_layout_error);
        TextView message = (TextView) dialog.findViewById(R.id.message);
        message.setText(m);
        dialog.setCancelable(false);

        Button btn_ok = (Button) dialog.findViewById(R.id.btn_ok);
        RxView.clicks(btn_ok)
                .throttleFirst(100, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe(s -> {

                    dialog.dismiss();
                    if (WITH_FINISH == 1) {
                        activity.finish();
                    }

                });



        if ((activity).isFinishing()) {
            return;
        }
        dialog.show();

    }


    public static void show_dialog_succes(String m, final Activity activity, int WITH_FINISH) {
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.custom_dialog_layout_succes);
        Button btn_ok = (Button) dialog.findViewById(R.id.btn_ok);
        TextView message = (TextView) dialog.findViewById(R.id.message);
        message.setText(m);
        dialog.setCancelable(false);

        RxView.clicks(btn_ok)
                .throttleFirst(100, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe(s -> {

                    dialog.dismiss();
                    if (WITH_FINISH == 1) {
                        activity.finish();
                    }

                });



        if ((activity).isFinishing()) {
            return;
        }
        dialog.show();
    }

}
