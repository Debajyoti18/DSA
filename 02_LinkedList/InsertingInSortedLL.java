/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head, int key) {
    
        Node newnode = new Node(key);
        if(head == null){
            return newnode;
        }
        Node temp = head.next; 
        Node prev= head;
        // insert at beginning
        if(key <= head.data){
            newnode.next = head;
            head = newnode;
            return head;
        }
        // insert at middle 
        while(temp != null){
            if(temp.data >= key){
               newnode.next = temp;
                prev.next = newnode;
               return head;
            }
            prev = temp;
            temp = temp.next;
        }
        // insert at end
        prev.next = newnode;
        return head;
    }
}