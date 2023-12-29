
import java.util.LinkedList;


public class StringHash {

    //array untuk menyimpan data
    private LinkedList<String>[] table;


    //konstrutor untuk membuat string hash dengn ukuran size
    public StringHash(int size) {
        table = new LinkedList[size];

        //menginisialisai setiap hsh di ndex
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    //fungsi hash untk menghitung index dari string
    public int hashFunction(String key) {
        return key.charAt(0) % table.length; //return index ynag di hasilkan
    }

    //unutk menambah string ke dalam hashtable
    public void insert(String value) {
        int index = hashFunction(value); //hitung inex
        table[index].add(value); //tambah index
        System.out.println("Data "+value+" ditambahkan di index: "+index);
    }

    //untuk mencari string yang ad di hashtble
    public int search(String value) {
        int index = hashFunction(value); //menghitung index hash
        return index;  //kembalikan index
    }

    //metode utama
    public static void main(String[] args) {
        //membuat hash table dengna ukuran 26
        StringHash stringHash = new StringHash(26);
        //tambahkan beberapa stirng ke hashtable
        stringHash.insert("Kucing");
        stringHash.insert("Ayam");
        stringHash.insert("Kelinci");

        //memcari sring kelinci dan mencetak indexnya
        System.out.println("String Kelinci ditemukan di index: " + stringHash.search("Kelinci")); // Mencari string "Kelinci"
    }
}