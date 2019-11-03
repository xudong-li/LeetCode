class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length + 1;
        int[] count = new int[n];
        for (int citation : citations) {
            if (citation >= n) {
                count[n - 1]++;
            } else {
                count[citation]++;
            }
        }
        
        int totalPapers = 0;
        for  (int i = n - 1; i >= 0; i--) {
            totalPapers += count[i];
            if (totalPapers >= i) {
                return i;
            }
        }
        
        return 0;
    }
}