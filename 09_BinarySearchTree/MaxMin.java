package 09_BinarySearchTree;

// Size  , Height and diameter are depends upon the structure of the tree so it will be same for BST as well as Binary Tree
// But Max and Min are depends upon the data  of BST
public class MaxMin {
    public static int maxInBst(Node root){
        //Maximum value is must present at the rightmost node of BST
        if(root.right != null){
            return maxInBst(root.right);
        }
        else{
            return root.data;
        }
    }
      public static int minInBst(Node root){
        //Minimum value is must present at the leftmost node of BST
        if(root.left != null){
            return maxInBst(root.left);
        }
        else{
            return root.data;
        }
    }
}
