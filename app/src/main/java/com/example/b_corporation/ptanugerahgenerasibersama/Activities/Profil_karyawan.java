package com.example.b_corporation.ptanugerahgenerasibersama.Activities;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.b_corporation.ptanugerahgenerasibersama.Model.Karyawan;
import com.example.b_corporation.ptanugerahgenerasibersama.R;

import java.util.List;

/**
 * Created by B-Corporation on 4/28/2016.
 */
public class Profil_karyawan extends AppCompatActivity {
    private ListView listViewkaryawan;
    private List<Karyawan> lkaryawan;
    private DatabaseAccess databaseAccess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_karyawan);

        this.listViewkaryawan = (ListView) findViewById(R.id.display_karyawan);
        this.databaseAccess = DatabaseAccess.getInstance(getApplicationContext());

    }

    private List<Karyawan> getKaryawan() {
        databaseAccess.open();
        List<Karyawan> list = databaseAccess.getKaryawan();
        databaseAccess.close();
        return list;
    }
    @Override
    protected void onResume() {
        super.onResume();
        updateListView();
    }

    private void updateListView() {
        this.lkaryawan = getKaryawan();

        // Create the adapter and assign to ListView
        KaryawanAdapter adapter = new KaryawanAdapter(this, lkaryawan);
        this.listViewkaryawan.setAdapter(adapter);
    }

    private class KaryawanAdapter extends ArrayAdapter<Karyawan> {
        public KaryawanAdapter(Context context, List<Karyawan> objects) {
            super(context, 0, objects);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.pk_row, parent, false);
            }
            TextView txtNo = (TextView) convertView.findViewById(R.id.t_no);
            TextView txtNama = (TextView) convertView.findViewById(R.id.t_nama);
            TextView txtJabatan = (TextView) convertView.findViewById(R.id.t_jbtn);
            TextView txtBK = (TextView) convertView.findViewById(R.id.t_bk);
            TextView txtPP = (TextView) convertView.findViewById(R.id.t_pp);
            TextView txtTM = (TextView) convertView.findViewById(R.id.t_tm);
            Karyawan karyawan = lkaryawan.get(position);
            txtNo.setText(karyawan.getNo());
            txtNama.setText(karyawan.getNamaKaryawan());
            txtJabatan.setText(karyawan.getJabatan());
            txtBK.setText(karyawan.getBidangKeahlian());
            txtPP.setText(karyawan.getPengalamanProfesi());
            txtTM.setText(karyawan.getTanggalMasuk());
            return convertView;
        }
    }
}



