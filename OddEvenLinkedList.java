/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head; 
        }
        
        ListNode oddTail = head;
        
        ListNode cur = head.next; 
        ListNode preCur = head;
        
        while (cur != null) {
            if(cur.next == null) {
                break; 
            }
            
            // move cur to odd
            preCur = cur; 
            cur = cur.next;
            
            // cut cur
            preCur.next = cur.next; 
            
            // insert cur to odd tail
            cur.next = oddTail.next; 
            oddTail.next = cur; 
            oddTail = oddTail.next; 
            
            // move cur to next even
            cur = preCur.next; 
        }
        
        return head; 
    }
}