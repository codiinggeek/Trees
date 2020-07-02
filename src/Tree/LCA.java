package Tree;

public class LCA {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left = right = null;
        }
    }
    public static Node LCA(Node root, int a, int b){
        if(root==null)
            return null;
        if(root.val==a||root.val==b){
            return root;
        }
        Node left = LCA(root.left, a, b);
        Node right = LCA(root.right, a, b);

        if(left!=null&&right!=null){
            return root;
        }else if(left!=null){
            return left;
        }else if(right!=null){
            return right;
        }else {
            return null;
        }
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("LCA(4, 5): " + LCA(root,4,5).val);
        System.out.println("LCA(4, 6): " + LCA(root,4,6).val);
        System.out.println("LCA(3, 4): " + LCA(root,3,4).val);
        System.out.println("LCA(2, 4): " + LCA(root,2,4).val);
    }
}
