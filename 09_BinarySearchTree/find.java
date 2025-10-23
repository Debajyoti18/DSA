public class find {
    //time complexity will be O(logn)
    public boolean findNode(Node root , int data ){
        if( root == null){
            return false;
        }
        if( root.data > data){
            return findNode(root.left, data);
        }else if( root.data < data ){
                return findNode(root.right, data);
        }else{
            return true;
        }
        return false;
    }
}
