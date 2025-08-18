import java.util.Scanner;

public class Fibbonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : \n");
        int n = sc.nextInt();
        System.err.println(n + "th Fibbonacci is :" + fibb(n));
         int[] dp = new int[n+1];//because we have to store ans from 0 to n
         System.err.println(n + "th \nFibbonacci is :" + getFib(dp, n));
    }
    // Recursion - Repeated number of same call -more stack space and time
    public static int fibb(int n){
        if( n == 0 || n == 1 ){
            return n;
        }
        return fibb(n-1)+fibb(n-2);
    }
    //dp - less number of calls ,stores the results and use it when same call in future
    public static int getFib(int[] dp,int n){
         if( n == 0 || n == 1 ){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] =  getFib(dp,n-1)+getFib(dp,n-2);
        
     return dp[n];

    }

}
