/*
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    Node deleteMid(Node head) {
        // if linked list is empty or has only one node
        if(head == null || head.next == null){
            return null;
        }
        Node fast = head;
        Node slow = head;
         Node prev = null;
        while( fast != null  && fast.next != null ){
            prev =slow;
            slow = slow.next;
            fast = p.next.next;
        }
        prev.next = slow.next ;
        slow.next = null;
        return head;
    }
}