package model;

import java.util.Date;

public class Tanggapan implements Laporan {
    private int idTanggapan;
    private int idAdmin;
    private int idPengaduan;
    private String status;
    private String isi;
    private Date tanggal;

    public Tanggapan(int idTanggapan, int idAdmin, int idPengaduan, String status, String isi, Date tanggal) {
        this.idTanggapan = idTanggapan;
        this.idAdmin = idAdmin;
        this.idPengaduan = idPengaduan;
        this.status = status;
        this.isi = isi;
        this.tanggal = tanggal;
    }

    public int getIdTanggapan() {
        return idTanggapan;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public int getIdPengaduan() {
        return idPengaduan;
    }

    public String getStatus() {
        return status;
    }

    public String getIsi() {
        return isi;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setIdTanggapan(int idTanggapan) {
        this.idTanggapan = idTanggapan;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setIdPengaduan(int idPengaduan) {
        this.idPengaduan = idPengaduan;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    public java.sql.Date getTanggalTanggapan() {
        return (tanggal == null) ? null : new java.sql.Date(tanggal.getTime());
    }

    @Override
    public String formatLaporan() {
        return String.format("Tanggapan#%d | Status: %s | Tanggal: %tF", idTanggapan, status, tanggal);
    }

    @Override 
    public String toString() { 
        return formatLaporan(); 
    }
}
