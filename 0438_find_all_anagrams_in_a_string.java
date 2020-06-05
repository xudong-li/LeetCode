class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> pCount = new HashMap<>();
        
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }
        
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            Character curr = s.charAt(windowEnd);
            sCount.put(curr, sCount.getOrDefault(curr, 0) + 1);
            
            if (windowEnd >= p.length()) {
                Character charAtStart = s.charAt(windowEnd - p.length());
                if (sCount.get(charAtStart) == 1) {
                    sCount.remove(charAtStart);
                } else {
                    sCount.put(charAtStart, sCount.get(charAtStart) - 1);
                }
            }
            
            if (sCount.equals(pCount)) {
                result.add(windowEnd - p.length() + 1);
            }
        }
        
        return result;
    }
}