package Tree;

public class Addition_of_All_Nodes {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left = right = null;
        }
    }
    static int add(Node root){
        if(root == null)
            return 0;
        return root.val+add(root.left)+add(root.right);
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        int sum = add(root);
        System.out.println("Total Sum: "+sum);
    }
}
