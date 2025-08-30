public class SubsetsOfArray {
    public static void main(String[] args) {
        String[] arr = {"a","b","c","d"};
        printSubsets(arr);
    }

    private static void printSubsets(String[] arr) {
        int limit = (int) Math.pow(2, arr.length);
       for(int i = 0; i < limit ; i++){
        String str = "";
        int temp = i;
        for(int j = arr.length - 1 ; j >= 0 ; j--){
            //converting  i  to binary 
            //eg 6 binary 0110 : -ab-
            int rem = temp % 2;
            temp = temp / 2;
            if(rem == 0){
                str =  "-" + str;
            }else{
                str  = arr[j] + str;
            }
        }
        System.out.println(str + " ");
       }
    }
}
/*
 * 
---- 
---d 
--c- 
--cd 
-b-- 
-b-d
-bc-
-bcd
a---
a--d
a-c-
a-cd
ab--
ab-d
abc-
abcd
 */