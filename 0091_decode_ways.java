class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return helper(s, 0);
    }
    
    private int helper(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        
        if (s.charAt(index) == '0') {
            return 0;
        }
        
        if (index == s.length() - 1) {
            return 1;
        }
        
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        int result = helper(s, index + 1);
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            result += helper(s, index + 2);
        }
        
        memo.put(index, result);
        
        return result;
        
    }
}