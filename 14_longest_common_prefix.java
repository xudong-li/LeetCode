class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int minStringLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < strs.length; i++) {
            minStringLength = Math.min(minStringLength, strs[i].length());    
        }
        
        for (int i = 0; i < minStringLength; i++) {
            Character curr = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != curr) {
                    return sb.toString();
                }    
            }
            sb.append(curr);
        }
        
        return sb.toString();
    }
}