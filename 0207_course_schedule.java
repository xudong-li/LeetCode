class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            inDegrees[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue q = new LinkedList<Integer>();
        
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
            }
        }
        
        int count = 0;
        while (!q.isEmpty()) {
            int course = (int)q.poll();
            count++;
            int n = edges[course].size();
            for (int i = 0; i < n; i++) {
                int pointer = (int)edges[course].get(i);
                inDegrees[pointer]--;
                if (inDegrees[pointer] == 0) {
                    q.add(pointer);
                }
            }
        }
        
        
        return count == numCourses;
    }
}