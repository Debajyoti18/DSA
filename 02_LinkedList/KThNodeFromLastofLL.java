/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */

class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {
        if( k  < 0  || head == null){
            return -1;
        }
        
        Node slow = head;
        Node fast = head;
        
        // move fast k nodes ahead so that the gap between slow and fast is k nodes
        for(int i = 0; i < k ; i++ ){
            //inbetween if fast reaches null then k is more than length of linked list
            if( fast == null){
                 return -1;  
        }
            fast=fast.next;
        }
        
        while(fast != null){
            // maintain the distance of k between slow and fast 
            slow=slow.next;
            fast= fast.next;
        }
        // at last slow is at the kth from last and fast at the last
        return slow.data;
    }
}