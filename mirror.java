public class mirror {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Node mirrorBst(Node root){ //Node return type because we need to return the root of mirrored bst
        if(root==null){
            return null;
        }

        Node leftMirror=mirrorBst(root.left);
        Node rightMirror=mirrorBst(root.right);
 
        // swap left and right subtree 
        root.left=rightMirror;
        root.right=leftMirror;

        return root;
    }
    //  preorder traversal for printing mirrored bst to verify
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        /*
                8
              /    \
             5      10
            /  \      \
           3    6      11
         */

        Node root=new Node(8);
        root.left=new Node(5);
        root.right=new Node(10);
        root.left.left=new Node(3);
        root.left.right=new Node(6);
        root.right.right=new Node(11);

        /*.   mirror of the bst
                   8
                /    \
               10      5
              /      /  \
             11     6    3
         */

        System.out.println("Preorder traversal of original BST:");
        preorder(root);
        root=mirrorBst(root);
        System.out.println("\nPreorder traversal of mirrored BST:");
        preorder(root);
    }
}
