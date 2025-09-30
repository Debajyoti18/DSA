package GenericTrees;

import java.util.ArrayList;
import java.util.Stack;

class Node{
    int val;
    ArrayList<Node> childerns;
    public Node(int x){
        this.val = x;
        this.childerns = new ArrayList<>();
    }
    public Node(){
        this.val = 0;
         this.childerns = new ArrayList<>();
    }
}

public class GenericTree {
    public static void main(String[] args) {
         int[] arr = {10, 20, -1, 30, 50, -1, -1, 40, -1, -1};
        
        Node root = constructTree(arr);
        
        System.out.println("Tree Display:");
        display(root);
        int x = SizeMaxHeight.getSize(root);
        System.out.println("Tree Size:" + x);
    }
    private static void display(Node root) {
        if( root == null){
            return;
        }
        String str = root.val + "->";
        for(Node child : root.childerns){
               str += child.val +",";
        }
        str += ".";
        System.out.println(str);
        for(Node child : root.childerns){
            display(child);
        }
    }
    public static Node constructTree(int[]  arr){
            if( arr.length == 0 || arr == null){
                return null;
            }
                Node root = null;
                Stack<Node> stack = new Stack<>();
                for(int i = 0; i < arr.length;i++){
                    if( arr[i] != -1){
                    Node temp = new Node(arr[i]);
                    if(stack.isEmpty()){
                        root = temp;
                    }else{
                        Node parent = stack.peek();
                        parent.childerns.add(temp);
                    }
                    stack.push(temp);
                }else{
                    stack.pop();
                }
            }
            return root;
    }
}
