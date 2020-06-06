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
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //1. find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode p2 = slow;
        
        // 2. reverse the second part of the list
        ListNode prev = null;
        while (p2 != null) {
            ListNode temp = p2.next;
            p2.next = prev;
            prev = p2;
            p2 = temp;
        }
                
        // 3. merge 2 lists, now the head of the second list is prev;
        ListNode p1 = head;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while (p1 != slow) {
            curr.next = p1;
            p1 = p1.next;
            curr = curr.next;
            
            curr.next = prev;
            prev = prev.next;
            curr = curr.next;
        }
        
        head = dummy.next;
    }
}