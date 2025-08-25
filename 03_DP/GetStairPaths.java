import java.util.ArrayList;
import java.util.Scanner;

public class GetStairPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stairs :  ");
        int x = sc.nextInt();
        System.out.println("The jumps to go to the ground are :");
        ArrayList<String> res = getPaths(x);
        for(String p : res ){
            System.out.print(p +",");
          }
        System.out.println("\nPrinting the Paths :" );
         printPaths(x,"");

         System.out.println("FOR NUMBER OF VALID PATHS WITH GIVEN array :");
         System.out.println("Enter number of stairs:");
        int n = sc.nextInt();

        // System.out.println("Enter number of allowed steps:");
        // int m = sc.nextInt();

        // int[] steps = new int[m];
        // System.out.println("Enter allowed steps:");
        // for (int i = 0; i < m; i++) {
        //     steps[i] = sc.nextInt();
        // }

        // int ways = countWays(steps, n);

        System.out.println("The number of stair paths is : " + GetStairPathsDP1(n, new int[n+1]) );


    }
    private static int countWays(int[] steps, int n) {
       int[] dp = new int[n+1];

       dp[0]=1;
       if(n == 0){
        return 1;
       }
       if( dp[n] != 0){
        return dp[n];
       }
       dp[n] = countWays(steps, n-1)+countWays(steps, n-2)+countWays(steps, n-3);
       return dp[n];
    }
    //recusion - this take more number of calls so less efficient 
    public static ArrayList<String> getPaths(int n){
        if(n == 0 ){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }else if(n < 0){
             ArrayList<String> bres = new ArrayList<>();
             return bres;
        }
           ArrayList<String> path1 = getPaths(n-1);
           ArrayList<String> path2 = getPaths(n-2);
           ArrayList<String> path3 =getPaths(n-3);
            
             ArrayList<String> res = new ArrayList<>();
             for(String p : path1 ){
                res.add("1" + p );
             }
              for(String p : path2 ){
                res.add("2" + p );
             }
              for(String p : path3 ){
                res.add("3" + p );
             } 
             return  res;
    }
    // recursion - instead of ArrayList we can Print it -less number of calls
    public static void printPaths(int n , String op){
        if ( n == 0) {
          System.out.print(op + ",");
        } else if(n < 0){
            return;
        }
        printPaths(n-1,op+1);
        printPaths(n-2,op+2);
        printPaths(n-3,op+3);
    }
    //dp - optimal 
    private static int GetStairPathsDP1(int n , int[] arr){
      if(n == 0){
        return 1;
      }else if(n<0){
        return 0;
      }
      if(arr[n] !=  0){
        return arr[n];
      }
      arr[n] = GetStairPathsDP1(n-1, arr) + GetStairPathsDP1(n-2, arr) + GetStairPathsDP1(n-3, arr);
      return arr[n];
    }


}
