class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, curr);
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
            curr.add(candidates[i]);
            helper(candidates, i, target - candidates[i], curr);
            curr.remove(curr.size() - 1);
        }
        
        return;
    }
}