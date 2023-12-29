

public class BubbleSort {

    //metode untuk mengurutkn array dengan algoritma buble sort
    //yaitu dengn cara memindahkan nilai yang kecil ke sebelah kiri dan yng besar ke sebelah kanan//
    void bubbleSort(int arr[]) {
        int n = arr.length;

        //perulangan untuk membandingkan nilai dalam array
        for (int i = 0; i < n-1; i++) {
            //perulangan untuk membandingkan nilai2 yang berdekatan
            for (int j = 0; j < n-i-1; j++) {
                //jika nilai di sebelah kiri lebih besar dari nilai sebelah kanan,tukar posisinya
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    //metode utama untuk menjalankan class
    public static void main(String args[]) {
        BubbleSort ob = new BubbleSort(); //buat objek Bubblesort nya
        int arr[] = {64, 34, 25, 12, 22, 11, 90}; //arrya yang nnti nya akan di urutkan menggunaka metode bubblesort

        ob.bubbleSort(arr);  //panggil metode bubble sort untk mengurutkan
        System.out.println("Sorted array");

        //cetak arrry yang sudah di urutka
        for (int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
