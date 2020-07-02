package Tree;

public class Diameter_of_Binary_Tree {
    /**
     * for explanation: https://www.youtube.com/watch?v=ey7DYc9OANo&list=PLeIMaH7i8JDj7DnmO7lll97P1yZjMCpgY&index=17
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
    Node root;
    Diameter_of_Binary_Tree(){
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
    static void inorder(Node root){
        if (root==null)
            return;
        inorder(root.left);
        System.out.print(root.val+"  ");
        inorder(root.right);
    }
    static int height(Node root){
        if(root==null)
            return -1;
        return Math.max(height(root.left), height(root.right))+1;
    }
    static int Diameter(Node root){
        if(root==null){
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        int lDiameter = Diameter(root.left);
        int rDiameter = Diameter(root.right);

        return Math.max(lHeight+rHeight+1, Math.max(lDiameter, rDiameter));
    }
    public static void main(String []args){
        Diameter_of_Binary_Tree tree = new Diameter_of_Binary_Tree();
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

        inorder(tree.root);
        System.out.println();

        int d = Diameter(tree.root);
        System.out.println("Diameter of tree: "+d);
    }
}
