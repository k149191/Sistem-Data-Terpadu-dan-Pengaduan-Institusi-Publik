package model;

public class Instansi implements Validatable {
    private int idInstansi;
    private String nama;
    private String jenis;
    private String sektor;
    private String alamat;

    public Instansi(int idInstansi, String nama, String jenis, String sektor, String alamat) {
        this.idInstansi = idInstansi;
        this.nama = nama;
        this.jenis = jenis;
        this.sektor = sektor;
        this.alamat = alamat;
        validate();
    }

    public int getIdInstansi() {
        return idInstansi;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public String getSektor() {
        return sektor;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setIdInstansi(int idInstansi) {
        this.idInstansi = idInstansi;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setSektor(String sektor) {
        this.sektor = sektor;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public void validate() {
        if (nama == null || nama.isBlank()) throw new IllegalArgumentException("Nama instansi kosong");
    }
}
