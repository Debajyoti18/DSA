public class SubArraysOfAnArray {
    public static void main(String[] args) {
        String[] arr = {"a","b","c","d"};
        printSubarrays(arr);
    }
    public static void printSubarrays(String[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i ; j < arr.length ; j++){
                for(int k = i ; k <= j; k++){
                    System.out.print(arr[k] + "  ");
                }
                System.out.println();
            }
        }
    }
}
/*
a  
a  b
a  b  c
a  b  c  d
b
b  c
b  c  d
c
c  d
d
 */