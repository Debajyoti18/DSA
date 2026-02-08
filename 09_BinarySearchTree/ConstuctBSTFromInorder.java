public static getBSTFromInOrder(TreeNode node, int si , int ei){
    if(si > ei) return null;
    // In Inorder traversal of BST, the middle element is the root of the tree
    int mid = (si + ei) / 2;
    TreeNode curr = new TreeNode(node.data);

    curr.left = getBSTFromInOrder(node, si, mid-1);
    curr.right = getBSTFromInOrder(node, mid+1, ei);
    return curr;
}
public static TreeNode constructBSTFromInorder(TreeNode node){
    int n = countNodes(node);
    return getBSTFromInOrder(node, 0, n-1);
}