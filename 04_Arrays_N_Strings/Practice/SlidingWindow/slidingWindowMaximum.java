package Practice.SlidingWindow;
/**
 * Sliding Window Maximum
 * Intuition: 
 * Precompute next greater element index (nge[]) for every element using a monotonic decreasing stack.
 * For each window, use the nge[] array to jump to the maximum element in O(1) time.
 */
public class slidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);// Push index of last element because it has no elements to its right
        nge[n - 1] = n;// Initialize nge for last element as n (no greater element)
        
        // Compute next greater element indices
        for (int i = n - 2; i >= 0; i--) {
            //-a+ pop,element,push
            // Pop elements from stack while they are less than or equal to current element
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            // If stack is empty, there is no greater element to the right
            nge[i] = stack.isEmpty() ? n : stack.peek();
            // Push current index onto stack
            stack.push(i);
        }
        // n-k+1 is the number of windows of size k
        int[] result = new int[n - k + 1];
        int j = 0;
        
        // Find maximum for each sliding window
        for (int i = 0; i <= n - k; i++) {
            if (j < i) {// Ensure j is within the current window
                j = i;// Move j to the start of the current window
            }
            while (nge[j] < i + k) {// Jump to the next greater element within the window
                j = nge[j];
            }
            result[i] = nums[j];// The maximum element for the current window
        }
        
        return result;
    }
    
}
