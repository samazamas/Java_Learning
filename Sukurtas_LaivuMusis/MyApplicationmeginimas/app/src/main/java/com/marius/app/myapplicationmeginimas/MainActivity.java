package com.marius.app.myapplicationmeginimas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    int laimejimas;
private LaivuGeneratorius laiveliai;
private Rezultatai rezas;
TextView btn;
    int skaiciuotuvas = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.suviuskaicius);
        laiveliai = new LaivuGeneratorius();
        rezas = new Rezultatai();
        laimejimas=0;
    }


    public void Paspaudimas (View v) {
        skaiciuotuvas++;
        btn.setText(""+ String.valueOf(skaiciuotuvas));

        // perziuri visus laukelius ir sugeneruoja juos priskiria jiems reiksmes.
        LinearLayout linearFilas = findViewById(R.id.linearFilas);
        for(int i=0; i< linearFilas.getChildCount(); i++)
        {
            // Label the row
            LinearLayout row = (LinearLayout) linearFilas.getChildAt(i);
            row.setTag(""+i);
            // Scroll through columns in each row
            for(int j=0; j<row.getChildCount();j++){
                View view = row.getChildAt(j);
                // Label column
                view.setTag(""+j);
            }
        }

        View viewFila = (View) v.getParent();
        int row = Integer.parseInt(viewFila.getTag().toString());
        int column = Integer.parseInt(v.getTag().toString());

        if(laiveliai.hayBarco(row, column)) {
            v.setBackgroundResource(R.drawable.bomba);
            v.setEnabled(false);
            laimejimas=laimejimas+1;
            if (laimejimas == 24) {
                Intent result = new Intent(getApplicationContext(), Rezultatai.class);
                result.putExtra("suviai", skaiciuotuvas);
                startActivity(result);
            }
        } else {
            v.setBackgroundResource(R.drawable.nepataikyta);
            v.setEnabled(false);
        }


    }
}
