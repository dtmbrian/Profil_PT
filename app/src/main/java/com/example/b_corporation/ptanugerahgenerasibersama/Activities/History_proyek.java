package com.example.b_corporation.ptanugerahgenerasibersama.Activities;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.b_corporation.ptanugerahgenerasibersama.Model.Proyek;
import com.example.b_corporation.ptanugerahgenerasibersama.R;

import java.util.List;

/**
 * Created by B-Corporation on 4/28/2016.
 */
public class History_proyek extends AppCompatActivity {
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

    private List<Proyek> getProyek() {
        databaseAccess.open();
        List<Proyek> listproyek = databaseAccess.getProyek();
        databaseAccess.close();
        return listproyek;
    }

    private List<Proyek> getProyekTahun04() {
        databaseAccess.open();
        List<Proyek> listproyektahun = databaseAccess.getProyektahun04();
        databaseAccess.close();
        return listproyektahun;
    }
    private List<Proyek> getProyekTahun05() {
        databaseAccess.open();
        List<Proyek> listproyektahun = databaseAccess.getProyektahun05();
        databaseAccess.close();
        return listproyektahun;
    }
    private List<Proyek> getProyekTahun06() {
        databaseAccess.open();
        List<Proyek> listproyektahun = databaseAccess.getProyektahun06();
        databaseAccess.close();
        return listproyektahun;
    }
    private List<Proyek> getProyekTahun07() {
        databaseAccess.open();
        List<Proyek> listproyektahun = databaseAccess.getProyektahun07();
        databaseAccess.close();
        return listproyektahun;
    }
    private List<Proyek> getProyekTahun08() {
        databaseAccess.open();
        List<Proyek> listproyektahun = databaseAccess.getProyektahun08();
        databaseAccess.close();
        return listproyektahun;
    }
    private List<Proyek> getProyekTahun09() {
        databaseAccess.open();
        List<Proyek> listproyektahun = databaseAccess.getProyektahun09();
        databaseAccess.close();
        return listproyektahun;
    }
    private List<Proyek> getProyekTahun10() {
        databaseAccess.open();
        List<Proyek> listproyektahun = databaseAccess.getProyektahun10();
        databaseAccess.close();
        return listproyektahun;
    }
    private List<Proyek> getProyekTahun11() {
        databaseAccess.open();
        List<Proyek> listproyektahun = databaseAccess.getProyektahun11();
        databaseAccess.close();
        return listproyektahun;
    }
    private List<Proyek> getProyekTahun12() {
        databaseAccess.open();
        List<Proyek> listproyektahun = databaseAccess.getProyektahun12();
        databaseAccess.close();
        return listproyektahun;
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateListView();
    }

    private void updateListView() {
        String flag = String.valueOf(getIntent().getStringExtra("Flag"));
        if (flag.equalsIgnoreCase("2004")) {
            this.lproyek = getProyekTahun04();
            // Create the adapter and assign to ListView
            ProyekAdapter adapter = new ProyekAdapter(this, lproyek);
            this.listViewproyek.setAdapter(adapter);
        }if (flag.equalsIgnoreCase("2005")) {
            this.lproyek = getProyekTahun05();
            // Create the adapter and assign to ListView
            ProyekAdapter adapter = new ProyekAdapter(this, lproyek);
            this.listViewproyek.setAdapter(adapter);
        }if (flag.equalsIgnoreCase("2006")) {
            this.lproyek = getProyekTahun06();
            // Create the adapter and assign to ListView
            ProyekAdapter adapter = new ProyekAdapter(this, lproyek);
            this.listViewproyek.setAdapter(adapter);
        }if (flag.equalsIgnoreCase("2007")) {
            this.lproyek = getProyekTahun07();
            // Create the adapter and assign to ListView
            ProyekAdapter adapter = new ProyekAdapter(this, lproyek);
            this.listViewproyek.setAdapter(adapter);
        }if (flag.equalsIgnoreCase("2008")) {
            this.lproyek = getProyekTahun08();
            // Create the adapter and assign to ListView
            ProyekAdapter adapter = new ProyekAdapter(this, lproyek);
            this.listViewproyek.setAdapter(adapter);
        }if (flag.equalsIgnoreCase("2009")) {
            this.lproyek = getProyekTahun09();
            // Create the adapter and assign to ListView
            ProyekAdapter adapter = new ProyekAdapter(this, lproyek);
            this.listViewproyek.setAdapter(adapter);
        }if (flag.equalsIgnoreCase("2010")) {
            this.lproyek = getProyekTahun10();
            // Create the adapter and assign to ListView
            ProyekAdapter adapter = new ProyekAdapter(this, lproyek);
            this.listViewproyek.setAdapter(adapter);
        }if (flag.equalsIgnoreCase("2011")) {
            this.lproyek = getProyekTahun11();
            // Create the adapter and assign to ListView
            ProyekAdapter adapter = new ProyekAdapter(this, lproyek);
            this.listViewproyek.setAdapter(adapter);
        }if (flag.equalsIgnoreCase("2012")) {
            this.lproyek = getProyekTahun12();
            // Create the adapter and assign to ListView
            ProyekAdapter adapter = new ProyekAdapter(this, lproyek);
            this.listViewproyek.setAdapter(adapter);
        }

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


