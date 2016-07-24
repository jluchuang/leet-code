/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode pcur = head; 
        ListNode newHead = null; 
        
        while(pcur != null) {
            ListNode pHead = pcur.next; 
            pcur.next = newHead; 
            newHead = pcur; 
            pcur = pHead; 
        }
        
        return newHead; 
    }
}