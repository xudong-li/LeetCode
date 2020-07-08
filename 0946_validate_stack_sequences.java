class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedIndex = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            }
        }
        return stack.isEmpty();
    }
}