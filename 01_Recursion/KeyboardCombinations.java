import java.util.ArrayList;
import java.util.Scanner;

public class KeyboardCombinations {
     static String[] codes = {
        ".;",    // 0
        "abc",   // 1
        "def",   // 2
        "ghi",   // 3
        "jkl",   // 4
        "mno",   // 5
        "pqrs",  // 6
        "tu",    // 7
        "vwx",   // 8
        "yz"     // 9
    };
   
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter digits: ");
        String digits = sc.nextLine();

        ArrayList<String> res = getKPC(digits);
        System.out.println("Possible combinations: " + res);
        System.out.println("\n Printing Subsequences :");
        printKPC(digits,"");
    }

   private static ArrayList<String> getKPC(String digits) {
    if(digits.length() == 0){
        ArrayList<String> brew = new ArrayList<>();
        brew.add("");
        return brew;
    }
    ArrayList<String> res = new ArrayList<>();
    char ch = digits.charAt(0);
    String rest = digits.substring(1);
    ArrayList<String> mres = getKPC(rest);
     String code = codes[ch - '0']; // mapping for this digit
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            for (String s : mres) {
                res.add(c + s); // add char + each smaller combination
            }
        }
    return res;
   }
   //Printing the KeyBoard Combination without returning as List .
   private static void printKPC(String str , String op){
    if(str.length() == 0){
        System.out.print(op + " , ");
        return;
    }
    char ch = str.charAt(0);
    String rest = str.substring(1);
    String codefor = codes[ch -'0'];
    for(int i =0 ;i < codefor.length();i++){
        printKPC(rest, op + codefor.charAt(i));
    }
   }
    
}
