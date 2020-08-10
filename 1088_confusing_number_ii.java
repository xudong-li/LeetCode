class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int result = 0;
    public int confusingNumberII(int N) {
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        helper(N,0);
        return result;
    }
    
    private void helper(int N, long curr) {
        if (isConfusingNumber(curr)) {
            result++;
        }
        
        for (int i : map.keySet()) {
            long next = curr * 10 + i;
            if (next <= N && next != 0) {
                helper(N, next);
            }
        }
    }
    
    private boolean isConfusingNumber(long num) {
        long src = num;
        long result = 0;
        while (num > 0) {
            result = result * 10 + map.get((int) num % 10);
            num /= 10;
        }
        
        return result != src;
    }
}