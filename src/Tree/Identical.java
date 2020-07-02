package Tree;

public class Identical {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left = right = null;
        }
    }
    static boolean isIdentical(Node root1, Node root2)
    {
        if(root1==null&&root2==null)
            return true;
        if(root1==null||root2==null)
            return false;

        if(root1.val==root2.val){
            return isIdentical(root1.left, root2.left)&&
                    isIdentical(root1.right, root2.right);

        }
        return false;

    }

    public static void main(String[] args){
        Node root1 = new Node(5);
        Node root2 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(8);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);

        root2.left = new Node(3);
        root2.right = new Node(8);
        root2.left.left = new Node(2);
        root2.left.right = new Node(4);

        if (isIdentical(root1, root2))
            System.out.print("Both Binary Trees are identical");
        else
            System.out.print("Binary Trees are not identical");
    }
}
