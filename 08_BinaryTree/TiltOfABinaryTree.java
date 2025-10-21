/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
// Tilt of Binary Tree : Tilt of a tree node is defined as the absolute difference between 
//sum of all left subtree node values and sum of all right subtree node values. Tilt of whole tree is defined as the sum of all nodes tilt.
class Solution {
    static int tilt = 0;
    public int tiltTree(Node root) {
        // reset tilt for each call
        tilt = 0;
        find(root);
        return tilt;
        
    }
    public int find(Node root){
        if( root == null){
            return 0;
        }
        int leftsum = find(root.left);
        int rightsum = find(root.right);
        // calculate tilt for current node
        int localtilt = Math.abs(leftsum - rightsum);
        // add to global tilt
        tilt += localtilt;
        // return sum of subtree
        return leftsum+rightsum+root.data;
    }
}