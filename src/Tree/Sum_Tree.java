package Tree;

/**
 * https://www.youtube.com/watch?v=zEIWqb8nWDk&list=PLeIMaH7i8JDj7DnmO7lll97P1yZjMCpgY&index=34
 */
public class Sum_Tree {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left = null;
            right = null;
        }
    }
    static int add(Node node){
            if(node==null)
                return 0;
            return node.val+add(node.left)+add(node.right);
    }
    static boolean isSumTree(Node node)
    {
        if(node==null){
            return true;
        }
        if(node.left==null&&node.right==null){
            return true;
        }
        int left = add(node.left);
        int right = add(node.right);

        if(left+right==node.val){
            if(isSumTree(node.left)&&isSumTree(node.right))
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        if (isSumTree(root))
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");
    }
}
