import java.util.Scanner;

public class CountSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.print("Enter target sum: ");
        int sum = sc.nextInt();

        int[][] dp = new int[n + 1][sum + 1];
        
        // Initialize dp with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }

        int count = subsetSum(arr, n, sum, dp);

        if (count != 0) {
            System.out.println("Number of subsets with given sum = " + count);
        } else {
            System.out.println("No subset with given sum");
        }
    }

    private static int subsetSum(int[] arr, int n, int sum, int[][] dp) {
        // Base cases
        if (sum == 0) return 1;   // Empty subset also counts
        if (n == 0) return 0;     // No elements left, but sum != 0

        // Memoization check
        if (dp[n][sum] != -1) return dp[n][sum];

        // Include or exclude current element
        if (arr[n - 1] <= sum) {
            dp[n][sum] = subsetSum(arr, n - 1, sum - arr[n - 1], dp)   // include
                       + subsetSum(arr, n - 1, sum, dp);              // exclude
        } else {
            dp[n][sum] = subsetSum(arr, n - 1, sum, dp); // can't include
        }

        return dp[n][sum];
    }
}
