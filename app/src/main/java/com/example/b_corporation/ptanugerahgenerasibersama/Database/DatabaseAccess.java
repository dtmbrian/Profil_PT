package com.example.b_corporation.ptanugerahgenerasibersama.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.b_corporation.ptanugerahgenerasibersama.Model.Karyawan;
import com.example.b_corporation.ptanugerahgenerasibersama.Model.Proyek;


import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public List<Karyawan> getKaryawan() {
        List<Karyawan> listKaryawan = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbl_karyawan", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Karyawan karyawan = new Karyawan();
            karyawan.setNo(cursor.getString(0));
            karyawan.setNamaKaryawan(cursor.getString(1));
            karyawan.setJabatan(cursor.getString(2));
            karyawan.setBidangKeahlian(cursor.getString(3));
            karyawan.setPengalamanProfesi(cursor.getString(4));
            karyawan.setTanggalMasuk(cursor.getString(5));
            listKaryawan.add(karyawan);
            cursor.moveToNext();
        }

        cursor.close();
        return listKaryawan;
    }

    public List<Proyek> getProyek() {
        List<Proyek> listProyek = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbl_proyek", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Proyek proyek = new Proyek();
            proyek.setNoProy(cursor.getString(0));
            proyek.setNamaPekerjaan(cursor.getString(1));
            proyek.setBidangPekerjaan(cursor.getString(2));
            proyek.setNamaPemberiTgs(cursor.getString(3));
            proyek.setAlamatPemberiTgs(cursor.getString(4));
            proyek.setNmrTglKontrak(cursor.getString(5));
            proyek.setNilaiRpKontrak(cursor.getString(6));
            proyek.setTglSelesaiMnrtKontrak(cursor.getString(7));
            proyek.setTglSelesaiMnrtBaSp(cursor.getString(8));
            listProyek.add(proyek);
            cursor.moveToNext();
        }

        cursor.close();
        return listProyek;
    }


    public List<Proyek> getProyektahun(int tahun) {
        List<Proyek> listProyekTahun = new ArrayList<>();
        String query = "SELECT * FROM tbl_proyek";
        if (tahun != 0) {
            query = String.format("SELECT * FROM tbl_proyek " +
                            "WHERE tgl_selesai_mnrt_kontrak BETWEEN '%d-01-01 AND '%d-12-31'",
                    tahun, tahun
            );
        }

        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Proyek proyek = new Proyek();
            proyek.setNoProy(cursor.getString(0));
            proyek.setNamaPekerjaan(cursor.getString(1));
            proyek.setBidangPekerjaan(cursor.getString(2));
            proyek.setNamaPemberiTgs(cursor.getString(3));
            proyek.setAlamatPemberiTgs(cursor.getString(4));
            proyek.setNmrTglKontrak(cursor.getString(5));
            proyek.setNilaiRpKontrak(cursor.getString(6));
            proyek.setTglSelesaiMnrtKontrak(cursor.getString(7));
            proyek.setTglSelesaiMnrtBaSp(cursor.getString(8));
            listProyekTahun.add(proyek);
            cursor.moveToNext();
        }

        cursor.close();
        return listProyekTahun;
    }

    public List<Proyek> getProyeknilai(int nilai1, int nilai2) {
        List<Proyek> listProyekNilai = new ArrayList<>();
        String query = "SELECT * FROM tbl_proyek";
        if ((nilai1 != 0) & (nilai2 != 0)) {
            query = String.format("SELECT * FROM tbl_proyek " +
                            "WHERE nilai_rp_kontrak BETWEEN '%d '%d'",
                    nilai1, nilai2
            );
        }

        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Proyek proyek = new Proyek();
            proyek.setNoProy(cursor.getString(0));
            proyek.setNamaPekerjaan(cursor.getString(1));
            proyek.setBidangPekerjaan(cursor.getString(2));
            proyek.setNamaPemberiTgs(cursor.getString(3));
            proyek.setAlamatPemberiTgs(cursor.getString(4));
            proyek.setNmrTglKontrak(cursor.getString(5));
            proyek.setNilaiRpKontrak(cursor.getString(6));
            proyek.setTglSelesaiMnrtKontrak(cursor.getString(7));
            proyek.setTglSelesaiMnrtBaSp(cursor.getString(8));
            listProyekNilai.add(proyek);
            cursor.moveToNext();
        }

        cursor.close();
        return listProyekNilai;
    }
}
