package GenericTrees;

import java.util.Collection;
import java.util.Collections;

public class MirrorOfTree {
    public static void main(String[] args) {
        int[] arr = {
    10, 
      20, 50, -1, 60, -1, -1,    // 20’s subtree
      30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1,   // 30’s subtree
      40, 100, -1, -1,           // 40’s subtree
    -1
   };
   Node root = GenericTree.constructTree(arr);
   GenericTree.display(root);
   mirror(root);
   System.out.println("--------------------------");
   GenericTree.display(root);

    }
    public static void mirror(Node root){
        for(Node childNode : root.children ){//faith that all child know mirror by own
            mirror(childNode);
        }
        Collections.reverse(root.children);//at last  reverse root's children with full nodes
    }
}
