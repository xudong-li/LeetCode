/***
a%k = x
b%k = x
(a - b) %k = x -x = 0
here a - b = the sum between i and j.
*/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (sumToIndex.containsKey(sum)) {
                if (i - sumToIndex.get(sum) > 1) {
                    return true;
                }
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return false;
    }
}