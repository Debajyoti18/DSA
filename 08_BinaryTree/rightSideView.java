
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
      
        if(root == null ){
          return res;
      }
     
      LinkedList<TreeNode> que = new LinkedList<>();
      que.addLast(root);
      // in level order
      while( que.size() != 0){
          int size = que.size();
          // Add the last node of each level i.e the left view
          // first push right child and then left child so that we can get the right view
          res.add(que.getFirst().val);
          
          while( size--  > 0){
              TreeNode rm = que.removeFirst();
              if(rm.right != null) que.addLast(rm.right);
              if(rm.left != null) que.addLast(rm.left);
          }
      }
      return res; 
    }
}