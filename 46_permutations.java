class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        helper(nums, new boolean[nums.length], new ArrayList<Integer>());
        return result;
    }
    
    private void helper(int[] nums, boolean[] visited, List<Integer> curr) {
        
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
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