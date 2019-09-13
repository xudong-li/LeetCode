class OperatorLevel {
    char operator;
    int level;
    public OperatorLevel (char operator, int level) {
        this.operator = operator;
        this.level = level;
    }
};


class Solution {
    public int calculate(String s) {
        Stack<OperatorLevel> operatorStack = new Stack<>();
        Stack<Integer> operandStack = new Stack<>();
        
        int level = 0;
        int number = 0;
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (int)(c - '0');
            } else if (c == '+' || c == '-') {
                operandStack.push(number);
                number = 0;
                while (!operatorStack.isEmpty() && operatorStack.peek().level >= level) {
                    evaluate(operatorStack, operandStack);
                }
                operatorStack.push(new OperatorLevel(c, level));
            } else if (c == '(') {
                level++;
            } else if (c == ')') {
                level--;
            }
        }
        operandStack.push(number);
        
        while (!operatorStack.isEmpty()) {
            evaluate(operatorStack, operandStack);
        }
        
        return operandStack.peek();
    }
    
    private void evaluate(Stack<OperatorLevel> operatorStack, Stack<Integer> operandStack) {
        int rightOperand = operandStack.pop();
        int leftOperand = operandStack.pop();
        char op = operatorStack.pop().operator;
        
        int result = 0;
        if (op == '+') {
            result = leftOperand + rightOperand;
        } else {
            result = leftOperand - rightOperand;
        }
        
        operandStack.push(result);
    }
}