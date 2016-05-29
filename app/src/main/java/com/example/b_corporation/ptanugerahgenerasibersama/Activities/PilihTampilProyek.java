package com.example.b_corporation.ptanugerahgenerasibersama.Activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.b_corporation.ptanugerahgenerasibersama.Fragment.FragPilih;
import com.example.b_corporation.ptanugerahgenerasibersama.R;

/**
 * Created by B-Corporation on 5/25/2016.
 */
public class PilihTampilProyek extends Activity {
    Button B1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilih_tampil_proyek);

        this.B1 = (Button) findViewById(R.id.tmpl_brdsrkn);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager FM=getFragmentManager();
                FragmentTransaction FT=FM.beginTransaction();
                FragPilih fragP= new FragPilih();
                FT.add(R.id.rel_frag, fragP);
                FT.addToBackStack("fragP");
                FT.commit();

            }
        });

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
