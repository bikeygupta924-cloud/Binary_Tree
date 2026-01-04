
// Question 1 :
// Check if a Binary Tree is univalued or not
// We have a binary tree, the task is to check if the binary tree is univalued or not. 
// If found to be true, then print "YES". Otherwise, print "NO".

// package Question;

public class Q1 {
    public static  class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static boolean isUnivalued(Node root){
        if(root==null){
            return true;
        }

        if(root.left !=null && root.left.data != root.data){
            return false;
        }
        if(root.right !=null && root.right.data != root.data){
            return false;
        }

        return isUnivalued(root.left) && isUnivalued(root.right);

    }
    public static void main(String[] args) {
        /*
                 2
                / \
               2   2
              / \
            5   2
         */
        Node root=new Node(2);
        root.left=new Node(2);
        root.right=new Node(2);
        root.left.left=new Node(5);
        root.left.right=new Node(2);

        if(isUnivalued(root)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        
    }
}
