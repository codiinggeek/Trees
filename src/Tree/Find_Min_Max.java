package Tree;

public class Find_Min_Max {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left=right=null;
        }
    }
    Node root;
    Find_Min_Max(){
        root = null;
    }
    static Node insert(Node root, int v){
        if(root==null){
            root = new Node(v);
            return root;
        }
        if(v<=root.val){
            root.left = insert(root.left, v);
        }else {
            root.right = insert(root.right, v);
        }
        return root;
    }
    static int findMin(Node root){
        int v = root.val;
        while(root.left!=null){
            root = root.left;
            v = root.val;
        }
        return v;
    }
    static int findMax(Node root){
        int v = root.val;
        while(root.right!=null){
            root = root.right;
            v = root.val;
        }
        return v;
    }
    public static void main(String []args){
        Find_Min_Max tree = new Find_Min_Max();
        tree.root = insert(tree.root, 50);
        tree.root = insert(tree.root, 30);
        tree.root = insert(tree.root, 20);
        tree.root = insert(tree.root, 40);
        tree.root = insert(tree.root, 35);
        tree.root = insert(tree.root, 70);
        tree.root = insert(tree.root, 60);
        tree.root = insert(tree.root, 80);
        tree.root = insert(tree.root, 75);
        tree.root = insert(tree.root, 90);

        int min = findMin(tree.root);
        int max = findMax(tree.root);
        System.out.println("Min: "+min);
        System.out.println("Max: "+max);

    }
}
