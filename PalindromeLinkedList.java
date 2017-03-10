/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true; 
        }
        
        int len = 0;
        ListNode t = head; 
        while (t != null) {
            t = t.next; 
            len ++; 
        }
        
        // Reverse First Half
        int mid = len / 2; 
        ListNode rev = null; 
        ListNode m = head; 
        ListNode tnext = null;  
        for(int i = 0; i < mid; i ++) {
            tnext = m.next; 
            m.next = rev; 
            rev = m; 
            m = tnext; 
        }
        
        ListNode sec = m; 
        if(len % 2 == 1) {
            sec = sec.next; 
        }
        
        // Compare and reset 
        boolean res = true; 
        for(int i = 0; i < mid; i++) {
            if(sec.val != rev.val) {
                res = false;
            }
            sec = sec.next; 
            
            tnext = rev.next; 
            rev.next = m; 
            m = rev; 
            rev = tnext; 
        }
        
        return res; 
    }
}