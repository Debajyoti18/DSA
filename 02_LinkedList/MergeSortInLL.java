/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node mergeSort(Node head) {
        // code here
        if(head == null){
            return null;
        }
        Node tail = head;
        while(tail.next != null){
            tail= tail.next;
        }
        return mergeSort(head,tail);
    }
    public Node mergeSort(Node head, Node tail){
        //for the single nodes they return as new node
        if(head == tail){
            return new Node(head.data);
        }
        // find mid node
         Node mid = findMidNode(head,tail);
         // recursive calls left half
         Node fsh = mergeSort(head , mid);
         // recursive calls right half
         Node ssh = mergeSort(mid.next , tail);
         // merge two sorted linked list
         Node res = mergetwoSortedLL(fsh,ssh);
         return res;


    }
    public Node findMidNode(Node head, Node tail){
        Node slow = head;
        Node fast= head;
         while(fast != tail //for oddlength 
             && fast.next != tail) // for evenlength)
    {
        slow = slow.next;
        fast = fast.next.next;
    }
    return  slow;
    }
   public Node mergetwoSortedLL(Node head1, Node head2) {
        // code here
        Node p = head1;
        Node q = head2;
        // dummy node to store the merged linked list
         Node newnode = new Node(0);
         // pointer to dummy node
         Node dummy = newnode;
        
        while(p != null && q!= null){
            // compare the data of both linked list and insert the smaller one
            if(p.data <= q.data ){
                    dummy.next = p;
                    p = p.next;
                }else{
                    dummy.next = q;
                    q = q.next;
                }
                // move the dummy pointer ahead
                 dummy = dummy.next;
        }
        // if any of the linked list has remaining nodes
        if(p!= null){
            dummy.next = p; 
        }
         if(q!= null){
          dummy.next = q;  
        }
        return newnode.next;
    }
}