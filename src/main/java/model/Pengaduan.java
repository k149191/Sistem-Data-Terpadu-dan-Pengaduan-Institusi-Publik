package model;

import java.util.Date;

public class Pengaduan implements Laporan {
    private int idPengaduan;
    private int idPengguna;
    private int idInstansi;
    private String judul;
    private String isi;
    private Date tanggal;

    public Pengaduan() {}

    public Pengaduan(int idPengaduan, int idPengguna, int idInstansi, String judul, String isi, Date tanggal) {
        this.idPengaduan = idPengaduan;
        this.idPengguna = idPengguna;
        this.idInstansi = idInstansi;
        this.judul = judul;
        this.isi = isi;
        this.tanggal = tanggal;
    }

    public int getIdPengaduan() {
        return idPengaduan;
    }

    public int getIdPengguna() {
        return idPengguna;
    }

    public int getIdInstansi() {
        return idInstansi;
    }

    public String getJudul() {
        return judul;
    }

    public String getIsi() {
        return isi;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setIdPengaduan(int idPengaduan) {
        this.idPengaduan = idPengaduan;
    }

    public void setIdPengguna(int idPengguna) {
        this.idPengguna = idPengguna;
    }

    public void setIdInstansi(int idInstansi) {
        this.idInstansi = idInstansi;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    

    @Override
    public String formatLaporan() {
        return String.format("Pengaduan#%d | Judul: %s | Tanggal: %tF", idPengaduan, judul, tanggal);
    }

    @Override public String toString() { return formatLaporan(); }
}
