package GenericTrees;

import java.util.ArrayDeque;
import java.util.Queue;

public class TraversalPrePost {
    public static void traversePrePost(Node node ){
        System.out.println("Pre Node " + node.val);
        for(Node child :node.children){
            System.out.println("Edge Pre "+node.val+"-->"+child.val);
            traversePrePost(child);
            System.out.println("Edge Post "+node.val+"-->"+child.val);
        }
         System.out.println("Post Node " + node.val);
    }
    //Level Order Traversal
    public static void levelOrderTraversal(Node node){
        if(node == null) return;
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        //rpa-remove print then add child
        while(q.size()>0){
            node = q.remove();
            System.out.print(node.val+ " ");
            for(Node child : node.children){
                q.add(child);
            }
           
        }
        System.out.println();
    }
}
