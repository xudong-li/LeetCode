class Solution {
    public int compress(char[] chars) {
        int left = 0, right = 0, index = 0;
        int n = chars.length;
        
        while (left < n) {
            while (right < n && chars[left] == chars[right]) {
                right++;
            }
            int freq = right - left;
            
            chars[index] = chars[left];
            index++;
            
            if (freq > 1) {
                for (Character c : String.valueOf(freq).toCharArray()) {
                    chars[index] = c;
                    index++;
                }
            }
            left = right;
        }
        
        return index;
    }
}