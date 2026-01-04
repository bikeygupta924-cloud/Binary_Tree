// TRANSFORM TO SUM TREE
// A Sum Tree is a binary tree where every node's value
// is replaced by the sum of values of its left and right subtrees in the original tree.
// Leaf nodes are replaced with 0.

public class sumTree {

    // Node class represents a single node in the binary tree
    public static class Node {
        int data;       // Value of the node
        Node left;      // Left child
        Node right;     // Right child

        // Constructor to initialize a node with data
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to convert the binary tree into a Sum Tree
    // It returns the total sum of values under the current node (including itself)
    public static int toSumTree(Node root){
        // Base case: if the node is null, return 0
        if(root == null){
            return 0;
        }

        // Store the old value (current node’s data) before modification
        int oldValue = root.data;

        // Recursively convert left and right subtrees to Sum Trees
        // and update the current node’s data with the sum of those subtrees
        root.data = toSumTree(root.left) + toSumTree(root.right);

        // Return the total sum of the subtree rooted at this node (including oldValue)
        return root.data + oldValue;
    }

    // Preorder traversal (Root -> Left -> Right)
    // Used to print the tree before and after transformation
    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Main function
    public static void main(String[] args) {
        /*
                Original Tree structure:
                       1
                     /   \
                    2     3
                   / \   / \
                  4   5 7   6

            Expected Sum Tree:
                          27
                        /    \
                       9      13
                     /   \    /  \
                    0     0  0    0

            Explanation:
            - Each node = sum of left + right subtree values (from original tree)
            - Leaf nodes (4,5,7,6) become 0
        */

        // Step 1: Create the original binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(6);

        // Step 2: Print preorder traversal of original tree
        System.out.println("Preorder traversal of original tree:");
        preOrder(root);
        System.out.println();

        // Step 3: Transform to Sum Tree
        toSumTree(root);

        // Step 4: Print preorder traversal of transformed Sum Tree
        System.out.println("Preorder traversal of sum tree:");
        preOrder(root);
    }
}