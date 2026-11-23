public class Pelanggan {

    // Atribut atau data pelanggan
    private String idPelanggan;
    private String nama;
    private String noHp;
    private String alamat;
    private double totalBelanja;

    // Constructor kosong
    public Pelanggan() {
    }

    // Constructor dengan parameter
    public Pelanggan(String idPelanggan, String nama,
                     String noHp, String alamat) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
        this.totalBelanja = 0;
    }

    // Method untuk menampilkan data pelanggan
    public void tampilkanInfo() {
        System.out.println("ID Pelanggan : " + idPelanggan);
        System.out.println("Nama         : " + nama);
        System.out.println("No. HP       : " + noHp);
        System.out.println("Alamat       : " + alamat);
        System.out.println("Total Belanja: Rp" + totalBelanja);
    }

    // Method untuk menambahkan total belanja
    public void tambahTotalBelanja(double jumlah) {
        if (jumlah > 0) {
            totalBelanja = totalBelanja + jumlah;
            System.out.println("Total belanja berhasil diperbarui.");
        } else {
            System.out.println("Jumlah belanja harus lebih dari 0!");
        }
    }
    // Method untuk mengurangi total belanja
    public void kurangiTotalBelanja(double jumlah) {

        if (jumlah > 0 && jumlah <= totalBelanja) {
            totalBelanja = totalBelanja - jumlah;

            System.out.println("Total belanja berhasil dikurangi.");
        } else {
            System.out.println("Pengurangan total belanja tidak valid!");
        }
    }
    // Method untuk mereset total belanja
    public void resetTotalBelanja() {
        totalBelanja = 0;
        System.out.println("Total belanja berhasil direset.");
    }

    // Getter dan setter ID pelanggan
    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        if (idPelanggan != null && !idPelanggan.trim().isEmpty()) {
            this.idPelanggan = idPelanggan;
        }
    }

    // Getter dan setter nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        }
    }

    // Getter dan setter nomor HP
    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        if (noHp != null && !noHp.trim().isEmpty()) {
            this.noHp = noHp;
        }
    }

    // Getter dan setter alamat
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        if (alamat != null && !alamat.trim().isEmpty()) {
            this.alamat = alamat;
        }
    }

    // Getter dan setter total belanja
    public double getTotalBelanja() {
        return totalBelanja;
    }

    public void setTotalBelanja(double totalBelanja) {
        if (totalBelanja >= 0) {
            this.totalBelanja = totalBelanja;
        } else {
            System.out.println("Total belanja tidak boleh negatif!");
        }
    }
}

