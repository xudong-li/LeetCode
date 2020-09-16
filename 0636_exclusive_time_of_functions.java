class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] result = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        String[] firstLog = logs.get(0).split(":");
        
        stack.push(Integer.parseInt(firstLog[0]));
        int prev = Integer.parseInt(firstLog[2]);
        
        for (int i = 1; i < logs.size(); i++) {
            String[] currLog = logs.get(i).split(":");
            if (currLog[1].equals("start")) {
                if (!stack.isEmpty())
                    result[stack.peek()] += Integer.parseInt(currLog[2]) - prev;
                stack.push(Integer.parseInt(currLog[0]));
                prev = Integer.parseInt(currLog[2]);
            } else {
                result[stack.peek()] += Integer.parseInt(currLog[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(currLog[2]) + 1;
            }
        }
        
        return result;
    }
}