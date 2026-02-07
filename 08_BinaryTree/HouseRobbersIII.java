
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
 class vPair{
    int include = 0;// node include
    int exclude = 0;//node exlude
    vPair(){}
    vPair(int x , int y){
        this.include = x;
        this.exclude = y;
    }
 }
class Solution {
    public static vPair houseRobber(TreeNode root){
        TreeNode node = root;
        vPair pair = new vPair();
        if( node == null){
            return new vPair();
        }
        vPair left = houseRobber(node.left);
        vPair right = houseRobber(node.right);
        // if parent is robbed then child are not rubbed
        pair.include = left.exclude + right.exclude + node.val;
        //if parent is not robbed then child can be robbed or not robbed both case we will take max
        pair.exclude = Math.max(left.include,left.exclude)+Math.max(right.include,right.exclude);
        return pair;
    }

    public int rob(TreeNode root) {
        
        vPair ans = houseRobber(root);
        return Math.max(ans.include,ans.exclude);
    }
}