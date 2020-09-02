class Solution {
    public int[][] highFive(int[][] items) {
        //Map<StudentID, scores>
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            if (!map.containsKey(items[i][0])) {
                map.put(items[i][0], new PriorityQueue<Integer>());
            }
            PriorityQueue<Integer> pq = map.get(items[i][0]);
            if (pq.size() < 5) {
                pq.add(items[i][1]);
            } else if (pq.peek() < items[i][1]) {
                pq.poll();
                pq.add(items[i][1]);
            }
        }
               
        int[][] result = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            result[i][0] = entry.getKey();
            int score = 0;
            int size = entry.getValue().size();
            while (!entry.getValue().isEmpty()) {
                score += entry.getValue().poll();
            }
            result[i][1] = score / size;
            i++;
        }
        
        return result;
    }
}