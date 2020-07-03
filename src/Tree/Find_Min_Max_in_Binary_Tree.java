package Tree;

public class Find_Min_Max_in_Binary_Tree {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left = right = null;
        }
    }
    static int findMin(Node root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int res = root.val;
        int left = findMin(root.left);
        int right = findMin(root.right);
        if(res>left){
            res = left;
        }
        if(res>right){
            res = right;
        }
        return res;
    }
    static int findMax(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int res = root.val;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(res<left){
            res = left;
        }
        if(res<right){
            res = right;
        }
        return res;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("MIN: "+findMin(root));
        System.out.println("MAX: "+findMax(root));
    }
}
