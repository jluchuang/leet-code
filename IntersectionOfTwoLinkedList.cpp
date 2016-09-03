/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int lenA = getLen(headA); 
        int lenB = getLen(headB); 
        
        int minLen = lenA > lenB ? lenB : lenA; 
        ListNode* tmpA = headA; 
        ListNode* tmpB = headB; 
        
        for(; lenA > minLen; lenA --) {
            tmpA = tmpA -> next; 
        } 
        for(; lenB > minLen; lenB --) {
            tmpB = tmpB -> next; 
        }
        
        for(; minLen > 0; minLen --) {
            if(tmpB == tmpA) {
                return tmpB;
            }
            tmpB = tmpB -> next;
            tmpA = tmpA -> next; 
        }
        
        return NULL; 
    }
private:
    int getLen(ListNode* head) {
        int res = 0; 
        ListNode* tmp = head; 
        
        while(tmp != NULL) {
            res++; 
            tmp = tmp -> next; 
        }
        return res; 
    }
};