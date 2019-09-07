class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        
        int maxLength = 0;
        for (String word : wordDict) {
            dict.add(word);
            maxLength = Math.max(maxLength, word.length());
        }
        
        // a string with length n has n + 1 break points
        boolean[] canBreak = new boolean[s.length() + 1];
        
        canBreak[0] = true;
        
        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 1; j <= maxLength && j <= i; j++) {
                
                String str = s.substring(i - j, i);
                if (dict.contains(str) && canBreak[i - j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        
        return canBreak[canBreak.length - 1];
    }
}