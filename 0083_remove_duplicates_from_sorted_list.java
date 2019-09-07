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
        
        ListNode ptr = head;
        while (ptr != null) {
            while (ptr.next != null && ptr.next.val == ptr.val) {
                ptr.next = ptr.next.next;
            }
            ptr = ptr.next;
        }
        
        return head;
    }
}