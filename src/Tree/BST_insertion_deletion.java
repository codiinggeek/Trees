package Tree;

public class BST_insertion_deletion {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left=right=null;
        }
    }
    Node root;
    BST_insertion_deletion(){
        root = null;
    }

    /**
     * Insertion
     */
    static Node insert(Node root, int v){
        if(root==null){
            root = new Node(v);
            return root;
        }
        if(v<=root.val){
            root.left = insert(root.left, v);
        }else{
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

    /**
     * Deletion
     */
    static Node delete(Node root, int v){
        if(root==null)
            return null;
        if(v<root.val){
            root.left = delete(root.left, v);
        }else if(v>root.val){
            root.right = delete(root.right, v);
        }else{
            if(root.left==null&&root.right==null){
                return null;
            }else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                root.val = findMin(root.right);
                root.right = delete(root.right, root.val);
            }
        }
        return root;
    }
    static int findMin(Node root){
        int min = root.val;
        while(root.left!=null){
            min = root.left.val;
            root = root.left;
        }
        return min;
    }
    public static void main(String[] args){
        BST_insertion_deletion tree = new BST_insertion_deletion();
        tree.root = insert(tree.root, 50);
        tree.root = insert(tree.root, 30);
        tree.root = insert(tree.root, 20);
        tree.root = insert(tree.root, 40);
        tree.root = insert(tree.root, 35);
        tree.root = insert(tree.root, 70);
        tree.root = insert(tree.root, 60);
        tree.root = insert(tree.root, 80);

        inorder(tree.root);
        System.out.println();

        System.out.println("Deleting node with value 30");
        tree.root = delete(tree.root, 30);

        inorder(tree.root);
    }
}
