package GenericTrees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {
    public static void levelOrderLineByLine1(Node root){
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
     public static void levelOrderLineByLineZigZag(Node root){
        Stack<Node> main = new Stack<>();
        Stack<Node> child = new Stack<>();
        main.push(root);
        int level = 1;
           while(main.size() > 0){
                root = main.pop();
                System.out.print(root.val + " ");
                if(level % 2 == 1){
                    for(int i =0;i<root.children.size();i++){
                       child.push(root.children.get(i)); //for odd level push from l to r
                    }
                    
                }else{
                    for(int i = root.children.size()-1 ; i >=0;i--){
                        child.push(root.children.get(i));//for even level push from r to l
                    }
                }
                
                if(main.size() == 0){
                main = child;
                child = new Stack<>();
                 level++;
                System.out.println();
            }
               
        }
        
    }
    
}
