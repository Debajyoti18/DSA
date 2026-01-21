
/**
 * Fix one number → use two pointers to find two numbers that sum to -nums[i], while skipping duplicates.
 * a+b+c=0 => a + b = -c
 * fix a, use two pointers to find b and c
 * Time Complexity: O(n^2)
 * 
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
       for(int i = 0 ; i < n-2 ; i++){
        //skip for duplicate numbers
        if(i > 0 && nums[i] == nums[i-1] ){
            continue;
        }
        int left = i + 1 , right = n - 1;
        while( left < right ){
            int sum = nums[i]+nums[left] +nums[right];
            if(sum == 0){
                list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left++;
                right--;
                //skip duplicates for left
            while(left < right && nums[left] == nums[left - 1]){
                left++;
            }
            //skip duplicates for right
            while(left < right && nums[right] == nums[right+1]){
                 right--;
              }
            }else if( sum < 0){
                left++;//increse sum
            }else{
                right--;//decrease sum
            }
            
        }
       }
       return list;
    }
}