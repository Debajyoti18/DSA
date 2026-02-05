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
     int cameras = 0;
    private int minCameraBT(TreeNode root){
        if( root == null){
            return 1;// take as already have 
        }
        int leftCh = minCameraBT(root.left);
        int rightCh = minCameraBT(root.right);

        if(leftCh == -1 || rightCh == -1){
            //Both are not covered so place camera
            cameras++;
            return 0;
        }
         if(leftCh == 0 || rightCh == 0){
            //already have cameras own 
            return 1;
        }
        return -1;//parent whode both child are covered and have no cameras inthem
    }
    public int minCameraCover(TreeNode root) {
        if( minCameraBT(root) == -1){
            //need cameras
            cameras++;
        }
        return cameras;
    }
}