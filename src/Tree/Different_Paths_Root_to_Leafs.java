package Tree;

import java.util.LinkedList;

public class Different_Paths_Root_to_Leafs {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left=right=null;
        }
    }
    Node root;
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
    Different_Paths_Root_to_Leafs(){
        root = null;
    }
    static LinkedList<LinkedList<String>> list = new LinkedList<>();

    static void paths(Node root, LinkedList<String> current){
        current.add(Integer.toString(root.val));
        if(root.left==null&&root.right==null){
            list.add(current);
            return;
        }
        if(root.left!=null){
            paths(root.left, new LinkedList<>(current));
        }
        if(root.right!=null){
            paths(root.right, new LinkedList<>(current));
        }
    }

    public static void main(String[] args){
        Different_Paths_Root_to_Leafs tree = new Different_Paths_Root_to_Leafs();
        tree.root = insert(tree.root, 50);
        tree.root = insert(tree.root, 30);
        tree.root = insert(tree.root, 20);
        tree.root = insert(tree.root, 40);
        tree.root = insert(tree.root, 35);
        tree.root = insert(tree.root, 70);
        tree.root = insert(tree.root, 60);
        tree.root = insert(tree.root, 80);

        if(tree.root==null){
            System.out.println("Tree Empty");
        }else{
            LinkedList<String> current = new LinkedList<>();
            current.add(Integer.toString(tree.root.val));
            if(tree.root.left!=null){
                paths(tree.root.left, new LinkedList<>(current));
            }

            if(tree.root.right!=null) {
                paths(tree.root.right, new LinkedList<>(current));
            }
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }
    }
}
