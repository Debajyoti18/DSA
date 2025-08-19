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
        System.out.println(" Printing the Paths :" + printPaths(x));

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
    // recursion - instead of ArrayList we can Print it 

}
