import java.util.Scanner;

public class SubsetSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.print("Enter target sum: ");
        int sum = sc.nextInt();

        if (subsetSum(arr, n, sum)) {
            System.out.println("Subset with given sum exists ");
        } else {
            System.out.println("No subset with given sum ");
        }
    }
    //Tabulation - Buttom-Up
    private static boolean subsetSum(int[] arr, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i <= n; i++) dp[i][0] = true;   // sum=0 → always true
        for (int j = 1; j <= sum; j++) dp[0][j] = false; // no elements → can't form sum

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
    //TOPDOWN -RECURSIVE+MEMOIZATION
}
