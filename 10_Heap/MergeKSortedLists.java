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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dmy = new ListNode(-1);
        ListNode curr = dmy;
        //min heap to get min element from k list
        //Integer min heap is bydefault in java - No custom comparator needed
        //but we need to compare ListNode so we need to provide custom comparator

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        //add first element of all list to min heap
        for(ListNode list : lists ){
            if(list != null){
                pq.add(list);
            }
        }
        //keep removing min element and add next element of that list to min heap
        while(!pq.isEmpty()){
            ListNode rm = pq.poll();
            curr.next = rm;
            curr = curr.next;
            //add next element of that list to min heap
            if( rm.next != null){
                pq.offer(rm.next);
            }
        }
        return dmy.next;
    }
}
/*
Dry run -
Input - lists = [[1,4,5],[1,3,4],[2,6]]
output - [1,1,2,3,4,4,5,6]


*/