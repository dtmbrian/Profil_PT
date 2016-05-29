package com.example.b_corporation.ptanugerahgenerasibersama.Model;

import java.io.Serializable;

public class Proyek implements Serializable {
    private String noProy;
    private String namaPekerjaan;
    private String bidangPekerjaan;
    private String namaPemberiTgs;
    private String alamatPemberiTgs;
    private String nmrTglKontrak;
    private String nilaiRpKontrak;
    private String tglSelesaiMnrtKontrak;
    private String tglSelesaiMnrtBaSp;
    private String tmplThn;

    public String getNoProy() {
        return noProy;
    }

    public void setNoProy(String noProy) {
        this.noProy = noProy;
    }

    public String getNamaPekerjaan() {
        return namaPekerjaan;
    }

    public void setNamaPekerjaan(String namaPekerjaan) {
        this.namaPekerjaan = namaPekerjaan;
    }

    public String getTmplThn() {
        return namaPekerjaan;
    }

    public void setTmplThn(String tmplThn) {
        this.tmplThn = tmplThn;
    }

    public String getBidangPekerjaan() {
        return bidangPekerjaan;
    }

    public void setBidangPekerjaan(String bidangPekerjaan) {
        this.bidangPekerjaan = bidangPekerjaan;
    }

    public String getNamaPemberiTgs() {
        return namaPemberiTgs;
    }

    public void setNamaPemberiTgs(String namaPemberiTgs) {
        this.namaPemberiTgs = namaPemberiTgs;
    }

    public String getAlamatPemberiTgs() {
        return alamatPemberiTgs;
    }

    public void setAlamatPemberiTgs(String alamatPemberiTgs) {
        this.alamatPemberiTgs = alamatPemberiTgs;
    }

    public String getNmrTglKontrak() {
        return nmrTglKontrak;
    }

    public void setNmrTglKontrak(String nmrTglKontrak) {
        this.nmrTglKontrak = nmrTglKontrak;
    }

    public String getNilaiRpKontrak() {
        return nilaiRpKontrak;
    }

    public void setNilaiRpKontrak(String nilaiRpKontrak) {
        this.nilaiRpKontrak = nilaiRpKontrak;
    }

    public String getTglSelesaiMnrtKontrak() {
        return tglSelesaiMnrtKontrak;
    }

    public void setTglSelesaiMnrtKontrak(String tglSelesaiMnrtKontrak) {
        this.tglSelesaiMnrtKontrak = tglSelesaiMnrtKontrak;
    }

    public String getTglSelesaiMnrtBaSp() {
        return tglSelesaiMnrtBaSp;
    }

    public void setTglSelesaiMnrtBaSp(String tglSelesaiMnrtBaSp) {
        this.tglSelesaiMnrtBaSp = tglSelesaiMnrtBaSp;
    }
}


