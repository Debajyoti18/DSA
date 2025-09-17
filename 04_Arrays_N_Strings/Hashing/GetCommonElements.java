package Hashing;

import java.util.HashSet;

/*
You are given two integer arrays nums1 and nums2 of sizes n and m, respectively. Calculate the following values:
answer1 : the number of indices i such that nums1[i] exists in nums2.
answer2 : the number of indices i such that nums2[i] exists in nums1.
Return [answer1,answer2].
 * 
 * Input: nums1 = [2,3,2], nums2 = [1,2]
 *
Output: [2,1]
 * 
 * 
 */

public class GetCommonElements {
    public static void main(String[] args) {
        int[] nums1 = {2,3,2};
        int[] nums2 = {1,2};
        int[] res = findIntersectionValues(nums1,nums2);
        System.out.println(res[0]+" "+res[1]);

    }

    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {

        HashSet<Integer> hs1 = new HashSet<>();
        for(int x : nums1){
            hs1.add(x);
        }
        HashSet<Integer> hs2 = new HashSet<>();
        for(int x : nums2){
            hs2.add(x);
        }
        int ans1 = 0,ans2=0;
        for(int x : nums1){
            if(hs2.contains(x)){
                ans1++;
            }
        }
         for(int x : nums2){
            if(hs1.contains(x)){
               ans2++;
            }
        }
        return new int[]{ans1,ans2};
    }
}