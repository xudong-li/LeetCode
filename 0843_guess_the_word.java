/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        // minimax idea, we want to guess the word with minimum number of 0 matches
        // why 0 match? beacuse it is most likely (25/26) ^ 6 = 79%
        for (int i = 0, x = 0; i < 10 && x < 6; i++) {
            Map<String, Integer> count = new HashMap<>();
            for (String s1 : wordlist) {
                for (String s2 : wordlist) {
                    if (match(s1, s2) == 0) {
                        count.put(s1, count.getOrDefault(s1, 0) + 1);
                    }
                }
            }
            
            int maxCount = 100;
            String guessWord = "";
            for (String s : wordlist) {
                if (count.getOrDefault(s, 0) < maxCount) {
                    maxCount = count.getOrDefault(s, 0);
                    guessWord = s;
                }
            }
            
            x = master.guess(guessWord);
            
            List<String> newWordList = new ArrayList<>();
            for (String s : wordlist) {
                if (match(s, guessWord) == x) {
                    newWordList.add(s);
                }
            }
            
            wordlist = newWordList.toArray(new String[0]);
        }
    }
    
    private int match(String s1, String s2) {
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
}