class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int res=0;
        if(n%2!=0){
            for(int nm : nums2){
                res ^= nm;
            }
        }
         int m = nums2.length;
        if(m%2!=0){
            for(int nm : nums1){
                res ^= nm;
            }
        }
        return res;
    }
}