package Practice.TwoPointer;
class Solution {
    //Time Complexity: O(N) where N is the number of elements in the array
    public int removeDuplicates(int[] nums) {
        int lastUniqueIndex = 0;
        for(int i = 1 ; i < nums.length ; i++){
            if( nums[i] != nums[lastUniqueIndex]){
            // unique element found so put it into next position
                   lastUniqueIndex++;
                   nums[lastUniqueIndex] = nums[i]; 
            }
        }
        return lastUniqueIndex +1;
    }
}
