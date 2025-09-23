
public class Bubble {
    public static void main(String[] args) {
        
    }
    public static void bubbleSort(int[] arr){
        int n = arr.length; 
        int flag ;
        for(int i = 0; i < n - 1 ; i++){
            flag = 0 ;
            for(int  j = 0; j < n - 1 - i ; j++  ){
                if(arr[j] < arr[j+1]){
                    int x = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = x ;
                    flag = 1;
                }
            }
            if(flag == 0){
                break;
            }
        }
    } 
}
