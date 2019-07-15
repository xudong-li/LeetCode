class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);
            if (stack.empty() || temp == '(' || temp == '{' || temp == '[') {
                stack.push(temp);
            } else {
                if (stack.peek() == '(' && temp == ')') {
                    stack.pop();
                } else if (stack.peek() == '[' && temp == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && temp == '}') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}