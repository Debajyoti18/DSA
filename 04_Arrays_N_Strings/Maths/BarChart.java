package Maths;
import java.util.Scanner;

public class BarChart {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter total the bar elements : ");
        int n = scn.nextInt();
        int[] arr = new int[n];
             System.out.println("Enter "+ n + " no of bar elements : ");
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
         for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("Printing the bar chart  :" );
        printBar(arr,n);
        
    }

    private static void printBar(int[] arr, int n) {
       int max = arr[0];
       for(int i =0;i<arr.length;i++){
        if(arr[i] > max){
            max = arr[i];
        }
       }
       for(int f = max ; f >= 1 ; f--){
        for(int i = 0 ; i < arr.length ;i++){
            if(arr[i] >= f){
                System.out.print("*\t");
            }else{
                System.out.print("\t");
            }
        }
         System.out.println();
       }
    }
}
