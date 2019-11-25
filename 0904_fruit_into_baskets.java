class Solution {
    public int totalFruit(int[] tree) {
        int windowStart = 0;
        int result = 0;
        Map<Integer, Integer> fruitCount = new HashMap<>();
        for (int windowEnd = 0; windowEnd < tree.length; windowEnd++) {
            if (fruitCount.containsKey(tree[windowEnd])) {
                fruitCount.put(tree[windowEnd], fruitCount.get(tree[windowEnd]) + 1);
            } else {
                fruitCount.put(tree[windowEnd], 1);
                while (fruitCount.size() > 2) {
                    fruitCount.put(tree[windowStart], fruitCount.get(tree[windowStart]) - 1);
                    if (fruitCount.get(tree[windowStart]) == 0) {
                        fruitCount.remove(tree[windowStart]);
                    }
                    windowStart++;
                }
            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        
        return result;
    }
}