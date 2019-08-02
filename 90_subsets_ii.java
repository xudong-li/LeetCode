class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void helper(int[] nums, List<Integer> subset, int startIndex) {
        result.add(new ArrayList<>(subset));
        
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            
            subset.add(nums[i]);
            helper(nums, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
        
        return;
    }
}