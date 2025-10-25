/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
     Node left;
    public boolean isPalindrome(Node head) {
        // code here
         left = head;
         return isPalindromeHelper(head);
    }
    public boolean isPalindromeHelper(Node right){
        if( right == null){
            return true;
        }
        boolean res = isPalindromeHelper(right.next);
        if( res == false){
            return false;
        }else if( left.data != right.data){
            return false;
        }else{
            left = left.next;
            return true;
        }
        
    }
}