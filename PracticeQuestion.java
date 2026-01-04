// package revision;

import java.util.*;

public class PracticeQuestion {

        // ---------------- Node Class ----------------
  public static class Node{
    int data;
    Node left,right;
    
    public Node(int data){
      this.data=data;
      this.left=null;
      this.right=null;
    }
  }

   // ---------------- Binary Tree Construction ----------------
  static class Binarytree{
    static int idx=-1;
    public static Node binarytree(int nodes[]){
      idx++;
      if(nodes[idx]==-1){
        return null;
      }
      Node newNode=new Node(nodes[idx]);
      newNode.left=binarytree(nodes);
      newNode.right=binarytree(nodes);
      return newNode;
    }
  }
  
   // ---------------- Tree Traversals ----------------
  public static void preorder(Node root){
    if(root==null){
      return;
    }
    
    System.out.print(root.data+" ");
    preorder(root.left);
    preorder(root.right);
  }
  
  public static void inorder(Node root){
    if(root==null){
      return;
    }
    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
  }
  
  public static void postorder(Node root){
    if(root==null){
      return;
    }
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.data+" ");
    
  }
  
  public static void levelorder(Node root){
    if(root==null){
      return;
    }
    Queue<Node>q=new LinkedList<>();
    q.add(root);
    
    while(!q.isEmpty()){
      Node curr=q.remove();
      System.out.print(curr.data+" ");
      if(curr.left!=null){
        q.add(curr.left);
      }
      if(curr.right!=null){
        q.add(curr.right);
      }
    }
  }

  // ---------------- Tree Properties ----------------
  public static int Nodecount(Node root){
    if(root==null){
      return 0;
    }
    int leftcount=Nodecount(root.left);
    int rightcount=Nodecount(root.right);
    
    return leftcount+rightcount+1;
  }
  
  public static int height(Node root){
    if(root==null){
      return 0;
    }
    int leftheight=height(root.left);
    int rightheight=height(root.right);
    
    return Math.max(leftheight,rightheight)+1;
  }
  
  public static int sumofnodes(Node root){
    if(root==null){
      return 0;
    }
    int leftsum=sumofnodes(root.left);
    int rightsum=sumofnodes(root.right);
    
    return leftsum+rightsum+root.data;
  }
  
  public static int diameter(Node root){
    if(root==null){
      return 0;
    }
    int leftheight=height(root.left);
    int leftdiameter=diameter(root.left);
    int rightheight=height(root.right);
    int rightdiameter=diameter(root.right);
    
    int selfdiameter=leftheight+rightheight + 1;
    
    return Math.max(selfdiameter,Math.max(leftdiameter,rightdiameter));
  }

      // ---------------- Subtree Check ----------------
    public static boolean isIdentical(Node root, Node subroot) {
        if (root == null && subroot == null) return true;
        if (root == null || subroot == null) return false;
        if (root.data != subroot.data) return false;
        return isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
    }

    public static boolean isSubtree(Node root, Node subroot) {
        if (subroot == null) return true;
        if (root == null) return false;
        if (root.data == subroot.data && isIdentical(root, subroot)) return true;
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public static void kthlevel(Node root,int k){
      if(root==null){
        return;
      }
    }

  // ---------------- Main Method ----------------
    public static void main(String[] args) {
      int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

  //       1
  //     /   \
  //    2     3
  //   / \     \
  //  4   5     6


      Node root=Binarytree.binarytree(nodes);

      
      System.out.println("preorder:");
      preorder(root);
      
      System.out.println("\n Inorder:");
      inorder(root);
      
      System.out.println("\n Postorder:");
      postorder(root);
      
      System.out.println("\n levelorder:");
      levelorder(root);
      
      System.out.println("\n Height of tree : ");
      System.out.println(height(root));
      
      System.out.println("count  of tree : ");
      System.out.print(Nodecount(root));
      
      System.out.println("\n Sum of Nodes  tree : ");
      System.out.print(sumofnodes(root));
      
      System.out.println("\n Diameter of tree : ");
      System.out.print(diameter(root));

       // ---------------- Subtree Example ----------------
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        System.out.println("\nIs subroot a subtree? " + isSubtree(root, subroot)); // true
      
      
  }
}