

class Solution {
    public TreeNode getRightMostNodeOfLeft(TreeNode left,TreeNode curr){
        while( left.right != null && left.right != curr){
            left = left.right;
        }
        return left;
    }
    
    public void recoverTree(TreeNode root) {
        TreeNode curr = root,prev=null,a=null,b=null;
        while( curr != null ){
            TreeNode left = curr.left;
            if( left == null ){
                if( prev != null && prev.val > curr.val ){
                    if( a == null){
                        a = prev;
                    }
                    b = curr;
                }
                prev = curr;

                curr = curr.right;
            }else{
                TreeNode rmn = getRightMostNodeOfLeft(left,curr);
                if( rmn.right == null ){
                    //create thread
                    rmn.right = curr;
                    curr = curr.left;
                }else{
                    rmn.right = null;
                    if( prev != null && prev.val > curr.val ){
                        // If a is null then assign prev to a else assign curr to b
                        if( a == null){
                            a = prev;
                        }
                        // If a is already assigned then assign curr to b
                    b = curr;
                }
                prev = curr;
                    curr = curr.right;
                }

            }
        }
        if( a != null){
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }
}