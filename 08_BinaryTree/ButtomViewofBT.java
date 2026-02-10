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

class Solution {
    static class Pair{
        Node node ;
        int hl ;
        Pair(Node node,int hl){
            this.node = node;
            this.hl = hl;
        }
    }
    public void getWidth(Node root,int hl,int[] minMax){
        if( root == null ){
            return;
        }
        minMax[0] = Math.min(minMax[0],hl);
        minMax[1] = Math.min(minMax[1],hl);
        
        getWidth(root.left,hl-1,minMax);
        getWidth(root.right,hl+1,minMax);
    }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Pair> que = new LinkedList<>();
        int[] minMax = new int[2];
        getWidth(root,0,minMax);
        
        int c = minMax[1] -minMax[0]+1;
        
        for(int i = 0;i< c;i++){
            res.add(0);
        }
        que.add(new Pair(root,-minMax[0]));
        while(!que.isEmpty()){
            Pair p = que.poll();
            int hl = p.hl;
            Node node = p.node;
           
            res.set(hl,node.data);
            
            if(node.left != null){
               que.offer(new Pair(node.left,hl-1)); 
            }
            if(node.right != null){
               que.offer(new Pair(node.right,hl+1)); 
            }
        }
        return res;
        
    }
}