class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int res = 0;
        for(int val : derived){//val -> original[i] xor original[i]
            res = res ^ val;
        }
        return (res==0);
    }
}