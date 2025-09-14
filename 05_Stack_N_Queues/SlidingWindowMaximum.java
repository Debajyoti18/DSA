import java.util.Stack;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ngr= rightNextGreater(nums);
        int[] res = new int[nums.length-k+1];
        for(int i = 0; i <= nums.length - k ; i++ ){
            //enter the loop for find max of i in its window
            int j = i;
            while(ngr[j] < i+k ){// if next greater element index is in the window
                j = ngr[j];// jump to next greater element index
            }
            res[i] = nums[j];// store the max of the window
        }
        return res;
    }
    public static int[] rightNextGreater(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        
        for (int i = n - 1; i >= 0; i--) {
            // Pop smaller or equal elements
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            // If stack not empty, top is the NGE
            nge[i] = st.isEmpty() ? n : st.peek();
            // Push current element
            st.push(i);
        }
        return nge;
    }

}