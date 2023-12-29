

public class DirectHash {

    private int[] table; //Array untuk menyimpan data dengan indeks sesuai nilai

    public DirectHash(int size) {  //konstruktor untuk membuat hashtable
        table = new int[size];
    }

    public void insert(int value) {  // metode yang di gunakan untuk menyisipkan ( insert) ke dalam hashtbale
        table[value] = value; // gunakan nilai sebagai kunci( index)
        System.out.println("Data: "+value+" dimasukan ke index: "+ value);
    }

    public int search(int value) {  //metode untuk mencari nilai yang ada di dalam data(hashtable)
        if (table[value] == value) { //periksa nilai,apakah nilai ada pada indeks yang sesuai apa tidak
            return table[value]; // kembalikan nilai jika ada
        }
        return -1; //jika tidak di temukan
    }

    //metode utama (main) untuk menjalankan hashtable
    public static void main(String[] args) {
        DirectHash directHash = new DirectHash(200); //inisialisai hash dengan ukuran array 200

        //menambah nilai ke directhash
        directHash.insert(9);
        directHash.insert(50);
        directHash.insert(100);

        //mencari nilai
        System.out.println("Hasil pencarian nilai 9 di Index: " + directHash.search(9));
        System.out.println("Hasil pencarian nilai 50 di Index: " + directHash.search(50));
        System.out.println("Hasil pencarian nilai 100 di Index: " + directHash.search(100));
        //jika nilai ada maka nilai akan di kembalikan


        System.out.println("Hasil pencarian nilai 150 di Index: " + directHash.search(150));
        //karena nilai 150 tidak ada di directhash maka yang akan di kembalikan adalah -1
    }
}