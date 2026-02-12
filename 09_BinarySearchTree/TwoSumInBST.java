
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // Make the inoreder 
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(root,list);
         // find the two sum in the list by first and last pointer
            int left = 0,right = list.size()-1;
            while(left < right){
                int l = list.get(left).val;
                int r = list.get(right).val;
                 if( l+r > k){
                    right--;
                 }else if( l+r < k){
                    left++;
                 }else{
                    return true;
                    
                 }
            }
            return false;
    }
       public void inOrder(TreeNode root, ArrayList<TreeNode> res) {
        if( root == null ){
            return;
        }
            inOrder(root.left,res);
            res.add(root);
            inOrder(root.right,res);
       }
 
}