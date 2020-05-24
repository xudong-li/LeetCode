class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Integer> inDegrees = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        
        for (String word: words) {
            for (Character c : word.toCharArray()) {
                inDegrees.putIfAbsent(c, 0);
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i], word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                Character parent = word1.charAt(j), child = word2.charAt(j);
                if (parent != child) {
                    graph.get(parent).add(child);
                    inDegrees.put(child, inDegrees.get(child) + 1);
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                q.offer(entry.getKey());
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        while (!q.isEmpty()) {
            Character curr = q.poll();
            result.append(curr);
            
            List<Character> children = graph.get(curr);
            for (Character c : children) {
                inDegrees.put(c, inDegrees.get(c) - 1);
                if (inDegrees.get(c) == 0) {
                    q.offer(c);
                }
            }
        }
        
        if (result.length() != graph.size()) {
            return "";
        }
        
        return result.toString();
    }
}



