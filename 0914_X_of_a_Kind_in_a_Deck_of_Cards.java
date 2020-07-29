class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int result = 0;
        for (int i : map.values()) {
            result = gcd(i, result);
        }
        
        return result >= 2;
    }
    
    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a; 
    }
}