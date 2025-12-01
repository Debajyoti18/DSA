/**
 * LeetCode Problem 42: Trapping Rain Water
 * Intuition:
 * - Use two pointers to traverse the height array from both ends.
 * - Maintain leftmax and rightmax to keep track of the maximum heights encountered from both sides.
 * - Move the pointer with the smaller height, as the water trapped is limited by the shorter side.
 * - Calculate trapped water at each step and accumulate it.
 * Time Complexity: O(n)
 */


class Solution {
    public int trap(int[] height) {
        int left = 0,right=height.length-1,leftmax=0,rightmax=0,water=0;
        while(left < right){
            //move the pointer with smaller height because the water trapped in that side is limited by the smaller height
            if(height[left] < height[right]){ // if right is greater then process left
                //if current height is less than leftmax then water can be trapped
                if(height[left] < leftmax){
                    water += leftmax-height[left];
                }else{
                    //update leftmax with current height
                    leftmax = height[left];
                }
                left++;
            }else{
                //left is greater than or equal to right
                //if current height is less than rightmax then water can be trapped
                if(height[right] < rightmax){
                      water += rightmax-height[right];
                }else{
                    //update rightmax with current height
                    rightmax = height[right];
                }
                right--;
            }
        }
        return water;
    }
}