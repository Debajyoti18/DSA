package GenericTrees;

import java.util.Stack;

public class PredecessorAndSuccessor {
            static Node predecessorNode , successorNode ;
            static int state = 0;
    public static void PredecessorAndSuccessor(Node root,int data){
        if(state == 0){
            if(root.val == data){
                state++;
            }else{
                predecessorNode = root;
            }
        }else if(state == 1){
            state++;
            successorNode = root;
        }
        for(Node chNode : root.children){
            PredecessorAndSuccessor(chNode,data);
        }
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
                PredecessorAndSuccessor(root,90 );
                System.out.println(predecessorNode.val +"\n"+successorNode.val);
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
                        parent.children.add(temp);
                    }
                    stack.push(temp);
                }else{
                    stack.pop();
                }
            }
            return root;
    }
    
}
