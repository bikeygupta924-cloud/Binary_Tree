public class subtree {
    public static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static boolean IsIdentical(Node root, Node subroot){
        if(root == null && subroot == null) return true;
        if(root == null || subroot == null) return false;

        if(root.data != subroot.data) return false;

        return IsIdentical(root.left, subroot.left) && IsIdentical(root.right, subroot.right);
    }

    public static boolean Subtree_of_anothertree(Node root, Node subroot){
        if(subroot == null) return true; // empty tree is always subtree
        if(root == null) return false;   // subroot not null but root finished → no match

        if(root.data == subroot.data){
            if(IsIdentical(root, subroot)) return true;
        }

        return Subtree_of_anothertree(root.left, subroot) || Subtree_of_anothertree(root.right, subroot);
    }

    public static void main(String[] args) {

        /*
                1
               /  \
              2    3
            / \    / \
           4   5   7  6
         */
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(7);
        root.right.right=new Node(6);

        /*      2
               / \
              4   5
         */
        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);

        System.out.println(Subtree_of_anothertree(root,subroot)); // ✅ Output: true
    }
}
