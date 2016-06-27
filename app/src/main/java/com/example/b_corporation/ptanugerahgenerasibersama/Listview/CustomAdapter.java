package com.example.b_corporation.ptanugerahgenerasibersama.Listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.b_corporation.ptanugerahgenerasibersama.Model.Proyek;
import com.example.b_corporation.ptanugerahgenerasibersama.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by B-Corporation on 6/18/2016.
 */
public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Proyek> proyeks;
    Proyek proyek;
    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<Proyek> proyeks) {
        this.c = c;
        this.proyeks = proyeks;
    }

    @Override
    public int getCount() {
        return proyeks.size();
    }

    @Override
    public Object getItem(int position) {
        return proyeks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.model1, parent, false);
        }
        //BIND DATA
        MyViewHolder holder = new MyViewHolder(convertView);

        holder.txtNoproy.setText(Integer.toString(proyeks.get(position).getNoProy()));
        holder.txtNamapekerjaan.setText(proyeks.get(position).getNamaPekerjaan());
        holder.txtBidpek.setText(proyeks.get(position).getBidangPekerjaan());
        holder.txtNPT.setText(proyeks.get(position).getNamaPemberiTgs());
        holder.txtAPT.setText(proyeks.get(position).getAlamatPemberiTgs());
        holder.txtNTK.setText(proyeks.get(position).getNmrTglKontrak());
        holder.txtNRK.setText(proyeks.get(position).getNilaiRpKontrak());
        holder.txtTSMK.setText(proyeks.get(position).getTglSelesaiMnrtKontrak());
        holder.txtTSMBASP.setText(proyeks.get(position).getTglSelesaiMnrtBaSp());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, proyeks.get(position).getNamaPekerjaan(), Toast.LENGTH_SHORT).show();

            }
        });

        holder.setLongClickListener(new MyLongClickListener() {
            @Override
            public void onItemLongClick() {
                proyek = (Proyek) getItem(position);
            }
        });
        return convertView;
    }

    public Integer getSelectedNoProy() {
        return proyek.getNoProy();
    }

    public String getSelectedNamaPekerjaan() {

        return proyek.getNamaPekerjaan();
    }

    public String getSelectedBidangPekerjaan() {
        return proyek.getBidangPekerjaan();
    }

    public String getSelectedNamaPemberiTgs() {
        return proyek.getNamaPemberiTgs();
    }

    public String getSelectedAlamatPemberiTgs() {
        return proyek.getAlamatPemberiTgs();
    }

    public String getSelectedNmrTglKontrak() {
        return proyek.getNmrTglKontrak();
    }

    public String getSelectedNilaiRpKontrak() {
        return proyek.getNilaiRpKontrak();
    }

    public String getSelectedTglSelesaiMnrtKontrak() {
        return proyek.getTglSelesaiMnrtKontrak();
    }

    public String getSelectedTglSelesaiMnrtBasp() {
        return proyek.getTglSelesaiMnrtBaSp();
    }
}
