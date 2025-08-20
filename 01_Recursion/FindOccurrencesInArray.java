import java.util.ArrayList;

public class FindOccurrencesInArray {
    public static void main(String[] args) {
            int[] arr = {2,3,4,5,6,7,3,5,7,3,4,7,8,9,4};
            System.out.println("The Occurences of the number 4 in the array is :" );
           int[] res =  findOcuur(arr,0,4,0);
           for( int x : res ){
            System.out.print(x+",");
           }
    }

    private static int[] findOcuur(int[] arr, int index,int x,int fsf) {
       if(index == arr.length){
        return new int[fsf];
       }
       if(arr[index] == x){
         int[]  res =findOcuur(arr, index+1, x, fsf+1);
         res[fsf] =  index;
         return res;

       }else{
        int[]  res =findOcuur(arr, index+1, x, fsf);
        return res;
       }
    }
}
