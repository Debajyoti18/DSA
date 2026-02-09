// User function Template for Java

/*
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
      int idx =  0; // Track the array 
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        // code here
        
        
        return buildBSTFromPre(pre,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
     public Node buildBSTFromPre(int pre[], int leftRange , int rightRange){
         //Out of bound 
         if( idx >= pre.length || leftRange > pre[idx] || rightRange < pre[idx]){
             return null;
         }
         
         Node root = new Node(pre[idx++]);
         root.left  = buildBSTFromPre(pre,leftRange,root.data);
         root.right  = buildBSTFromPre(pre,root.data,rightRange);
         return root;
     }
}