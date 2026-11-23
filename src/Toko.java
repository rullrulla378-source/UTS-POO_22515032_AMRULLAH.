import java.util.ArrayList;
public class Toko {

    // Atribut toko
    private String namaToko;
    private String alamatToko;

    // Tempat menyimpan data produk dan pelanggan
    private ArrayList<Produk> daftarProduk;
    private ArrayList<Pelanggan> daftarPelanggan;

    // Tempat menyimpan riwayat transaksi
    private StackTransaksi stackTransaksi;

    // Constructor kosong
    public Toko() {
        this.namaToko = "Toko Kelontong";
        this.alamatToko = "Kolaka Timur";
        this.daftarProduk = new ArrayList<>();
        this.daftarPelanggan = new ArrayList<>();
        this.stackTransaksi = new StackTransaksi();
    }

    // Constructor dengan parameter
    public Toko(String namaToko, String alamatToko) {
        this.namaToko = namaToko;
        this.alamatToko = alamatToko;
        this.daftarProduk = new ArrayList<>();
        this.daftarPelanggan = new ArrayList<>();
        this.stackTransaksi = new StackTransaksi();
    }

    // Menampilkan informasi toko
    public void tampilkanInfoToko() {
        System.out.println("=== INFORMASI TOKO ===");
        System.out.println("Nama Toko   : " + namaToko);
        System.out.println("Alamat Toko : " + alamatToko);
    }

    // Menambahkan produk ke dalam daftar
    public void tambahProduk(Produk produk) {

        if (produk == null) {
            System.out.println("Data produk tidak boleh kosong!");
            return;
        }

        if (cariProduk(produk.getKodeProduk()) != null) {
            System.out.println("Kode produk sudah digunakan!");
            return;
        }

        daftarProduk.add(produk);
        System.out.println("Produk berhasil ditambahkan.");
    }

    // Menampilkan semua produk
    public void tampilkanSemuaProduk() {

        if (daftarProduk.isEmpty()) {
            System.out.println("Belum ada data produk.");
            return;
        }

        System.out.println("=== DAFTAR PRODUK ===");

        for (Produk produk : daftarProduk) {
            produk.tampilkanInfo();
            System.out.println("---------------------");
        }
    }

    // Mencari produk berdasarkan kode
    public Produk cariProduk(String kodeProduk) {

        for (Produk produk : daftarProduk) {
            if (produk.getKodeProduk().equalsIgnoreCase(kodeProduk)) {
                return produk;
            }
        }

        return null;
    }

    // Menambahkan pelanggan ke dalam daftar
    public void tambahPelanggan(Pelanggan pelanggan) {

        if (pelanggan == null) {
            System.out.println("Data pelanggan tidak boleh kosong!");
            return;
        }

        if (cariPelanggan(pelanggan.getIdPelanggan()) != null) {
            System.out.println("ID pelanggan sudah digunakan!");
            return;
        }

        daftarPelanggan.add(pelanggan);
        System.out.println("Pelanggan berhasil ditambahkan.");
    }

    // Menampilkan semua pelanggan
    public void tampilkanSemuaPelanggan() {

        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada data pelanggan.");
            return;
        }

        System.out.println("=== DAFTAR PELANGGAN ===");

