package Tree;

public class Inorder_Ancestor_in_BST {
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
    Inorder_Ancestor_in_BST(){
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
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    static Node findroot(Node root, int data){
        if(root==null){
            return null;
        }else if(data==root.val){
            return root;
        }else if(data<root.val){
            return findroot(root.left, data);
        }else{
            return findroot(root.right, data);
        }
    }
    static Node getSuccessor(Node root, int data){
        Node cur = findroot(root, data);
        if(cur==null)
            return null;
        if(cur.right!=null){
            return findMin(cur.right);
        }else{
            Node succesor = root;
            Node ancestor = null;
            while(succesor!=cur){
                if(data<succesor.val){
                    ancestor = succesor;
                    succesor = succesor.left;
                }else{
                    succesor = succesor.right;
                }
            }
            return ancestor;
        }
    }

    static Node findMin(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public static void main(String[] args){
        Inorder_Ancestor_in_BST tree = new Inorder_Ancestor_in_BST();
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

        Node ans = getSuccessor(tree.root, 40);
        System.out.println(ans.val);
    }
}
