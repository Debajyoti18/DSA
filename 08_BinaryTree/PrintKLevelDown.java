public class PrintKLevelDown {
   // Intuition : To print all nodes at a given level k, we can use a recursive approach.
    public static void printKLevelDown(Node root, int k) {
        // base case: if the node is null or k is negative, return
        if(root == null || k < 0){
            return;
        }
        // if k is 0, print the current node's value
        if(k == 0){
            System.out.print(root.val + " ");
            return;
        }
        // recursively call the function for left and right children with k decremented by 1
        printKLevelDown(root.left, k-1);
        printKLevelDown(root.right, k-1);
    }
}
