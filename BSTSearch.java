// package BinarySearchTree;

public class BSTSearch {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Recursive search in BST
    public static boolean search(Node root, int key) {
        // Base Case: empty tree or reached leaf node
        if (root == null) {
            return false; // key not found
        }

        // Case 1: key found
        if (root.data == key) {
            return true;
        }

        // Case 2: key < root.data → search left
        if (key < root.data) {
            return search(root.left, key);
        }

        // Case 3: key > root.data → search right
        else {
            return search(root.right, key);
        }
    }

    public static void main(String[] args) {
        // Building a sample BST
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        int key = 6;
        if (search(root, key)) {
            System.out.println("Found " + key);
        } else {
            System.out.println("Not Found " + key);
        }
    }
}

