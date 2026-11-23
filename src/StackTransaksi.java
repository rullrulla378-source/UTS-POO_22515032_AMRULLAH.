public class StackTransaksi {

    // Atribut Stack
    private Transaksi[] dataTransaksi;
    private int top;
    private int kapasitas;

    // Constructor kosong
    public StackTransaksi() {
        this.kapasitas = 100;
        this.dataTransaksi = new Transaksi[kapasitas];
        this.top = -1;
    }

    // Constructor dengan parameter
    public StackTransaksi(int kapasitas) {
        if (kapasitas <= 0) {
            kapasitas = 100;
        }

        this.kapasitas = kapasitas;
        this.dataTransaksi = new Transaksi[kapasitas];
        this.top = -1;
    }

    // Memeriksa apakah Stack kosong
    public boolean isEmpty() {
        return top == -1;
    }

    // Memeriksa apakah Stack penuh
    public boolean isFull() {
        return top == kapasitas - 1;
    }

    // Menambahkan transaksi ke dalam Stack
    public boolean push(Transaksi transaksi) {

        if (transaksi == null) {
            System.out.println("Transaksi tidak boleh kosong!");
            return false;
        }

        if (isFull()) {
            System.out.println("Stack penuh! Transaksi tidak dapat ditambahkan.");
            return false;
        }

        top++;
        dataTransaksi[top] = transaksi;

        System.out.println("Transaksi berhasil ditambahkan.");
        return true;
    }

    // Mengambil dan menghapus transaksi paling atas
    public Transaksi pop() {

        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada transaksi.");
            return null;
        }

        Transaksi transaksi = dataTransaksi[top];
        dataTransaksi[top] = null;
        top--;

        return transaksi;
    }

    // Melihat transaksi paling atas tanpa menghapusnya
    public Transaksi peek() {

        if (isEmpty()) {
            System.out.println("Stack masih kosong!");
            return null;
        }

        return dataTransaksi[top];
    }

    // Menghitung jumlah transaksi dalam Stack
    public int size() {
        return top + 1;
    }

    // Menampilkan seluruh transaksi dari yang terbaru
    public void tampilkanSemua() {

        if (isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        System.out.println("=== RIWAYAT TRANSAKSI ===");

        for (int i = top; i >= 0; i--) {
            dataTransaksi[i].tampilkanTransaksi();
            System.out.println("-------------------------");
        }
    }
}
