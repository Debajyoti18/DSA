/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Solution {
    static class vPair{
        int hl;Node node;
        vPair(int hl,Node node){
            this.node=node;
            this.hl=hl;
        }
    }
    public void getBoundary(Node node,int hl,int[] minMax){
        if( node == null){
            return ;
        }
        
        minMax[0] = Math.min(minMax[0],hl);
        minMax[1] = Math.max(minMax[1],hl);
        
        getBoundary(node.left, hl-1 ,minMax);
        getBoundary(node.right, hl+1 ,minMax);
        
    }
    public ArrayList<Integer> verticalSum(Node root) {
        // add your code here
        ArrayList<Integer> res = new ArrayList<>();
        if( root == null){
            return res;
        }
        int[] minMax = new int[2];
        getBoundary(root,0,minMax);
        int width = minMax[1] -minMax[0]+1;
        for( int i = 0;i< width;i++){
            res.add(0);
        }
        
        LinkedList<vPair> que = new LinkedList<>();
        que.addLast(new vPair(-minMax[0],root));
        while(!que.isEmpty()){
            int size = que.size();
            while( size-- > 0){
                vPair rm = que.removeFirst();
                Node node = rm.node;
                int hl = rm.hl;
                res.set(hl,res.get(hl)+node.data);
                if(node.left!=null){
                    que.add(new vPair(hl-1,node.left));
                }
                if(node.right!=null){
                    que.add(new vPair(hl+1,node.right));
                }
            }
        }
        return res;
    }
}