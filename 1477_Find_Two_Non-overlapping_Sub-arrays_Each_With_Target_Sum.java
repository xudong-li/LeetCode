class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // best[i] is the minimum length with target sum before i;
        int[] best = new int[n];
        int sum = 0, start = 0, result = Integer.MAX_VALUE, bestSoFar = Integer.MAX_VALUE;
        Arrays.fill(best, Integer.MAX_VALUE);
        
        for (int end = 0; end < n; end++) {
            sum += arr[end];
            while (sum > target) {
                sum -= arr[start];
                start++;
            }
            if (sum == target) {
                if (start > 0 && best[start - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, best[start - 1] + end - start + 1);
                }
                bestSoFar = Math.min(bestSoFar, end - start + 1);
            }
            best[end] = bestSoFar;
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}