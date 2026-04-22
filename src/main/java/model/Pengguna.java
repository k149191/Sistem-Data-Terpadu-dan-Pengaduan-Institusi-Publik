package model;

public class Pengguna extends Akun {
    private String alamat;

    public Pengguna(String idAkun, String nama, String email, String noHp, String kataSandi, String alamat) {
        super(idAkun, nama, email, noHp, kataSandi);
        this.alamat = alamat;
    }

    @Override
    public String getPeran() { 
        return "PENGGUNA"; 
    }

    public String getAlamat() { 
        return alamat; 
    }
    public void setAlamat(String alamat) { 
        this.alamat = alamat; 
    }
    
}
