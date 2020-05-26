class Pair {
    Character first;
    Character second;
    public Pair(Character first, Character second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        List<Pair> pairList = new ArrayList<>();
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1], word2 = words[i];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return false;
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != (word2.charAt(j))) {
                    pairList.add(new Pair(word1.charAt(j), word2.charAt(j)));
                    break;
                }
            }
        }
        
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        
        for (Pair pair : pairList) {
            int firstIndex = orderMap.get(pair.first);
            int secondIndex = orderMap.get(pair.second);
            if (firstIndex >= secondIndex) {
                return false;
            }
        }
        
        return true;
    }
}