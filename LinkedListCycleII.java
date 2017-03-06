/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null; 
        }
        
        ListNode fast = head; 
        ListNode slow = head; 
        
        while(true) {
            
            slow = slow.next; 
            if(fast.next != null) {
                fast = fast.next.next; 
            }
            else {
                return null; 
            }
            
            if(fast == null || slow == null) {
                return null; 
            }
            
            if(fast.equals(slow)) {
                break; 
            }
        }
        
        fast = head; 
        while(!fast.equals(slow)) {
            fast = fast.next; 
            slow = slow.next; 
        }
        return slow; 
    }
}