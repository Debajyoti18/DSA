package 04_Arrays_N_Strings.In;

public class ProductOfArrayExceptSelf {
    /*
    Brute Force — O(n²)
    Idea
         For each index i, multiply every element except i.
            Example
            nums = [1,2,3,4]
        For index 2 → skip nums[2] → product = 1×2×4 = 8
    Intuition
        Just brute multiply everything except self.
     */
}
//  OPTIMAL :Time O(n) space O(1)
/*   1.Fill prefix array with prefix products
     2.Fill suffix array with suffix products
     3.Multiply prefix & suffix products into it ans store it using output array
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        int[] prefix=new int[nums.length]; // find the products of prefixes of an element 
        int[] suffix=new int[nums.length];//find the products of suffixes
                
                prefix[0] = 1;
                suffix[nums.length-1] = 1;
                for(int i=1;i<nums.length;i++){
                    prefix[i] = prefix[i-1]*nums[i-1];  
                }
                for(int i=nums.length-2;i>=0;i--){
                    suffix[i]= nums[i+1]*suffix[i+1]; 
                }
                for(int i =0;i<nums.length;i++){
                    res[i] = prefix[i] * suffix[i];
                }
               
        return res;
    }
}