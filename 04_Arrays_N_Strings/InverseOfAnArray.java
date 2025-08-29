public class InverseOfAnArray {
    public static void main(String[] args) {
        int[] a = {3 ,4 ,1,2,0};
        System.out.println("Before Inverse :");
        for(int x : a){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("After Inverse :");
        findInverse(a);
        
    }

    private static void findInverse(int[] a) {
        int[]  res = new int[a.length];
            for(int i = 0 ; i < a.length ; i++){
                int x = a[i];
                res[x] = i;
            }
            for(int x : res)
            System.out.print(x+" ");
        
    } 
}
/*
Before Inverse :
3 4 1 2 0 
After Inverse :
4 2 3 0 1
 * 
 */