package Tree;

import java.util.LinkedList;

public class BinaryTree_Check_If_BST {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left=right=null;
        }
    }
    Node root;
    BinaryTree_Check_If_BST(){
        root = null;
        list = new LinkedList<>();
    }
    static LinkedList<Integer> list;
    static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public static void main(String []args){
        BinaryTree_Check_If_BST tree = new BinaryTree_Check_If_BST();
        tree.root = new Node(4);
        tree.root.left = new Node(6);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        inorder(tree.root);
        int s = list.size();
        int y = 0;
        for(int i=1;i<s;i++){
            if(list.get(i)>=list.get(i-1))
                continue;
            y=1;
            break;
        }
        if(y==1)
            System.out.println("NOT a BST");
        else{
            System.out.println(list);
            System.out.println("It is a BST");
        }
    }
}
