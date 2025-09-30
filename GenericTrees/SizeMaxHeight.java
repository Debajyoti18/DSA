
 package GenericTrees;

class SizeMaxHeight {
public static int getSize(Node root){
    // Base Case for recursion is implicitly handled: if root is null or 
    // when a leaf node is hit and the loop is skipped.
    int size = 0; 
    
    // 1. Recursive step (Faith): Calculate size of all subtrees.
    for(Node child : root.childerns){ // Note: uses 'childerns'
       int childsize = getSize(child); 
       size += childsize;
    }
    
    // 2. Meeting Expectation: Add 1 for the current node.
    size += 1; 
    return size;
}
    
}
