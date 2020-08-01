class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        
        //1. find the last position of each character
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (last[c - 'a'] < i) {
                last[c - 'a'] = i;
            }
        }
        
        // 2. expand the window greedily
        int start = 0, end = -1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (end == i) {
                result.add(end - start + 1);
                start = end + 1;
                end = start;
            }
        }
        
        return result;
    }
}