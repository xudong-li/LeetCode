class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];
        int[] queriesFx = new int[queries.length];
        int[] wordsFx = new int[words.length];
        
        for (int i = 0; i < queries.length; i++) {
            queriesFx[i] = fx(queries[i]);
        }
        
        for (int i = 0; i < words.length; i++) {
            wordsFx[i] = fx(words[i]);
        }
        
        for (int i = 0; i < result.length; i++) {
            int temp = 0;
            for (int j = 0; j < words.length; j++) {
                if (queriesFx[i] < wordsFx[j]) {
                    temp++;
                }
            }
            
            result[i] = temp;
        }
        
        return result;
    }
    
    private int fx(String s) {
        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return letters[i];
            }
        }
        return 0;
    }
}