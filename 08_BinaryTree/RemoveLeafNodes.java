public class RemoveLeafNodes {
    public static Node removeLeafNodes(Node root,Node parent ) {
        // Base case: if the current node is null, return null
        if (root == null) {
            return null;
        }
        // If the current node is a leaf node, return null to remove it
        if (parent != null && root.left == null && root.right == null) {
            return null;
        }else if (parent == null && root.left == null && root.right == null) {
            return root;
        }
        // Recursively remove leaf nodes from the left and right subtrees
        root.left = removeLeafNodes(root.left,root);
        root.right = removeLeafNodes(root.right,root);

        

        // Return the current node if it's not a leaf node
        return root;
    }

    
}
