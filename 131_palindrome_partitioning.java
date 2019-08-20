class Solution {
    private List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return result;
        }
        
        helper(s, 0, new ArrayList<String>());
        
        return result;
    }
    
    private void helper(String s, int startIndex, List<String> curr) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = startIndex; i < s.length(); i++) {
            String temp = s.substring(startIndex, i + 1);
            if (!isPalindrome(temp)){
                continue;
            }
            curr.add(temp);
            helper(s, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}