// PROBLEM STATEMENT- Given an array of positive integers, determine if the array can be partitioned into two subsets such 
//that the sum of elements in both subsets is equal.op-True/false

import java.util.Scanner;

public class EqualSumPartition {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        

        long sum = 0;
        for(int x : arr){
            sum += x;
        }
        long  target = sum /2;

        if (canHavePartition(arr, n, target)) {
            System.out.println("Equal Sum Partition exists ");
        } else {
            System.out.println("Equal Sum Partition doesn't exists ");
        }
        Boolean[][] dp = new Boolean[n + 1][(int) (target + 1)];
         if (canHavePartitionRecursion(arr, n, target,dp)) {
            System.out.println("Equal Sum Partition exists ");
        } else {
            System.out.println("Equal Sum Partition doesn't exists ");
        }
    }

     private static boolean canHavePartitionRecursion(int[] arr, int n, long target, Boolean[][] dp) {
        
    }

     private static boolean canHavePartition(int[] arr, int n, long target) {
                    if(n%2 != 0) return false;
                      boolean[][] dp = new boolean[n + 1][(int) (target + 1)];
                      // Initialization
        for (int i = 0; i <= n; i++) dp[i][0] = true;   // sum=0 → always true
        for (int j = 1; j <= target; j++) dp[0][j] = false; // no elements → can't form sum

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][(int)target];

     }
    
}
