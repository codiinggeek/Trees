package Tree;

/**
 * https://www.youtube.com/watch?v=vdwcCIkLUQI
 */
public class MirrorTree {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left = right = null;
        }
    }

    static void mirror(Node root){
        if(root==null){
            return;
        }
        mirror(root.left);
        mirror(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
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
        mirror(root);
        inorder(root);
    }
}
