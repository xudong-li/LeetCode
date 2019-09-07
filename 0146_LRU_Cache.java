class DLinkedListNode {
    int key;
    int value;
    DLinkedListNode next;
    DLinkedListNode prev;
    
    public DLinkedListNode(int key, int value, DLinkedListNode next, DLinkedListNode prev) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
};


class LRUCache {

    private int capacity;
    private int count = 0;
    private DLinkedListNode dummyHead;
    private DLinkedListNode dummyTail;
    private Map<Integer, DLinkedListNode> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        dummyHead = new DLinkedListNode(-1, -1, null, null);
        dummyTail = new DLinkedListNode(-1, -1, null, null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DLinkedListNode node = map.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLinkedListNode node = map.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }
        
        DLinkedListNode node = new DLinkedListNode(key, value, null, null);
        map.put(key, node);
        moveToHead(node);
        count++;
        
        if (count > capacity) {
            removeLastNode();
            count--;
        }
        
        return;
    }
    
    private void moveToHead(DLinkedListNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
        
        return;
    }
    
    private void removeLastNode() {
        DLinkedListNode node = dummyTail.prev;
        map.remove(node.key);
        node.prev.next = dummyTail;
        dummyTail.prev = node.prev; 
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */