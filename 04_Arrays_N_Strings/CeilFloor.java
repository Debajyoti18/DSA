public class CeilFloor {
    public static void main(String[] args) {
        int[] arr = { 10,20,30,40,50,60,70,80};
        int num = 31;
        findCeilFloor(arr,num);
    }

    private static void findCeilFloor(int[] arr, int num) {
       int l = 0;
       int r = arr.length -1;
       int ceil = 0,floor = 0;
       while (l <= r) {
            int mid = (l+r)/2;
            if(arr[mid] > num){
                r = mid - 1;
                 ceil = arr [mid];//update ceil when the right  pointer is updated
            }else if(arr[mid] < num){
                l = mid + 1;
                 floor = arr[mid];//update floor when the left pointer is updated
            }else{
                ceil = floor = arr[mid];
            }
       }
       System.out.println(ceil + " " +floor);
    }
}
