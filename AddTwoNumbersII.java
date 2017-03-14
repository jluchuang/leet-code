/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//
// Another Solutions :
//  1. with two stacks 
//  2. reverse the output not input(need calcluate length of input)
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2; 
        }
        if(l2 == null) {
            return l1; 
        }
        
        ListNode r1 = reverse(l1); 
        ListNode r2 = reverse(l2); 
        
        ListNode res = new ListNode(0); 
        
        ListNode tmp = res; 
        int ad = 0; 
        while(true) {
            if(r1 == null || r2 == null) {
                break; 
            }
            
            int t = r1.val + r2.val + ad; 
            
            int val = t % 10; 
            ad = t / 10; 
            
            tmp.next = new ListNode(val); 
            tmp = tmp.next; 
            
            r1 = r1.next;
            r2 = r2.next; 
        }
        
        ListNode ls = null;
        if(r1 != null) {
            ls = r1; 
        }
        else {
            ls = r2; 
        }
        
        while(ls != null) {
            int t = ls.val + ad; 
            
            int val = t % 10; 
            ad = t / 10;
            
            tmp.next = new ListNode(val); 
            tmp = tmp.next; 
            
            ls = ls.next; 
        }
        
        if(ad != 0) {
            tmp.next = new ListNode(ad); 
        }
        
        res = res.next; 
        return reverse(res); 
    }
    
    private ListNode reverse(ListNode l) {
        ListNode tmp = l; 
        ListNode preTmp = null; 
        
        while(tmp != null) {
            ListNode n = tmp.next; 
            tmp.next = preTmp; 
            
            preTmp = tmp; 
            tmp = n; 
        }
        
        return preTmp; 
    }
}