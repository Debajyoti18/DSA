import java.util.Scanner;

public class EqualSumPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int sum = 0;
        for (int x : arr) sum += x;

        // If total sum is odd → impossible
        if (sum % 2 != 0) {
            System.out.println("Equal Sum Partition doesn't exist");
            return;
        }

        int target = sum / 2;

        // Bottom-up DP
        if (canHavePartition(arr, n, target)) {
            System.out.println("Equal Sum Partition exists (Bottom-up DP)");
        } else {
            System.out.println("Equal Sum Partition doesn't exist (Bottom-up DP)");
        }

        // Top-down recursion + memoization
        Boolean[][] dp = new Boolean[n + 1][target + 1];
        if (canHavePartitionRecursion(arr, n, target, dp)) {
            System.out.println("Equal Sum Partition exists (Recursion + Memo)");
        } else {
            System.out.println("Equal Sum Partition doesn't exist (Recursion + Memo)");
        }
    }

    // Top-down recursion + memoization
    private static boolean canHavePartitionRecursion(int[] arr, int n, int target, Boolean[][] dp) {
        if (target == 0) return true;   // subset found
        if (n == 0) return false;       // no elements left

        if (dp[n][target] != null) return dp[n][target];

        if (arr[n - 1] <= target) {
            dp[n][target] = canHavePartitionRecursion(arr, n - 1, target - arr[n - 1], dp)
                          || canHavePartitionRecursion(arr, n - 1, target, dp);
        } else {
            dp[n][target] = canHavePartitionRecursion(arr, n - 1, target, dp);
        }
        return dp[n][target];
    }

    // Bottom-up DP
    private static boolean canHavePartition(int[] arr, int n, int target) {
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Initialization
        for (int i = 0; i <= n; i++) dp[i][0] = true;  // sum=0 is always possible

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
        return dp[n][target];
    }
}
