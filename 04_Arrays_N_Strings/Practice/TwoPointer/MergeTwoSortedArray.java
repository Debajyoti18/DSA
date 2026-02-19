public class MergeTwoSortedArray {
    void mergeArrayByTwoPointer(int[] a,int m,int[] b,int n){
        //a [1,2,3,0,0,0] b[2,5,6]
        int i = m - 1;// At the last element  of the 1st array
        int j = n - 1;//At the last index of 2nd Array
        int k = m+n-1;//last free space o the 1st array
        while(  i > 0 && j > 0){
            // Greater element fills from the last of the 1st array
            if( a[i] > b[j]){
                a[k--] = a[i--];
            }else{
                a[k--] = b[j--];
            }
        }// add the extra elements of the 2nd array
        while( j != 0){
            a[k--] = b[j--];
        }
    }
}
