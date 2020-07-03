package Tree;

public class find_nth_node {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left=right=null;
        }
    }
    static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    static int count = 0;
    static void findNth(Node root, int v){
        if(root==null){
            return;
        }
        if(count<=v) {
            findNth(root.left, v);
            count++;
            if(count==v)
            System.out.print(root.val + " ");
            findNth(root.right, v);
        }
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        inorder(root);
        System.out.println();
        findNth(root, 4);
    }
}
