class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> toRemoveList = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals('(')) {
                stack.push(i);   
            } else if (c.equals(')')) {
                if (stack.isEmpty()) {
                    toRemoveList.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        
        while (!stack.isEmpty()) {
            toRemoveList.add(stack.pop());
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (toRemoveList.contains(i)) {
                continue;
            }
            result.append(s.charAt(i));
        }
        
        return result.toString();
        
    }
}