class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        
        helper(n, k, new ArrayList<Integer>(), 1);
        return result;
    }
    
    private void helper(int n, int k, List<Integer> combination, int startIndex) {
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
        }
        
        for (int i = startIndex; i <= n; i++) {
            combination.add(i);
            helper(n, k, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}