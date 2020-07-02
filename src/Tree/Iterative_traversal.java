package Tree;

import java.util.Stack;

public class Iterative_traversal {
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
    Iterative_traversal(){
        root = null;
    }
    static void left(Node root, int left){
        root.left = new Node(left);
    }
    static void right(Node root, int right)
    {
        root.right = new Node(right);
    }

    static void preorder(Node root){
        if(root==null)
            return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        System.out.println("Preorder Traversal:");
        while (!st.isEmpty()){
            Node temp = st.pop();
            System.out.print(temp.val);
            if(temp.right!=null){
                st.push(temp.right);
            }
            if(temp.left!=null){
                st.push(temp.left);
            }
        }
    }

    static void inorder(Node root){
        if(root==null)
            return;
        Node temp = root;
        Stack<Node> st = new Stack<>();
        while(!st.isEmpty()||temp!=null){
            if(temp!=null){
                st.push(temp);
                temp = temp.left;
            }else{
                temp = st.pop();
                System.out.print(temp.val);
                temp = temp.right;
            }
        }
    }

    static void postorder_2stacks(Node root){
        if(root==null)
            return;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);

            if(root.left!=null)
                st1.push(root.left);
            if(root.right!=null)
                st1.push(root.right);
        }
        while(!st2.isEmpty()){
            System.out.print(st2.pop().val);
        }
    }
    static void postorder_1stack(Node root){
        if(root==null)
            return;
        Node current = root;
        Stack<Node> st = new Stack<>();
        while(current!=null||!st.isEmpty()){
            if(current!=null){
                st.push(current);
                current = current.left;
            }else{
                Node temp = st.peek();
                if(temp.right!=null){
                    current = temp.right;
                }else{
                    temp = st.pop();
                    System.out.print(temp.val);
                    while(!st.isEmpty()&&temp==st.peek().right){
                        temp = st.pop();
                        System.out.print(temp.val);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Iterative_traversal it = new Iterative_traversal();
        it.root = new Node(1);
        left(it.root, 2);
        right(it.root, 3);
        left(it.root.left, 4);
        right(it.root.left, 5);
        left(it.root.right, 6);
        right(it.root.right, 7);

        preorder(it.root);
        System.out.println();

        inorder(it.root);
        System.out.println();

        postorder_2stacks(it.root);
        System.out.println();

        postorder_1stack(it.root);
    }
}
