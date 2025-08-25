public class StairPathsWithVariableJumps {
    public static void main(String[] args) {
        int[] arr = {3,3,0,1,2,3};
        System.out.println("The number of jumps with variable paths in a staircase is :" + getStairPaths(arr,arr.length) );
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
}
