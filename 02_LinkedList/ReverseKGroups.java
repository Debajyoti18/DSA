/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
            Node temp = head;
            Node prev = null;
            Stack<Node> st = new Stack<>();

            while(temp != null){
                int count = 0;
                while(temp != null && count < k){
                    st.push(temp);
                    count++;
                     temp = temp.next;
                   }
                 while(st.size() > 0){
                    // if prev is null then it is first node
                if(prev == null){
                    prev = st.pop();
                    head = prev;
                  }else{
                    // link prev to stack top
                    prev.next = st.pop();
                     prev = prev.next;
                }
             }
               
            }
            //prev is at last node of reversed list
            prev.next = null;
            return head;
            
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static ListNode th =null;
    static ListNode tt = null;
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k==0) return head;

        ListNode curr = head;
        int len = getLength(head);
        ListNode oh = null,ot=null;
        while(len >= k){
            int tempk = k;
            while(tempk-- > 0){
                ListNode ford = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = ford;
            }
            if(oh==null){
                oh=th;
                ot=tt;
            }else{
                ot.next = th;
                ot=tt;
            }
            th =null;
            tt=null;
            len -= k;
        }
        if(ot != null){
        ot.next = curr;
        }
        return oh;
    }
    void addFirst(ListNode head){
        if(th == null){
            th=head;
            tt=head;
        }else{
            head.next = th;
            th = head;
        }
    }
    int getLength(ListNode head){
         ListNode curr = head;
         int count =0;
         while(curr != null){
                count++;
                curr = curr.next;
         }
         return count;
    }
}