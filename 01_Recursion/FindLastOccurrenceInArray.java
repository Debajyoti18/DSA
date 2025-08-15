import java.util.Scanner;

public class FindLastOccurrenceInArray {
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

        // Display array
        System.out.print("Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // First query
        System.out.print("Enter starting index: ");
        int startIndex1 = sc.nextInt();
        System.out.print("Enter target value: ");
        int target1 = sc.nextInt();
        System.out.println("Last Occurrence of " + target1 + " is : " +
                findLastOccurrence(arr, startIndex1, target1));

        // Second query
        System.out.print("Enter starting index: ");
        int startIndex2 = sc.nextInt();
        System.out.print("Enter target value: ");
        int target2 = sc.nextInt();
        System.out.println("Last Occurrence of " + target2 + " is : " +
                findLastOccurrence(arr, startIndex2, target2));

        sc.close();
    }

    public static int findLastOccurrence(int[] arr, int index, int val) {
        if (index == arr.length) {
            return -1;
        }
        int fi = findLastOccurrence(arr, index + 1, val);
        if (fi != -1) {
            return fi;
        }
        return (arr[index] == val) ? index : -1;
    }
}
