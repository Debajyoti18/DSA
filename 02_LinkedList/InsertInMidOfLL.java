class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertInMidOfLL {
    public Node findMid(Node head, int x){
        if(head == null){
            return new Node(x);
        }
        Node slow = head;Node fast = head;
        while( fast != null // if odd length
         && fast.next != null // if even length
         && fast.next.next != null // to avoid null pointer exception
         ){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newNode = new Node(x);
        newNode.next = slow.next;
        slow.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        InsertInMidOfLL list = new InsertInMidOfLL();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);

        int x = 3; // Value to be inserted in the middle
        head = list.findMid(head, x);

        // Print the updated linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
