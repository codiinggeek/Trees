package Tree;

public class Inorder_Predecessor_in_BST {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int v){
            val = v;
            left = right = null;
        }
    }
    Node root;
    Inorder_Predecessor_in_BST(){
        root = null;
    }
    static Node insert(Node root, int v){
        if(root == null){
            root = new Node(v);
            return root;
        }
        if(v<=root.val){
            root.left = insert(root.left, v);
        }else root.right = insert(root.right, v);
        return root;
    }
    static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    static Node findCurrent(Node root, int data){
        if(root==null)
            return null;
        if(data==root.val)
            return root;
        else if(data<root.val)
            return findCurrent(root.left, data);
        else return findCurrent(root.right, data);
    }
    static Node findMax(Node root){
        while(root.right!=null){
            root = root.right;
        }
        return root;
    }
    static Node predecessor(Node root, int data){
        if(root==null)
            return null;
        Node current = findCurrent(root, data);
        if(current==null)
            return null;
        if(current.left!=null){
            return findMax(current.left);
        }else{
            Node pre = null;
            Node temp = root;
            while(temp!=current){
                if(data>temp.val){
                    pre = temp;
                    temp = temp.right;
                }else{
                    temp = temp.left;
                }
            }
            return pre;
        }
    }
    public static void main(String args[]){
        Inorder_Predecessor_in_BST tree = new Inorder_Predecessor_in_BST();
        int ar[] = {50, 10, 30, 60 , 70 ,40, 55, 58};
        for(int i=0;i<ar.length;i++){
            tree.root = insert(tree.root, ar[i]);
        }
        inorder(tree.root);
        System.out.println();

        Node ans = predecessor(tree.root, 70);
        System.out.println(ans.val);
    }
}
