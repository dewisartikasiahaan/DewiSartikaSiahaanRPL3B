
//folder untuk menyimpan class

//class node
class nodee {
    int data; // Data yang disimpan dalam nodee
    nodee left, right; // Anak kiri dan anak kanan dari nodee

    public nodee(int data) { //konstruktor untuk membuat node
        this.data = data;
        left = right = null;
    }
}

//clsss binarytree
public class BinaryTree {

    nodee root; // Akar dari pohon biner

    //ini adalah metode utama untuk menjalankan program
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(); // Membuat objek tree

        // ini adalah untuk Membuat node
        tree.root = new nodee(1);
        tree.root.left = new nodee(2);
        tree.root.right = new nodee(3);
        tree.root.left.left = new nodee(4);
        tree.root.left.right = new nodee(5);
        tree.root.right.left = new nodee(6);
        tree.root.right.right = new nodee(7);
        tree.root.left.left.left = new nodee(8);
        tree.root.left.right.left = new nodee(9);
        tree.root.right.left.left = new nodee(10);

        //ini adalah untuk cetak tree
        printTree(tree.root, "", true);
    }


    //ini adalah metode untuk mencetak tree
    public static void printTree(nodee nodee, String indent, boolean last) {
        if (nodee != null) {
            System.out.println(indent + "+-- " + nodee.data);
            indent += last ? "    " : "|   ";
            printTree(nodee.right, indent, false);
            printTree(nodee.left, indent, true);
        }
    }
}