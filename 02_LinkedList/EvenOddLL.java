// User function Template for Java

/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node divide(Node head) {
        // code here
        Node even = new Node(0);
        Node odd = new Node(0);
        Node edummy = even;
        Node odummy= odd;
        Node temp =  head;
        while(temp != null){
            if(temp.data %2 == 0){
                edummy.next = temp;
                edummy = edummy.next;
            }else{
                 odummy.next = temp;
                odummy = odummy.next;
            }
            temp = temp.next;
        }
        odummy.next = null;
        edummy.next = odd.next;
        head = even.next;
        return head;
        
    }
}