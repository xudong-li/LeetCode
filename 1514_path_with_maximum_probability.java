class Node {
    int id;
    double probability;
    public Node(int id, double probability) {
        this.id = id;
        this.probability = probability;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Node>> graph = buildGraph(n, edges, succProb);
        
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>((n1, n2) -> Double.compare(n2.probability, n1.probability));
        maxHeap.add(new Node(start, 1.0));
        
        Map<Integer, Double> memo = new HashMap<>();
        
        while (!maxHeap.isEmpty()) {
            Node curr = maxHeap.poll();
            if (visited.contains(curr.id)) {
                continue;
            }
            visited.add(curr.id);
            if (curr.id == end) {
                return curr.probability;
            }
            
            for (Node next : graph.get(curr.id)) {
                if (visited.contains(next.id)) {
                    continue;
                }
                double probability = curr.probability * next.probability;
                if (probability > memo.getOrDefault(next.id, 0.0)) {
                    memo.put(next.id, probability);
                    maxHeap.offer(new Node(next.id, probability));
                }
            }
        }
        
        return 0.0;
        
    }
    
    private List<List<Node>> buildGraph(int n, int[][] edges, double[] succProb) {
        List<List<Node>> graph = new ArrayList<List<Node>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Node(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Node(edges[i][0], succProb[i]));
        }
        
        return graph;
    }
}