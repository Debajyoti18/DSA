package ArraysNHashing;
package 04_Arrays_N_Strings.In;

public class mergingSortedArray {
    
    /**
     * Merges two sorted arrays into one sorted array.
     *  nums1 The first sorted array with enough space to hold elements of nums2.
     * nums2 The second sorted array.
     */
    //Brute Force Approach - O((n+m)log(n+m)) time = O(n+m) space
    public void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
        // Copy elements from nums2 to the end of nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        // Sort the combined array
        java.util.Arrays.sort(nums1);
    }
    //Optimal Approach - O(n + m) time = O(1) space
    public void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for the end of the initialized part of nums1
        int j = n - 1; // Pointer for the end of nums2
        int k = m + n - 1; // Pointer for the end of nums1

        // Merge in reverse order
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If there are remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
    //merging using extra array - O(n + m) time = O(n + m) 
    public void mergeUsingExtraArray(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Merge elements from both arrays
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Copy remaining elements from nums1
        while (i < m) {
            merged[k++] = nums1[i++];
        }

        // Copy remaining elements from nums2
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        // Copy merged array back to nums1
        System.arraycopy(merged, 0, nums1, 0, m + n);
    }
}
