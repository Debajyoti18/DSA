package Maths;

import java.util.Scanner;

public class DecimalToAnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        System.out.println("Enter the base You want to convert :");
        int b = sc.nextInt();
        System.out.println("After the conversion " + n + " in base "+ b +" is :"+ DecimalToanyBase(n,b) );
    }

    private static int DecimalToanyBase(int n, int b) {
       int res = 0;
       int p  = 1;     //smallest power anything power 0 is 1.
       while (n > 0) {
        int rem = n % b;
        n = n / b;
        res += rem * p;
        p =  p * 10;  //next 10 multiple
       }
       return res;
    }
}
