class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        // mark nums as negative if visit once
        for (int num : nums) {
            nums[Math.abs(num) - 1] *= -1;
        }
        
        // if a number is positive, it must visted twice
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] > 0) {
                result.add(Math.abs(num));
                // make it back to negative to avoid duplicates
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        
        return result;
    }
}