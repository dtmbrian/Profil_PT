package com.example.b_corporation.ptanugerahgenerasibersama.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



import com.example.b_corporation.ptanugerahgenerasibersama.Activities.HistoryProyek;
import com.example.b_corporation.ptanugerahgenerasibersama.R;

public class Fragment1 extends Fragment {
    EditText eMin, eMax;
    Button Tampil_nilai;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, container, false);
        this.eMin = (EditText) v.findViewById(R.id.editMin);
        this.eMax = (EditText) v.findViewById(R.id.editMax);

        this.Tampil_nilai = (Button) v.findViewById(R.id.display_nilai);
        Tampil_nilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HistoryProyek.class);
                intent.putExtra("Flag", "nilai");
                intent.putExtra("nilaiMin", eMin.getEditableText().toString());
                intent.putExtra("nilaiMax", eMax.getEditableText().toString());
                startActivity(intent);
            }
        });

        return v;
    }

}