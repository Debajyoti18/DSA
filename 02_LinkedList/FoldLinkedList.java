/*
 * For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.
  Note: Try to solve without using any auxiliary space.
 */


public class FoldLinkedList {
    static Node leftNode;
    public static void reorderlist(Node head) {
         leftNode  = head;
         reorderlistHelper(head);
    }
    public static void reorderlistHelper(Node right) {
      if( right == null){
         return;
      }
      reorderlist(right.next);//move to the end
      //check edge cage that we have to stop at mid node
      if( leftNode == right // odd length
          || leftNode.next == right){ // even length
          right.next = null; // to avoid cycle and end it 
          return;
      }
        //folding
      Node newLeftNode = leftNode.next; //store next of left
      leftNode.next = right; //link left to right
      right.next = newLeftNode; // link right to next of left
      leftNode = newLeftNode; // update left to next
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        reorderlist(head);
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    
    }

}

class Node{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

//unfolding a Linkedlist
/*
 * Given a folded linked list, unfold it to get the original linked list.
  Note: Try to solve without using any auxiliary space.
 */
public Node unfoldLinkedList(Node head) {
    if(head == null || head.next == null){ // handle for 0 or 1 node
        return head;
    }
    Node firstHead = head; //odd positioned nodes
    Node secondHead = head.next; //even positioned nodes
    Node firstprev = firstHead;
    Node secondprev = secondHead;
    while(secondprev != null){
        Node curr = secondprev.next;//store next of even node
        //linking
        firstprev.next = curr;
        secondprev.next = curr.next;
        //move pointers ahead
        firstprev = firstprev.next;
        secondprev = secondprev.next;
        
    }
    firstprev.next = secondHead; //link end of first to head of second
    return firstHead;
}
    