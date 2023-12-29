
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas untuk merepresentasikan objek Mahasiswa.
 */
class Mahasiswa {
    private String nim;      // NIM mahasiswa
    private String nama;     // Nama mahasiswa
    private String jurusan;  // Jurusan mahasiswa

    /**
     * Konstruktor untuk menginisiasi objek Mahasiswa.
     *
     *  NIM mahasiswa
     * nama    Nama mahasiswa
     *  jurusan Jurusan mahasiswa
     */
    public Mahasiswa(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    // Getter untuk NIM(untuk mendapatkan Nim mahasiswa)
    public String getNim() {
        return nim;
    }

    // Getter untuk nama (untuk mendapatkan nama mahassiwa)
    public String getNama() {
        return nama;
    }

    // Getter untuk jurusan (untuk mendapatkan nama mahasiswa)
    public String getJurusan() {
        return jurusan;
    }

    // Metode untuk mengembalikan informasi mahasiswa dalam bentuk String
    @Override
    public String toString() {
        return "NIM: " + nim + ", Nama: " + nama + ", Jurusan: " + jurusan;
    }
}

/**
 * Kelas utama untuk mengelola data mahasiswa.
 */
public class DataMahasiswa {

    /**
     *
     * metode untuk melakukan pencarian data mahasiswa dengan algoritma squential seacrh
     * menggunakan nim
     *
     */
    public static int sequentialSearch(ArrayList<Mahasiswa> list, String nimTarget) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNim().equals(nimTarget)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * metode untuk melakukan pencarian data mahasiswa dengan algoritma binary seacrh
     * menggunakan nim
     *
     */
    public static int binarySearch(ArrayList<Mahasiswa> list, String nimTarget) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid).getNim().compareTo(nimTarget) < 0) {
                low = mid + 1;
            } else if (list.get(mid).getNim().compareTo(nimTarget) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     *
     * metode untuk melakukan pencarian data mahasiswa dengan algoritma interpolation seacrh
     * menggunakan nim
     *
     */
    public static int interpolationSearch(ArrayList<Mahasiswa> list, String nimTarget) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high && nimTarget.compareTo(list.get(low).getNim()) >= 0 && nimTarget.compareTo(list.get(high).getNim()) <= 0) {
            int position = low + (((int) (high - low) / (list.get(high).getNim().compareTo(list.get(low).getNim())))
                    * (nimTarget.compareTo(list.get(low).getNim()) - low));
            if (list.get(position).getNim().compareTo(nimTarget) < 0) {
                low = position + 1;
            } else if (list.get(position).getNim().compareTo(nimTarget) > 0) {
                high = position - 1;
            } else {
                return position;
            }
        }
        return -1;
    }

    /**
     * Metodet utama untuk menampilkan data mahasiswa
     */
    public static void tampilkanHeaderTabel() {
        System.out.printf("+--------------+---------------------+--------------------+%n");
        System.out.printf("|     NIM      |         Nama        |      Jurusan       |%n");
        System.out.printf("+--------------+---------------------+--------------------+%n");
    }

    //meetode utama untuk menjalakan program data mahasiswa berisi menu dan logika yang akan menjalankan program
    public static void main(String[] args) {
        // Membuat objek scanner untuk menerima input dari pengguna
        Scanner scanner = new Scanner(System.in);

        // Membuat daftar untuk menyimpan semua data mahasiswa
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();

        boolean continueInput = true;

        // Melakukan loop selama pengguna tidak memilih untuk keluar
        while (continueInput) {
            // Menampilkan menu ke pengguna
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Semua Data Mahasiswa");
            System.out.println("3. Hapus Data Mahasiswa");
            System.out.println("4. Pencarian Mahasiswa (Sequential Search)");
            System.out.println("5. Pencarian Mahasiswa (Binary Search)");
            System.out.println("6. Pencarian Mahasiswa (Interpolation Search)");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi (1-7): ");

            // Menerima inputpilihan menu dari pengguna
            int choice = scanner.nextInt();
            scanner.nextLine(); // Mengosongkan buffer

            switch (choice) {
                case 1:
                    // Menerima data mahasiswa dari pengguna dan menambahkannya ke daftar
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Jurusan: ");
                    String jurusan = scanner.nextLine();

                    listMahasiswa.add(new Mahasiswa(nim, nama, jurusan));
                    break;
                case 2:
                    // Menampilkan header tabel dan data mahasiswa dalam format tabel
                    tampilkanHeaderTabel();
                    for (Mahasiswa mhs : listMahasiswa) {
                        System.out.printf("| %-12s | %-19s | %-18s |%n", mhs.getNim(), mhs.getNama(), mhs.getJurusan());
                    }
                    System.out.printf("+--------------+---------------------+--------------------+%n");
                    break;

                case 3:
                    // case untuk menghapus data mahasiswa berdasarkan indeks
                    System.out.print("Masukkan indeks data mahasiswa yang ingin dihapus: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < listMahasiswa.size()) {
                        listMahasiswa.remove(index);
                        System.out.println("Data mahasiswa pada indeks " + index + " telah dihapus.");
                    } else {
                        System.out.println("Indeks tidak valid.");
                    }
                    break;
                case 4:
                    // Menerima NIM dari pengguna dan mencari nim menggunakan metode squential seacrh yang sudah di buat sebellumnya
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimSeq = scanner.nextLine();
                    int indexSeq = sequentialSearch(listMahasiswa, nimSeq);
                    if (indexSeq != -1) {
                        System.out.println("Data ditemukan pada indeks " + indexSeq);
                        System.out.println(listMahasiswa.get(indexSeq));
                    } else {
                        System.out.println("Data dengan NIM " + nimSeq + " tidak ditemukan.");
                    }
                    break;

                case 5:
                    // Menerima NIM dari pengguna dan mencari nim menggunakan metode binary seacrh yang sudah di buat sebellumnya
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimBin = scanner.nextLine();
                    int indexBin = binarySearch(listMahasiswa, nimBin);
                    if (indexBin != -1) {
                        System.out.println("Data ditemukan pada indeks " + indexBin);
                        System.out.println(listMahasiswa.get(indexBin));
                    } else {
                        System.out.println("Data dengan NIM " + nimBin + " tidak ditemukan.");
                    }
                    break;

                case 6:
                    // Menerima NIM dari pengguna dan mencari nim menggunakan metode interpolation seacrh yang sudah di buat sebellumnya
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimInt = scanner.nextLine();
                    int indexInt = interpolationSearch(listMahasiswa, nimInt);
                    if (indexInt != -1) {
                        System.out.println("Data ditemukan pada indeks " + indexInt);
                        System.out.println(listMahasiswa.get(indexInt));
                    } else {
                        System.out.println("Data dengan NIM " + nimInt + " tidak ditemukan.");
                    }
                    break;
                case 7:
                    // menghentikan perulangan dan keluar dari program
                    continueInput = false;
                    break;
                default:
                    // Menampilkan pesan kesalahan jika pilihan tidak valid
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
        // Menampilkan pesan keluar
        System.out.println("Terima kasih telah menggunakan program ini.");
    }
}
