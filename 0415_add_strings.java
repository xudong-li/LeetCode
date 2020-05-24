class Solution {
    public String addStrings(String num1, String num2) {
        char[] num1chars = num1.toCharArray();
        char[] num2chars = num2.toCharArray();
        
        int num1Index = num1.length() - 1;
        int num2Index = num2.length() - 1;
        
        char[] sum = new char[Math.max(num1.length(), num2.length())];
        Arrays.fill(sum, '0');
        
        int sumIndex = sum.length - 1;
        int carry = 0;
        while (sumIndex >= 0) {
            if (num1Index >= 0) {
                sum[sumIndex] += num1chars[num1Index] - '0';
            }
            
            if (num2Index >= 0) {
                sum[sumIndex] += num2chars[num2Index] - '0';
            }
            
            sum[sumIndex] += carry;
            if (sum[sumIndex] > '9') {
                sum[sumIndex] -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sumIndex--;
            num1Index--;
            num2Index--;
        }
        
        StringBuilder result = new StringBuilder();
        if (carry == 1) {
            result.append('1');
        }
        
        result.append(sum);
        return result.toString();
    }
}