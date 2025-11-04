package model;

public class Wilayah implements Validatable {
    private int idWilayah;
    private String nama;
    private String tingkat;

    public Wilayah(int idWilayah, String nama, String tingkat) {
        this.idWilayah = idWilayah;
        this.nama = nama;
        this.tingkat = tingkat;
        validate();
    }

    public int getIdWilayah() {
        return idWilayah;
    }

    public String getNama() {
        return nama;
    }

    public String getTingkat() {
        return tingkat;
    }

    public void setIdWilayah(int idWilayah) {
        this.idWilayah = idWilayah;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTingkat(String tingkat) {
        this.tingkat = tingkat;
    }

    @Override
    public void validate() {
        if (nama == null || nama.isBlank()) throw new IllegalArgumentException("Nama wilayah kosong");
    }
}
