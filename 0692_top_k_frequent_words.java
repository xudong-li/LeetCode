class Node {
    String word;
    int count;
    public Node(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> countFreq = new HashMap<String, Integer>();
        for (String word : words) {
            countFreq.put(word, countFreq.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1,n2) -> (n1.count == n2.count ? 
                                                                     n2.word.compareTo(n1.word) : n1.count - n2.count));
        for (Map.Entry<String, Integer> entry : countFreq.entrySet()) {
            String word = entry.getKey();
            Integer count = entry.getValue();
            if (minHeap.size() < k) {
                minHeap.add(new Node(word, count));
            } else if (minHeap.peek().count <= count){
                minHeap.add(new Node(word, count));
                minHeap.poll();
            }
        }
        
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().word);
        }
        Collections.reverse(result);
        
        return result;
    }
}