/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    private Node prev = null;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node(0, null, null);
        prev = dummy;
        helper(root);
        
        //connect the head and tail
        dummy.right.left = prev;
        prev.right = dummy.right;
        
        return dummy.right;
    }
    
    private void helper(Node curr) {
        if (curr == null) {
            return;
        }
        helper(curr.left);
        prev.right = curr;
        curr.left = prev;
        prev = curr;
        helper(curr.right);
    }
}