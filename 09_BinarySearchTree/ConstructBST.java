class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
public class ConstructBST {
    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        Node root = buildBSTFromInorder(inorder, 0, inorder.length - 1);
        DisplayBT(root);

    }
    public static Node buildBSTFromInorder(int[] inorder, int start , int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        Node root = new Node(inorder[mid]);
        // recursively build left and right subtrees
        root.left = buildBSTFromInorder(inorder, start, mid - 1);
        root.right = buildBSTFromInorder(inorder, mid + 1, end);
        return root;
    }
     public static void DisplayBT(Node root){
        if( root == null){
            return;
    }
    String res = "";
    res +=  root.left == null ? "." : root.left.data + " ";
    res += "<-" + root.data + "->";
    res += root.right == null ? "." : root.right.data + " ";
    System.out.println(res);
    DisplayBT(root.left);
    DisplayBT(root.right);
   }
}
