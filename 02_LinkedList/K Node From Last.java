public int kthFromLast(int k){
    Node t = head;
    int len = 0;
    while(t != null){
        len++;
        t = t.next;
    }
    int index = len - k ;
    t=head;
    for(int i =0;i < index;i++){
       t = t.next;
    }
    return t.data;
}
//one pass 
public int kthFromLast(int k) {
    if (head == null || k <= 0) {
        throw new IllegalArgumentException("Invalid k");
    }

    Node first = head, second = head;

    // Move first k steps ahead
    for (int i = 0; i < k; i++) {
        if (first == null) {
            throw new IllegalArgumentException("k is greater than length of list");
        }
        first = first.next;
    }

    // Move both until first reaches end
    while (first != null) {
        first = first.next;
        second = second.next;
    }

    return second.data; // kth node from last
}
//Recursion vv imp
public int kthFromLast(Node head, int k) {
    if (head == null) {
        return 0;  // base case: no nodes, return count 0
    }

    int count = kthFromLast(head.next, k) + 1;  // unwind and count make it last node as 1 not 0

    if (count == k) {
        System.out.println("Kth from last is: " + head.data);
    }

    return count; // return counter up the chain
}
