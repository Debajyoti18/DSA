/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    // Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head) {
        // Your code here
        Node p = head.next;//pointer to traverse the linked list
        Node q = head;//pointer to maintain the last unique element
        while(p != null){
            if(p.data != q.data){//if data is unique
                q=p;
                p= p.next;
            }else{
                //duplicate found
            Node x = p.next;//store the next node of p
            q.next = x;//link q to next of p
            p.next = null;//remove the reference of p
            p = x;//move p to next node
            }
        }
        return head;
    }
}