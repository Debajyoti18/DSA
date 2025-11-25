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
    // Find mid then reverse second half then check both halves by pointers (O(n) time and O(1) space)
    public boolean isPalindrome2(Node head) {
        if(head == null || head.next == null){
            return true;
        }
        // find mid
        Node mid = findMid(head); // O(n)
        // reverse second half
        Node revNode = reverseList(mid.next);// O(n/2)
        // compare both halves
        Node left = head;
        Node right = revNode;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
            
        }// restore the list (optional)
        mid.next = reverseList(revNode);

        return true;
    }
}