// class Solution {
//     public int longestSubarray(int[] nums, int limit) {
//         int windowStart = 0, windowEnd;
//         int result = 0;
//         TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
//         for (windowEnd = 0; windowEnd < nums.length; windowEnd++) {
//             treeMap.put(nums[windowEnd], treeMap.getOrDefault(nums[windowEnd], 0) + 1);
            
//             if (treeMap.lastEntry().getKey() - treeMap.firstEntry().getKey() > limit) {
//                 treeMap.put(nums[windowStart], treeMap.get(nums[windowStart]) - 1);
                
//                 if (treeMap.get(nums[windowStart]) == 0) {
//                     treeMap.remove(nums[windowStart]);
//                 }
                
//                 windowStart++;
//             }
//             result = Math.max(result, windowEnd - windowStart + 1);
//         }
        
//         return result;
//     }
// }

class Solution {
    public int longestSubarray(int[] A, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int windowStart = 0, windowEnd, result = 0;
        for (windowEnd = 0; windowEnd < A.length; ++windowEnd) {
            while (!maxd.isEmpty() && A[windowEnd] > maxd.peekLast()) maxd.pollLast();
            while (!mind.isEmpty() && A[windowEnd] < mind.peekLast()) mind.pollLast();
            maxd.add(A[windowEnd]);
            mind.add(A[windowEnd]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == A[windowStart]) maxd.poll();
                if (mind.peek() == A[windowStart]) mind.poll();
                ++windowStart;
            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
    }
}