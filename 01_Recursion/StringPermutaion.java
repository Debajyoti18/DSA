import java.util.ArrayList;
import java.util.Scanner;

public class StringPermutaion {
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String str = scn.nextLine();
            ArrayList<String> arr = perm(str,"");
            System.out.println("Permutaion of " + str + " are :\n");
            for (String s : arr){
                System.out.print(s + ",");
            }

            System.out.println("\nPrinting all Permuations : \n" );
            printPerm(str, "");

    }
    // By recursion takes more numbers of calls.instead of that we can print all
    public static ArrayList<String> perm(String str , String op){
        ArrayList<String> result = new ArrayList<>();

        // Base case: if input string is empty, add the output string
        if (str.length() == 0) {
            result.add(op);
            return result;
        }

        char ch = str.charAt(0);
        String rest = str.substring(1);

        // Insert 'ch' at every possible position in 'op'
        ArrayList<String> partial = perm(rest, op);
        for (String s : partial) {
            for (int i = 0; i <= s.length(); i++) {
                String newStr = s.substring(0, i) + ch + s.substring(i);
                result.add(newStr);
            }
        }
        return result;
    
    }
    //printing all permutations
    public static void printPerm(String str ,String op){
        if( str.length() == 0){
            System.out.print(op + " ");
            return;
        }
        for(int i =0;i< str.length();i++){
        char ch = str.charAt(i);
        String restStringleft  = str.substring(0,i);
          String restStringright  = str.substring(i+1);
          String res = restStringleft + restStringright;
          printPerm(res, op+ch);
        }
       
    }
}
