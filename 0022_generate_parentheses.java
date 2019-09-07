class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }
    
    private void helper(List<String> result, String curr, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(curr);
            return;
        }
        
        if (left > 0) {
            helper(result, curr + "(", left - 1, right);
        }
        
        if (right > 0 && left < right) {
            helper(result, curr + ")", left, right - 1);
        }
        
        return;
    }
}