package model;

import java.util.Objects;

public abstract class Akun {
    private String idAkun;
    private String nama;
    private String email;
    private String noHp;
    private String kataSandi;

    protected Akun(String idAkun, String nama, String email, String noHp, String kataSandi) {
        this.idAkun = idAkun;
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.kataSandi = kataSandi;
        validate();
    }

    public abstract String getPeran();

    public String getIdAkun() {
        return idAkun;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getKataSandi() {
        return kataSandi;
    }

    public void setIdAkun(String idAkun) {
        this.idAkun = idAkun;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void setKataSandi(String kataSandi) {
        this.kataSandi = kataSandi;
    }
    
    

    protected void validate() {
        if (idAkun == null || idAkun.isBlank()) throw new IllegalArgumentException("idAkun kosong");
        if (nama == null || nama.isBlank()) throw new IllegalArgumentException("nama kosong");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("email kosong");
    }

    @Override public String toString() {
        return getPeran() + "{" + idAkun + ", " + nama + ", " + email + "}";
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Akun a)) return false;
        return Objects.equals(idAkun, a.idAkun);
    }
    @Override public int hashCode() { return Objects.hash(idAkun); }
}
