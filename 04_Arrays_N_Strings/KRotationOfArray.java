public class KRotationOfArray {
    public static void main(String[] args) {
        int[] a = {12 ,34 ,22,56,74,88};
        int k = 3;
        rotate(a,k);
        for(int x : a){
            System.out.print(x +" ");
        }
    }

    private static void rotate(int[] a, int k) {
        
        k %= a.length;
        if(k < 0){
            k += a.length;
        }
     
        
        reverse(a,0,k-1);
        reverse(a, k, a.length -1);
        reverse(a, 0, a.length-1);
        
    }
     private static void reverse(int[] arr,int x,int n) {
  
        int i = x;
        int j = n;
        while(j > i){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;i++;
        }
       
    }
}
