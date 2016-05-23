/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        if(head == null) {
            return head;
        }
        
        ListNode pre = null; 
        ListNode curr = head;
        
        
        while(curr != null) {
            if(curr.val == val) {
                if(head == curr) {
                    pre = head; 
                    head = curr.next;
                    pre.next = null; 
                    pre = null; 
                    curr = head; 
                }
                else {
                    pre.next = curr.next;
                    curr.next = null; 
                    curr=pre.next; 
                }
            }
            else {
                pre = curr; 
                curr = curr.next; 
            }
        }
        
        return head; 
    }
}