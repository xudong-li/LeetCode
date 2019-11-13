class Solution {
    public boolean isHappy(int n) {        
        Set<Integer> record = new HashSet<>();
        record.add(n);
        
        while (true) {
            int result = calculate(n);
            if (result == 1) {
                return true;
            }
            if (record.contains(result)) {
                return false;
            }
            record.add(result);
            n = result;
        }
        
    }
    
    private int calculate(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n = n / 10;
        }
        return result;
    }
}