package Practice.ArraysNHashing;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//we can use Map<Integer,Boolean> but it cannot handle the large test cases.
//Time : O(n^2)
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        // Step 1: Put all numbers with value true (potential starts)
        for (int x : nums) {
            map.put(x, true);
        }

        // Step 2: Mark numbers that are NOT starting points
        for (int x : nums) {
            if (map.containsKey(x - 1)) {
                map.put(x, false);   // because x has a predecessor
            }
        }

        // Step 3: Expand sequences only from true-marked elements
        int maxiL = 0;
        for (int x : nums) {
            if (map.get(x) == true) {  // start of a sequence
                int temp = 1, curr = x;

                // count forward
                while (map.containsKey(curr + 1)) {
                    temp++;
                    curr++;
                }

                maxiL = Math.max(maxiL, temp);
            }
        }

        return maxiL;
    }
}
// Optimal Approach  : Set for removing Duplicate 

public class LongestConsequetiveSequence {
    class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for(int x : nums){
            map.add(x);
        }
        
        int maxiL = 0;
        for(int x : map){
            if(!map.contains(x-1)){
                int temp = 1 ,curr = x;
                while(map.contains(curr+1)){
                        temp++;
                        curr++;
                }
                maxiL= Math.max(maxiL,temp);
            }
        }
        return maxiL;
    }
}
}
