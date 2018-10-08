package com.marius.app.myapplicationmeginimas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;


public class Rezultatai extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultatas);
        TextView zaidimoRezultatas = findViewById(R.id.zaidimoRezultatas);
        TextView rekordas = findViewById(R.id.rekordas);

        int suviai = getIntent().getIntExtra("suviai", 0);
        zaidimoRezultatas.setText("Padaryta šūvių:" + suviai);

        SharedPreferences issaugojimas = getSharedPreferences("Zaidimo rezultatai", Context.MODE_PRIVATE);
        int geriausias = issaugojimas.getInt("Zaidimo rezultatai", 100);

        if (suviai < geriausias) {
            rekordas.setText("Geriausias rezultatas: " + suviai);

            // Issaugojimas
            SharedPreferences.Editor editor = issaugojimas.edit();
            editor.putInt("Zaidimo rezultatai", suviai);
            editor.commit();
        } else  {
            rekordas.setText("Geriausias rezultatas: " +  geriausias);
        }
    }
    @Override
    public void onBackPressed(){
        System.exit(0);
    }
    public void Kartojimas(View view) {
        finish();
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);

        // Tapati daro ir == System.exit(0);
    }
}
