public class Knapsack_01 {
    public static void main(String[] args) {
         int val[] = {60, 100, 120};  // values
        int wt[] = {10, 20, 30};     // weights
        int W = 50;                  // capacity of knapsack
        int n = val.length;          // number of items

        //int maxValue = knapsack(W, wt, val, n);
        int[][] dp = new int[n+1][W+1];
        int  maxValue = knapsackButtomUP(W, wt, val, n,dp);

        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
    //Recursive Approach- DP Buttom-UP 

    private static int knapsackButtomUP(int w, int[] wt, int[] val, int n, int[][] dp) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i-1] <= j) {
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }

    //Recursive + Memoizaization
    private static int knapsack(int w, int[] wt, int[] val, int n) {
        if( n == 0 || w == 0){
            return 0;
        }
        if(wt[n-1] <= w){
            return Math.max((val[n-1]+ knapsack( w-wt[n-1],wt, val, n-1)),
            knapsack(w, wt, val, n-1));
        }
        return knapsack(w, wt, val, n-1);
    }
    
}
