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
