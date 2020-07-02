package Tree;

import java.util.LinkedList;

public class Specified_Sum_from_root_to_leaf {
    /**
     Given a binary tree and a number, return true
     if the tree has a root-to-leaf path such that adding up all
     the values along the path equals the given number.
     Return false if no such path can be found.
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
    Specified_Sum_from_root_to_leaf(){
        root = null;
    }
    static boolean paths(Node root, int sum){
        if (root==null)
            return false;
        if(root.left==null&&root.right==null&&sum-root.val==0){
            return true;
        }else{
            return paths(root.left, sum-root.val)||paths(root.right, sum-root.val);
        }
    }

    static LinkedList<LinkedList<Integer>> ll = new LinkedList<>();
    static void pathList(Node root, LinkedList<Integer> current, int sum){
        if(root==null)
            return;
        if(sum-root.val<0)
            return;
        current.add(root.val);
        if(root.left==null&&root.right==null&&sum-root.val==0){
            ll.add(current);
            return;
        }else{
            pathList(root.left, new LinkedList<>(current), sum-root.val);
            pathList(root.right, new LinkedList<>(current), sum-root.val);
        }
    }

    public static void main(String[] args){
        Specified_Sum_from_root_to_leaf tree = new Specified_Sum_from_root_to_leaf();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

        int sum = 21;
        if(paths(tree.root, sum)){
            System.out.println("Path Found");
            pathList(tree.root, new LinkedList<>(), sum);
            for(int i=0;i<ll.size();i++){
                System.out.println(ll.get(i));
            }
        }else{
            System.out.println("Path not found");
        }

    }
}
