package com.example.b_corporation.ptanugerahgenerasibersama.Activities;

/**
 * Created by B-Corporation on 5/10/2016.
 */
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


    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @paramcontext
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }


    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }
    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
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


    public List<Proyek> getProyektahun04() {
        List<Proyek> listProyektahun = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbl_proyek where tgl_selesai_mnrt_kontrak between '2004-01-01' and '2004-12-31'", null);
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
            listProyektahun.add(proyek);
            cursor.moveToNext();
        }
        cursor.close();
        return listProyektahun;
    }
    public List<Proyek> getProyektahun05() {
        List<Proyek> listProyektahun = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbl_proyek where tgl_selesai_mnrt_kontrak between '2005-01-01' and '2005-12-31'", null);
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
            listProyektahun.add(proyek);
            cursor.moveToNext();
        }
        cursor.close();
        return listProyektahun;
    } public List<Proyek> getProyektahun06() {
        List<Proyek> listProyektahun = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbl_proyek where tgl_selesai_mnrt_kontrak between '2006-01-01' and '2006-12-31'", null);
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
            listProyektahun.add(proyek);
            cursor.moveToNext();
        }
        cursor.close();
        return listProyektahun;
    }
    public List<Proyek> getProyektahun07() {
        List<Proyek> listProyektahun = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbl_proyek where tgl_selesai_mnrt_kontrak between '2007-01-01' and '2007-12-31'", null);
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
            listProyektahun.add(proyek);
            cursor.moveToNext();
        }
        cursor.close();
        return listProyektahun;
    } public List<Proyek> getProyektahun08() {
        List<Proyek> listProyektahun = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbl_proyek where tgl_selesai_mnrt_kontrak between '2008-01-01' and '2008-12-31'", null);
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
            listProyektahun.add(proyek);
            cursor.moveToNext();
        }
        cursor.close();
        return listProyektahun;
    } public List<Proyek> getProyektahun09() {
        List<Proyek> listProyektahun = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbl_proyek where tgl_selesai_mnrt_kontrak between '2009-01-01' and '2009-12-31'", null);
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
            listProyektahun.add(proyek);
            cursor.moveToNext();
        }
        cursor.close();
        return listProyektahun;
    } public List<Proyek> getProyektahun10() {
        List<Proyek> listProyektahun = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbl_proyek where tgl_selesai_mnrt_kontrak between '2010-01-01' and '2010-12-31'", null);
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
            listProyektahun.add(proyek);
            cursor.moveToNext();
        }
        cursor.close();
        return listProyektahun;
    } public List<Proyek> getProyektahun11() {
        List<Proyek> listProyektahun = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbl_proyek where tgl_selesai_mnrt_kontrak between '2011-01-01' and '2011-12-31'", null);
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
            listProyektahun.add(proyek);
            cursor.moveToNext();
        }
        cursor.close();
        return listProyektahun;
    } public List<Proyek> getProyektahun12() {
        List<Proyek> listProyektahun = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbl_proyek where tgl_selesai_mnrt_kontrak between '2012-01-01' and '2012-12-31'", null);
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
            listProyektahun.add(proyek);
            cursor.moveToNext();
        }
        cursor.close();
        return listProyektahun;
    }

}
