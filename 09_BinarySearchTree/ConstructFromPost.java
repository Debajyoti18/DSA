/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG {
    static int idx = 0;
    public static Node constructTree(int post[], int n) {
        // Add your code here.
        int leftR = Integer.MIN_VALUE;
        int rightR = Integer.MAX_VALUE;
        idx = n-1;// traverse from end of the post as in postorder root is at last
        return buildBstFromPostOrder(post,leftR,rightR);
        
    }
    public static Node buildBstFromPostOrder(int[] post,int leftR,int rightR) {
            if(idx < 0|| post[idx] < leftR || post[idx] > rightR){
                return null;
            }
            Node node = new Node(post[idx--]);//create one one node
           // Go to right then left n backtrack
            node.right = buildBstFromPostOrder(post,node.data,rightR);//right range
            node.left = buildBstFromPostOrder(post,leftR,node.data);//left range 
            return node;
      }
}