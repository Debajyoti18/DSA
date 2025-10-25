public Node findMid(Node head){
    Node slow = head;
    Node fast = head;
        while(fast.next != null //for oddlength 
                && fast.next.next != null) // for evenlength)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return  slow;
}
