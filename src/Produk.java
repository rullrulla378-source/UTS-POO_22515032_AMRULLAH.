public class Produk {

    // 1. Atribut produk
    private String kodeProduk;
    private String namaProduk;
    private double harga;
    private int stok;
    private String kategori;

    // 2. Konstruktor default
    public Produk() {
    }

    // 3. Konstruktor berparameter
    public Produk(String kodeProduk, String namaProduk,
                  double harga, int stok, String kategori) {

        this.kodeProduk = kodeProduk;
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
    }

    // 4. Method untuk menampilkan informasi produk
    public void tampilkanInfo() {
        System.out.println("Kode Produk : " + kodeProduk);
        System.out.println("Nama Produk : " + namaProduk);
        System.out.println("Harga       : Rp" + harga);
        System.out.println("Stok        : " + stok);
        System.out.println("Kategori    : " + kategori);
    }

    // 5. Method untuk mengurangi stok produk
    public boolean kurangiStok(int jumlah) {

        if (jumlah <= 0) {
            System.out.println("Jumlah pembelian harus lebih dari 0!");
            return false;
        }

        if (jumlah > stok) {
            System.out.println("Stok produk tidak mencukupi!");
            return false;
        }

        stok = stok - jumlah;
        System.out.println("Stok produk berhasil dikurangi.");
        return true;
    }

    // 6. Method untuk menambah stok produk
    public void tambahStok(int jumlah) {

        if (jumlah <= 0) {
            System.out.println("Jumlah stok harus lebih dari 0!");
            return;
        }

        stok = stok + jumlah;
        System.out.println("Stok produk berhasil ditambahkan.");
    }

    // 7. Getter dan Setter

    public String getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk) {
        if (kodeProduk != null && !kodeProduk.trim().isEmpty()) {
            this.kodeProduk = kodeProduk;
        }
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        if (namaProduk != null && !namaProduk.trim().isEmpty()) {
            this.namaProduk = namaProduk;
        }
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga harus lebih dari 0!");
        }
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            System.out.println("Stok tidak boleh negatif!");
        }
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        if (kategori != null && !kategori.trim().isEmpty()) {
            this.kategori = kategori;
        }
    }
}