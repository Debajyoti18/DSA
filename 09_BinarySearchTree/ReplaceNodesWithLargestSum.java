/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    static int sum ;
    public static void transformTree(Node root) {
        // why sum = 0 her because we have to reset sum for every function call
        sum =0;
        replace(root);
    }
    public static void replace(Node node){
        if( node == null){
            return ;
        }
        // Recur for right subtree
        replace(node.right);
        // store the original data
        int od = node.data;
        // replace with sum
        node.data = sum;
        // update sum
        sum += od;
        // Recur for left subtree
        replace(node.left);
        
    }
}