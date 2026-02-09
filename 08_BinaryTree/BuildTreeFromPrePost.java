
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int iei = preorder.length;
        int pei = postorder.length;
        return buildTreeFromPostPre(preorder,0,iei-1,postorder,0,pei-1);
    }
    public TreeNode buildTreeFromPostPre(int[] preorder,int psi,int pei, int[] postorder,int posi,int poei){

       if(psi > pei) return null;
        TreeNode root = new TreeNode(preorder[psi]);

        if(psi == pei){ // ONLY ONE NODE
            return root;
        }
        int index = posi;
        while(postorder[index] != preorder[psi+1] //as root is already build

        ){
            index++;
        }
        int c = index - posi +1;
       root.left = buildTreeFromPostPre(preorder,psi+1,psi+c,postorder,posi,index);
       root.right = buildTreeFromPostPre(preorder,psi+c+1,pei,postorder,index+1,pei-1); 
       return root;
        
    }
}