public class ReverseLL {
    public static Node reverseLL(Node head){
        Node prev = null, curr = head;
        while( curr != null){
            Node newnode =  curr.next;
            curr.next = prev;
            prev = curr;
            curr = newnode;
        }
        return prev;
    }
}
