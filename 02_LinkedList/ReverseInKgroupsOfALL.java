class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * Implements the core logic for reversing nodes in a singly linked list in groups of size K.
 * This class uses static variables (th and tt) to manage the temporary reversed segment.
 */
public class ReverseInKgroupsOfALL {
    // th (Temporary Head): Head of the K-node segment being built/reversed via addFirstNode.
    static ListNode th = null;
    // tt (Temporary Tail): Tail of the K-node segment being built/reversed.
    static ListNode tt = null;
    
    /**
     * Helper function to prepend a node to the currently temporary list (th/tt).
     * This effectively reverses the order of the nodes passed to it sequentially.
    
     */
    public static void addFirstNode(ListNode node) {
        if (th == null) {
            // This is the very first node of the segment.
            th = node;
            tt = node;
        } else {
            // Link the new node to the current head and update th.
            node.next = th;
            th = node;
        }
    }

    /**
     * Reverses the linked list in groups of K. If the remaining nodes are fewer than K, 
     * they are left unreversed. K is hardcoded to 3 in this implementation.
     *
     * @param head The head of the entire linked list.
     * @return The head of the modified linked list.
     */
    public static ListNode reverseInKGroup(ListNode head) {
        // K is the size of the group to reverse.
        final int k = 3; 
        
        // Base case: If list is empty, too short, or K=1, no reversal is needed.
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        // Dummy node simplifies handling the new head of the entire list and the first group link.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        // prevTail tracks the tail of the segment *before* the current group being reversed.
        ListNode prevTail = dummy;

        while (current != null) {
            ListNode startOfGroup = current;
            ListNode endOfGroup = current;
            int count = 1;
            
            // 1. CHECK & FIND END: Traverse to find the K-th node (endOfGroup)
            while (count < k && endOfGroup.next != null) {
                endOfGroup = endOfGroup.next;
                count++;
            }

            // If we found fewer than K nodes, we link the unreversed remainder and stop.
            if (count < k) {
                prevTail.next = startOfGroup;
                break; 
            }

            // 2. PREPARE FOR REVERSAL: Detach the K-node segment
            ListNode nextGroupHead = endOfGroup.next; 
            endOfGroup.next = null; // Cut the link to the next group
            
            // 3. REVERSE SEGMENT using addFirstNode helper
            int revcount = 0;
            th = null; // Reset static segment pointers before reversing the new group
            tt = null;
            ListNode nodeToReverse = startOfGroup; 
            
            while(revcount < k){
                ListNode nextNode = nodeToReverse.next;
                nodeToReverse.next = null; // Isolate node
                addFirstNode(nodeToReverse); 
                nodeToReverse = nextNode;
                revcount++;
            }
            // After the loop, th is the head of the reversed segment, and tt is the tail.
            
            // 4. RE-LINKING: Connect the main list back together
            
            // Link the tail of the previous group to the new head of the reversed segment (th)
            prevTail.next = th;
            
            // The original startOfGroup is now the tail of the reversed segment (tt).
            // Update prevTail to the tail of the group we just reversed.
            prevTail = startOfGroup;  
            
            // Move 'current' pointer to the start of the next K nodes
            current = nextGroupHead;
        }

        // The final result is the node after the dummy node.
        return dummy.next;
    }
}