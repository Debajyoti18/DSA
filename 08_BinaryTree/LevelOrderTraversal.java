import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void printLevelOrderTraversal(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        // check if the tree is empty
        queue.add(root);
        while(queue.size() > 0){
            int count = queue.size();
            for(int i = 0 ; i < count ; i++ ){
                // remove the front node
                root = queue.remove();
                // print the node
                System.out.print(root.val + " ");
                // add the children of the node
                if(root.left != null){
                queue.add(root.left);
                }
                if(root.right != null){
                queue.add(root.right);
                }
            }
            // print a new line after each level
            System.out.println();
        }
    }
    
}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
       
        // code here
        ArrayList<ArrayList<Integer>> m = new ArrayList<>();
         if(root == null){
         return m;
         }
        Queue<Node> mainque = new ArrayDeque<>();
        mainque.add(root);
        while(mainque.size() > 0){
            int count = mainque.size();
            ArrayList<Integer> res= new ArrayList<>();
            for(int i =0;i< count;i++){
           Node curr = mainque.poll();
            res.add(curr.data);
            
            if(curr.left != null){
                mainque.add(curr.left);
            }
            if(curr.right != null){
                mainque.add(curr.right);
            }
            
           }
            m.add(res);
            
        }
       
        return m;
    }
}