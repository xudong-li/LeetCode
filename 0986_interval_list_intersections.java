class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> result = new ArrayList();
        
        while (i < A.length && j < B.length) {
            // if end of A is less than start of B
            if (A[i][1] < B[j][0]) {
                i++;
            }
            // if end of B is less than start of A
            else if (B[j][1] < A[i][0]) {
                j++;
            }
            else if (A[i][1] < B[j][1]) {
                result.add(new int[]{Math.max(A[i][0], B[j][0]), A[i][1]});
                i++;
            } else {
                result.add(new int[]{Math.max(A[i][0], B[j][0]), B[j][1]});
                j++;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}