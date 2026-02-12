
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
       return hasPathSum_(root,targetSum);
    }
     public boolean hasPathSum_(TreeNode root, int targetSum){
        if( root == null ){
            return false;
        }
        // For leaf node check if the sum is equal to target sum or not
        if( root.left == null && root.right == null){
            return root.val - targetSum == 0;
        }
       return hasPathSum_(root.left,targetSum-root.val) ||
       hasPathSum_(root.right,targetSum-root.val);
     }
}