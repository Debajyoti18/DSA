public class FindDuplicateVIATWOPointer {
    int findDuplicate(int arr[]){
        // 1,2,3,4,5,6,7,8,9,10
        // Duplicates are find by 2nd collision of the slow and fast pointer
        int slow = arr[0], fast = arr[0];
        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while( slow != fast);
        // first collision happens at the point where the fast and slow pointer meet
        fast = arr[0];

        while( slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        // 2nd collision happens at the point where the fast and slow pointer meet
        // the point where they meet is the duplicate number
        return slow;// or fast
    }
}
