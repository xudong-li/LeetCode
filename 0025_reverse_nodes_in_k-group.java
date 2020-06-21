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
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 0; 
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        curr.next = head;
        
        ListNode p1 = head, p2 = head;
        ListNode nodeBeforeReverseGroup = dummy;
        while (p2 != null) {
            while (p2 != null && i < k) {
                p2 = p2.next;
                i++;
            }
            if (i == k) {
                ListNode tailAfterReverse = p1;
                ListNode headAfterReverse = reverseNodes(p1, p2);
                nodeBeforeReverseGroup.next = headAfterReverse;
                nodeBeforeReverseGroup = tailAfterReverse;
                p1 = p2;
            }
            i = 0;
            
        }
        
        nodeBeforeReverseGroup.next = p1;
        
        return dummy.next;
    }
    
    private ListNode reverseNodes(ListNode p1, ListNode p2) {
        ListNode prev = null;
        while (p1 != p2) {
            ListNode temp = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = temp;
        }
        
        return prev;
    }
}