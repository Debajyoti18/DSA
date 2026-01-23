package Maths;
public class ReverseAnArray {
    public static void main(String[] args) {
        int[]  arr = { 12 , 13, 14, 15 ,17};
        reverse(arr);
    }

    private static void reverse(int[] arr) {
        // TODO Auto-generated method stub
        int i = 0;
        int j = arr.length -1;
        while(j > i){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;i++;
        }
        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println();
       
    }
}
