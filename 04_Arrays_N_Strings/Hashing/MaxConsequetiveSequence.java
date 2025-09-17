package Hashing;

import java.util.HashMap;

public class MaxConsequetiveSequence {
    
     public void longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        // initially mark all elements as potential starting point of sequence
        for(int x : nums){
            map.put(x, true);
        }
        // mark all elements which have a predecessor as false
        for(int x : nums){
            if(map.containsKey(x-1)){
                map.put(x,false);
            }
        }
        // now find the longest sequence
        int maxLen = 0;
        int startingPoint = 0;
        for(int x : nums){
            if(map.get(x) == true){// means x is potential starting point
                int tempLen = 1;
                int tempStartingPoint = x;
                while(map.containsKey(tempStartingPoint + tempLen)){// check for next elements
                    tempLen++;
                }
                if(tempLen > maxLen){
                    maxLen = tempLen;
                    startingPoint = tempStartingPoint;
                }
            }
        }
        for(int i = 0 ; i < maxLen ; i++){
            System.out.print(startingPoint + i + " ");
        }
        
    }
}
