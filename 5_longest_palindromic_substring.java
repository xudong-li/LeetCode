class Solution {
    public String longestPalindrome(String s) {
        int start = 0, longest = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = findLongestPalindromeFrom(s, i, i);
            if (len > longest) {
                longest = len;
                start = i - len / 2;   //abcba  start = 2 - 5 / 2 = 0  
            }
            
            len = findLongestPalindromeFrom(s, i, i + 1);
            if (len > longest) {
                longest = len;
                start = i - len / 2 + 1;  //ab|bac  start = 1 - 4/2 + 1 = 0
            }
        }
        
        return s.substring(start, start + longest);
    }
    
    private int findLongestPalindromeFrom(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            if (left == right) {
                len++;
            } else {
                len += 2;
            }
            
            left--;
            right++;
        }
        
        return len;
    }
}