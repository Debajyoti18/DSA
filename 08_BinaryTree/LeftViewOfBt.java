/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> leftView(Node root) {
       
        // code here
      ArrayList<Integer> res = new ArrayList<>();
      
        if(root == null ){
          return res;
      }
     
      LinkedList<Node> que = new LinkedList<>();
      que.addLast(root);
      // in level order
      while( que.size() != 0){
          int size = que.size();
          // Add the first node of each level i.e the left view
          res.add(que.getFirst().data);
          
          while( size--  > 0){
              Node rm = que.removeFirst();
              if(rm.left != null) que.addLast(rm.left);
              if(rm.right != null) que.addLast(rm.right);
          }
      }
      return res;
      
    }
}