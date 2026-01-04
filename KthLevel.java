// Print kth level, find LCA, and Minimum Distance between two nodes  in a Binary Tree 
// Kth ancestor of a node
// Time Complexity: O(n)
// Space Complexity: O(h) — recursion stack height

import java.util.*;

class KthLevel {

    // Node class represents each node in the binary tree
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Print all nodes at the Kth level (Recursive)
    public static void kthlevel(Node root, int level, int k) {
        if (root == null) return;

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        kthlevel(root.left, level + 1, k);
        kthlevel(root.right, level + 1, k);
    }

    // ----------- LCA using path method ----------- lowest common ancestor
    public static Node lca(Node root,int n1,int n2){
        if(root==null || root.data==n1 || root.data==n2){
            return root;
        }
        Node leftLca=lca(root.left,n1,n2);
        Node rightLca=lca(root.right,n1,n2);

        if(rightLca==null) return leftLca;
        if(leftLca==null) return rightLca;

        if(leftLca!=null && rightLca!=null);
        return root;
    }

    // ----------- LCA using single traversal (better for distance) -----------
    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if (leftLca == null) return rightLca;
        if (rightLca == null) return leftLca;

        return root;
    }

    // ----------- Find Distance from a node to given data -----------
    public static int localDistance(Node root, int n) {
        if (root == null) return -1;
        // overlapeping condition at root 
        if (root.data == n) return 0;  

        int leftDist = localDistance(root.left, n);
        int rightDist = localDistance(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
        
    }

    // ----------- Minimum Distance between two nodes -----------
    public static void minDistance(Node root, int m1, int m2) {
        Node lca = lca2(root, m1, m2);

        int dist1 = localDistance(lca, m1);
        int dist2 = localDistance(lca, m2);

        System.out.println("Minimum distance between " + m1 + " and " + m2 + " is: " + (dist1 + dist2));
    }

    // -----------kth ancestor of node--------

    public static int KthAncestor(Node root,int n,int p){

        if(root==null){
            return -1;
        }

        if(root.data==n){
            return 0;
        }
        int leftDist=KthAncestor(root.left,n,p);
        int rightDist=KthAncestor(root.right,n,p);

        if(leftDist==-1 && rightDist==-1){
            return -1;
        }

        int maxDist= Math.max(leftDist,rightDist);
        if(maxDist+1==p){
            System.out.println(p+"th Ancestor of node "+n+" is: "+root.data);
        }
        return maxDist+1;
    }

    // ----------- Main Function -----------
    public static void main(String[] args) {
        /*
                Tree structure:
                       1
                     /   \
                    2     3
                   / \   / \
                  4   5 7   6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(6);
        

        System.out.println("----------Kth Level-----------");
        int k = 3;
        System.out.println("Nodes at level " + k + ":");
        kthlevel(root, 1, k);

        System.out.println("\n-----------LCA-----------");
        int n1 = 4, n2 = 5;
        System.out.println(lca(root, n1, n2).data);

        System.out.println("----------Min Distance Between Two Nodes---------------");
        int m1 = 4, m2 = 6;
        minDistance(root, m1, m2);

        System.out.println("----------Kth Ancestor of a Node---------------");
        int n = 5;
        int p = 2;
        KthAncestor(root, n, p);

    }
}