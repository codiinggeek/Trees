package Tree;

public class Height {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left=right=null;
        }
    }
    Node root;
    Height(){
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
    static int findHeight(Node root){
        if(root==null){
            return -1;//if 0 is returned it will count the number of nodes
            // but we need height i.e. no. of edges on the longest path
        }
        return Math.max(findHeight(root.left),findHeight(root.right))+1;
    }
    public static void main(String args[]){
        Height tree = new Height();
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

        int height = findHeight(tree.root);
        System.out.println("Height: "+height);
    }
}
