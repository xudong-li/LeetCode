/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + carry;
            carry = temp / 10;
            curr.next = new ListNode(temp % 10);
            
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int temp = l1.val + carry;
            carry = temp / 10;
            curr.next = new ListNode(temp % 10);
            
            curr = curr.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int temp = l2.val + carry;
            carry = temp / 10;
            curr.next = new ListNode(temp % 10);
            
            curr = curr.next;
            l2 = l2.next;
        }
        
        if (carry == 1) {
            curr.next = new ListNode(1);
            curr = curr.next;
        }
        
        return head.next;
    }
}