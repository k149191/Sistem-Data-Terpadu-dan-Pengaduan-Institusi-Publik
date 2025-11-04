package model;

public class Anggaran implements Laporan, Validatable {

    private String idAnggaran;
    private String namaAnggaran;
    private double totalAnggaran;
    private double realisasi;
    private String keterangan;

    public Anggaran(String idAnggaran, String namaAnggaran, double totalAnggaran, double realisasi, String keterangan) {
        this.idAnggaran = idAnggaran;
        this.namaAnggaran = namaAnggaran;
        this.totalAnggaran = totalAnggaran;
        this.realisasi = realisasi;
        this.keterangan = keterangan;
        validate();
    }

    public String getIdAnggaran() { 
        return idAnggaran; 
    }
    public void setIdAnggaran(String idAnggaran) { 
        this.idAnggaran = idAnggaran; 
        validate(); 
    }
    public String getNamaAnggaran() { 
        return namaAnggaran; 
    }
    public void setNamaAnggaran(String namaAnggaran) { 
        this.namaAnggaran = namaAnggaran; 
        validate(); 
    }

    public double getTotalAnggaran() { 
        return totalAnggaran; 
    }
    public void setTotalAnggaran(double totalAnggaran) { 
        this.totalAnggaran = totalAnggaran; 
        validate(); 
    }

    public double getRealisasi() { 
        return realisasi; 
    }
    public void setRealisasi(double realisasi) { 
        this.realisasi = realisasi; 
        validate(); 
    }

    public String getKeterangan() { 
        return keterangan; 
    }
    public void setKeterangan(String keterangan) { 
        this.keterangan = keterangan; 
        validate(); 
    }

    @Override
    public String formatLaporan() {
        return String.format(
            "ID: %s | Nama: %s | Total: %.2f | Realisasi: %.2f | Keterangan: %s",
            idAnggaran, namaAnggaran, totalAnggaran, realisasi, keterangan
        );
    }

    @Override
    public void validate() {
        if (idAnggaran == null || idAnggaran.isBlank())
            throw new IllegalArgumentException("ID Anggaran tidak boleh kosong");
        if (namaAnggaran == null || namaAnggaran.isBlank())
            throw new IllegalArgumentException("Nama Anggaran tidak boleh kosong");
        if (totalAnggaran < 0) throw new IllegalArgumentException("Total Anggaran tidak boleh negatif");
        if (realisasi < 0) throw new IllegalArgumentException("Realisasi tidak boleh negatif");
    }

    @Override 
    public String toString() { 
        return formatLaporan(); 
    }
}
