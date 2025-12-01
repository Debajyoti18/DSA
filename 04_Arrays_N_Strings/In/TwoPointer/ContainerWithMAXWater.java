class Solution {
    public int maxArea(int[] height) {
        int left = 0 , right = height.length - 1 , maxi = 0;
        while( left < right){
     int area = Math.min(height[left],height[right]) * (right - left);
            maxi = Math.max(maxi,area);
            // move the pointer pointing to the smaller height
            //because the width is decreasing as we move pointers towards each other
            //so to maximize area we need to find a taller line
            //always move the smaller height pointer
             if(height[left] < height[right] ){
                left++;
            }else{
                 right--;
            }
            
        }
        return maxi;
    }
}
//dry run : 1,8,6,2,5,4,8,3,7 ans = 49