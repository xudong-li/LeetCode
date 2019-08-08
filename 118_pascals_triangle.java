class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i > 0 && j > 0 && j < i) {
                    level.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                } else {
                    level.add(1);
                }
            }
            result.add(new ArrayList<Integer>(level));
        }
        
        return result;
    }
}