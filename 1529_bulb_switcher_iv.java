class Solution {
    public int minFlips(String target) {
        int length = target.length();
        char[] targetChars = target.toCharArray();
        int result = 0;
        if (targetChars[0] == '1') {
            result++;   
        }
        
        for (int i = 1; i < length; i++) {
            if (targetChars[i] != targetChars[i - 1]) {
                result++;
            }
        }
        
        return result;
    }
}