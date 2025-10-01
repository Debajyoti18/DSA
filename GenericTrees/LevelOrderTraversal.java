package GenericTrees;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void levelOrderLineByLine(Node root){
        Queue<Node> mainQueue = new ArrayDeque<>();
        Queue<Node> childQueue = new ArrayDeque<>();
        mainQueue.add(root);
           while(mainQueue.size() > 0){
                root = mainQueue.remove();
                System.out.print(root.val + " ");
                for(Node ch : root.children){
                    childQueue.add(ch);
                }
             
            if(mainQueue.size() == 0){
                mainQueue = childQueue;
                childQueue = new ArrayDeque<>();
                System.out.println();
            }
        }
    }
}
