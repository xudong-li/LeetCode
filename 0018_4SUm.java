class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                findPairs(nums, target, i, j, result);
            }
        }
        
        return result;
    }
    
    private void findPairs(int[] nums, int target, int i, int j, List<List<Integer>> result) {
        int start = j + 1;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[i] + nums[j] + nums[start] + nums[end];
            if (sum == target) {
                List<Integer> sol = new ArrayList<>();
                sol.add(nums[i]);
                sol.add(nums[j]);
                sol.add(nums[start]);
                sol.add(nums[end]);
                result.add(sol);
                
                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        
        return;
    }
}