package com.example.b_corporation.ptanugerahgenerasibersama.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.b_corporation.ptanugerahgenerasibersama.Model.Karyawan;
import com.example.b_corporation.ptanugerahgenerasibersama.Model.Proyek;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;
    DatabaseOpenHelper mDbHelper;
    Context c;

    public DatabaseAccess(Context c) {

        this.c = c;
        mDbHelper = new DatabaseOpenHelper(c);

    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {


        try {
            database = mDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new RuntimeException("Unable to create database");

        }

        try {

            database = mDbHelper.openDataBase();

        } catch (SQLException sqle) {

            throw sqle;

        }
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public Boolean add(String noProy, String namaPekerjaan, String bidangPekerjaan, String namaPemberiTgs, String alamatPemberiTugas, String nomorTglKontrak, String nilaiRpKontrak, String tglSelesaiMenurutKontrak, String tglSelesaiMenurutBasp) {
        try {
            ContentValues cv = new ContentValues();
            cv.put(Constant.ROW_ID, noProy);
            cv.put(Constant.NAMA_PEKERJAAN, namaPekerjaan);
            cv.put(Constant.BIDANG_PEKERJAAN, bidangPekerjaan);
            cv.put(Constant.NAMA_PEMBERI_TUGAS, namaPemberiTgs);
            cv.put(Constant.ALAMAT_PEMBERI_TUGAS, alamatPemberiTugas);
            cv.put(Constant.NOMOR_TGL_KONTRAK, nomorTglKontrak);
            cv.put(Constant.NILAI_RP_KONTRAK, nilaiRpKontrak);
            cv.put(Constant.TANGGAL_SELESAI_MENURUT_KONTRAK, tglSelesaiMenurutKontrak);
            cv.put(Constant.TANGGAL_SELESAI_MENURUT_BASP, tglSelesaiMenurutBasp);

            long result = database.insert(DatabaseOpenHelper.TB_Name, Constant.ROW_ID, cv);
            if (result > 0) {
                return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Cursor retrieve() {
        String[] columns = {Constant.ROW_ID, Constant.NAMA_PEKERJAAN, Constant.BIDANG_PEKERJAAN, Constant.NAMA_PEMBERI_TUGAS, Constant.ALAMAT_PEMBERI_TUGAS, Constant.NOMOR_TGL_KONTRAK, Constant.NILAI_RP_KONTRAK, Constant.TANGGAL_SELESAI_MENURUT_KONTRAK, Constant.TANGGAL_SELESAI_MENURUT_BASP};
        Cursor c = database.query(DatabaseOpenHelper.TB_Name, columns, null, null, null, null, null);
        return c;
    }

    public boolean update(String newNoProy, String newNamaPekerjaan, String newBidangPekerjaan, String newNamaPemberiTgs, String newAlamatPemberiTugas, String newNomorTglKontrak, String newNilaiRpKontrak, String newTglSelesaiMenurutKontrak, String newTglSelesaiMenurutBasp, int noProy1) {
        try {
            ContentValues cv = new ContentValues();
            cv.put(Constant.ROW_ID, newNoProy);
            cv.put(Constant.BIDANG_PEKERJAAN, newBidangPekerjaan);
            cv.put(Constant.NAMA_PEMBERI_TUGAS, newNamaPemberiTgs);
            cv.put(Constant.ALAMAT_PEMBERI_TUGAS, newAlamatPemberiTugas);
            cv.put(Constant.NOMOR_TGL_KONTRAK, newNomorTglKontrak);
            cv.put(Constant.NILAI_RP_KONTRAK, newNilaiRpKontrak);
            cv.put(Constant.TANGGAL_SELESAI_MENURUT_KONTRAK, newTglSelesaiMenurutKontrak);
            cv.put(Constant.TANGGAL_SELESAI_MENURUT_BASP, newTglSelesaiMenurutBasp);
            cv.put(Constant.NAMA_PEKERJAAN, newNamaPekerjaan);

            int result = database.update(DatabaseOpenHelper.TB_Name, cv, Constant.ROW_ID + "=?", new String[]{String.valueOf(noProy1)});
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int noProy) {
        try {
            int result = database.delete(DatabaseOpenHelper.TB_Name, Constant.ROW_ID + "=?", new String[]{String.valueOf(noProy)});
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
            proyek.setNoProy(cursor.getInt(0));
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
                            "WHERE tgl_selesai_mnrt_kontrak BETWEEN '%d-01-01' AND '%d-12-31'",
                    tahun, tahun
            );
        }

        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Proyek proyek = new Proyek();
            proyek.setNoProy(cursor.getInt(0));
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
                            "WHERE nilai_rp_kontrak BETWEEN '%d' And '%d'",
                    nilai1, nilai2
            );
        }

        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Proyek proyek = new Proyek();
            proyek.setNoProy(cursor.getInt(0));
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
