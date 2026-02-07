
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