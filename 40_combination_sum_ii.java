class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>());
        
        return result;
    }
    
    private void helper(int[] candidates, int start, int target, List<Integer> curr) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            
            // make unique combination
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            curr.add(candidates[i]);
            // i + 1 makes every number to be used only once
            helper(candidates, i + 1, target - candidates[i], curr);
            curr.remove(curr.size() - 1);
        }
        
        return;
    }
}