
class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {

        if( root == null ) return true;
    
        if(!isValidBST(root.left)) {
            return false;
        }
        // Prev store the root node that checks the BST condition
        if( prev != null && prev.val > root.val){
                return false;
            }
         prev = root;// reset prev
        if(!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}
/**
 //Use Of Morris Traversal O(1) space
 */
class Solution {
   
    public static TreeNode getRightmostNode(TreeNode left,TreeNode curr){
        while( left.right != null && left.right != curr){
            left = left.right;
        }
        return left;
    }
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root; 
        TreeNode prev = null;
        while( curr != null){
            TreeNode left = curr.left;
            if( left == null){
                if(prev != null && prev.val >= curr.val){
                    return false;
                }
                prev =curr;
                curr = curr.right;
            }else{
                TreeNode rmn = getRightmostNode(left,curr);
                if( rmn.right == null){
                    //Make the thread
                    rmn.right = curr;
                    curr = curr.left;
                }else{
                     rmn.right = null;
                     //After breaking the thread check the BST condition
                 if(prev != null && prev.val >= curr.val){
                    return false;
                }
               
                prev = curr;
                curr = curr.right;
                }
            }
        }
        return true;
    }
}