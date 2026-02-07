/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG {
    Node buildTree(int inord[], int level[], int n) {
        // your code here
        return build(inord,0,n-1,level);
    }
    Node build(int inord[],int isi,int iei, int level[]) {
        if( isi > iei) return null;
        int idx = isi;
        Node curr = new Node(level[0]);//First node of level order is the root always 
        //find the root in the inorder and find the count of left subtree nodes
        while(level[0] != inord[idx]){
            idx++;
        }
        int c = idx - isi;
        //Put the left subtree in set first
        HashSet<Integer> hash = new HashSet<>();
        for(int i = isi ; i < idx ; i++ ) hash.add(inord[i]);
        
        int[] leftLevel = new int[idx-isi];
        int[] rightLevel = new int[iei - idx];
        int ls =0,rs =0;
        //As root is already used start the loop from 1 
        for(int i = 1;i < level.length ; i++){
            // set store the left subtree nodes so if the level order node is
            //  present in set then it is the left child else right child
            if(hash.size() > 0 && hash.contains(level[i])){
                leftLevel[ls++] = level[i];
                hash.remove(level[i]);
            }else{
                rightLevel[rs++] = level[i];
            }
        }
        curr.left = build(inord,isi,idx-1,leftLevel);
        curr.right = build(inord,idx+1,iei,rightLevel);
        return curr;
    }
}