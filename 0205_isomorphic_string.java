class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char S = s.charAt(i);
            char T = t.charAt(i);
            
            if (sMap.containsKey(S)) {
                if (sMap.get(S) != T) {
                    return false;
                }
            } else {
                sMap.put(S, T);
            }
            
            if (tMap.containsKey(T)) {
                if (tMap.get(T) != S) {
                    return false;
                }
            } else {
                tMap.put(T, S);
            }
        }
        
        return true;
    }
}