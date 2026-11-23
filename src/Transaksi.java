public class Transaksi {

    // Atribut transaksi
    private String kodeTransaksi;
    private Pelanggan pelanggan;
    private Produk produk;
    private int jumlahBeli;
    private double diskon;
    private double totalBayar;
    private String tanggal;

    // Constructor kosong
    public Transaksi() {
    }

    // Constructor dengan parameter
    public Transaksi(String kodeTransaksi,
                     Pelanggan pelanggan,
                     Produk produk,
                     int jumlahBeli,
                     double diskon,
                     String tanggal) {

        this.kodeTransaksi = kodeTransaksi;
        this.pelanggan = pelanggan;
        this.produk = produk;
        this.jumlahBeli = jumlahBeli;
        this.diskon = diskon;
        this.tanggal = tanggal;
        this.totalBayar = 0;
    }

    // Method untuk menghitung total pembayaran
    public void hitungTotal() {

        if (produk == null || jumlahBeli <= 0
                || diskon < 0 || diskon > 50) {
            System.out.println("Data transaksi tidak valid!");
            return;
        }

        double subtotal = produk.getHarga() * jumlahBeli;

        double potongan = subtotal * diskon / 100;

        totalBayar = subtotal - potongan;
    }

    // Method untuk menampilkan data transaksi
    public void tampilkanTransaksi() {

        System.out.println("Kode Transaksi : " + kodeTransaksi);

        if (pelanggan != null) {
            System.out.println("Nama Pelanggan : " + pelanggan.getNama());
        }

        if (produk != null) {
            System.out.println("Nama Produk    : " + produk.getNamaProduk());
            System.out.println("Harga Produk   : Rp" + produk.getHarga());
        }

        System.out.println("Jumlah Beli    : " + jumlahBeli);
        System.out.println("Diskon         : " + diskon + "%");
        System.out.println("Tanggal        : " + tanggal);
        System.out.println("Total Bayar    : Rp" + totalBayar);
    }

    // Method untuk menghitung ulang total pembayaran
    public double hitungSubtotal() {
        if (produk == null || jumlahBeli <= 0) {
            return 0;
        }

        return produk.getHarga() * jumlahBeli;
    }

    // Getter kode transaksi
    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    // Setter kode transaksi
    public void setKodeTransaksi(String kodeTransaksi) {
        if (kodeTransaksi != null && !kodeTransaksi.trim().isEmpty()) {
            this.kodeTransaksi = kodeTransaksi;
        }
    }

    // Getter pelanggan
    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    // Setter pelanggan
    public void setPelanggan(Pelanggan pelanggan) {
        if (pelanggan != null) {
            this.pelanggan = pelanggan;
        }
    }

    // Getter produk
    public Produk getProduk() {
        return produk;
    }

    // Setter produk
    public void setProduk(Produk produk) {
        if (produk != null) {
            this.produk = produk;
        }
    }

    // Getter jumlah beli
    public int getJumlahBeli() {
        return jumlahBeli;
    }

    // Setter jumlah beli
    public void setJumlahBeli(int jumlahBeli) {
        if (jumlahBeli > 0) {
            this.jumlahBeli = jumlahBeli;
        }
    }

    // Getter diskon
    public double getDiskon() {
        return diskon;
    }

    // Setter diskon
    public void setDiskon(double diskon) {
        if (diskon >= 0 && diskon <= 50) {
            this.diskon = diskon;
        }
    }

    // Getter total bayar
    public double getTotalBayar() {
        return totalBayar;
    }

    // Setter total bayar
    public void setTotalBayar(double totalBayar) {
        if (totalBayar >= 0) {
            this.totalBayar = totalBayar;
        }
    }

    // Getter tanggal
    public String getTanggal() {
        return tanggal;
    }

    // Setter tanggal
    public void setTanggal(String tanggal) {
        if (tanggal != null && !tanggal.trim().isEmpty()) {
            this.tanggal = tanggal;
        }
    }
}
