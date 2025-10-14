import java.util.Stack;

public class IterativePrePostInOrder {
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        iterativePrePostInOrder(root);
    }
    public static void iterativePrePostInOrder(Node root){
        Stack<Pair> stack = new Stack<>();
        Pair rpair = new Pair(root, 1);
        stack.push(rpair);
        String pre = "";
        String post = "";
        String in = ""; 
        while(stack.size()> 0){
            Pair top = stack.peek();
            if(top.node.state == 1){
                    pre += root.data + " ";
                    if(root.node.left != null){
                        stack.push(new Pair(root.left, 1));
                    }
                top.state++;

            }else if (top.node.state == 2){
                     in += root.data + " ";
                    if(root.right != null){
                        stack.push(new Pair(root.right, 1));
                    }
                top.state++;
            }else{
                post += root.data + " ";
                top.state++;
            }
        }

    }
}
