package Tree;

public class Sum_Longest_path_RootToLeaf {
    static class Node{
        int val;
        Node left, right;
        Node(int v){
            val = v;
            left=right=null;
        }
    }
    static int maxLen = 0, maxSum = 0;

    static void sumPath(Node root, int curLen, int curSum){
        if(root==null)
            return;
        curSum += root.val;
        if(root.left==null&&root.right==null){
            if(curLen>maxLen){
                maxLen = curLen;
                maxSum = curSum;
                return;
            }
            if(curLen==maxLen){
                if(maxSum<curSum){
                    maxSum = curSum;
                }
                return;
            }
        }
        sumPath(root.left, curLen+1, curSum);
        sumPath(root.right, curLen+1, curSum);
    }

    public static void main(String[] args){
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.left.left = new Node(7);
            root.left.right = new Node(5);
            root.left.right.left = new Node(8);
            root.right.left = new Node(6);

            sumPath(root, 1, 0);
            System.out.println("Max Length: "+maxLen);
            System.out.println("Sum: "+maxSum);
    }
}
