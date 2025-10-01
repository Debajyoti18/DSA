
 package GenericTrees;

class SizeMaxHeight {
public static int getSize(Node root){
    // Base Case for recursion is implicitly handled: if root is null or 
    // when a leaf node is hit and the loop is skipped.
    int size = 0; 
    
    // 1. Recursive step (Faith): Calculate size of all subtrees.
    for(Node child : root.children){ // Note: uses 'childerns'
       int childsize = getSize(child); 
       size += childsize;
    }
    
    // 2. Meeting Expectation: Add 1 for the current node.
    size += 1; 
    return size;
}
public static int getMaximum(Node node){
    int max = Integer.MIN_VALUE;
    for(Node chilNode : node.children){
        int x = getMaximum(chilNode);
        max = Math.max(x, max);
    }
     max = Math.max(node.val, max);
     return max;
}
public static int getHeightEdges(Node root){
    int height = -1 ;//for single node height is 0
 for(Node chilNode : root.children){
        int x = getHeightEdges(chilNode);
        height = Math.max(x, height);
    }
    return height +1;

}
    
}
