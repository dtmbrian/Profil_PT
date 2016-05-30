package com.example.b_corporation.ptanugerahgenerasibersama.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.b_corporation.ptanugerahgenerasibersama.Database.DatabaseAccess;
import com.example.b_corporation.ptanugerahgenerasibersama.Model.Proyek;
import com.example.b_corporation.ptanugerahgenerasibersama.R;

import java.util.List;

public class HistoryProyek extends AppCompatActivity {
    private ListView listViewproyek;
    private List<Proyek> lproyek;
    private DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_proyek);

        this.listViewproyek = (ListView) findViewById(R.id.display_proyek);
        this.databaseAccess = DatabaseAccess.getInstance(getApplicationContext());

    }

    private List<Proyek> getProyek(int tahun) {
        databaseAccess.open();
        List<Proyek> listproyek = databaseAccess.getProyek(tahun);
        databaseAccess.close();
        return listproyek;
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateListView();
    }

    private void updateListView() {

        String flag = String.valueOf(getIntent().getStringExtra("Flag"));
        int tahun = Integer.parseInt(flag);

        lproyek = getProyek(tahun);
        ProyekAdapter adapter = new ProyekAdapter(this, lproyek);
        listViewproyek.setAdapter(adapter);
    }

    private class ProyekAdapter extends ArrayAdapter<Proyek> {
        public ProyekAdapter(Context context, List<Proyek> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.hp_row, parent, false);
            }

            TextView txtNoproy = (TextView) convertView.findViewById(R.id.t_noproy);
            TextView txtNamapekerjaan = (TextView) convertView.findViewById(R.id.t_namaproy);
            TextView txtBidpek = (TextView) convertView.findViewById(R.id.t_bidpek);
            TextView txtNPT = (TextView) convertView.findViewById(R.id.t_npt);
            TextView txtAPT = (TextView) convertView.findViewById(R.id.t_apt);
            TextView txtNTK = (TextView) convertView.findViewById(R.id.t_ntk);
            TextView txtNRK = (TextView) convertView.findViewById(R.id.t_nrk);
            TextView txtTSMK = (TextView) convertView.findViewById(R.id.t_tsmk);
            TextView txtTSMBASP = (TextView) convertView.findViewById(R.id.t_tsmbasp);
            Proyek proyek = lproyek.get(position);
            txtNoproy.setText(proyek.getNoProy());
            txtNamapekerjaan.setText(proyek.getNamaPekerjaan());
            txtBidpek.setText(proyek.getBidangPekerjaan());
            txtNPT.setText(proyek.getNamaPemberiTgs());
            txtAPT.setText(proyek.getAlamatPemberiTgs());
            txtNTK.setText(proyek.getNmrTglKontrak());
            txtNRK.setText(proyek.getNilaiRpKontrak());
            txtTSMK.setText(proyek.getTglSelesaiMnrtKontrak());
            txtTSMBASP.setText(proyek.getTglSelesaiMnrtBaSp());
            return convertView;
        }
    }
}


