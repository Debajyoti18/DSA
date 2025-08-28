import java.util.Scanner;

public class AnyBaseToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        System.out.println("Enter the base of the number :");
        int b = sc.nextInt();
        System.out.println("After the conversion " + n + " in base 10  is :"+ anyToDecimal(n,b) );
    }

    private static int anyToDecimal(int n, int b) {
       int res = 0;
       int p  = 1;//smallest power anything power 0 is 1.
       while (n > 0) {
        int rem = n % 10;
        n /= 10;
        res += rem * p;
        p =  b * p;
       }
       return res;
    }
}
