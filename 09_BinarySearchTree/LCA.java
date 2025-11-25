/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
// Intuition: In BST, for any node, left subtree contains smaller values and right subtree contains larger values. 
//So, we can traverse the tree starting from the root. If both n1 and n2 are smaller than root, then LCA lies in left subtree. If both n1 and n2 are greater than root, then LCA lies in right subtree. Otherwise, root is LCA of n1 and n2.

class Solution {
    public Node LCA(Node root, Node n1, Node n2) {
        // code here
        if(n1.data < root.data && n2.data < root.data){ // both nodes are greater than the given nodes so  are in left subtree
            return LCA(root.left,n1,n2);
        }else if(n1.data > root.data && n2.data > root.data){// both nodes are smaller than the given nodes so  are in right subtree
            return LCA(root.right,n1,n2);
        }else{
            // it must be the LCA node
            return root;
        }
    }
}
