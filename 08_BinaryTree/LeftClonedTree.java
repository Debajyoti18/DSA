public class LeftClonedTree {
    public static Node leftClonedTree(Node root) {
        if (root == null) {
            return null;
        }
        // Clone the left child
        Node lcr = leftClonedTree(root.left);
        Node rcr = leftClonedTree(root.right);
        // Create a new node that is a clone of the current node
        Node leftClone = new Node(root.data,lcr,rcr);
        // Set the left child of the current node to the cloned node
        leftClone.left = clonedNode.left;
        // Set the right child of the cloned node to the original right child
        root.right = rcr;

        return root;
    }
}
