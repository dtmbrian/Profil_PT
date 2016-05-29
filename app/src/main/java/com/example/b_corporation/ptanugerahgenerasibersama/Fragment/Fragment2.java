package com.example.b_corporation.ptanugerahgenerasibersama.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.b_corporation.ptanugerahgenerasibersama.Activities.History_proyek;
import com.example.b_corporation.ptanugerahgenerasibersama.Activities.PilihTampilProyek;
import com.example.b_corporation.ptanugerahgenerasibersama.Model.Proyek;
import com.example.b_corporation.ptanugerahgenerasibersama.R;

/**
 * Created by B-Corporation on 5/25/2016.
 */
public class Fragment2 extends Fragment{
    Spinner spinner2;
    Button Tampil_tahun;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment2, container,false);
        this.spinner2 = (Spinner) v.findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this.getActivity(), R.array.tahun_proyek, android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapterSpinner);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String selecting;
            @Override
            public void onItemSelected(AdapterView<?> parent, View v,
                                       int position, long id) {

                selecting = parent.getItemAtPosition(position).toString();
                }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

        this.Tampil_tahun = (Button) v.findViewById(R.id.tmpl_tahun);
        Tampil_tahun.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), History_proyek.class);
                intent.putExtra("Flag", spinner2.getSelectedItem().toString());
                startActivity(intent);
            }
        });
        return v;
    }
}



