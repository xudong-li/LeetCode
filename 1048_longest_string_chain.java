class Solution {
    public int longestStrChain(String[] words) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> memo = new HashMap<>();
        
        //(O(n))
        for (String s : words) {
            set.add(s);
        }
        
        // (O(n * length(s) * length(s)))
        int result = 0;
        for (String s : words) {
            result = Math.max(result, helper(s, set, memo));
        }
        
        return result;
    }
    
    private int helper(String s, Set<String> set, Map<String, Integer> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String curr = s.substring(0, i) + s.substring(i + 1);
            if (set.contains(curr)) {
                count = Math.max(count, helper(curr, set, memo));
            }
            
        }
        
        memo.put(s, count + 1);
        return count + 1;
    }
}