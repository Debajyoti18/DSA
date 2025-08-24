import java.util.ArrayList;
import java.util.Scanner;

public class Subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter the String :");
        String inp =  sc. nextLine();
        ArrayList<String> res = findSubsequences(inp);
        for (String s: res ){
            System.out.print(s+" ");
        }
        System.out.println("Printing Subsequences :");
        printSubsequences(inp, "");
    }

    private static ArrayList<String> findSubsequences(String inp) {
        if (inp.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = inp.charAt(0);
        String str = inp.substring(1);
        ArrayList<String> li = findSubsequences(str);
        ArrayList<String> res = new ArrayList<>();
        for(String c : li ){
            res.add(c );
            
        }
        for(String c : li ){
            res.add( ch +c );
        }
        return res;
    }
    //printing Subsequences - Less number of Stack calls.TC: 0(logn)
    private static void printSubsequences(String inp , String op){
        if(inp.length() == 0){
            System.out.println(op);
            return;
        }
        char ch = inp.charAt(0);
        String rest = inp.substring(1);
       
        printSubsequences(rest, op + "");
        printSubsequences(rest, op + ch);

    }
}
