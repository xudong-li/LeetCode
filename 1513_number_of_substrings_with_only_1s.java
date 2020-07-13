class Solution {
    public int numSub(String s) {
        int result = 0;
        int count = 0;
        int modulo = (int) 1e9 + 7;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                count = 0;
            }
            result = (result + count) % modulo;
        }
        
        return result;
    }
}