class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        
        String sLowerCase = s.toLowerCase();
        
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(sLowerCase.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(sLowerCase.charAt(end))) {
                end--;
            }
            if (start < end && sLowerCase.charAt(start) != sLowerCase.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}