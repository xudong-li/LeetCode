/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        
        q.offer(node);
        visited.add(node);
        
        while (!q.isEmpty()) {
            Node temp = q.poll();
            map.put(temp, new Node(temp.val, new ArrayList<Node>()));
            for (int i = 0; i < temp.neighbors.size(); i++) {
                Node neighbor = temp.neighbors.get(i);
                if (visited.contains(neighbor)) {
                    continue;
                }
                q.offer(neighbor);
                visited.add(neighbor);
            }
        }
        
        for (Map.Entry<Node,Node> entry : map.entrySet()) {
            for (int i = 0; i < entry.getKey().neighbors.size(); i++) {
                entry.getValue().neighbors.add(map.get(entry.getKey().neighbors.get(i)));
            }
        }
        
        return map.get(node);
    }
}