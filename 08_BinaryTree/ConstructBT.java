
 
import java.util.*;

class ConstructBT {
    
  public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
    static class Pair {
        TreeNode node;
        int state;

        Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public TreeNode buildTree(Integer[] preorder) {
        if (preorder == null || preorder.length == 0 || preorder[0] == null) 
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        int index = 1;

        while (!stack.isEmpty() && index < preorder.length) {
            Pair top = stack.peek();

            if (top.state == 1) {
                // process left child
                if (preorder[index] != null) {
                    TreeNode left = new TreeNode(preorder[index]);
                    top.node.left = left;
                    stack.push(new Pair(left, 1));
                }
                top.state++;
                index++;
            } 
            else if (top.state == 2) {
                // process right child
                if (index < preorder.length && preorder[index] != null) {
                    TreeNode right = new TreeNode(preorder[index]);
                    top.node.right = right;
                    stack.push(new Pair(right, 1));
                }
                top.state++;
                index++;
            } 
            else {
                // both children processed
                stack.pop();
            }
        }

        return root;
    }
}
