package org.dedepradana.snackbarexample;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dedepradana on 3/24/16.
 * Copyright (C) 2016 Dede Pradana <me@dedepradana.org>
 */

// Ingat, sample project ini bukan "best practice", hanya sekedar contoh penggunaan.
// Untuk best practice coding pelajari lebih lanjut tentang design pattern di android. Ex : MVP , MVC, MVVM.
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btSimple, btAction, btCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSimple = (Button) findViewById(R.id.btSimple);
        btAction = (Button) findViewById(R.id.btAction);
        btCustom = (Button) findViewById(R.id.btCustom);

        btSimple.setOnClickListener(this);
        btAction.setOnClickListener(this);
        btCustom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btSimple:
                showSimpleSB();
                break;
            case R.id.btAction:
                showActionSB();
                break;
            case R.id.btCustom:
                showCustomSB();
                break;
        }
    }

    private void showCustomSB() {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Halo dede!", Snackbar.LENGTH_LONG);

        // Set warna action text menjadi merah
        snackbar.setActionTextColor(Color.RED);

        // Tambahkan action text "Ok" dan action menampilkan message Toast "Bye!"
        snackbar.setAction("Ok", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Bye!", Toast.LENGTH_SHORT).show();
            }
        });


        View snackbarView = snackbar.getView();

        // set warna message text menjadi hijau
        TextView tv = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(Color.GREEN);
        snackbar.show();
    }

    private void showActionSB() {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Halo dede!", Snackbar.LENGTH_LONG);

        // Tambahkan action text "Ok" dan action menampilkan message Toast "Bye!"
        snackbar.setAction("Ok", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Bye!", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }

    private void showSimpleSB() {
        Snackbar.make(findViewById(android.R.id.content), "Halo dede!", Snackbar.LENGTH_LONG).show();
    }


}
