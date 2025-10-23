import java.util.HashSet;

public class RemoveDuplicateInUnsortedLL {
    //In Unsorted LL duplicates may not be adjacent (next to each other).
    public Node removeDuplicates(Node head) {
        // Your code here
       if(head == null){
            return head;
        }
        Node currNode = head;
        Node prevNode = null;
        HashSet<Integer> st = new HashSet<>(); //to store unique elements
        // Traverse the linked list
        while( currNode != null){
            if(st.contains(currNode.data)){ 
                //duplicate found
                //skip the current node
                prevNode.next = currNode.next;
            }else{
                //unique element
                st.add(currNode.data);
                prevNode = currNode;
            }
            currNode = currNode.next;
        }
        return head;
    }
}
