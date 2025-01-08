
Time complexity=O(3N)
Space complexity=O(3N)
    

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];
        
        //as there is no left in the left of 1st index and no right
        // in rigth of the last index
        left[0] = 0;
        right[n-1] = 0;
        int count = boxes.charAt(0) - '0';//no of balls
        //'1'-'0'= 1  and '0'-'0'= 0
        for(int i = 1;i < n; i++){
            left[i] = left[i-1] + count;
            count += boxes.charAt(i) - '0';

        }
        //reassign the count for the no of balls for right half
        count =  boxes.charAt(n-1) - '0';
         for(int i = n-2 ;i >= 0; i--){
            right[i] = right[i+1] + count;
            count += boxes.charAt(i) - '0';

        }
        // addin the left and right half
        for(int i = 0;i < n; i++){
            res[i] = left[i] + right[i];
        }
        return res;
    }
}
