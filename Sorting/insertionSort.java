
//folder unutk menyimpam class

public class insertionSort {

    //metode yang digunakan untuk mengurutkan array menggunkan algortima insertioin sort
    public static int[] insertion(int[] array) {
        int ukuran = array.length;//panjang array
        int max, j; //variabel untuk menyimpan nilai dan indeks
        int i = 1; //mulai dari indeks 1

        //pengulangan untuk membandingkan dan menyisipkn nilai
        while (i < ukuran) {
            max = array[i]; //simpan nilai yang akan disisipkan
            j = i; // mulai dari index 1

            // Pengulangan untuk menggeser elemen yang lebih besar ke kanan
            while (j > 0 && array[j - 1] > max) {
                array[j] = array[j - 1];  // Geser elemen ke kanan
                j--;                     // Pindah ke indeks sebelumnya
            }

            // Sisipkan nilai ke posisi yang sudah sesuai
            array[j] = max;
            i++;  // Pindah ke elemen berikutnya
        }

        return array;  // Kembalikan array yang sudah diurutkan
    }

    // Metode utama untuk menjalakan insertion sort
    public static void main(String[] args) {
        int[] array = {9, 5, 1, 4, 3};  // Array yang akan diurutkan
        int[] sortedArray = insertion(array);  // Panggil metode insertion untuk mengurutkan array

        System.out.println("Array yang sudah diurutkan:");

        // Cetak array yang sudah diurutkan
        for (int value : sortedArray) {
            System.out.print(value + " ");
        }
    }
}

