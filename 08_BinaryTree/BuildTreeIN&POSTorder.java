public class BuildTreeIN&POSTorder {

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int iei = inorder.length;
        int pei = postorder.length;
        return buildTreeFromPostIn(inorder,0,iei-1,postorder,0,pei-1);
    }
    public TreeNode buildTreeFromPostIn(int[] inorder,int isi,int iei, int[] postorder,int psi,int pei){
        if(isi > iei){
            return null;
        }
        int index = isi;
        //root at the last index of the post order  traversal
        while(inorder[index] != postorder[pei]){
            index++;
        }
        int c = index - isi;
        TreeNode root = new TreeNode(postorder[pei]);
      root.left = buildTreeFromPostIn(inorder,isi,index-1,postorder,psi,psi+c-1);
       root.right = buildTreeFromPostIn(inorder,index+1 // bcx index is at root
        iei,postorder,psi+c,pei-1); 
       return root;
        
    }
}
}
