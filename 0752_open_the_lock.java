class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Queue<String> q = new LinkedList<>();
        
        q.offer("0000");
        visited.add("0000");
        int moves = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String curr = q.poll();
                if (deads.contains(curr)) {
                    continue;
                }
                if (curr.equals(target)) {
                    return moves;
                }
                StringBuilder sb = new StringBuilder(curr);
                for (int i = 0; i < 4; i++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                 
                    if (!visited.contains(s1) && !deads.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                    
                    if (!visited.contains(s2) && !deads.contains(s2)) {
                        q.offer(s2);
                        visited.add(s2);
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
}