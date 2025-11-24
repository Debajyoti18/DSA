public class ReverseLL {

    // Standard reverse
    public static Node reverseLL(Node head){
        Node prev = null, curr = head;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Three pointer version
    public static Node reverseLLThreePointers(Node head) {
        if (head == null || head.next == null)
            return head;

        Node prev = null, curr = head, ford = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = ford;
            if (ford != null) ford = ford.next;
        }
        return prev;
    }
}
