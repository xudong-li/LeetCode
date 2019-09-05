/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copyMap = new HashMap<>();
        
        Node p1 = head;
        while (p1 != null) {
            copyMap.put(p1, new Node(p1.val, null, null));
            p1 = p1.next;
        }
        
        p1 = head;
        
        while (p1 != null) {
            copyMap.get(p1).next = copyMap.get(p1.next);
            copyMap.get(p1).random = copyMap.get(p1.random);
            p1 = p1.next;
        }
        
        return copyMap.get(head);
    }
}