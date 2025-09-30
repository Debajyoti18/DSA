public class SelectionSort {
    public static void main(String[] args) {
         int[]  arr = {21,3,45,64,12};
       for(int i =0; i< arr.length -1;i++){
        for(int j =i;j<arr.length;j++){
            int k =i;
                if(arr[j] < arr[k]){
                    k = j;
                }
                swap(arr,i,k);
        }
       }
       for(int x : arr){
        System.out.print(x + " ");
       }
    }

    private static void swap(int[] arr,int i, int j) {
       int temp = arr[i];
       arr[i]=arr[j];
      arr[j]=temp;
    }
}
