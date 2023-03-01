package com.example.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    KendaliLogin KL = new KendaliLogin();
    private TextView tvSesi;
    private Button btnLogout;
    private String ambilSesi;
    public static String keySPusername = "spPadang";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (KL.isLogin(MainActivity.this, keySPusername) == true)
        {
            setContentView(R.layout.activity_main);

//            tvSesi = findViewById(R.id.tv_sesi);
//            tvSesi.setText(KL.getPref(MainActivity.this, keySPusername));

            ambilSesi = KL.getPref(MainActivity.this, keySPusername);
            tvSesi = findViewById(R.id.tv_sesi);
            tvSesi.setText(ambilSesi);
            btnLogout = findViewById(R.id.btn_logout);
        }
        else
        {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }

    public void prosesLogout(View view)
    {
        KL.setPref(MainActivity.this, keySPusername,null);
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }
}