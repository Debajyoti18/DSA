package GenericTrees;

import java.util.ArrayList;
import java.util.Stack;

class Node{
    int val;
    ArrayList<Node> children;
    public Node(int x){
        this.val = x;
        this.children = new ArrayList<>();
    }
    public Node(){
        this.val = 0;
         this.children = new ArrayList<>();
    }
}

public class MultiSolver {
    //static heap variables
    static int size;
    static int maximum , minimum ,height;
    public static Node constructTree(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        Node root = null;
        Stack<Node> stack = new Stack<>();
            for(int i = 0; i < arr.length ; i++){
                if(arr[i] != -1){
                        Node child = new Node(arr[i]);
                        if(stack.isEmpty()){
                            root = child;
                        }else{
                           Node parentNode = stack.peek();
                           parentNode.children.add(child); 
                        }
                        stack.push(child);
                }else{
                    stack.pop();
                }
            }
            return root;
    }
    private static int getSize(Node root){
        int size = 0;
        for(Node chNode : root.children){
            int childsize = getSize(chNode);
            size++;
        }
        return 1+size;
    }
    public static void main(String[] args) {
            int[] arr = {
    10, 
      20, 50, -1, 60, -1, -1,    // 20’s subtree
      30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1,   // 30’s subtree
      40, 100, -1, -1,           // 40’s subtree
    -1
};
     Node root = constructTree(arr);

        size = 0;
        maximum = Integer.MIN_VALUE;
        minimum = Integer.MAX_VALUE;
        height =  0;
        multiSolver(root, 0);
        System.out.println(size + "\n" + maximum +"\n" +minimum +"\n"+height);


        


    }
    public static void multiSolver(Node root , int depth){
        size++;
        maximum = Math.max(maximum, root.val);
        minimum = Math.min(minimum, root.val);
        height = Math.max(height,depth);
        for(Node child : root.children){
            multiSolver(child, depth+1);
        }
    }
}
