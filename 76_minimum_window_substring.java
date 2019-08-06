class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        // count char frequency of t using map
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        int countT = t.length();
        int countS = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && countS < countT) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    if (map.get(c) > 0) {
                        countS++;
                    }
                    map.put(c, map.get(c) - 1);
                }
                j++;
            }
            
            if (countS >= countT && j - i < min) {
                result = s.substring(i, j);
                min = j - i;
            }
            
            char cc = s.charAt(i);
            if (map.containsKey(cc)) {
                if (map.get(cc) >= 0) {
                    countS--;
                }
                map.put(cc, map.get(cc) + 1);
            }
        }
        
        return result;
        
        
        
    }
}