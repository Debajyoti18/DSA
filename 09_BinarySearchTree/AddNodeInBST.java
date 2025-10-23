public class AddNodeInBST {
    public static Node addNodeToBST( Node root , int data ){
        if( root == null){
            return new Node(data);
        }
        if( root.data > data ){
            // receive the left part of the node by calling left recursive
            root.left = addNodeToBST(root.left, data);
        }else if(root.data < data){
             // receive the right part of the node by calling right recursive
            root.right = addNodeToBST(root.right, data);
        }else{
            //do nothing
        }
        return root;
    }
}
