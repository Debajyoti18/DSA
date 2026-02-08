
class Solution {
     int idx = 0;//tracks the index of preorder array
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int leftR = Integer.MIN_VALUE;
        int rightR = Integer.MAX_VALUE;
        return buildBstFromPreOrder(preorder,leftR,rightR);
    }
      public TreeNode buildBstFromPreOrder(int[] preorder,int leftR,int rightR) {
            if(idx >= preorder.length || preorder[idx] < leftR || preorder[idx] > rightR){
                return null;
            }
            TreeNode node = new TreeNode(preorder[idx++]);//create one one node
            node.left = buildBstFromPreOrder(preorder,leftR,node.val);//left range 
            node.right = buildBstFromPreOrder(preorder,node.val,rightR);//right range

            return node;
      }
}