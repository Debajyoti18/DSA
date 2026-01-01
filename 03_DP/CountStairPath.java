public class CountStairPath {
    //Variable Steps allowed 
    public static void main(String[] args) {
        int n = 6; // number of stairs
        int[] steps = {2, 3,0,1,2,3}; // allowed steps

        int ways = countWays(steps, n);
        System.out.println("Number of ways to climb " + n + " stairs: " + ways);
     
    }
    //Bottom-UP approach
     static int countWays(int[] steps, int n) {
       int[] dp = new int[n+1];

       dp[n]=1;//smaller subproblem
       for(int i=n-1; i >= 0; i--){ // taversering from n-1 to i.e from smaller to larger
        for(int j =1;j<= steps[i] && i+j < dp.length ;j++){ // allowed steps and within bounds
            dp[i] += dp[i+j];// summing all the ways
        }
       }
       return dp[0];

    }

}
