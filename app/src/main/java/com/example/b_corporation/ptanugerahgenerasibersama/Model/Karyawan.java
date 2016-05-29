package com.example.b_corporation.ptanugerahgenerasibersama.Model;

import java.io.Serializable;

/**
 * Created by B-Corporation on 5/13/2016.
 */
public class Karyawan implements Serializable {
    private String no;
    private String namaKaryawan;
    private String jabatan;
    private String bidangKeahlian;
    private String pengalamanProfesi;
    private String tanggalMasuk;

    public String getNo(){
        return no;
    }
    public void setNo(String no){
        this.no=no;
    }
    public String getNamaKaryawan(){
        return namaKaryawan;
    }
    public void setNamaKaryawan(String namaKaryawan){
        this.namaKaryawan=namaKaryawan;
    }
    public String getJabatan(){
        return jabatan;
    }
    public void setJabatan(String jabatan){
        this.jabatan=jabatan;
    }
    public String getBidangKeahlian(){
        return bidangKeahlian;
    }
    public void setBidangKeahlian(String bidangKeahlian){
        this.bidangKeahlian=bidangKeahlian;
    }
    public String getPengalamanProfesi(){
        return pengalamanProfesi;
    }
    public void setPengalamanProfesi(String pengalamanProfesi){
        this.pengalamanProfesi=pengalamanProfesi;
    }
    public String getTanggalMasuk(){
        return tanggalMasuk;
    }
    public void setTanggalMasuk(String tanggalMasuk){
        this.tanggalMasuk=tanggalMasuk;
    }
}
