class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0)
            return result;
        
        List<int[]> height = new ArrayList<>();
        
        //1. Create all vertical lines for line sweep
        for(int[] building : buildings){
            height.add(new int[]{building[0], -building[2]}); //Neg ht Denotes building start
            height.add(new int[]{building[1], building[2]}); //Pos ht denotes building end
        }
        
        //2. Sort the heights
        Collections.sort(height, (a,b) -> {
            if(a[0] == b[0])
                return a[1] - b[1]; //Tie breaker! if they have the same x, then smaller height first
            else
                return a[0] - b[0]; //Sort acc to x
        });
        
        //3. Store max height of building
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b - a); //max heap
        
        //4. Keep height 0 in the queue for spaces in buildings or no buildings
        queue.add(0);
        
        //5. Maintain states for maxHeight to know when it changes!
        int prevMaxHeight = 0;
        
        //6. Start creating the skyline by visiting all vertical lines in order
      
        for(int[] point : height){
            //For Building start, add in queue
            if(point[1] < 0)
                queue.add(-point[1]);
            else
                queue.remove(point[1]);
            
            int currMaxHeight = queue.peek();
            
            //State has changed
            if(prevMaxHeight != currMaxHeight){
                result.add(new ArrayList<>(Arrays.asList(point[0], currMaxHeight)));
                prevMaxHeight = currMaxHeight;
            }
            
        }
        
        return result;
    }
}