        for (Pelanggan pelanggan : daftarPelanggan) {
            pelanggan.tampilkanInfo();
            System.out.println("-------------------------");
        }
    }

    // Mencari pelanggan berdasarkan ID
    public Pelanggan cariPelanggan(String idPelanggan) {

        for (Pelanggan pelanggan : daftarPelanggan) {
            if (pelanggan.getIdPelanggan().equalsIgnoreCase(idPelanggan)) {
                return pelanggan;
            }
        }

        return null;
    }

    // Membuat transaksi pembelian
    public boolean buatTransaksi(String kodeTransaksi,
                                 String idPelanggan,
                                 String kodeProduk,
                                 int jumlahBeli,
                                 double diskon,
                                 String tanggal) {

        // Mencari data pelanggan
        Pelanggan pelanggan = cariPelanggan(idPelanggan);

        // Mencari data produk
        Produk produk = cariProduk(kodeProduk);

        if (pelanggan == null) {
            System.out.println("Pelanggan tidak ditemukan!");
            return false;
        }

        if (produk == null) {
            System.out.println("Produk tidak ditemukan!");
            return false;
        }

        if (jumlahBeli <= 0 || jumlahBeli > produk.getStok()) {
            System.out.println("Jumlah pembelian tidak valid!");
            return false;
        }

        if (diskon < 0 || diskon > 50) {
            System.out.println("Diskon harus antara 0 sampai 50 persen!");
            return false;
        }

        if (stackTransaksi.isFull()) {
            System.out.println("Stack penuh! Transaksi tidak dapat diproses.");
            return false;
        }

        // Membuat objek transaksi
        Transaksi transaksi = new Transaksi(
                kodeTransaksi,
                pelanggan,
                produk,
                jumlahBeli,
                diskon,
                tanggal
        );

        // Menghitung total pembayaran
        transaksi.hitungTotal();

        // Menyimpan transaksi ke Stack
        if (!stackTransaksi.push(transaksi)) {
            return false;
        }

        // Mengurangi stok produk
        if (!produk.kurangiStok(jumlahBeli)) {
            stackTransaksi.pop();
            return false;
        }

        // Menambahkan total belanja pelanggan
        pelanggan.tambahTotalBelanja(transaksi.getTotalBayar());

        System.out.println("Transaksi berhasil diproses.");
        return true;
    }

    // Menampilkan riwayat transaksi
    public void tampilkanRiwayatTransaksi() {
        stackTransaksi.tampilkanSemua();
    }

    // Menampilkan transaksi terakhir
    public void tampilkanTransaksiTerakhir() {

        Transaksi transaksi = stackTransaksi.peek();

        if (transaksi != null) {
            System.out.println("=== TRANSAKSI TERAKHIR ===");
            transaksi.tampilkanTransaksi();
        }
    }

    // Membatalkan transaksi terakhir
    public void batalkanTransaksiTerakhir() {

        Transaksi transaksi = stackTransaksi.pop();

        if (transaksi != null) {

            // Mengembalikan stok produk
            transaksi.getProduk().tambahStok(transaksi.getJumlahBeli());

            // Mengurangi total belanja pelanggan
            transaksi.getPelanggan().kurangiTotalBelanja(
                    transaksi.getTotalBayar()
            );

            System.out.println("Transaksi berhasil dibatalkan.");
        }
    }

    // Menampilkan laporan penjualan
    public void tampilkanLaporanPenjualan() {

        System.out.println("=== LAPORAN PENJUALAN ===");
        System.out.println("Nama Toko          : " + namaToko);
        System.out.println("Jumlah Transaksi   : " + stackTransaksi.size());

        double totalPenjualan = 0;

        Transaksi[] data = new Transaksi[stackTransaksi.size()];

        // Mengambil data transaksi dari Stack
        for (int i = 0; i < data.length; i++) {
            data[i] = stackTransaksi.pop();
            totalPenjualan += data[i].getTotalBayar();
        }

        // Memasukkan kembali transaksi ke Stack
        for (int i = data.length - 1; i >= 0; i--) {
            stackTransaksi.push(data[i]);
        }

        System.out.println("Total Penjualan    : Rp" + totalPenjualan);
    }

    // Getter dan setter nama toko
    public String getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(String namaToko) {
        if (namaToko != null && !namaToko.trim().isEmpty()) {
            this.namaToko = namaToko;
        }
    }

    // Getter dan setter alamat toko
    public String getAlamatToko() {
        return alamatToko;
    }

    public void setAlamatToko(String alamatToko) {
        if (alamatToko != null && !alamatToko.trim().isEmpty()) {
            this.alamatToko = alamatToko;
        }
    }

    // Getter Stack transaksi
    public StackTransaksi getStackTransaksi() {
        return stackTransaksi;
    }
}
