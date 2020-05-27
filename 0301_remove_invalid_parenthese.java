class Solution {
    private Set<String> validExpressions = new HashSet<String>();
    private int minimumRemoved;
    
    private void reset() {
        this.validExpressions.clear();
        this.minimumRemoved = Integer.MAX_VALUE;
    }
    
    private void helper(String s, int index, int leftCount, int rightCount, StringBuilder expression, int removedCount) {
        
        //if we reached to the end of string
        if (index == s.length()) {
            
            // if the expression is valid
            if (leftCount == rightCount) {
                
                if (removedCount <= this.minimumRemoved) {
                    String possibleAnswer = expression.toString();
                    
                    if (removedCount < this.minimumRemoved) {
                        this.validExpressions.clear();
                        this.minimumRemoved = removedCount;
                    }
                    this.validExpressions.add(possibleAnswer);
                }
            }
        } else {
            char currentChar = s.charAt(index);
            int length = expression.length();
            
            // if it is not a bracket, simly recurse further by adding it to the expression and continue
            if (currentChar != '(' && currentChar != ')') {
                expression.append(currentChar);
                this.helper(s, index + 1, leftCount, rightCount, expression, removedCount);
                expression.deleteCharAt(length);
                
            } else {
                // remove the curr character and move forward
                this.helper(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
                
                expression.append(currentChar);
                // if it is an opning parenthesis, consider it and recurse
                if (currentChar == '(') {
                    this.helper(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
                } else if (rightCount < leftCount) {
                    this.helper(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
                }
                
                expression.deleteCharAt(length);
            }
        }
    }
    
    
    public List<String> removeInvalidParentheses(String s) {
        this.reset();
        this.helper(s, 0, 0, 0, new StringBuilder(), 0);
        return new ArrayList(this.validExpressions);
    }
}