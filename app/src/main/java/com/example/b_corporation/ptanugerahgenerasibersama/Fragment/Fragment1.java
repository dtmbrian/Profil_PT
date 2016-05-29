package com.example.b_corporation.ptanugerahgenerasibersama.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.b_corporation.ptanugerahgenerasibersama.Activities.History_proyek;
import com.example.b_corporation.ptanugerahgenerasibersama.Activities.Profil_karyawan;
import com.example.b_corporation.ptanugerahgenerasibersama.R;

/**
 * Created by B-Corporation on 5/25/2016.
 */
public class Fragment1 extends Fragment {
    Button TampilTahun;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment1, container,false);
        return v;
    }

}

