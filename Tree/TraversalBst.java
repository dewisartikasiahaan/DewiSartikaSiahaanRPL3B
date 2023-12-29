
//untuk folder untuk menyimpan class

import java.util.LinkedList;
import java.util.Queue;

//untuk class node
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

//untuk class utama untuk algoritma yang di perlukan
public class TraversalBst {

    Node root;

    //untuk menabah node
    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // untuk  metode in odrder
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    //untuk metode  post order
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    //untuk metode untuk menjalankan levelorder
    public void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        //untuk  kondisi untuk memerika apakah queue nya kosong ap tidak
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }


    //untuk metode utama untuk menjalankan program
    public static void main(String[] args) {
        TraversalBst bst = new TraversalBst();

        // Membuat struktur BST
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 35);
        bst.insert(bst.root, 65);
        bst.insert(bst.root, 80);

        System.out.println("In-Order traversal:");
        bst.inOrder(bst.root);
        System.out.println();

        System.out.println("Post-Order traversal:");
        bst.postOrder(bst.root);
        System.out.println();

        System.out.println("Level-Order traversal:");
        bst.levelOrder(bst.root);
        System.out.println();
    }
}