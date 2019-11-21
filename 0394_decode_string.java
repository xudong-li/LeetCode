class Solution {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        
        int num = 0;
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                if (num > 0) {
                    numberStack.push(num);
                    num = 0;
                } 
                if (c == ']'){
                    StringBuilder buildOneString = new StringBuilder();
                    while (!stringStack.isEmpty() && !stringStack.peek().equals("[")) {
                        buildOneString.append(stringStack.pop());
                    }
                    //pop used '['
                    stringStack.pop();
                    String oneString = buildOneString.toString();

                    int n = numberStack.pop();
                    StringBuilder repeatedString = new StringBuilder();
                    for (int i = 0; i < n; i++) {
                        repeatedString.append(oneString);
                    }
                    
                    stringStack.push(repeatedString.toString());
                    
                } else {
                    stringStack.push(c + "");
                }
            }
        }
        
        while (!stringStack.isEmpty()) {
            result.append(stringStack.pop());
        }
        
        return result.reverse().toString();
    }
}