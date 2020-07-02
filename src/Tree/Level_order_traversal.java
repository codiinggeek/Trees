package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Level_order_traversal {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left=right=null;
        }
    }
    Node root;
    Level_order_traversal(){
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
    public static void main(String[] args){
        Level_order_traversal tree = new Level_order_traversal();
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

        /**
         * Level Order Traversal
         */
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.root);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(current.val+" ");
            if(current.left!=null){
                queue.add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
            }
        }
    }
}
