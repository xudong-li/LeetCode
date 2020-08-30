/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = head;
        int count = 1;
        
        if (head == null) {
            return null;
        }
        
        ListNode prev = null, curr = head;
        while (count < m) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        
        ListNode con = prev, tail = curr;
        
        ListNode temp = null;
        while (count <= n) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
        }
        
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        
        tail.next = curr;
        
        return head;
    }
}