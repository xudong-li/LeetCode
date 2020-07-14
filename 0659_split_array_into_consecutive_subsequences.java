class Solution {
    public boolean isPossible(int[] nums) {
        int prev = Integer.MIN_VALUE;
        // The number of consecutive subsequences ending with 1, 2, or >= 3  
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        int curr = 0;
        int count = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        
        for (int i = 0; i < nums.length; prev = curr, p1 = c1, p2 = c2, p3 = c3) {
            // count the number appearance in curr character
            for (count = 0, curr = nums[i]; i < nums.length && curr == nums[i]; i++) {
                count++;
            }
            
            // if the current character is not an increment of the previous one
            if (curr != prev + 1) {
                if (p1 != 0 || p2 != 0) {
                    return false;
                }
                
                c1 = count;
                c2 = 0;
                c3 = 0;
            } else {
                // the current character is not enough to cover p1 and p2
                if (count < p1 + p2) {
                    return false;
                }
                
                c1 = Math.max(0, count - (p1 + p2 + p3)); // the subsequences ending at curr with length 1 is max between 0 and extra count
                c2 = p1;
                c3 = p2 + Math.min(p3, count - (p1 + p2)); // the subsequences ending at curr with length >=3 is p2 + the minimum of extra count
            }
        }
        
        return (p1 == 0 && p2 == 0);
    }
}