class Solution {
    public void sortColors(int[] nums) {
        int low = 0 , mid = 0 , high = nums.length -1;
        for(int i = 0 ; i < nums.length ; i++){
            //three way partitioning
            if(nums[mid] == 0){
                swap(nums,low,mid);
                low++;mid++;
            }else if( nums[mid] == 1){
                mid++;
            }else{
                 swap(nums,mid,high);
                 high--;
            }
        }
    }
    public void swap(int[] nums,int s,int e){
        int t = nums[s];
        nums[s]=nums[e];
        nums[e]=t;
    }
}