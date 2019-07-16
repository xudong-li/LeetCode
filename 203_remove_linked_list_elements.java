/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (head != null) {
            if (head.val != val) {
                p.next = new ListNode(head.val);
                p = p.next;
            }
            head = head.next;
        }
        
        return dummy.next;
    }
}