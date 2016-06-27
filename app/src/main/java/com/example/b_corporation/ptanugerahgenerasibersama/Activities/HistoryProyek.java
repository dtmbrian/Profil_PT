package com.example.b_corporation.ptanugerahgenerasibersama.Activities;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.b_corporation.ptanugerahgenerasibersama.Database.DatabaseAccess;
import com.example.b_corporation.ptanugerahgenerasibersama.Listview.CustomAdapter;
import com.example.b_corporation.ptanugerahgenerasibersama.Model.Proyek;
import com.example.b_corporation.ptanugerahgenerasibersama.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryProyek extends AppCompatActivity {
    private ListView listViewproyek;
    public List<Proyek> lproyek;
    public ArrayList<Proyek> proyeks = new ArrayList<>();
    private DatabaseAccess databaseAccess1;
    private EditText noedText, namaedText, bpedText, nmptedText, almtptedText, nmrtgledText, nilairpedText, tglkontrakedText, tglbaspedText;
    Button btnsimpan, btnmuatUlang;
    Proyek proyek;
    CustomAdapter Cadapter;
    final Boolean forUpdate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_proyek);

        this.listViewproyek = (ListView) findViewById(R.id.display_proyek);
        this.databaseAccess1 = DatabaseAccess.getInstance(getApplicationContext());
        Cadapter = new CustomAdapter(this, proyeks);
        this.getProyeks();

    }

    private List<Proyek> getProyektahun(int tahun) {
        databaseAccess1.open();
        List<Proyek> listproyektahun = databaseAccess1.getProyektahun(tahun);
        databaseAccess1.close();
        return listproyektahun;
    }

    private List<Proyek> getProyek() {
        databaseAccess1.open();
        List<Proyek> listproyek = databaseAccess1.getProyek();
        databaseAccess1.close();
        return listproyek;
    }

    private List<Proyek> getProyeknilai(int nilai1, int nilai2) {
        databaseAccess1.open();
        List<Proyek> listproyeknilai = databaseAccess1.getProyeknilai(nilai1, nilai2);
        databaseAccess1.close();
        return listproyeknilai;
    }


    private void displayDialog(Boolean forUpdate) {
        Dialog d = new Dialog(this);
        d.setTitle("Kelola Data Proyek");
        d.setContentView(R.layout.dialog_layout);
        noedText = (EditText) d.findViewById(R.id.noEdtext);
        namaedText = (EditText) d.findViewById(R.id.namaEdtext);
        bpedText = (EditText) d.findViewById(R.id.bpEdtext);
        nmptedText = (EditText) d.findViewById(R.id.nmPtEdtext);
        almtptedText = (EditText) d.findViewById(R.id.almtPtEdtext);
        nmrtgledText = (EditText) d.findViewById(R.id.nmrTglEdtext);
        nilairpedText = (EditText) d.findViewById(R.id.nilaiRpEdtext);
        tglkontrakedText = (EditText) d.findViewById(R.id.tglselesaikontrakEdtext);
        tglbaspedText = (EditText) d.findViewById(R.id.tglselesaibaspEdtext);
        btnsimpan = (Button) d.findViewById(R.id.btnsimpan);
        btnmuatUlang = (Button) d.findViewById(R.id.btnReload);


        if (!forUpdate) {
            btnsimpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    simpan(noedText.getText().toString(), namaedText.getText().toString(), bpedText.getText().toString(), nmptedText.getText().toString(), almtptedText.getText().toString(), nmrtgledText.getText().toString(), nilairpedText.getText().toString(), tglkontrakedText.getText().toString(), tglbaspedText.getText().toString());
                }
            });
            btnmuatUlang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getProyeks();
                }
            });

        } else {
            String id = Integer.toString(Cadapter.getSelectedNoProy());
            noedText.setText(id);
            namaedText.setText(Cadapter.getSelectedNamaPekerjaan());
            bpedText.setText(Cadapter.getSelectedBidangPekerjaan());
            nmptedText.setText(Cadapter.getSelectedNamaPemberiTgs());
            almtptedText.setText(Cadapter.getSelectedAlamatPemberiTgs());
            nmrtgledText.setText(Cadapter.getSelectedNmrTglKontrak());
            nilairpedText.setText(Cadapter.getSelectedNilaiRpKontrak());
            tglkontrakedText.setText(Cadapter.getSelectedTglSelesaiMnrtKontrak());
            tglbaspedText.setText(Cadapter.getSelectedTglSelesaiMnrtBasp());

            btnsimpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    update(noedText.getText().toString(), namaedText.getText().toString(), bpedText.getText().toString(), nmptedText.getText().toString(), almtptedText.getText().toString(), nmrtgledText.getText().toString(), nilairpedText.getText().toString(), tglkontrakedText.getText().toString(), tglbaspedText.getText().toString());
                }
            });
            btnmuatUlang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getProyeks();
                }
            });
        }

        d.show();

    }

    //save
    private void simpan(String noProy, String namaPekerjaan, String bidangPekerjaan, String namaPemberiTgs, String alamatPemberiTugas, String nomorTglKontrak, String nilaiRpKontrak, String tglSelesaiMenurutKontrak, String tglSelesaiMenurutBasp) {
        DatabaseAccess databaseAccess = new DatabaseAccess(this);
        databaseAccess.open();
        boolean saved = databaseAccess.add(noProy, namaPekerjaan, bidangPekerjaan, namaPemberiTgs, alamatPemberiTugas, nomorTglKontrak, nilaiRpKontrak, tglSelesaiMenurutKontrak, tglSelesaiMenurutBasp);
        if (saved) {
            noedText.setText("");
            namaedText.setText("");
            bpedText.setText("");
            nmptedText.setText("");
            almtptedText.setText("");
            nmrtgledText.setText("");
            nilairpedText.setText("");
            tglkontrakedText.setText("");
            tglbaspedText.setText("");
            getProyeks();
        } else {
            Toast.makeText(this, "Tidak Dapat Menyimpan Data", Toast.LENGTH_SHORT).show();
        }


    }

    protected void onResume() {
        super.onResume();
        updateListView();
    }

    private void updateListView() {

        String flag = String.valueOf(getIntent().getStringExtra("Flag"));
        String nilaiMin = String.valueOf(getIntent().getStringExtra("nilaiMin"));
        String nilaiMax = String.valueOf(getIntent().getStringExtra("nilaiMax"));
        if (flag.equalsIgnoreCase("all")) {
            displayDialog(false);
        } else {
            if (flag.equalsIgnoreCase("nilai")) {
                int nilai1 = Integer.parseInt(nilaiMin);
                int nilai2 = Integer.parseInt(nilaiMax);
                this.lproyek = getProyeknilai(nilai1, nilai2);
                ProyekAdapter adapter = new ProyekAdapter(this, lproyek);
                listViewproyek.setAdapter(adapter);
            } else {
                int tahun = Integer.parseInt(flag);
                this.lproyek = getProyektahun(tahun);
                ProyekAdapter adapter = new ProyekAdapter(this, lproyek);
                listViewproyek.setAdapter(adapter);
            }
        }

    }

    private void delete() {
        DatabaseAccess databaseAccess = new DatabaseAccess(this);
        int id = Cadapter.getSelectedNoProy();
        databaseAccess.open();
        boolean deleted = databaseAccess.delete(id);
        databaseAccess.close();
        if (deleted) {

            getProyeks();
        } else {
            Toast.makeText(this, "Tidak Dapat Menghapus Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void update(String newNoProy, String newNamaPekerjaan, String newBidangPekerjaan, String newNamaPemberiTgs, String newAlamatPemberiTugas, String newNomorTglKontrak, String newNilaiRpKontrak, String newTglSelesaiMenurutKontrak, String newTglSelesaiMenurutBasp) {
        DatabaseAccess databaseAccess = new DatabaseAccess(this);
        int id = Cadapter.getSelectedNoProy();
        databaseAccess.open();
        boolean updated = databaseAccess.update(newNoProy, newNamaPekerjaan, newBidangPekerjaan, newNamaPemberiTgs, newAlamatPemberiTugas, newNomorTglKontrak, newNilaiRpKontrak, newTglSelesaiMenurutKontrak, newTglSelesaiMenurutBasp, id);
        databaseAccess.close();

        if (updated) {
            noedText.setText(newNoProy);
            namaedText.setText(newNamaPekerjaan);
            bpedText.setText(newBidangPekerjaan);
            nmptedText.setText(newNamaPemberiTgs);
            almtptedText.setText(newAlamatPemberiTugas);
            nmrtgledText.setText(newNomorTglKontrak);
            nilairpedText.setText(newNilaiRpKontrak);
            tglkontrakedText.setText(newTglSelesaiMenurutKontrak);
            tglbaspedText.setText(newTglSelesaiMenurutBasp);
            getProyeks();
        } else {
            Toast.makeText(this, "Tidak Dapat Meng-Update Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void getProyeks() {
        proyeks.clear();
        DatabaseAccess databaseAccess = new DatabaseAccess(this);
        databaseAccess.open();
        Cursor c = databaseAccess.retrieve();
        Proyek proyek = null;


        while (c.moveToNext()) {
            int id = c.getInt(0);
            String nama = c.getString(1);
            String bp = c.getString(2);
            String npt = c.getString(3);
            String apt = c.getString(4);
            String ntk = c.getString(5);
            String nrk = c.getString(6);
            String tsmk = c.getString(7);
            String tsmbasp = c.getString(8);
            proyek = new Proyek();
            proyek.setNoProy(id);
            proyek.setNamaPekerjaan(nama);
            proyek.setBidangPekerjaan(bp);
            proyek.setNamaPemberiTgs(npt);
            proyek.setAlamatPemberiTgs(apt);
            proyek.setNmrTglKontrak(ntk);
            proyek.setNilaiRpKontrak(nrk);
            proyek.setTglSelesaiMnrtKontrak(tsmk);
            proyek.setTglSelesaiMnrtBaSp(tsmbasp);
            proyeks.add(proyek);

        }
        databaseAccess.close();
        listViewproyek.setAdapter(Cadapter);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        CharSequence title = item.getTitle();
        if (title == "Tambah Data") {
            displayDialog(!forUpdate);
        } else if (title == "Edit Data") {
            displayDialog(forUpdate);
        } else if (title == "Hapus Data") {
            delete();
        }
        return super.onContextItemSelected(item);
    }

    private class ProyekAdapter extends ArrayAdapter<Proyek> {
        public ProyekAdapter(Context context, List<Proyek> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.model1, parent, false);
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
            String id = Integer.toString(proyek.getNoProy());
            txtNoproy.setText(id);
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


