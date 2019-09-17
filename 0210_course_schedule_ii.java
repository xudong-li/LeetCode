class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int course = (int)q.poll();
            
            order.add(course);
            
            int n = edges[course].size();
            for (int i = 0; i < n; i++) {
                int pointer = (int)edges[course].get(i);
                inDegrees[pointer]--;
                if (inDegrees[pointer] == 0) {
                    q.add(pointer);
                }
            }
        }
        
        int[] result = new int[order.size()];
        for (int i = 0; i < order.size(); i++) {
            result[i] = order.get(i);
        }
        
        if (numCourses == order.size()) {
            return result;
        }
        
        return new int[0];
    }
}