class Solution {
    public int waysToSplitArray(int[] nums) {
        int count=0;long sum=0;
        for(int n :nums){
            sum+=n;
        }
        long l=0;
        for(int i=0;i<nums.length-1;i++){
            l+= nums[i];
            sum-= nums[i];
            if(l>=sum){
                count++;
            }
        }
        return count;
    }
}