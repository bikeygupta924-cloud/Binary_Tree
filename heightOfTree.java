public class heightOfTree {
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
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int leftheight=height(root.left);
        int rightheight=height(root.right);
        return Math.max(leftheight,rightheight)+1;
    }

    public static int CountOfNodes(Node root){
        if(root==null){
            return 0;
        }

        int leftcount=CountOfNodes(root.left);
        int rightcount=CountOfNodes(root.right);
        return leftcount+rightcount+1;
    }

    public static int SumOfNodes(Node root){
        if(root==null){
            return 0;
        }

        int leftsum=SumOfNodes(root.left);
        int rightsum=SumOfNodes(root.right);
        return leftsum+rightsum+root.data;
    }

    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int leftdiameter=diameter(root.left);
        int leftheight=height(root.left);
        int rightdiameter=diameter(root.right);
        int rightheight=height(root.right);
        int selfdiameter=leftheight+rightheight+1;

        return Math.max(selfdiameter, Math.max(leftdiameter, rightdiameter));
    }
    public static void main(String[] args) {
      /*         1
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
        root.right.right=new Node(6);
        root.right.left=new Node(7);

        System.out.println("Height of tree is: "+height(root));
        System.out.println( "------------------");

        System.out.println("Count of nodes is: "+CountOfNodes(root));
        System.out.println( "------------------");

        System.out.println("Sum of nodes is: "+SumOfNodes(root));
        System.out.println( "------------------");

        System.out.println("Diameter of tree is: "+diameter(root));

    }
}