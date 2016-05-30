package com.example.b_corporation.ptanugerahgenerasibersama.Activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.b_corporation.ptanugerahgenerasibersama.Fragment.FragPilih;
import com.example.b_corporation.ptanugerahgenerasibersama.R;

public class PilihTampilProyek extends Activity {
    Button B1, B2, B3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilih_tampil_proyek);

        this.B3 = (Button) findViewById(R.id.tmpl_brdsrkn);
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager FM = getFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();
                FragPilih fragP = new FragPilih();
                FT.add(R.id.rel_frag, fragP);
                FT.addToBackStack("fragP");
                FT.commit();
            }
        });
        this.B2 = (Button) findViewById(R.id.tmpl_semua);
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), HistoryProyek.class);
                i.putExtra("Flag", "all");
                startActivity(i);
            }
        });
    }

    public void displayFoto(View view) {
        startActivity(new Intent(this, TampilFoto.class));
    }
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
