import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        
        int xpn = power(x, n);
        System.out.println(xpn);
    }
    public static int power(int x,int n){ //pow(2,4)
        if ( n == 0) return 1;
        int xpn = power(x, n-1);  //faith pow(2,3) = 2*2*2
        int res =  xpn * x  ;   //faith to exp pow(2,4)=pow(2,3)*2
        return res;
    }
}
