class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        q.offer(beginWord);
        visited.add(beginWord);
        
        int result = 0;
        
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String temp = q.poll();
                if (temp.equals(endWord)) {
                    return ++result;
                }
                for (int j = 0; j < wordList.size(); j++) {
                    String curr = wordList.get(j);
                    if (!visited.contains(curr) && canTransform(temp, curr)) {
                        q.offer(curr);
                        visited.add(curr);
                    }
                }
            }
            result++;
        }
        
        
        
        return 0;
    }
    
    private boolean canTransform(String s1, String s2) {
        int diff = 0;
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        
        for (int i = 0; i < s1Array.length; i++) {
            if (s1Array[i] != s2Array[i]) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }
}