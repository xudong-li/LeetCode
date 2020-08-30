class Solution {
    public String reorganizeString(String S) {
        int count[] = new int[26];
        int mostFreqCharCount = 0;
        char mostFreqChar = S.charAt(0);
        int sum = 0;
        
        for (char c : S.toCharArray()) {
            count[c - 'a']++;
            sum++;
            if (count[c - 'a'] > mostFreqCharCount) {
                mostFreqChar = c;
                mostFreqCharCount = count[c - 'a'];
            }
        }
        
        if (mostFreqCharCount > sum - mostFreqCharCount + 1) {
            return "";
        }
        
        char[] res = new char[S.length()];
        
        int index = 0;
        while (count[mostFreqChar - 'a'] > 0) {
            res[index] = mostFreqChar;
            index += 2;
            count[mostFreqChar - 'a']--;
        }
        
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }
        
        return String.valueOf(res);
    }
}