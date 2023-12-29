
import java.util.*;
class Edges {
    public String destination;  // Simpul tujuan (destination)
    public int weight;  // Bobot sisi (weight)

    public Edges(String destination, int weight) {  // Konstruktor untuk membuat sisi
        this.destination = destination;
        this.weight = weight;
    }
}

public class BfsGraphTraversal {  // Kelas utama untuk algoritma BFS
    private Map<String, List<Edges>> adjacencyList;

    public BfsGraphTraversal() {  // Konstruktor untuk menginisialisasi graf
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan simpul (node) ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());  // Tambahkan simpul jika belum ada
    }

    // Metode untuk menambahkan sisi berbobot ke graf
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot
        adjacencyList.get(source).add(new Edges(destination, weight));
    }

    // Metode untuk mendapatkan daftar tetangga dan bobot dari node
    public List<Edges> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());  // Kembalikan daftar tetangga, atau daftar kosong jika tidak ada
    }

    // Metode untuk melakukan BFS traversal dari node sumber
    public void bfsTraversal(String start) {
        Set<String> visited = new HashSet<>();  // Kumpulan untuk menyimpan simpul yang sudah dikunjungi
        Queue<String> queue = new LinkedList<>();  // Antrian untuk menyimpan simpul yang akan diproses

        queue.add(start);  // Tambahkan node awal ke antrian
        visited.add(start);  // Tandai node awal sebagai sudah dikunjungi

        while (!queue.isEmpty()) {
            String current = queue.poll();  // Ambil simpul dari antrian
            System.out.print(current + " ");  // Cetak simpul yang sedang diproses

            // Periksa semua tetangga simpul saat ini
            for (Edges edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(edge.destination)) {
                    queue.add(edge.destination);  // Tambahkan tetangga yang belum dikunjungi ke antrian
                    visited.add(edge.destination);  // Tandai tetangga sebagai sudah dikunjungi
                    //System.out.print("-> (" + edge.weight + ") " + edge.destination + " ");  // Opsional: Cetak bobot sisi
                }
            }
        }
        System.out.println();  // Cetak baris baru setelah selesai
    }

    // Metode utama untuk menjalankan program bfs
    public static void main(String[] args) {
        BfsGraphTraversal graph = new BfsGraphTraversal();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        graph.bfsTraversal("A");  // Jalankan BFS traversal dari simpul "A"
    }
}