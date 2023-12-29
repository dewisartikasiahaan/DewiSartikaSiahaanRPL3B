
//folder untuk menyimpan class

public class selectionSort {

    // Metode untuk mengurutkan array menggunakan algoritma selection sort
    public static int[] SelectionSort(int[] array) {
        int ukuran = array.length;  // Panjang array

        // Pengulangan untuk mencari nilai maksimum dan menempatkannya di posisi yang benar
        while (ukuran > 0) {
            int max = 0;  // Asumsikan nilai maksimum berada di indeks 0

            // Pengulangan untuk mencari nilai maksimum dalam bagian yang belum diurutkan
            for (int i = 1; i < ukuran; i++) {
                if (array[max] < array[i]) {
                    max = i;  // Perbarui indeks nilai maksimum jika ditemukan nilai yang lebih besar
                }
            }

            // Tukar nilai maksimum dengan nilai di akhir bagian yang belum diurutkan
            int temp = array[max];
            array[max] = array[ukuran - 1];
            array[ukuran - 1] = temp;

            ukuran--;  // Kurangi ukuran bagian yang belum diurutkan
        }

        return array;  // Kembalikan array yang sudah diurutkan
    }

    // Metode utama untuk menjalankan class
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};  // Array yang akan diurutkan
        int[] sortedArray = SelectionSort(array);  // Panggil metode SelectionSort untuk mengurutkan array

        System.out.println("Array yang sudah diurutkan (descending):");

        // Cetak array yang sudah diurutkan
        for (int value : sortedArray) {
            System.out.print(value + " ");
        }
    }
}