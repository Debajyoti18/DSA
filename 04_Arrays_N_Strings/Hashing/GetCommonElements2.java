/*
Get Common Elements – 2
You are given a number n1, representing the size of array a1.
You are given n1 integers, representing the elements of array a1.
You are given a number n2, representing the size of array a2.
You are given n2 integers, representing the elements of array a2.
You are required to find the intersection of a1 and a2, including duplicate occurrences.

*/
package Hashing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GetCommonElements2 {
    public static void main(String[] args) {
        int[] nums1 = {2,3,2};
        int[] nums2 = {1,2};
        List<Integer> res = findIntersectionValues(nums1,nums2);
        System.out.println(res);

    }

    public static List<Integer> findIntersectionValues(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int x : nums1){
            hm.put(x,hm.getOrDefault(x, 0)+1);
        }
        
        List<Integer> ans = new ArrayList<>();
         for(int x : nums2){
            if(hm.containsKey(x) && hm.get(x) > 0){// if x is present in map and its count is greater than 0
                ans.add(x);
                hm.put(x,hm.get(x)-1);// decrease the count as we have used one occurrence of x
            }
        }
        return ans;
    }
}