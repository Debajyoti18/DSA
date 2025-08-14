import java.util.ArrayList;
import java.util.Scanner;

public class Subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp =  sc. nextLine();
        ArrayList<String> res = findSubsequences(inp);
        for (String s: res ){
            System.out.print(s+" ");
        }
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
}
