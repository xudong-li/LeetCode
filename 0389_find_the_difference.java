class Solution {
    public char findTheDifference(String s, String t) {
        int[] countLetters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countLetters[s.charAt(i) - 'a']++;
            countLetters[t.charAt(i) - 'a']--;
        }
        
        countLetters[t.charAt(t.length()-1) -'a']--;
        
        for (int i = 0; i < 26; i++) {
            if (countLetters[i] != 0) {
                return (char)(i + 'a');
            }
        }
        
        return 'a';
    }
}