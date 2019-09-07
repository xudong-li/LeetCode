class Solution {
    public int candy(int[] ratings) {
        
        int[] count = new int[ratings.length];
        Arrays.fill(count, 1);
        
        for (int i = 1; i < count.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        
        int result = 0;
        
        for (int i = count.length - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i] && count[i - 1] <= count[i]) {
                count[i - 1] = count[i] + 1;
            }
            
            result += count[i];
        }
        result += count[0];
        return result;
    }
}