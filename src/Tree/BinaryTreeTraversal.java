package Tree;


class BinaryTree{
    static class Node{
        int key;
        Node left,right;
        public Node(int t){
            key=t;
            left=null;
            right=null;
        }
    }
    Node root;
    BinaryTree(){
        root=null;
    }
    void preorder(Node node){
        if(node==null)
            return;
        System.out.print(node.key);
        preorder(node.left);
        preorder(node.right);
    }
    void inorder(Node node){
        if(node==null)
            return;
        inorder(node.left);
        System.out.print(node.key);
        inorder(node.right);
    }
    void postorder(Node node){
        if(node==null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.key);
    }
    public static void main(String[] args){
        BinaryTree tree=new BinaryTree();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);

        System.out.println("Preorder traversal:");
        tree.preorder(tree.root);
        System.out.println("");

        System.out.println("Postorder traversal:");
        tree.postorder(tree.root);
        System.out.println("");

        System.out.println("Inorder traversal:");
        tree.inorder(tree.root);
    }
}