import java.util.Scanner;

public class FirstOccurrenceInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // First query
        System.out.print("Enter starting index: ");
        int startIndex1 = sc.nextInt();
        System.out.print("Enter target value: ");
        int target1 = sc.nextInt();
        System.out.println("First Occurrence of " + target1 + " is : " +
                findFirstOccurrence(arr, startIndex1, target1));

        // Second query
        System.out.print("Enter starting index: ");
        int startIndex2 = sc.nextInt();
        System.out.print("Enter target value: ");
        int target2 = sc.nextInt();
        System.out.println("First Occurrence of " + target2 + " is : " +
                findFirstOccurrence(arr, startIndex2, target2));

        sc.close();
    }

    
    public static int findFirstOccurrence(int[] arr , int index, int val){
        if(index == arr.length){
            return -1;
        }
       
        if( arr[index] == val ){
                return index;
        }
       
            return findFirstOccurrence(arr, index+1, val);
           
        
    }
}
