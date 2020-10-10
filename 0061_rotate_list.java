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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        
        // count the length of the list
        ListNode prev = null;
        ListNode curr = head;
        int length = 0;
        
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        
        //1. reverse the whole list
        curr = head;
        prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        //now head is prev;
        head = prev;
        
        
        if (k == 0) {
            return head;
        }
        
        ListNode breakpoint = head;
        while (k > 0) {
            breakpoint = breakpoint.next;
            k--;
        }
        //System.out.println(breakpoint.val);
        
        //2. reverse the first part
        curr = head;
        prev = null;
        //System.out.println(curr.val);
        while (curr != breakpoint) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        ListNode result = prev;
        
        //3. reverse the second part
        curr = breakpoint;
        prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head.next = prev;
        
        return result;
    }
}