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