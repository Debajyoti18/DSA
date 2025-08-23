import java.util.ArrayList;
import java.util.Scanner;

public class GetStairPaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of Stairs :");
        int n = scanner.nextInt();
        System.out.println("The number of ways to get to the base are : \n");
        ArrayList<String> arr = getPaths(n);
       System.out.println(arr);
    }
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
}
