package model;

public class Admin extends Akun {
    private String peran;

    public Admin(String idAkun, String nama, String email, String noHp, String kataSandi, String peran) {
        super(idAkun, nama, email, noHp, kataSandi);
        this.peran = (peran == null || peran.isBlank()) ? "ADMIN" : peran;
    }

    public String getPeran() {
        return peran;
    }

    public void setPeran(String peran) {
        this.peran = (peran == null || peran.isBlank()) ? "ADMIN" : peran;
    }
    
}
