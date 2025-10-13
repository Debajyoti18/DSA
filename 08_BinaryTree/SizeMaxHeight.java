public class SizeMaxHeight {
    public static void main(String[] args) {
        
    }
    public static int size(Node node){
        if( node == null){
            return 0;
        }
        int lf = size(node.left);
        int rf = size(node.right);
        return lf + rf + 1;
    }
    public static int height(Node node){
        if( node == null){
            return -1;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) + 1;
    }
    public static int max(Node node){
        if( node == null){
            return -1;
        }
        int left = max(node.left);
        int right = max(node.right);
        int max = Math.max(node.data, Math.max(left, right));
        return max;
    }
}
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}