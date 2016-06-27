package com.example.b_corporation.ptanugerahgenerasibersama.Listview;

import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import com.example.b_corporation.ptanugerahgenerasibersama.R;

/**
 * Created by B-Corporation on 6/18/2016.
 */
public class MyViewHolder implements View.OnLongClickListener, View.OnCreateContextMenuListener {
    TextView txtNoproy, txtNamapekerjaan, txtBidpek, txtNPT, txtAPT, txtNTK, txtNRK, txtTSMK, txtTSMBASP;
    MyLongClickListener longClickListener;

    public MyViewHolder(View v) {
        txtNoproy = (TextView) v.findViewById(R.id.t_noproy);
        txtNamapekerjaan = (TextView) v.findViewById(R.id.t_namaproy);
        txtBidpek = (TextView) v.findViewById(R.id.t_bidpek);
        txtNPT = (TextView) v.findViewById(R.id.t_npt);
        txtAPT = (TextView) v.findViewById(R.id.t_apt);
        txtNTK = (TextView) v.findViewById(R.id.t_ntk);
        txtNRK = (TextView) v.findViewById(R.id.t_nrk);
        txtTSMK = (TextView) v.findViewById(R.id.t_tsmk);
        txtTSMBASP = (TextView) v.findViewById(R.id.t_tsmbasp);
        v.setOnLongClickListener(this);
        v.setOnCreateContextMenuListener(this);
    }

    @Override
    public boolean onLongClick(View v) {
        this.longClickListener.onItemLongClick();
        return false;
    }

    public void setLongClickListener(MyLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Kelola Proyek: ");
        menu.add(0, 0, 0, "Tambah Data");
        menu.add(0, 1, 0, "Edit Data");
        menu.add(0, 2, 0, "Hapus Data");
    }
}
