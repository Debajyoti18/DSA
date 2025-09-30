public class InsertionSort {
    public static void main(String[] args) {
        int[]  arr = {21,3,45,64,12};
        insertionSort(arr);
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n ; i++ ){
            int x = arr[i];
            int j = i-1;
            while( j > -1 && arr[j] > x ){
               arr[j+1] = arr[j];
               j--;
            }
            arr[j+1] = x;
        }
    }
}
