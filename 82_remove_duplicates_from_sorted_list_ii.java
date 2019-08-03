/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        
        while (head != null && head.next != null) {
            if (head.next.val != head.val) {
                p.next = new ListNode(head.val);
                p = p.next;
                head = head.next;
            } else {
                while (head != null && head.next != null && head.next.val == head.val) {
                    head = head.next;
                }
                head = head.next;
            }
            
        }
        p.next = head;
        return dummy.next;
    }
}