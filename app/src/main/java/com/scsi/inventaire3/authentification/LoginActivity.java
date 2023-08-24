package com.scsi.inventaire3.authentification;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.scsi.inventaire3.MainActivity;
import com.scsi.inventaire3.ParametrageActivity;
import com.scsi.inventaire3.R;
import com.scsi.inventaire3.bdd.entity.INV_ENTETES;
import com.scsi.inventaire3.bdd.entity.USERS;
import com.scsi.inventaire3.bdd.singleton.AppDatabase;
import com.scsi.inventaire3.divers.Utils;
import com.scsi.inventaire3.inventaire.LoadInventaireActivity;
import com.scsi.inventaire3.splash.AcceuilActivity;
import com.tfb.fbtoast.FBToast;

import static com.scsi.inventaire3.divers.Utils.GET_SHARED_USER_ID;
import static com.scsi.inventaire3.splash.AcceuilActivity.USER_CONNECTED;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.txt_valider)
    TextView txt_valider;
    @BindView(R.id.edit_user_name)
    EditText edit_user_name;
    @BindView(R.id.edit_password)
    EditText edit_password;
    AppDatabase db;
    public static INV_ENTETES invEntetes = new INV_ENTETES();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        db = AppDatabase.getAppDatabase(this);

        int USER_ID = GET_SHARED_USER_ID(LoginActivity.this);
        if (USER_ID != -1) {

            USER_CONNECTED=db.USERSDao().getUsersUSER_ID(USER_ID);
            if (USER_CONNECTED!=null)
            {


                invEntetes = db.INV_ENTETESDao().getINV_ENTETES();
                if (LoginActivity.invEntetes == null) {
                    Intent intent = new Intent(LoginActivity.this.getApplicationContext(), LoadInventaireActivity.class);
                    LoginActivity.this.startActivity(intent);
                } else {

                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(i);
                }





                startActivity(new Intent(this, LoadInventaireActivity.class));
                finish();
            }else
            {

            }

        }
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txt_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edit_user_name.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Nom d'utilisateur obligatoire", Toast.LENGTH_SHORT).show();

                    edit_user_name.setError("Nom d'utilisateur obligatoire");
                    edit_user_name.requestFocus();
                } else if (edit_password.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Mot de passe obligatoire", Toast.LENGTH_SHORT).show();
                    edit_password.setError("Mot de passe obligatoire");
                    edit_password.requestFocus();
                }else
                {
                    USER_CONNECTED = db.USERSDao().getUserByLoginPWD(edit_user_name.getText().toString(),edit_password.getText().toString());
                    if (USER_CONNECTED != null) {
                        Utils.insert_shared_user(LoginActivity.this, USER_CONNECTED.getUSR_ID());
                        startActivity(new Intent(LoginActivity.this, LoginActivity.class));
                        finish();

                    } else {
                        FBToast.errorToast(LoginActivity.this, "Authentification impossible", 0);

                    }
                }



            }
        });
    }
}