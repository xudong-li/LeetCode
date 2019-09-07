class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        
        int result = Integer.MAX_VALUE;
        
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == 0 && j == 0) {
                    row.add(triangle.get(i).get(j));
                    continue;
                }
                
                if (i > 0 && j == 0) {
                    row.add(dp.get(i - 1).get(j) + triangle.get(i).get(j));
                    continue;
                }
                
                if (i > 0 && j == triangle.get(i).size() - 1) {
                    row.add(dp.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                    continue;
                }
                
                int temp = Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j));
                row.add(temp + triangle.get(i).get(j));
                
            }
            
            dp.add(new ArrayList<Integer>(row));
        }
        
        
        for (int i = 0; i < dp.get(dp.size() - 1).size(); i++) {
            result = Math.min(result, dp.get(dp.size() - 1).get(i));    
        }
        
        // for (int i = 0; i < dp.size(); i++) {
        //     for (int j = 0; j < dp.get(i).size(); j++) {
        //         System.out.print(dp.get(i).get(j) + " ");
        //     }
        //     System.out.println(" ");
        // }
        
        
        return result;
    }
}