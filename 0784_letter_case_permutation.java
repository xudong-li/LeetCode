class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        helper(S, 0, "", result);
        return result;
    }
    
    private void helper(String S, int index, String curr, List<String> result) {
        if (index == S.length()) {
            result.add(curr);
            return;
        }
        Character c = S.charAt(index);
        if (Character.isDigit(c)) {
            helper(S, index + 1, curr + c, result);
            return;
        }
        helper(S, index + 1, curr + Character.toLowerCase(c), result);
        helper(S, index + 1, curr + Character.toUpperCase(c), result);
    }
}