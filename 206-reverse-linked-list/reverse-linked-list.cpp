/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode *p=head,*q=nullptr,*r=nullptr;
        if (p == nullptr){
            return head;

        }else{
            while(p!=nullptr){
                r=q;
                q=p;
                p=p->next;
                q->next=r;
            }
             head=q;
        }
        return head;
       
    }
};