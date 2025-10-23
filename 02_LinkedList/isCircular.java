/* Structure of LinkedList
class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/
class isCircular {
    boolean isCircular(Node head) {
        // Your code here
        Node p = head;
        Node q = head;
        while( p != null // to avoid null pointer exception
        && p.next != null 
        && p.next.next != null ){
            q = q.next;
            p = p.next.next;
            // cycle detected
            if(p == q){
                return true;
            }
        }
        return false;
    }
}