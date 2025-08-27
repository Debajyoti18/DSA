import java.util.Scanner;

public class MinSubsetSumDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int sum = 0;
        for (int x : arr) sum += x;

        // Bottom-up DP
        int ans1 = minSubsetSumDiffDP(arr, n, sum);
        System.out.println("Minimum Subset Sum Difference (Bottom-up DP) = " + ans1);

        // Top-down recursion + memoization
        Boolean[][] dp = new Boolean[n + 1][(sum / 2) + 1];
        int ans2 = minSubsetSumDiffRec(arr, n, sum, sum / 2, dp);
        System.out.println("Minimum Subset Sum Difference (Recursion + Memo) = " + ans2);
    }

    // Bottom-up DP version
    private static int minSubsetSumDiffDP(int[] arr, int n, int sum) {
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Initialization
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        // Fill DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the largest s1 ≤ target
        int s1 = 0;
        for (int j = target; j >= 0; j--) {
            if (dp[n][j]) {
                s1 = j;
                break;
            }
        }

        return sum - 2 * s1;
    }

    // Recursion + Memoization version
    private static int minSubsetSumDiffRec(int[] arr, int n, int sum, int target, Boolean[][] dp) {
        // Find largest subset sum ≤ target
        int s1 = maxSubsetSum(arr, n, target, dp);
        return sum - 2 * s1;
    }

    private static int maxSubsetSum(int[] arr, int n, int target, Boolean[][] dp) {
        if (target == 0) return 0;
        if (n == 0) return 0;

        if (dp[n][target] != null) return dp[n][target] ? target : 0;

        int include = 0;
        if (arr[n - 1] <= target) {
            include = arr[n - 1] + maxSubsetSum(arr, n - 1, target - arr[n - 1], dp);
        }
        int exclude = maxSubsetSum(arr, n - 1, target, dp);

        int best = Math.max(include, exclude);
        dp[n][target] = (best == target); // mark if exact target achieved
        return best;
    }
}
