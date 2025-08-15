public class MaxInArray {
    public static void main(String[] args) {
        int[] arr = {12,76,98,43,88,96};
        System.out.println("The maximum in whole array is : " + findmax(arr,0));
        System.out.println("The maximum from 4 index to last in array is : " + findmax(arr,4));
    }
    public static int findmax(int[]  arr,int index){
            if(index == arr.length - 1){
                return arr[index];
            }
            int maxi = findmax(arr, index+1);
            if( maxi > arr[index] ){
                return maxi;
            }else{
                return arr[index];
            }
          
    }
}
