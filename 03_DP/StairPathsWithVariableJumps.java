public class StairPathsWithVariableJumps {
    public static void main(String[] args) {
        int[] arr = {3,3,0,1,2,3};
        System.out.println("The number of jumps with variable paths in a staircase is :" + getStairPaths(arr,arr.length) );
        System.out.println("The minimum number of jumps to reach base is : "  + getMinimumJumps(arr));
    }

    private static int getStairPaths(int[] arr, int length) {
        int[] dp = new int[length+1];
        dp[length] = 1; // if at the base or top stay there
        for(int i = length-1; i >= 0; i--){
            for(int j = 1 ; j <= arr[i] && i+j < dp.length ; j++ ){
                dp[i] += dp[i+j];
            }
        }
        return dp[0];
    }
    private static int getMinimumJumps(int[] arr) {
    Integer[] dp = new Integer[arr.length + 1];
    dp[arr.length] = 0;  // base case: no jumps needed from the end

    for (int i = arr.length - 1; i >= 0; i--) {
        int min = Integer.MAX_VALUE;

        // try all jumps from current index
        for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
            if (dp[i + j] != null) { // check reachable states
                min = Math.min(min, dp[i + j]);
            }
        }

        // if at least one jump was valid
        if (min != Integer.MAX_VALUE) {
            dp[i] = min + 1;
        }
    }

    return dp[0] == null ? -1 : dp[0]; // -1 if unreachable
}

}
