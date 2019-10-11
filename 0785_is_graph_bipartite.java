class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] != 0) {
                continue;
            }
            
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            colors[i] = 1;
            
            while (!q.isEmpty()) {
                int curr = (int)q.poll();
                for (int next : graph[curr]) {
                    if (colors[next] == 0) {
                        colors[next] = -colors[curr]; // assign an opposite color to neighbor
                        q.offer(next);
                    } else if (colors[next] != -colors[curr]) {
                        return false;
                    }
                }
                
            }
        }
        
        return true;
    }
}