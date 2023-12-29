
//folder untuk menyimpan class

//class node
class Node {
    int data;
    Node left, right;

    //konstruktor untuk menambah node baru
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}


//class utama untuk algoritma tree
public class BinarySearchTree {

    Node root;  // Node akar dari BST

    public Node insert(Node root, int data) {
        // Jika sub-pohon kosong, ciptakan node baru sebagai akar dari sub-pohon
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Rekursif menambahkan node berdasarkan perbandingan data
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }


    // metode untuk mencetak tree dengn terstruktur

    public void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.println(indent + "+-- " + node.data);
            indent += last ? "    " : "|   ";
            printTree(node.right, indent, false);
            printTree(node.left, indent, true);
        }
    }


    //metode utama untuk menjalankan program
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();  // Membuat objek BST

        //menambah data
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 35);
        bst.insert(bst.root, 65);
        bst.insert(bst.root, 80);

        // Mencetak struktur pohon dalam bentuk folder
        bst.printTree(bst.root, "", true);

    }
}