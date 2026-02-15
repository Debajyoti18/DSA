
class Solution {
    void findPath(TreeNode root,String path,List<String> res){
        if( root == null){
            return;
        }
        if(path.length() == 0){
            path = ""+ root.val;// convert the int to string
        }else{
            path = path +"->"+ root.val;
        }
        if(root.left == null && root.right == null){
            res.add(path); //at each leaf 
            return;
        }
        findPath(root.left,path,res);
        findPath(root.right,path,res);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        findPath(root,"",res);
        return res;
    }
}