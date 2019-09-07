class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> memo = new HashMap<String, List<String>>();
        
        Set<String> dict = new HashSet<>();
        
        for (String word : wordDict) {
            dict.add(word);
        }
        
        return helper(s, dict, memo);
    }
    
    private List<String> helper(String s, 
                                Set<String> dict, 
                                Map<String, List<String>> memo) {
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        List<String> result = new ArrayList<String>();
        
        if (s.length() == 0) {
            return result;
        }
        
        if (dict.contains(s)) {
            result.add(s); 
        }
        
        for (int len = 1; len < s.length(); len++) {
            String word = s.substring(0, len);
            if (!dict.contains(word)) {
                continue;
            }
            
            String suffix = s.substring(len); //from len to the end
            
            List<String> segmentations = helper(suffix, dict, memo);
            
            for (String segments : segmentations) {
                result.add(word + " " + segments);
            }
        }
        
        memo.put(s, result);
        return result;
        
    }
}