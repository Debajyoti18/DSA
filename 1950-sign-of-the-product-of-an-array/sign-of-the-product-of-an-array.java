class Solution {
    public int arraySign(int[] nums) {
        int x=0;
        for(int n :nums){
                if(n==0){
                 return 0;
                }
                if(n<0){
                    x++;
                }
                
        }
       return x%2==0?1:-1;
    }
   
}