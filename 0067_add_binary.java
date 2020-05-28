class Solution {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1, bIndex = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            char curr = '0';
            if (aIndex >= 0 ) {
                curr += a.charAt(aIndex) - '0';
                aIndex--;
            }
            if (bIndex >= 0) {
                curr += b.charAt(bIndex) - '0';
                bIndex--;
            }
            
            curr += carry;
            
            if (curr == '3') {
                curr = '1';
                carry = 1;
            } else if (curr == '2'){
                curr = '0';
                carry = 1;
            } else {
                carry = 0;
            }
            
            result.append(curr);
        }
        
        if (carry == 1) {
            result.append('1');
        }
        
        return result.reverse().toString();
    }
}