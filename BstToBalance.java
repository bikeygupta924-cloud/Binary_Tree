
import java.util.*;

public class BstToBalance {

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

    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void storeInorder(Node root,ArrayList<Integer> inorder){
        if(root==null){
            return;
        }
        storeInorder(root.left,inorder);
        inorder.add(root.data);
        storeInorder(root.right,inorder);
    }

    public static Node sortedArrayToBalancedBst(ArrayList<Integer> inorder,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(inorder.get(mid));

        root.left=sortedArrayToBalancedBst(inorder,start,mid-1);
        root.right=sortedArrayToBalancedBst(inorder,mid+1,end);

        return root;
    }

    public static Node bstToBalancedBst(Node root){
        // step 1: store inorder of bst in arraylist
        ArrayList<Integer> inorder=new ArrayList<>();
        storeInorder(root,inorder);

        // sorted inorder to balanced bst
        return sortedArrayToBalancedBst(inorder,0,inorder.size()-1);
        
        
    }
    
    public static void main(String[] args) {

         /*
         * The unbalanced BST is:
                 8
               /   \
             6     10
            /       \
           5         11
          /           \
        3              12
         */

        Node root = new Node (8);
        root.left = new Node (6);
        root.left.left = new Node (5);
        root.left.left.left = new Node (3);

        root.right = new Node (10);
        root.right.right = new Node (11);
        root.right.right.right = new Node (12);
       
        /*
         * The balanced BST will be:
                 8
               /   \
             5     11
            / \    / \
           3   6  10 12
         */

        System.out.println("Preorder traversal of balanced BST:");
        root=bstToBalancedBst(root);
        preorder(root);
        
       
    }
}
