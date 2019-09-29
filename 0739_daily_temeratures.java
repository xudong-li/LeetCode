class Pair {
    int temperature;
    int index;
    public Pair (int temperature, int index) {
        this.temperature = temperature;
        this.index = index;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        
        Stack<Pair> stack = new Stack<Pair>();
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty() || T[i] <= stack.peek().temperature) {
                stack.push(new Pair(T[i], i));
            } else {
                while (!stack.isEmpty() && T[i] > stack.peek().temperature) {
                    Pair temp = stack.pop();
                    result[temp.index] = i - temp.index;
                }
                stack.push(new Pair(T[i], i));
            }
        }
        
        return result;
    }
}