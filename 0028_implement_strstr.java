class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int result = 0;
        int p1 = 0, p2 = 0;
        while (p1 < haystack.length()) {
            result = p1;
            while (p1 < haystack.length() && p2 < needle.length() && 
                   haystack.charAt(p1) == needle.charAt(p2)) {
                p1++;
                p2++;
                if (p2 == needle.length()) {
                    return result; 
                }
            } 
            p2 = 0;
            p1 = result;
            p1++;
        }
        return -1;
    }
}