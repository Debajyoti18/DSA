

public class DisplayBT {
    public void DisplayBT(Node root){
        if( root == null){
            return;
    }
    String res = "";
    res +=  root.left == null ? "." : root.left.val + " ";
    res += "<-" + root.val + "->";
    res += root.right == null ? "." : root.right.val + " ";
    System.out.println(res);
    DisplayBT(root.left);
    DisplayBT(root.right);
   }
}
