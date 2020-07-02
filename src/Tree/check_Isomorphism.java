package Tree;

public class check_Isomorphism {
    /**
     * for explanation: https://www.youtube.com/watch?v=9Eo42meRcrY&list=PLeIMaH7i8JDj7DnmO7lll97P1yZjMCpgY&index=18
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
    Node root1, root2;
    check_Isomorphism(){
        root1 = null;
        root2 = null;
    }
    static boolean checkIso(Node root1, Node root2){
        if(root1==null&&root2==null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return ((checkIso(root1.left, root2.left)&&checkIso(root1.right, root2.right))||
                (checkIso(root1.left, root2.right)&&checkIso(root1.right, root2.left)));
    }
    public static void main(String[] args){
        check_Isomorphism tree = new check_Isomorphism();

        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);
        tree.root1.right.left = new Node(6);
        tree.root1.left.right.left = new Node(7);
        tree.root1.left.right.right = new Node(8);

        tree.root2 = new Node(1);
        tree.root2.left = new Node(3);
        tree.root2.right = new Node(2);
        tree.root2.right.left = new Node(4);
        tree.root2.right.right = new Node(5);
        tree.root2.left.right = new Node(6);
        tree.root2.right.right.left = new Node(8);
        tree.root2.right.right.right = new Node(7);

        if(checkIso(tree.root1, tree.root2)){
            System.out.println("They are Isomorphic");
        }else{
            System.out.println("Not Isomorphic");
        }

    }
}
