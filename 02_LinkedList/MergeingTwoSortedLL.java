/*
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        Node p = head1;
        Node q = head2;
        // dummy node to store the merged linked list
         Node dummy = new Node(0);
         // pointer to dummy node
         Node prev = newnode;
        
        while(p != null && q!= null){
            // compare the data of both linked list and insert the smaller one
            if(p.data <= q.data ){
                    dummy.next = p;
                    p = p.next;
                }else{
                    dummy.next = q;
                    q = q.next;
                }
                // move the prev pointer ahead
                 prev = prev.next;
        }
        // if any of the linked list has remaining nodes
        if(p!= null){
            dummy.next = p; 
        }
         if(q!= null){
          dummy.next = q;  
        }
        // dummy.next = p != null ? p : q;
        return dummy.next;
    }
}