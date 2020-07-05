package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Print_Diagonal {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left=right=null;
        }
    }

    public static void main(String args[]){
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp==null){
                queue.add(null);
                temp = queue.poll();
                if(temp==null){
                    break;
                }
            }
            while(temp!=null){
                System.out.print(temp.val+" ");
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                temp = temp.right;
            }
            System.out.println();
        }
    }
}
