class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        helper(nums, new boolean[nums.length], new ArrayList<Integer>());
        return result;
    }
    
    private void helper(int[] nums, boolean[] visited, List<Integer> curr) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<Integer>(curr));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            
            curr.add(nums[i]);
            visited[i] = true;
            helper(nums, visited, curr);
            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
        
        return;
    }
}