
 
import java.util.*;

class ConstructBT {
    
  public class Node {
     int val;
     Node left;
     Node right;
    Node() {}
     Node(int val) { this.val = val; }
     Node(int val, Node left, Node right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public Node buildTree(Integer[] preorder) {
        if (preorder == null || preorder.length == 0 || preorder[0] == null) 
            return null;

        Node root = new Node(preorder[0]);
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        int index = 1;

        while (!stack.isEmpty() && index < preorder.length) {
            Pair top = stack.peek();

            if (top.state == 1) {
                // process left child
                if (preorder[index] != null) {
                    Node left = new Node(preorder[index]);
                    top.node.left = left;
                    stack.push(new Pair(left, 1));
                }
                top.state++;
                index++;
            } 
            else if (top.state == 2) {
                // process right child
                if (index < preorder.length && preorder[index] != null) {
                    Node right = new Node(preorder[index]);
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
