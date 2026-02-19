/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if( root == null){
            return null;// not found
        }
        if( root.val < key){
            // key may be at right right
            root.right = deleteNode( root.right,key);
        }else if ( root.val > key){
            // at the left side 
            root.left = deleteNode(root.left,key);
        }else{
            // found
            //for 2 child, Get the max from left subtree and replace with the node 
            if( root.left != null && root.right != null){
                 int lmax = getMax(root.left);
                root.val = lmax;
                root.left = deleteNode( root.left,lmax);
                return root;
            }else if( root.left != null){
                return root.left;
            }else if( root.right != null){
                    return root.right;
            }else{// for leaf nodes
                return null;
            }
        }
        return root;
    }
    int getMax( TreeNode root){
        if( root.right != null){
            return getMax( root.right);
        }
        return root.val;
    }
}