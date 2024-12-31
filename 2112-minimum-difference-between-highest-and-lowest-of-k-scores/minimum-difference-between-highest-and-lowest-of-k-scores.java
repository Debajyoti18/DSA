class Solution {
    public int minimumDifference(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        if(k==1){
            return 0;
        }
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-k;i++){
            int dif=nums[i+k-1]-nums[i];
            min=Math.min(dif,min);
        }
        return min;
    }
}