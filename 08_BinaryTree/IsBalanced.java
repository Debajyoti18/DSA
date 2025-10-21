/*
class Node {
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    
    public boolean isBalanced(Node root) {
        // if tree is balanced then return true else false
        return isBal(root) != -1;
      
        
    }
    public int isBal(Node node ){
        if( node == null){
            return 0;
        }
        // Cheack for left and right subtree
        int lh = isBal(node.left);
        int rh = isBal(node.right);
        // If any of subtree is not balanced then return -1
        if( lh == -1 || rh == -1){
            return -1;
        }
        // Check for current node
        int gap = Math.abs(lh - rh);
        // If gap is more than 1 then not balanced
        if(gap > 1){
          return -1;
        }
        // Return height of current node
        int height = Math.max(lh,rh);
        return height +1;
    }
        
    }