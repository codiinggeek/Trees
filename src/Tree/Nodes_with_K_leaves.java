package Tree;

public class Nodes_with_K_leaves {
    /**
     * https://www.youtube.com/watch?v=u2O11mengx8&list=PLeIMaH7i8JDj7DnmO7lll97P1yZjMCpgY&index=23
     */
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left = null;
            right = null;
        }
    }

    public static int countLeaves(Node root){
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null) {
            return 1;
        }
        int total = countLeaves(root.left)+countLeaves(root.right);
        if(total==k)
            System.out.print(root.val+" ");
        return total;
    }
    static int k;
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        root.left.left.left = new Node(9);
        root.left.left.right = new Node(10);
        root.right.right = new Node(8);
        root.right.left = new Node(7);
        root.right.left.left = new Node(11);
        root.right.left.right = new Node(12);

        k = 2;

        countLeaves(root);
    }
}
