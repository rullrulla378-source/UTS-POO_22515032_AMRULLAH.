import java.util.Scanner;

public class Main {

    // Scanner untuk menerima input pengguna
    static Scanner input = new Scanner(System.in);

    // Membuat objek toko
    static Toko toko = new Toko(
            "Toko Kelontong Sejahtera",
            "Kolaka Timur"
    );

    public static void main(String[] args) {

        int pilihan;

        do {
            tampilkanMenu();

            pilihan = inputInt("Pilih menu: ");

            switch (pilihan) {

                case 1:
                    tambahProduk();
                    break;

                case 2:
                    toko.tampilkanSemuaProduk();
                    break;

                case 3:
                    tambahPelanggan();
                    break;

                case 4:
                    toko.tampilkanSemuaPelanggan();
                    break;

                case 5:
                    cariProduk();
                    break;

                case 6:
                    buatTransaksi();
                    break;

                case 7:
                    toko.tampilkanRiwayatTransaksi();
                    break;

                case 8:
                    toko.tampilkanTransaksiTerakhir();
                    break;

                case 9:
                    toko.batalkanTransaksiTerakhir();
                    break;

                case 10:
                    toko.tampilkanLaporanPenjualan();
                    break;

                case 11:
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

            System.out.println();

        } while (pilihan != 11);

        input.close();
    }

    // Menampilkan menu aplikasi
    public static void tampilkanMenu() {

        System.out.println("======================================");
        System.out.println("       SISTEM MANAJEMEN TOKO");
        System.out.println("          TOKO KELONTONG");
        System.out.println("======================================");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Tampilkan Semua Produk");
        System.out.println("3. Tambah Pelanggan");
        System.out.println("4. Tampilkan Semua Pelanggan");
        System.out.println("5. Cari Produk");
        System.out.println("6. Buat Transaksi Pembelian");
        System.out.println("7. Lihat Riwayat Transaksi");
        System.out.println("8. Lihat Transaksi Terakhir");
        System.out.println("9. Batalkan Transaksi Terakhir");
        System.out.println("10. Tampilkan Laporan Penjualan");
        System.out.println("11. Keluar");
        System.out.println("======================================");
    }

    // Menu tambah produk
    public static void tambahProduk() {

        System.out.println("=== TAMBAH PRODUK ===");

        System.out.print("Kode Produk : ");
        String kode = input.nextLine();

        System.out.print("Nama Produk : ");
        String nama = input.nextLine();

        double harga = inputDouble("Harga Produk: ");
        int stok = inputInt("Jumlah Stok : ");

        System.out.print("Kategori    : ");
        String kategori = input.nextLine();

        if (kode.trim().isEmpty() || nama.trim().isEmpty()
                || kategori.trim().isEmpty()) {
            System.out.println("Data produk tidak boleh kosong!");
            return;
        }

        if (harga <= 0 || stok < 0) {
            System.out.println("Harga harus lebih dari 0 dan stok tidak boleh negatif!");
            return;
        }

        Produk produk = new Produk(
                kode, nama, harga, stok, kategori
        );

        toko.tambahProduk(produk);
    }

    // Menu tambah pelanggan
    public static void tambahPelanggan() {

        System.out.println("=== TAMBAH PELANGGAN ===");

        System.out.print("ID Pelanggan : ");
        String id = input.nextLine();

        System.out.print("Nama         : ");
        String nama = input.nextLine();

        System.out.print("Nomor HP     : ");
        String noHp = input.nextLine();

        System.out.print("Alamat       : ");
        String alamat = input.nextLine();

        if (id.trim().isEmpty() || nama.trim().isEmpty()
                || noHp.trim().isEmpty() || alamat.trim().isEmpty()) {
            System.out.println("Data pelanggan tidak boleh kosong!");
            return;
        }

        Pelanggan pelanggan = new Pelanggan(
                id, nama, noHp, alamat
        );

        toko.tambahPelanggan(pelanggan);
    }

    // Menu mencari produk
    public static void cariProduk() {

        System.out.println("=== CARI PRODUK ===");

        System.out.print("Masukkan Kode Produk: ");
        String kode = input.nextLine();

        Produk produk = toko.cariProduk(kode);

        if (produk != null) {
            System.out.println("Produk berhasil ditemukan.");
            produk.tampilkanInfo();
        } else {
            System.out.println("Produk tidak ditemukan!");
        }
    }

    // Menu membuat transaksi
    public static void buatTransaksi() {

        System.out.println("=== TRANSAKSI PEMBELIAN ===");

        System.out.print("Kode Transaksi : ");
        String kode = input.nextLine();

        System.out.print("ID Pelanggan   : ");
        String idPelanggan = input.nextLine();

        System.out.print("Kode Produk    : ");
        String kodeProduk = input.nextLine();

        int jumlah = inputInt("Jumlah Beli    : ");

        double diskon = inputDouble("Diskon (%)    : ");

        System.out.print("Tanggal        : ");
        String tanggal = input.nextLine();

        if (kode.trim().isEmpty() || idPelanggan.trim().isEmpty()
                || kodeProduk.trim().isEmpty()
                || tanggal.trim().isEmpty()) {
            System.out.println("Data transaksi tidak boleh kosong!");
            return;
        }

        toko.buatTransaksi(
                kode,
                idPelanggan,
                kodeProduk,
                jumlah,
                diskon,
                tanggal
        );
    }

    // Mengambil input angka bulat
    public static int inputInt(String pesan) {

        while (true) {

            System.out.print(pesan);

            try {
                int angka = Integer.parseInt(input.nextLine());
                return angka;

            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka bulat yang benar!");
            }
        }
    }

    // Mengambil input angka desimal
    public static double inputDouble(String pesan) {

        while (true) {

            System.out.print(pesan);

            try {
                double angka = Double.parseDouble(
                        input.nextLine().replace(",", ".")
                );

                return angka;

            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang benar!");
            }
        }
    }
}
