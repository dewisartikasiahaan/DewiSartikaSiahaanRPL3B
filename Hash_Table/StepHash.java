public class StepHash {


    private int[] table; // array untuk menyimpan data


    private int step = 1; //ukuran langkah

    //komstruktor
    public StepHash(int size) {
        table = new int[size]; //array hashtable
    }


    //metode untuk menambahkan/menyisipkan nilai ke dalam hashtable
    public void insert(int value) {
        int index = value % table.length; //hitung indeks awal dengan menggunakan operasi modulp (%)

        // untuk menangani kolisi/tabrakan
        while (table[index] != 0) {
            System.out.println("Terjadi collition pada key: "+ index);
            index = (index + step) % table.length; //geser indeks sebesar ukuran langkah,di atas tadi sudah dikasi ukuran ny 1,digunakan untuk mencari slot yang kosong
            System.out.println("Index di geser ke: "+index);
        }
        //tambahkan nilai ke indeks //
        table[index] = value;
        System.out.println("Data dimasukan ke dalam index : "+index);
    }


    //metode yang di gunakan untuk mencari nilai yang ada di dalam hashtbale
    public int search(int value) {
        int index = value % table.length; //hitung index awal


        //cari nilai yang sesuai,jika nilai di temukan makaa index ny di kemblikan
        while (table[index] != 0) {
            if (table[index] == value) {
                return index; //kembalikan index
            }
            index = (index + step) % table.length; //geser index menggunakna langkah untuk mencari lagi
        }
        return -1; // Tidak ditemukan
    }



    //metode utama untuk menjalakan clas stephash
    public static void main(String[] args) {
        StepHash stepHash = new StepHash(10);

        // menambahkan beberapa nilai
        stepHash.insert(9);
        stepHash.insert(9);
        stepHash.insert(8);
        stepHash.insert(50);

        // Mencari nilai
        System.out.println("Hasil pencarian nilai 9 di Index: " + stepHash.search(9));
        System.out.println("Hasil pencarian nilai 50 di Index: " + stepHash.search(50));
        System.out.println("Hasil pencarian nilai 8 di Index: " + stepHash.search(8));
        // jika nilai ditemukan maka index akan di kembalikan,dikarenakan semua nilai yang akan di tampilkan
        // ada maka index ny akan di kembalikan



        // Mencari nilai yang tidak ada
        System.out.println("Hasil pencarian nilai 200 di Index: " + stepHash.search(200));
        //jika nilai tidak ada maka akan di kembalikan -1
    }
}