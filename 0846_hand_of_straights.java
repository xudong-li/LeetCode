class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int card : hand) {
            treeMap.put(card, treeMap.getOrDefault(card, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            int currKey = entry.getKey();
            int currValue = entry.getValue();
            if (currValue > 0) {
                for (int i = 0; i < W; i++) {
                    if (treeMap.getOrDefault(currKey + i, 0) < currValue) {
                        return false;
                    } else {
                        treeMap.put(currKey + i, treeMap.get(currKey + i) - currValue);
                    }
                }   
            }
            
        }
        return true;
    }
}


class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int card : hand) {
            treeMap.put(card, treeMap.getOrDefault(card, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            int currKey = entry.getKey();
            int currValue = entry.getValue();
            while (currValue > 0) {
                for (int i = currKey; i < currKey + W; i++) {
                    if (treeMap.getOrDefault(i, 0) <= 0) {
                        return false;
                    } else {
                        treeMap.put(i, treeMap.get(i) - 1);
                    }
                }
                currValue--;
            }
            
        }
        return true;
    }
}