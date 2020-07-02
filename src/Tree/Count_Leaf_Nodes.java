package Tree;

public class Count_Leaf_Nodes {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left = null;
            right = null;
        }
    }
    static int y=0;
    static void count(Node root){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            y++;
            return;
        }
        count(root.left);
        count(root.right);
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        count(root);
        System.out.println("Number of Leaf Nodes: "+y);
    }
}
