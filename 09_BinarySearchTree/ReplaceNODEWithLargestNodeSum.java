}
class Solution {
     int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        replace(root);
        return root;
    }
    void replace(TreeNode root){
        if( root == null){
            return ;
        }
        replace(root.right); // MOve towards right to get larger nodes sum first
        sum += root.val;
        root.val = sum;
        replace(root.left);
    }
}