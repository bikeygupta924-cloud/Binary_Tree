public class SortedArrayToBalanceBst {
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

    // Function to convert sorted array to balanced BST
    public static Node SortedToBalancedBst(int arr[],int start,int End){
        if(start>End){
            return null;
        }
        int mid=(start+End)/2;
        Node root=new Node(arr[mid]);

        root.left=SortedToBalancedBst(arr,start,mid-1);
        root.right=SortedToBalancedBst(arr,mid+1,End);
        return root;
    }

    // preorder traversal to verify balanced bst
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        int arr[]={3,5,6,8,10,11,12};
        /*
         * The balanced BST will be:
         *        8
         *      /   \
         *    5     11
         *   / \    / \
         *  3   6  10 12
         */

        Node root=SortedToBalancedBst(arr,0,arr.length-1);
        System.out.println("Preorder traversal of balanced BST:");
        preorder(root);

    }
}
