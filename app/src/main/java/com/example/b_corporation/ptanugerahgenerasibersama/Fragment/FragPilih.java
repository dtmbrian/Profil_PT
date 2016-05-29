package com.example.b_corporation.ptanugerahgenerasibersama.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.b_corporation.ptanugerahgenerasibersama.R;

/**
 * Created by B-Corporation on 5/25/2016.
 */
public class FragPilih extends Fragment {
    Button Bnilai,Btahun;
    FragmentManager FM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.frag_pilih, container,false);

        this.Bnilai =(Button) v.findViewById(R.id.nilai_proyek);
        this.Btahun =(Button) v.findViewById(R.id.thn_proyek);

        Bnilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment1 fragment1 = new Fragment1();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction =        fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.rel_frag, fragment1);
                fragmentTransaction.addToBackStack("f1");
                fragmentTransaction.commit();
            }
        });


        Btahun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment2 fragment2 = new Fragment2();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction =        fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.rel_frag, fragment2);
                fragmentTransaction.addToBackStack("f2");
                fragmentTransaction.commit();
            }
        });
        return v;
    }
}



